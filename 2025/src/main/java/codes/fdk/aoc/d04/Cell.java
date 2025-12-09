package codes.fdk.aoc.d04;

public sealed interface Cell {

    int row();
    int column();

    static Cell of(int row, int column, Character character) {
        return switch (character) {
            case '@' -> new RollOfPaper(row, column);
            case '.' -> new EmptyCell(row, column);
            default -> throw new IllegalArgumentException("Unexpected cell character.");
        };
    }

    record RollOfPaper(int row, int column) implements Cell {}
    record EmptyCell(int row, int column) implements Cell {}

}
