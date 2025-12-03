package codes.fdk.aoc.d01;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

import static codes.fdk.aoc.d01.DialRotation.LeftDialRotation;
import static codes.fdk.aoc.d01.DialRotation.RightDialRotation;

public class Dial {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 99;

    private final SequencedCollection<DialState> states;

    public Dial(SequencedCollection<DialState> states) {
        this.states = new ArrayList<>(states);
    }

    public static Dial initial() {
        return new Dial(List.of(DialState.initial()));
    }

    public SequencedCollection<DialState> getStates() {
        return states;
    }

    public int getPointer() {
        return states.getLast().pointer();
    }

    public Dial processRotation(DialRotation rotation) {
        states.add(applyRotation(rotation));
        return this;
    }

    private DialState applyRotation(DialRotation rotation) {
        return switch (rotation) {
            case LeftDialRotation(int distance) -> rotateLeft(distance);
            case RightDialRotation(int distance) -> rotateRight(distance);
        };
    }

    private DialState rotateLeft(int distance) {
        int pointer = states.getLast().pointer();
        while (distance > 0) {
            if (pointer == MIN_NUMBER) {
                pointer = MAX_NUMBER;
            } else {
                pointer--;
            }
            distance--;
        }
        return new DialState(pointer);
    }

    private DialState rotateRight(int distance) {
        int pointer = states.getLast().pointer();
        while (distance > 0) {
            if (pointer == MAX_NUMBER) {
                pointer = MIN_NUMBER;
            } else {
                pointer++;
            }
            distance--;
        }
        return new DialState(pointer);
    }

    long countZeros() {
        return states.stream()
                     .filter(state -> state.pointer() == 0)
                     .count();
    }

}
