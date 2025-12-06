package codes.fdk.aoc.d03;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LobbyTest {

    private static final List<String> BANKS = List.of(
            "987654321111111",
            "811111111111119",
            "234234234234278",
            "818181911112111"
    );

    @ParameterizedTest
    @MethodSource("batteryCounts")
    void testCalculateSumOfMaxJoltages(int batteryCount, long expectedSum) {
        assertThat(Lobby.sumMaxJoltages(BANKS.stream(), batteryCount)).isEqualTo(expectedSum);
    }

    static Stream<Arguments> batteryCounts() {
        return Stream.of(
                Arguments.of(2, 357L),
                Arguments.of(12, 3121910778619L)
        );
    }

}
