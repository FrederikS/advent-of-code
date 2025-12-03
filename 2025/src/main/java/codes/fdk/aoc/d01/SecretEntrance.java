package codes.fdk.aoc.d01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static codes.fdk.aoc.utils.Preconditions.requireNonNull;

public class SecretEntrance {

    static void main(String[] args) {
        requireNonNull(args, "Please provide input");
        requireNonNull(args[0], "Please provide a input file containing the rotations.");
        try (var dialRotations = Files.lines(Path.of(args[0]))) {
            var password = determinePassword(dialRotations);
            IO.println("Password: " + password);
        } catch (IOException e) {
            IO.println("Unable to read input file " + args[0] + " " + e.getMessage());
        }
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
