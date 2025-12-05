package codes.fdk.aoc.d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LobbyTest {

    private static final List<String> LABELS = List.of(
            "987654321111111",
            "811111111111119",
            "234234234234278",
            "818181911112111"
    );

    @Test
    void testCalculateSumOfMaxJoltages() {
        assertThat(Lobby.calculateSumOfMaxJoltages(LABELS.stream())).isEqualTo(357L);
    }
}
