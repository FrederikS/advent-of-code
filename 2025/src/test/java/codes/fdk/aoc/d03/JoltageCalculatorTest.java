package codes.fdk.aoc.d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class JoltageCalculatorTest {

    @Nested
    class PartOne {

        @ParameterizedTest
        @MethodSource("banks")
        void testCalculateMax(String bank, int maxJoltage) {
            assertThat(JoltageCalculator.calculateMaxJoltage(bank, 2)).isEqualTo(maxJoltage);
        }

        private static Stream<Arguments> banks() {
            return Stream.of(
                    Arguments.of("987654321111111", 98),
                    Arguments.of("811111111111119", 89),
                    Arguments.of("234234234234278", 78),
                    Arguments.of("818181911112111", 92)
            );
        }

    }

    @Nested
    class PartTwo {

        @ParameterizedTest
        @MethodSource("banks")
        void testCalculateMax(String bank, long maxJoltage) {
            assertThat(JoltageCalculator.calculateMaxJoltage(bank, 12)).isEqualTo(maxJoltage);
        }

        private static Stream<Arguments> banks() {
            return Stream.of(
                    Arguments.of("987654321111111", 987654321111L),
                    Arguments.of("811111111111119", 811111111119L),
                    Arguments.of("234234234234278", 434234234278L),
                    Arguments.of("818181911112111", 888911112111L)
            );
        }

    }

}
