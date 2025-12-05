package codes.fdk.aoc.d02;

import codes.fdk.aoc.utils.IOUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static codes.fdk.aoc.utils.Preconditions.checkArgument;
import static codes.fdk.aoc.utils.Preconditions.requireNonNull;

public class GiftShop {

    private static final String SEPARATOR = ",";

    static void main(String[] args) {
        requireNonNull(args, "Please provide input");
        checkArgument(args.length > 0, "Please provide file input");
        IOUtils.processLinesFromFile(args[0], GiftShop::printSumOfInvalidIds);
    }

    private static void printSumOfInvalidIds(Stream<String> lines) {
        IO.println("Sum: " + findSumOfInvalidIds(lines));
    }

    static long findSumOfInvalidIds(Stream<String> lines) {
        var invalidIds = findInvalidIds(lines);
        return invalidIds.mapToLong(Long::longValue).sum();
    }

    private static Stream<Long> findInvalidIds(Stream<String> lines) {
        var idRangeChecker = new IdRangeChecker();

        return lines.map(line -> line.split(SEPARATOR))
                    .flatMap(Arrays::stream)
                    .map(Range::of)
                    .map(idRangeChecker::findInvalidIdsWithin)
                    .flatMap(Collection::stream);
    }

}
