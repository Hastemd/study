package com.example.businessErrorCase;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 测试用例
 *
 * @author lijie
 * @date 2025/4/28 15:03
 */
public class TestConcurrentHashMap {
    private static Map<String, Long> gooduse() throws InterruptedException {
        //循环次数
        int LOOP_COUNT = 10000;
        //线程数量
        int THREAD_COUNT = 10;
        //元素数量
        int ITEM_COUNT = 10;

        ConcurrentHashMap<String, LongAdder> freqs = new ConcurrentHashMap<>(ITEM_COUNT);
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, LOOP_COUNT).parallel().forEach(i -> {
                    String key = "item" + ThreadLocalRandom.current().nextInt(ITEM_COUNT);
                    //利用computeIfAbsent()方法来实例化LongAdder，然后利用LongAdder来进行线程安全计数
                    freqs.computeIfAbsent(key, k -> new LongAdder()).increment();
                }
        ));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        //因为我们的Value是LongAdder而不是Long，所以需要做一次转换才能返回
        return freqs.entrySet().stream()
                .collect(Collectors.toMap(
                        e -> e.getKey(),
                        e -> e.getValue().longValue())
                );
    }

    public static void main(String[] args) throws InterruptedException {
        //Map<String, Long> gooduse = gooduse();
        //gooduse.forEach((k, v) -> System.out.println(k + ":" + v));
        System.out.println(972+
                1031+
                1018+
                1000+
                970+
                1030+
                987+
                993+
                998+
                1001);
    }
}
