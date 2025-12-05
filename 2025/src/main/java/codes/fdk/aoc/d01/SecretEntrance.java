package codes.fdk.aoc.d01;

import codes.fdk.aoc.utils.IOUtils;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static codes.fdk.aoc.utils.Preconditions.checkArgument;
import static codes.fdk.aoc.utils.Preconditions.requireNonNull;

public class SecretEntrance {

    static void main(String[] args) {
        requireNonNull(args, "Please provide input");
        checkArgument(args.length > 0, "Please provide file input");
        IOUtils.processLinesFromFile(args[0], SecretEntrance::printPassword);
    }

    private static void printPassword(Stream<String> lines) {
        IO.println("Password: " + determinePassword(lines));
    }

    static String determinePassword(Stream<String> dialRotations) {
        var counterPart1 = new AtomicInteger();
        var counterPart2 = new AtomicInteger();
        var dial = new Dial();
        dial.onRotationCompleted(incrementCounterIfZero(counterPart1));
        dial.onPointerChanged(incrementCounterIfZero(counterPart2));
        dial.processRotations(dialRotations.map(DialRotation::of));
        return "Part1: %d, Part2: %d".formatted(counterPart1.get(), counterPart2.get());
    }

    private static Consumer<Integer> incrementCounterIfZero(AtomicInteger counter) {
        return pointer -> {
            if (pointer == 0) {
                counter.getAndIncrement();
            }
        };
    }

}
