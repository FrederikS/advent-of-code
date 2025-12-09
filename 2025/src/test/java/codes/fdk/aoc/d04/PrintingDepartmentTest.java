package codes.fdk.aoc.d04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrintingDepartmentTest {

    private static final List<String> GRID = List.of(
            "..@@.@@@@.",
            "@@@.@.@.@@",
            "@@@@@.@.@@",
            "@.@@@@..@.",
            "@@.@@@@.@@",
            ".@@@@@@@.@",
            ".@.@.@.@@@",
            "@.@@@.@@@@",
            ".@@@@@@@@.",
            "@.@.@@@.@."
    );

    @Test
    void calculateNumberOfAccessibleRolls() {
        assertThat(PrintingDepartment.calculateNumberOfAccessibleRolls(GRID.stream())).isEqualTo(13);
    }

    @Test
    void calculateNumberOfRemovableRolls() {
        assertThat(PrintingDepartment.calculateNumberOfRemovableRolls(GRID.stream())).isEqualTo(43);
    }

}
