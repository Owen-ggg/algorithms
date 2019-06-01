package jdk8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * @author Mengjun Wen
 * @date 2018/7/22
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture[] futures = new CompletableFuture[10];
        List resultList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            CompletableFuture<Object> future1 = CompletableFuture.supplyAsync(() -> {
                System.out.println("do something"+ finalI);
                String result  = "result"+finalI;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return result;
            });
            futures[i]=future1;
            future1.thenAccept(result->resultList.add(result));
        }

        //调用get方法的线程会阻塞等待get返回结果
        // allOf 方法会等待所有线程执行结束
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures);
        allOf.join();
        System.out.println(resultList.toString());
    }
}
