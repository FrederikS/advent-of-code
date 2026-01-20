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

    @ParameterizedTest
    @MethodSource("mergeArguments")
    void testMerge(String value1, String value2, String valueExpected) {
        var mergedRange = Range.of(value1).merge(Range.of(value2));
        assertThat(mergedRange).isEqualTo(Range.of(valueExpected));
    }

    private static Stream<Arguments> mergeArguments() {
        return Stream.of(
                Arguments.of("3-5", "10-14", "3-5"),
                Arguments.of("10-14", "12-18", "10-18"),
                Arguments.of("16-20", "12-18", "12-20"),
                Arguments.of("16-20", "20-22", "16-22"),
                Arguments.of("16-20", "16-22", "16-22"),
                Arguments.of("16-20", "21-26", "16-26"),
                Arguments.of("16-20", "13-15", "13-20"),
                Arguments.of("16-20", "12-28", "12-28")
        );
    }

}
