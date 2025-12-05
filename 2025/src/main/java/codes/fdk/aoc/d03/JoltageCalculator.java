package codes.fdk.aoc.d03;

public class JoltageCalculator {

    public static int calculateMax(String label) {
        int max = 0;
        for (int i = 0; i < label.length(); i++) {
            char current = label.charAt(i);
            for (int j = i + 1; j < label.length(); j++) {
                char next = label.charAt(j);
                int combined = Integer.parseInt("%c%c".formatted(current, next));
                max = Math.max(max, combined);
            }
        }

        return max;
    }

}
