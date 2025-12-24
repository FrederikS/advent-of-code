package codes.fdk.aoc.d05;

import codes.fdk.aoc.common.Range;

import java.util.stream.Stream;

public interface RangeRepository {

    void save(Range range);

    boolean hasRangeFor(long value);

    long count();

}
