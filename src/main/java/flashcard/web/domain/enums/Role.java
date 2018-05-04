package flashcard.web.domain.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum  Role {
    ADMIN("ADMIN"),
    DISABLED("BANNED"),
    USER("USER");

    String name;

    Role(String name) {
        this.name = name;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }
}