package codes.fdk.aoc.d02;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class IdRangeChecker {

    public Collection<Long> findInvalidIdsWithin(Range range) {
        return LongStream.rangeClosed(range.start(), range.end())
                         .filter(IdRangeChecker::isInvalid)
                         .boxed()
                         .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private static boolean isInvalid(long number) {
        var string = String.valueOf(number);
        if (string.length() % 2 == 0) {
            int halfLength = string.length() / 2;
            var part1 = string.substring(0, halfLength);
            var part2 = string.substring(halfLength);
            return Objects.equals(part1, part2);
        }
        return false;
    }

}
