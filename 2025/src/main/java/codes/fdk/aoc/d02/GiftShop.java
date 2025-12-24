package codes.fdk.aoc.d02;

import codes.fdk.aoc.common.Range;
import codes.fdk.aoc.utils.IOUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.ServiceLoader;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static codes.fdk.aoc.utils.Preconditions.checkArgument;
import static codes.fdk.aoc.utils.Preconditions.requireNonNull;

public class GiftShop {

    private static final String SEPARATOR = ",";

    static void main(String[] args) {
        requireNonNull(args, "Please provide input");
        checkArgument(args.length > 0, "Please provide file input");
        ServiceLoader.load(IdCheckerStrategy.class).forEach(strategy -> {
            IO.print(strategy.getClass().getSimpleName() + ": ");
            IOUtils.processLinesFromFile(args[0], printSumOfInvalidIds(new IdRangeChecker(strategy)));
        });
    }

    private static Consumer<Stream<String>> printSumOfInvalidIds(IdRangeChecker checker) {
        return lines -> IO.println("Sum = " + findSumOfInvalidIds(lines, checker));
    }

    static long findSumOfInvalidIds(Stream<String> lines, IdRangeChecker checker) {
        var invalidIds = findInvalidIds(lines, checker);
        return invalidIds.mapToLong(Long::longValue).sum();
    }

    private static Stream<Long> findInvalidIds(Stream<String> lines, IdRangeChecker checker) {
        return lines.map(line -> line.split(SEPARATOR))
                    .flatMap(Arrays::stream)
                    .map(Range::of)
                    .map(checker::findInvalidIdsWithin)
                    .flatMap(Collection::stream);
    }

}
