package fibonacci;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author PeterBoss
 */
public class Main {

    static ArrayBlockingQueue<Long> s1 = new ArrayBlockingQueue<>(100);
    static ArrayBlockingQueue<Long> s2 = new ArrayBlockingQueue<>(100);
    static ExecutorService service = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {

        service.execute(() -> {
            Long[] nums = {
                4L, 5L, 8L, 12L, 21L, 22L, 34L, 35L, 36L, 37L, 42L
            };
            s1.addAll(Arrays.asList(nums));
            
            service.execute(producer);
            service.execute(producer);
            service.execute(producer);
            service.execute(producer);
            
        }
        );
        Thread.sleep(5000);
        service.shutdown();
    }

    static Runnable producer = () -> {
        for (Long l : s1) {
            try {
                s2.put(fib(s1.poll()));
            } catch (Exception e) {
                System.out.println("something went wrong:");
            }
        }
    };
    static Runnable consumer = () -> {

    };

    static long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

}
