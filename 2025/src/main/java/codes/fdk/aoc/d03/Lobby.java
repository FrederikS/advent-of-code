package codes.fdk.aoc.d03;

import codes.fdk.aoc.utils.IOUtils;

import java.util.function.Consumer;
import java.util.stream.Stream;

import static codes.fdk.aoc.utils.Preconditions.checkArgument;
import static codes.fdk.aoc.utils.Preconditions.requireNonNull;

public class Lobby {

    static void main(String[] args) {
        requireNonNull(args, "Please provide input");
        checkArgument(args.length > 0, "Please provide file input");
        Stream.of(2, 12).forEach(batteryCount -> {
            IOUtils.processLinesFromFile(args[0], printSumOfMaxJoltages(batteryCount));
        });
    }

    static long sumMaxJoltages(Stream<String> banks, int batteryCount) {
        return JoltageCalculator.sumMaxJoltages(banks, batteryCount);
    }

    private static Consumer<Stream<String>> printSumOfMaxJoltages(int batteryCount) {
        return banks -> IO.println("Sum: " + sumMaxJoltages(banks, batteryCount));
    }

}
