package flashcard.web.security;


import flashcard.web.domain.User;

public interface PrincipalProvider {
    AppPrincipal getPrincipal();

    User getLoggedUser();

    boolean isUserLogged();

    String getLoggedUsername();
}
