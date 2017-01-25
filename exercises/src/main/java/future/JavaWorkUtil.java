package future;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author victorp
 */
public class JavaWorkUtil {

    static ExecutorService threadPool = Executors.newFixedThreadPool(10);



    public static Future<List<String>> doItInTheFuture(String... results) {
        CompletableFuture<String>[] futures = createFutures(results);
        return toSingleFuture(futures);
    }

    private static CompletableFuture<String>[] createFutures(String[] results) {
        CompletableFuture<String>[] futures = new CompletableFuture[results.length];

        IntStream.range(0, results.length).forEach(index -> {
            futures[index] = doWorkInTheFuture(100L, true, results[index], null);
        });

        return futures;
    }


    public static Future<Pair<Integer, String>> doItInTheFuture(Integer result1,String result2) {
        CompletableFuture<Integer> work1 = doWorkInTheFuture(100L, true,result1, null);
        CompletableFuture<String> work2 = doWorkInTheFuture(100L, true, result2, null);


        Future<Pair<Integer,String>> result =
                CompletableFuture.allOf(work1,work2)
                        .thenApply(v -> new Pair<>(work1.join(), work2.join()));


        return result;
    }




    static <R> CompletableFuture<R> doWorkInTheFuture(Long processingTimeMillis, boolean success, R result, RuntimeException exception ){
        return
                CompletableFuture.supplyAsync( () ->
                        doWork(processingTimeMillis, success,result,exception)
                        , threadPool);

    }

    static private <R> R doWork(Long processingTimeMillis, boolean success, R result, RuntimeException exception ) {
        if (success) {
            System.out.println("Going to sleep " + processingTimeMillis + " millis");
            sleep(processingTimeMillis);
            System.out.println("The work is done");
            return result;
        }else {
            throw exception;
        }
    }

    static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static <T> CompletableFuture<List<T>>  toSingleFuture(CompletableFuture<T>... futures){

        Stream<CompletableFuture<T>> futuresStream = Arrays.stream(futures);
        return CompletableFuture.allOf(futures)
                .thenApply(v -> futuresStream
                                .map(CompletableFuture::join)
                                .collect(toList())
                );
    }


}