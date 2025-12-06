package codes.fdk.aoc.d03;

import java.util.stream.Stream;

public class JoltageCalculator {

    public static long sumMaxJoltages(Stream<String> banks, int batteryCount) {
        return banks.mapToLong(bank -> calculateMaxJoltage(bank, batteryCount)).sum();
    }

    public static long calculateMaxJoltage(String bank, int batteryCount) {
        var builder = new StringBuilder();
        int startIndex = 0;

        for (int remaining = batteryCount; remaining > 0 ; remaining--) {
            char maxDigit = '0';
            int maxIndex = startIndex;

            for (int j = startIndex; j <= bank.length() - remaining; j++) {
                var battery = bank.charAt(j);
                if (battery > maxDigit) {
                    maxDigit = battery;
                    maxIndex = j;
                }
            }

            builder.append(maxDigit);
            startIndex = maxIndex + 1;
        }

        return Long.parseLong(builder.toString());
    }

}
