package codes.fdk.aoc.d01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Gatherers;
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
        var dial = processDialRotations(dialRotations);
        return String.valueOf(dial.getZeroCount());
    }

    static Dial processDialRotations(Stream<String> rotations) {
        return rotations.map(DialRotation::of)
                        .gather(Gatherers.fold(Dial::new, Dial::processRotation))
                        .findFirst()
                        .orElseThrow();
    }

}
