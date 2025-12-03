package codes.fdk.aoc.d01;

import static codes.fdk.aoc.d01.DialRotation.LeftDialRotation;
import static codes.fdk.aoc.d01.DialRotation.RightDialRotation;
import static codes.fdk.aoc.utils.Preconditions.checkArgument;
import static codes.fdk.aoc.utils.Preconditions.requireNonNull;

public sealed interface DialRotation permits LeftDialRotation, RightDialRotation {

    int distance();

    static DialRotation of(String rotation) {
        requireNonNull(rotation, "Rotation must be non-null.");
        checkArgument(rotation.length() > 1, "Rotation length must be greater than 1.");
        return of(rotation.charAt(0), rotation.substring(1));
    }

    private static DialRotation of(Character direction, String distance) {
        requireNonNull(direction, "Direction must be non-null.");
        requireNonNull(distance, "Distance must be non-null.");
        checkArgument(distance.chars().allMatch(Character::isDigit), "Distance needs to alphanumerical.");
        return of(direction, Integer.parseInt(distance));
    }

    private static DialRotation of(Character direction, Integer value) {
        requireNonNull(direction, "Direction must be non-null.");
        requireNonNull(value, "Distance must be non-null.");
        return switch (direction) {
            case 'L' -> new LeftDialRotation(value);
            case 'R' -> new RightDialRotation(value);
            default -> throw new IllegalArgumentException("Unexpected direction value: " + direction);
        };
    }

    record LeftDialRotation(int distance) implements DialRotation {
        @Override
        public String toString() {
            return "L" + distance;
        }
    }
    record RightDialRotation(int distance) implements DialRotation {
        @Override
        public String toString() {
            return "R" + distance;
        }
    }

}
