package codes.fdk.aoc.d02;

import java.util.Objects;

public class IdCheckerStrategyPartOne implements IdCheckerStrategy {

    @Override
    public boolean test(long id) {
        var string = String.valueOf(id);
        if (string.length() % 2 == 0) {
            int halfLength = string.length() / 2;
            var part1 = string.substring(0, halfLength);
            var part2 = string.substring(halfLength);
            return Objects.equals(part1, part2);
        }
        return false;
    }

}
