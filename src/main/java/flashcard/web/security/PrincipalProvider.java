package flashcard.web.security;


import flashcard.application.domain.User;

public interface PrincipalProvider {
    AppPrincipal getPrincipal();

    User getLoggedUser();

    boolean isUserLogged();

    String getLoggedUsername();
}
