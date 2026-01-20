package codes.fdk.aoc.d05;

import codes.fdk.aoc.common.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class InMemoryRangeRepository implements RangeRepository {

    private final List<Range> ranges = new ArrayList<>();

    @Override
    public void save(Range range) {
        var mergeable = findMergeable(range);
        if (mergeable.isPresent()) {
            delete(mergeable.get());
            save(mergeable.get().merge(range));
        } else {
            ranges.add(range);
        }
    }

    private void delete(Range range) {
        ranges.remove(range);
    }

    private Optional<Range> findMergeable(Range range) {
        return ranges.stream().filter(range::isMergeableWith).findFirst();
    }

    @Override
    public boolean hasRangeFor(long value) {
        return ranges.stream().anyMatch(range -> range.isWithinRange(value));
    }

    @Override
    public long count() {
        return ranges.size();
    }

    @Override
    public Stream<Range> stream() {
        return ranges.stream();
    }

}
