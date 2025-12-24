package codes.fdk.aoc.d05;

import codes.fdk.aoc.common.Range;
import codes.fdk.aoc.utils.IOUtils;

import java.util.ServiceLoader;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static codes.fdk.aoc.utils.Preconditions.checkArgument;
import static codes.fdk.aoc.utils.Preconditions.requireNonNull;
import static java.util.function.Predicate.not;

public class Cafeteria {

    static void main(String[] args) {
        requireNonNull(args, "Please provide input");
        checkArgument(args.length > 0, "Please provide file input");
        var repository = ServiceLoader.load(RangeRepository.class).findFirst().orElseThrow();
        IOUtils.processLinesFromFile(args[0], storeRanges(repository));
        IOUtils.processLinesFromFile(args[0], printNumberOfValuesInRange(repository));
    }

    private static Consumer<Stream<String>> storeRanges(RangeRepository repository) {
        return lines -> storeRanges(lines, repository);
    }

    static void storeRanges(Stream<String> lines, RangeRepository repository) {
        lines.takeWhile(not(String::isBlank))
                .map(Range::of)
                .forEach(repository::save);
    }

    private static Consumer<Stream<String>> printNumberOfValuesInRange(RangeRepository repository) {
        return lines -> IO.println("Number of fresh ingredients: " + findNumberOfValuesInRange(lines, repository));
    }

    static long findNumberOfValuesInRange(Stream<String> lines, RangeRepository repository) {
        return lines.skip(repository.count() + 1)
                .mapToLong(Long::parseLong)
                .filter(repository::hasRangeFor)
                .count();
    }

}
