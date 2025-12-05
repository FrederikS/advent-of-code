package codes.fdk.aoc.d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GiftShopTest {

    private static final List<String> RANGES = List.of(
            "11-22",
            "95-115",
            "998-1012",
            "1188511880-1188511890",
            "222220-222224",
            "1698522-1698528",
            "446443-446449",
            "38593856-38593862",
            "565653-565659",
            "824824821-824824827",
            "2121212118-2121212124"
    );

    @Nested
    class PartOne {

        private IdRangeChecker checker;

        @BeforeEach
        void setUp() {
            checker = new IdRangeChecker(new IdCheckerStrategyPartOne());
        }

        @Test
        void testFindSumOfInvalidIds() {
            assertThat(GiftShop.findSumOfInvalidIds(RANGES.stream(), checker)).isEqualTo(1227775554L);
        }

    }

    @Nested
    class PartTwo {

        private IdRangeChecker checker;

        @BeforeEach
        void setUp() {
            checker = new IdRangeChecker(new IdCheckerStrategyPartTwo());
        }

        @Test
        void testFindSumOfInvalidIds() {
            assertThat(GiftShop.findSumOfInvalidIds(RANGES.stream(), checker)).isEqualTo(4174379265L);
        }

    }

}
