package ua.com.sourceit.subtask5;

import java.util.concurrent.*;

public class SubTask5 
{
	public static void main(String[] args) {


        Semaphore operators = new Semaphore(2);

        CyclicBarrier standbyMessage = new CyclicBarrier(3, new StandBy());

        System.out.println("Call Center готовий до роботи");

        System.out.println("Доступних операторів: " + operators.availablePermits());

        new CallCenter(operators, standbyMessage, "Сергій");
        new CallCenter(operators, standbyMessage, "Марія");
        new CallCenter(operators, standbyMessage, "Степан");
        new CallCenter(operators, standbyMessage, "Петро");
        new CallCenter(operators, standbyMessage, "Іван");
    }
}


