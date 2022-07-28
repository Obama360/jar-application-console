package ch.tacocat.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class example_app {
    public static void main(String[] args) throws IOException {
        new Thread(() -> {
            while (true) {
                System.out.println("Its been a second, did you miss me?");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );

        while (true) {
            String input = reader.readLine();
            System.out.println(input);
        }
    }
}
