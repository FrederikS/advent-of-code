package codes.fdk.aoc.d01;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DialTest {

    @ParameterizedTest
    @MethodSource("rotations")
    void testProcessRotation(int pointer, String rotation, int expected) {
        var dial = new Dial(pointer);
        dial.processRotation(DialRotation.of(rotation));
        assertThat(dial.getPointer()).isEqualTo(expected);
    }

    private static Stream<Arguments> rotations() {
        return Stream.of(
                Arguments.of(50, "L523", 27),
                Arguments.of(50, "L68", 82),
                Arguments.of(50, "L20", 30),
                Arguments.of(50, "R20", 70),
                Arguments.of(50, "R60", 10),
                Arguments.of(50, "R939", 89),
                Arguments.of(52, "R48", 0),
                Arguments.of(55, "L55", 0),
                Arguments.of(95, "R60", 55),
                Arguments.of(67, "R337", 4),
                Arguments.of(91, "R683", 74),
                Arguments.of(0, "L299", 1),
                Arguments.of(39, "L139", 0)
        );
    }

}
