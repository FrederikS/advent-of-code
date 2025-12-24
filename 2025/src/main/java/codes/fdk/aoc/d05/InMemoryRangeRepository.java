package codes.fdk.aoc.d05;

import codes.fdk.aoc.common.Range;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class InMemoryRangeRepository implements RangeRepository {

    private final List<Range> ranges = new ArrayList<>();

    @Override
    public void save(Range range) {
        ranges.add(range);
    }

    @Override
    public boolean hasRangeFor(long value) {
        return ranges.stream().anyMatch(range -> range.isWithinRange(value));
    }

    @Override
    public long count() {
        return ranges.size();
    }

}
