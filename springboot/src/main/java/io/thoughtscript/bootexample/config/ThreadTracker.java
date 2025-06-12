package io.thoughtscript.bootexample.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class ThreadTracker implements CommandLineRunner {
    @Value("${custom.tracking.thread}")
    private boolean enabled;

    @Override
    public void run(String... args) {
        if (enabled) {
            ExecutorService nonBlockingService = Executors.newSingleThreadExecutor();
            nonBlockingService.execute(() -> {
                while (true) {
                    Set<Thread> threads = Thread.getAllStackTraces().keySet();
                    System.out.println("=================================================================================");
                    for (Thread t : threads) {
                        System.out.println(" [ Thread Id: " + t.getId() + " Name: " + t.getName() + " State: " +  t.getState());
                    }

                    try {
                        Thread.sleep(5000);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }
}
