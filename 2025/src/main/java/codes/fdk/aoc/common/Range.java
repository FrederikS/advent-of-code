package codes.fdk.aoc.common;

import static codes.fdk.aoc.utils.Preconditions.checkArgument;
import static codes.fdk.aoc.utils.Preconditions.requireNonNull;

public record Range(long start, long end) {

    private static final String DIVIDER = "-";

    public static Range of(String value) {
        requireNonNull(value, "Value must be non-null.");
        checkArgument(value.contains(DIVIDER), "Value must contain divider: " + DIVIDER);
        return parseRange(value);
    }

    private static Range parseRange(String value) {
        var values = value.split(DIVIDER);
        checkArgument(values.length == 2, "Min and max value must be defined.");
        requireNonNull(values[0], "Min value must not be null.");
        requireNonNull(values[1], "Max value must not be null.");
        checkArgument(values[0].chars().allMatch(Character::isDigit), "Min value must be alphanumerical.");
        checkArgument(values[1].chars().allMatch(Character::isDigit), "Min value must be alphanumerical.");
        return new Range(Long.parseLong(values[0]), Long.parseLong(values[1]));
    }

    public Range {
        checkArgument(start <= end, "Range start must be lower than range end.");
    }

    public boolean isWithinRange(long value) {
        return value >= start && value <= end;
    }

}
