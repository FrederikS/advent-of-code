package codes.fdk.aoc.utils;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.stream.Gatherer;

public final class GatherUtils {

    public static <T,R> Gatherer<T, ?, R> zipWithIndex(BiFunction<Integer,T, R> zipFunction) {
        return Gatherer.ofSequential(
                AtomicInteger::new,
                Gatherer.Integrator.ofGreedy((index, element, downStream) -> {
                    return downStream.push(zipFunction.apply(index.getAndIncrement(), element));
                })
        );
    }

}
