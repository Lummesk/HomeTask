package ua.com.sourceit.subtask5;

import java.util.concurrent.*;

public class CallCenter extends Thread {
	CyclicBarrier standByMessage;
    private Semaphore operators;

    public CallCenter(Semaphore operators, CyclicBarrier standByMessage, String name) {
        this.standByMessage = standByMessage;
        this.operators = operators;
        this.setName(name);
        this.start();
    }

    @Override
    public void run() {
        long duration = ThreadLocalRandom.current().nextLong(1, 10);

        try {
            System.out.println(getName() + " чекає розмови з оператором...");
            standByMessage.await();
            operators.acquire();
            System.out.println(getName() + " з'єднався з оператором.");
            Thread.sleep(TimeUnit.SECONDS.toMillis(duration));
            System.out.println(getName() + " закінчив розмову з оператором.");
            operators.release();
            System.out.println("Доступних операторів: " + operators.availablePermits());
        } catch (InterruptedException | BrokenBarrierException e) {
            System.err.println(e);
        }
    }
}
