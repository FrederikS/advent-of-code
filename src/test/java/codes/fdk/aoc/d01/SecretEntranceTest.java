package codes.fdk.aoc.d01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.list;

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
    void processDialRotations() {
        assertThat(SecretEntrance.processDialRotations(DIAL_ROTATIONS.stream()))
                .extracting(Dial::getStates, list(DialState.class))
                .containsExactlyInAnyOrder(
                        new DialState(50),
                        new DialState(82),
                        new DialState(52),
                        new DialState(0),
                        new DialState(95),
                        new DialState(55),
                        new DialState(0),
                        new DialState(99),
                        new DialState(0),
                        new DialState(14),
                        new DialState(32)
                );
    }

    @Test
    void testDeterminePassword() {
        assertThat(SecretEntrance.determinePassword(DIAL_ROTATIONS.stream())).isEqualTo("3");
    }

}
