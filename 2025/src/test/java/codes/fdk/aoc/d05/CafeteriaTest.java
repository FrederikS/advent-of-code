package codes.fdk.aoc.d05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CafeteriaTest {

    private static final List<String> INGREDIENTS = List.of(
            "3-5",
            "10-14",
            "16-20",
            "12-18",
            "",
            "1",
            "5",
            "8",
            "11",
            "17",
            "32"
    );

    private RangeRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryRangeRepository();
    }

    @Test
    void testFindNumberOfValuesInRange() {
        Cafeteria.storeRanges(INGREDIENTS.stream(), repository);
        var numberOfFreshIngredients = Cafeteria.findNumberOfValuesInRange(INGREDIENTS.stream(), repository);
        assertThat(numberOfFreshIngredients).isEqualTo(3);
    }

    @Test
    void testSumOfValuesInRange() {
        Cafeteria.storeRanges(INGREDIENTS.stream(), repository);
        var sumOfValuesInRange = Cafeteria.sumOfValuesInRange(repository);
        assertThat(sumOfValuesInRange).isEqualTo(14L);
    }

}
