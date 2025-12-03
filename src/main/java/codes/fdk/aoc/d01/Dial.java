package codes.fdk.aoc.d01;

import java.util.concurrent.atomic.AtomicInteger;

import static codes.fdk.aoc.d01.DialRotation.LeftDialRotation;
import static codes.fdk.aoc.d01.DialRotation.RightDialRotation;

public class Dial {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 99;
    private static final int INITIAL_POINTER = 50;

    private final AtomicInteger pointer;
    private final AtomicInteger zeroCounter = new AtomicInteger();

    public Dial() {
        this.pointer = new AtomicInteger(INITIAL_POINTER);
    }

    public Dial(int pointer) {
        this.pointer = new AtomicInteger(pointer);
    }

    public Dial processRotation(DialRotation rotation) {
        applyRotation(rotation);
        return this;
    }

    private void applyRotation(DialRotation rotation) {
        switch (rotation) {
            case LeftDialRotation(int distance) -> rotateLeft(distance);
            case RightDialRotation(int distance) -> rotateRight(distance);
        }
    }

    private void rotateLeft(int distance) {
        while (distance > 0) {
            turnLeft();
            incrementCounterIfZero();
            distance--;
        }
    }

    private void turnLeft() {
        var previous = this.pointer.getAndDecrement();
        if (previous == MIN_NUMBER) {
            this.pointer.set(MAX_NUMBER);
        }
    }

    private void rotateRight(int distance) {
        while (distance > 0) {
            turnRight();
            incrementCounterIfZero();
            distance--;
        }
    }

    private void turnRight() {
        var previous = this.pointer.getAndIncrement();
        if (previous == MAX_NUMBER) {
            this.pointer.set(MIN_NUMBER);
        }
    }

    private void incrementCounterIfZero() {
        if (this.pointer.get() == MIN_NUMBER) {
            this.zeroCounter.getAndIncrement();
        }
    }

    public int getPointer() {
        return pointer.get();
    }

    public int getZeroCount() {
        return zeroCounter.get();
    }

}
