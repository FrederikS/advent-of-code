package codes.fdk.aoc.d01;

public record DialState(int pointer) {

    private static final int INITIAL_POINTER = 50;

    public static DialState initial() {
        return new DialState(INITIAL_POINTER);
    }

}
