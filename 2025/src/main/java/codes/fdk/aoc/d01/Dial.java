package codes.fdk.aoc.d01;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static codes.fdk.aoc.d01.DialRotation.LeftDialRotation;
import static codes.fdk.aoc.d01.DialRotation.RightDialRotation;

public class Dial {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 99;
    private static final int INITIAL_POINTER = 50;

    private final AtomicInteger pointer;

    private Consumer<Integer> onPointerChanged = pointer -> {};
    private Consumer<Integer> onRotationCompleted = pointer -> {};

    public Dial() {
        this.pointer = new AtomicInteger(INITIAL_POINTER);
    }

    public Dial(int pointer) {
        this.pointer = new AtomicInteger(pointer);
    }

    public void processRotations(Stream<DialRotation> rotations) {
        rotations.forEach(this::processRotation);
    }

    public void processRotation(DialRotation rotation) {
        switch (rotation) {
            case LeftDialRotation(int distance) -> rotateLeft(distance);
            case RightDialRotation(int distance) -> rotateRight(distance);
        }
    }

    private void rotateLeft(int distance) {
        while (distance > 0) {
            turnLeft();
            distance--;
        }
        this.onRotationCompleted.accept(this.pointer.get());
    }

    private void turnLeft() {
        var previous = this.pointer.getAndDecrement();
        if (previous == MIN_NUMBER) {
            this.pointer.set(MAX_NUMBER);
        }
        this.onPointerChanged.accept(this.pointer.get());
    }

    private void rotateRight(int distance) {
        while (distance > 0) {
            turnRight();
            distance--;
        }
        this.onRotationCompleted.accept(this.pointer.get());
    }

    private void turnRight() {
        var previous = this.pointer.getAndIncrement();
        if (previous == MAX_NUMBER) {
            this.pointer.set(MIN_NUMBER);
        }
        this.onPointerChanged.accept(this.pointer.get());
    }

    public int getPointer() {
        return pointer.get();
    }

    public void onPointerChanged(Consumer<Integer> onPointerChanged) {
        this.onPointerChanged = onPointerChanged;
    }

    public void onRotationCompleted(Consumer<Integer> onRotationCompleted) {
        this.onRotationCompleted = onRotationCompleted;
    }

}
