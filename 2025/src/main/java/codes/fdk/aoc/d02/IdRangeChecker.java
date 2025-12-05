package codes.fdk.aoc.d02;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class IdRangeChecker {

    private final IdCheckerStrategy strategy;

    public IdRangeChecker(IdCheckerStrategy strategy) {
        this.strategy = strategy;
    }

    public Collection<Long> findInvalidIdsWithin(Range range) {
        return LongStream.rangeClosed(range.start(), range.end())
                         .filter(strategy)
                         .boxed()
                         .collect(Collectors.toCollection(LinkedHashSet::new));
    }

}
