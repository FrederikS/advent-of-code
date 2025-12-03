package codes.fdk.aoc.utils;

import java.util.Objects;

public final class Preconditions {

    public static <T> T requireNonNull(T obj, String message) {
        return Objects.requireNonNull(obj, message);
    }

    public static void checkArgument(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

}
