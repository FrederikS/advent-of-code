package codes.fdk.aoc.d03;

import codes.fdk.aoc.utils.IOUtils;

import java.util.stream.Stream;

import static codes.fdk.aoc.utils.Preconditions.checkArgument;
import static codes.fdk.aoc.utils.Preconditions.requireNonNull;

public class Lobby {

    static void main(String[] args) {
        requireNonNull(args, "Please provide input");
        checkArgument(args.length > 0, "Please provide file input");
        IOUtils.processLinesFromFile(args[0], Lobby::printSumOfMaxJoltages);
    }

    private static void printSumOfMaxJoltages(Stream<String> lines) {
        IO.println("Sum: " + calculateSumOfMaxJoltages(lines));
    }

    static long calculateSumOfMaxJoltages(Stream<String> lines) {
        return lines.mapToInt(JoltageCalculator::calculateMax).sum();
    }

}
