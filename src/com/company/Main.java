package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Callable<Integer>> callables = Arrays.asList(
                new MyCallable(3000, 5),
                new MyCallable(5000, 3),
                new MyCallable(1000, 7),
                new MyCallable(7000, 4)
        );
        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Future<Integer>> results = threadPool.invokeAll(callables);
        for (Future<Integer> result : results) {
            System.out.println("Колличество выведенных сообщений: " + result.get());
        }

        Integer result = threadPool.invokeAny(callables);
        System.out.println("Результат первой завершившейся задачи: " + result);

        threadPool.shutdown();

    }
}
