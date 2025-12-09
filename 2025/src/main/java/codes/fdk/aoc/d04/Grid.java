package codes.fdk.aoc.d04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static codes.fdk.aoc.d04.Cell.EmptyCell;
import static codes.fdk.aoc.d04.Cell.RollOfPaper;

public class Grid {

    private final Cell[][] data = new Cell[150][150];

    public void addAll(Grid other) {
        throw new UnsupportedOperationException();
    }

    public void addCells(List<Cell> cells) {
        cells.forEach(this::addCell);
    }

    public void addCell(Cell cell) {
        data[cell.row()][cell.column()] = cell;
    }

    public List<Cell> getCells() {
        return Arrays.stream(data, 0, data.length)
                     .map(Arrays::stream)
                     .map(Stream::toList)
                     .flatMap(Collection::stream)
                     .toList();
    }

    public Optional<Cell> getCell(int row, int column) {
        if (row < 0 || column < 0 || row >= data.length || column >= data[0].length) {
            return Optional.empty();
        }

        return Optional.ofNullable(data[row]).map(columns -> columns[column]);
    }

    public List<Cell> getAdjacentCellsOf(Cell cell) {
        List<Cell> cells = new ArrayList<>();
        for (int row = cell.row() - 1; row <= cell.row() + 1; row++) {
            for (int column = cell.column() - 1; column <= cell.column() + 1; column++) {
                if (row != cell.row() || column != cell.column()) {
                    getCell(row, column).ifPresent(cells::add);
                }
            }
        }
        return cells;
    }

    public void removeRollOfPaper(RollOfPaper cell) {
        data[cell.row()][cell.column()] = new EmptyCell(cell.row(), cell.column());
    }

}
