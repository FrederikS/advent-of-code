package codes.fdk.aoc.d01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SecretEntranceTest {

    private static final List<String> DIAL_ROTATIONS = List.of(
            "L68",
            "L30",
            "R48",
            "L5",
            "R60",
            "L55",
            "L1",
            "L99",
            "R14",
            "L82"
    );

    @Test
    void testDeterminePassword() {
        assertThat(SecretEntrance.determinePassword(DIAL_ROTATIONS.stream())).isEqualTo("6");
    }

}
