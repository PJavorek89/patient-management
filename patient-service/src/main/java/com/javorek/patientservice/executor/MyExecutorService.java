package com.javorek.patientservice.executor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.*;

@Service
public class MyExecutorService implements CommandLineRunner {

    private final ExecutorService executorService;

    public MyExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    List<Callable<String>> ukoly = List.of(
            () -> { Thread.sleep(300); return "Výsledek A v 1. vlakne" + Thread.currentThread().getName(); },
            () -> { Thread.sleep(100); return "Výsledek B v 2. vlakne" + Thread.currentThread().getName(); },
            () -> { Thread.sleep(200); return "Výsledek C v 3, vlakne" + Thread.currentThread().getName(); },
            () -> { Thread.sleep(10000); return "Výsledek D v 4. vlakne" + Thread.currentThread().getName(); },
            () -> { Thread.sleep(500); return "Výsledek E v 2. vlakne co se uvilnilo jako prvni" + Thread.currentThread().getName(); }
    );

    public List<Future<String>> executeAllThreads() throws InterruptedException {
        return executorService.invokeAll(ukoly);
    }



    @Override
    public void run(String... args) throws Exception {
        System.out.println("Do somethnig");

        /**
        executorService.submit(() -> {
            List<Future<String>> futures = null;
            try {
                futures = executeAllThreads();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for(Future<String> future : futures) {
                try {
                    System.out.println(future.get() + " -" + future.toString());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }

        });
         */

        /**
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
                return "Výsledek A v 1. vlakne" + Thread.currentThread().getName();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
                return "Výsledek B v 2. vlakne" + Thread.currentThread().getName();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                return "Výsledek C v 3. vlakne" + Thread.currentThread().getName();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000);
                return "Výsledek D v 4. vlakne" + Thread.currentThread().getName();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Čekám na první dokončenou úlohu...");
        CompletableFuture.allOf(future1, future2, future3, future4)
                .thenRun(() -> {

                        System.out.println("Všechny úlohy dokončeny!");
                        System.out.println(future1.join());
                        System.out.println(future2.join());
                        System.out.println(future3.join());
                        System.out.println(future4.join());
                });

        future3.thenAccept(result -> {
            System.out.println("Úloha C dokončena s výsledkem: " + result);
        });
         */




    }
}
