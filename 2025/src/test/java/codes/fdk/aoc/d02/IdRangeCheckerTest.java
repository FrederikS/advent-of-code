package codes.fdk.aoc.d02;

import codes.fdk.aoc.common.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IdRangeCheckerTest {

    @Nested
    class PartOne {

        private IdRangeChecker checker;

        @BeforeEach
        void setUp() {
            checker = new IdRangeChecker(new IdCheckerStrategyPartOne());
        }

        @ParameterizedTest
        @MethodSource("ranges")
        void findInvalidIdsWithin(String value, Iterable<Long> invalidIds) {
            assertThat(checker.findInvalidIdsWithin(Range.of(value))).containsAll(invalidIds);
        }

        @ParameterizedTest
        @MethodSource("emptyRanges")
        void findInvalidIdsWithinEmpty(String value) {
            assertThat(checker.findInvalidIdsWithin(Range.of(value))).isEmpty();
        }

        private static Stream<Arguments> ranges() {
            return Stream.of(
                    Arguments.of("11-22", List.of(11L, 22L)),
                    Arguments.of("95-115", List.of(99L)),
                    Arguments.of("998-1012", List.of(1010L)),
                    Arguments.of("1188511880-1188511890", List.of(1188511885L)),
                    Arguments.of("222220-222224", List.of(222222L)),
                    Arguments.of("446443-446449", List.of(446446L)),
                    Arguments.of("38593856-38593862", List.of(38593859L))
            );
        }

        private static Stream<Arguments> emptyRanges() {
            return Stream.of(
                    Arguments.of("1698522-1698528")
            );
        }

    }

    @Nested
    class PartTwo {

        private IdRangeChecker checker;

        @BeforeEach
        void setUp() {
            checker = new IdRangeChecker(new IdCheckerStrategyPartTwo());
        }

        @ParameterizedTest
        @MethodSource("ranges")
        void findInvalidIdsWithin(String value, Iterable<Long> invalidIds) {
            assertThat(checker.findInvalidIdsWithin(Range.of(value))).containsAll(invalidIds);
        }

        @ParameterizedTest
        @MethodSource("emptyRanges")
        void findInvalidIdsWithinEmpty(String value) {
            assertThat(checker.findInvalidIdsWithin(Range.of(value))).isEmpty();
        }

        private static Stream<Arguments> ranges() {
            return Stream.of(
                    Arguments.of("11-22", List.of(11L, 22L)),
                    Arguments.of("95-115", List.of(99L, 111L)),
                    Arguments.of("998-1012", List.of(999L, 1010L)),
                    Arguments.of("1188511880-1188511890", List.of(1188511885L)),
                    Arguments.of("222220-222224", List.of(222222L)),
                    Arguments.of("446443-446449", List.of(446446L)),
                    Arguments.of("38593856-38593862", List.of(38593859L)),
                    Arguments.of("565653-565659", List.of(565656L)),
                    Arguments.of("824824821-824824827", List.of(824824824L)),
                    Arguments.of("2121212118-2121212124", List.of(2121212121L))
            );
        }

        private static Stream<Arguments> emptyRanges() {
            return Stream.of(
                    Arguments.of("1698522-1698528")
            );
        }

    }

}
