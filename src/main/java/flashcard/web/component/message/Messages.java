package flashcard.web.component.message;

public interface Messages {
    String get(String code);
    String get(String code, String... args);
}
