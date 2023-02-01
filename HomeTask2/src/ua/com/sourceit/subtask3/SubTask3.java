package ua.com.sourceit.subtask3;

import java.util.Random;
import java.util.Scanner;

public class SubTask3 {
    public static void main(String[] args) {
    	int randomNum = new Random().nextInt(1, 101);
        Scanner sc = new Scanner(System.in);
        System.out.println("Комп'ютер загадав число від 1 до 100, ваша задача вгадати його.");
        while (true) {
            System.out.print("Ваш варіант: ");
            int answer = sc.nextInt();
            if (answer == randomNum) {
                System.out.println("Молодець!");
                break;
            } else if (answer < randomNum) {
                System.out.println("Меньше");
            } else {
                System.out.println("Більше");
            }
        }
    }
}
