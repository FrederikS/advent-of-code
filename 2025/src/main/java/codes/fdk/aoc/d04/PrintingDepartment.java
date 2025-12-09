package codes.fdk.aoc.d04;

import codes.fdk.aoc.utils.IOUtils;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static codes.fdk.aoc.utils.GatherUtils.zipWithIndex;
import static codes.fdk.aoc.utils.Preconditions.checkArgument;
import static codes.fdk.aoc.utils.Preconditions.requireNonNull;

public class PrintingDepartment {

    static void main(String[] args) {
        requireNonNull(args, "Please provide input");
        checkArgument(args.length > 0, "Please provide file input");
        IOUtils.processLinesFromFile(args[0], PrintingDepartment::printNumberOfAccessibleRolls);
        IOUtils.processLinesFromFile(args[0], PrintingDepartment::printNumberOfRemovableRolls);
    }

    private static void printNumberOfAccessibleRolls(Stream<String> lines) {
        IO.println("Sum (Part 1): " + calculateNumberOfAccessibleRolls(lines));
    }

    static long calculateNumberOfAccessibleRolls(Stream<String> lines) {
        var grid = buildGrid(lines);
        return getAccessibleRolls(grid).size();
    }

    private static List<Cell.RollOfPaper> getAccessibleRolls(Grid grid) {
        return grid.getCells()
                   .stream()
                   .filter(Cell.RollOfPaper.class::isInstance)
                   .map(Cell.RollOfPaper.class::cast)
                   .filter(isAccessible(grid))
                   .toList();
    }

    private static Predicate<Cell> isAccessible(Grid grid) {
        return cell -> grid.getAdjacentCellsOf(cell)
                           .stream()
                           .filter(Cell.RollOfPaper.class::isInstance)
                           .count() < 4;
    }

    private static Grid buildGrid(Stream<String> lines) {
        return lines.gather(zipWithIndex(PrintingDepartment::toCells))
                    .collect(Grid::new, Grid::addCells, Grid::addAll);
    }

    private static List<Cell> toCells(int row, String line) {
        return IntStream.range(0, line.length())
                        .mapToObj(column -> Cell.of(row, column, line.charAt(column)))
                        .toList();
    }

    private static void printNumberOfRemovableRolls(Stream<String> lines) {
        IO.println("Removable rolls (Part 2): " + calculateNumberOfRemovableRolls(lines));
    }

    static long calculateNumberOfRemovableRolls(Stream<String> lines) {
        long amount = 0;
        var grid = buildGrid(lines);
        var accessibleRolls = getAccessibleRolls(grid);
        while (!accessibleRolls.isEmpty()) {
            accessibleRolls.forEach(grid::removeRollOfPaper);
            amount += accessibleRolls.size();
            accessibleRolls = getAccessibleRolls(grid);
        }
        return amount;
    }

}
