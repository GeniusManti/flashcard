package flashcard.web.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import flashcard.web.DTO.request.LoginRequest;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;

public class AppAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        } else {
            LoginRequest requestForm = obtainJSONLoginCredentials(request);
            String nick = Optional.ofNullable(requestForm).map(e -> e.getNick()).orElse(null);
            String password = Optional.ofNullable(requestForm).map(e -> e.getPassword()).orElse(null);
            if (nick == null) {
                nick = "";
            }

            if (password == null) {
                password = "";
            }

            nick = nick.trim();
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(nick, password);
            this.setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        }
    }

    private LoginRequest obtainJSONLoginCredentials(HttpServletRequest request) {

        StringBuilder builder = new StringBuilder();
        char[] charBuffer = new char[128];
        String requestContent;
        int bytesRead;

        try (BufferedReader bufferedReader = request.getReader()) {
            while ((bytesRead = bufferedReader.read(charBuffer)) != -1) {
                builder.append(charBuffer, 0, bytesRead);
            }
            requestContent = builder.toString();

            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.readValue(requestContent, LoginRequest.class);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        SecurityContextHolder.getContext().setAuthentication(authResult);
        if (this.eventPublisher != null) {
            this.eventPublisher.publishEvent(new InteractiveAuthenticationSuccessEvent(authResult, this.getClass()));
        }
        if (authResult != null) {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        clearAuthenticationAttributes(request);

    }

    private void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        }
    }
}