package codes.fdk.aoc.d03;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class JoltageCalculatorTest {

    @ParameterizedTest
    @MethodSource("labels")
    void name(String label, int maxJoltage) {
        assertThat(JoltageCalculator.calculateMax(label)).isEqualTo(maxJoltage);
    }

    private static Stream<Arguments> labels() {
        return Stream.of(
                Arguments.of("987654321111111", 98),
                Arguments.of("811111111111119", 89),
                Arguments.of("234234234234278", 78),
                Arguments.of("818181911112111", 92)
        );
    }


}
