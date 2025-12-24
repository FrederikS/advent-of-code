package codes.fdk.aoc.d02;

import codes.fdk.aoc.common.Range;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RangeTest {

    @ParameterizedTest
    @MethodSource("ranges")
    void testRangeParsing(String value, long expectedStart, long expectedEnd) {
        assertThat(Range.of(value)).satisfies(range -> {
            assertThat(range.start()).isEqualTo(expectedStart);
            assertThat(range.end()).isEqualTo(expectedEnd);
        });
    }

    private static Stream<Arguments> ranges() {
        return Stream.of(
                Arguments.of("11-22", 11, 22),
                Arguments.of("95-115", 95, 115)
        );
    }

}
