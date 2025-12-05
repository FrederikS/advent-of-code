package codes.fdk.aoc.d02;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Gatherers;

public class IdCheckerStrategyPartTwo implements IdCheckerStrategy {

    @Override
    public boolean test(long id) {
        var string = String.valueOf(id);
        for (int i = 0; i < string.length() / 2; i++) {
            var sub = string.substring(0, i + 1);
            if (string.length() % sub.length() == 0 && isIsInvalid(string, sub)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isIsInvalid(String string, String sub) {
        return string.chars()
                     .boxed()
                     .gather(Gatherers.windowFixed(sub.length()))
                     .map(window -> window.stream().map(Character::toString).collect(Collectors.joining()))
                     .allMatch(Predicate.isEqual(sub));
    }

}
