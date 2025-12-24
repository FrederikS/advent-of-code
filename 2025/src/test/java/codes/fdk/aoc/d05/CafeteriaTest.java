package codes.fdk.aoc.d05;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        Assertions.assertThat(numberOfFreshIngredients).isEqualTo(3);
    }

}