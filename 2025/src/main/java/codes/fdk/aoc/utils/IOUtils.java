package codes.fdk.aoc.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static codes.fdk.aoc.utils.Preconditions.requireNonNull;

public final class IOUtils {

    public static void processLinesFromFile(String path, Consumer<Stream<String>> linesConsumer) {
        requireNonNull(path, "Path must be non-null.");
        try (var lines = Files.lines(Path.of(path))) {
            linesConsumer.accept(lines);
        } catch (IOException e) {
            java.lang.IO.println("Unable to read input file " + path + " " + e.getMessage());
        }
    }

}
