package org.example.lambda.functional;


class ThreadDemo implements Runnable {

    @Override
    public void run() {
        System.out.println("Run method called ...");
    }
}

public class RunnableLambdaExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadDemo());
        thread.start();

        Runnable runnable = () -> System.out.println("Run method called ...");
    }
}
