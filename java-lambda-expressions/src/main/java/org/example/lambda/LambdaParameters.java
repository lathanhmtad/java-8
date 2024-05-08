package org.example.lambda;

@FunctionalInterface
interface Addable {
    int addition(int a, int b);
}

class AddableImple implements Addable {
    @Override
    public int addition(int a, int b) {
        return a + b;
    }
}

public class LambdaParameters {
    public static void main(String[] args) {
        Addable addition = (a, b) -> a + b;
        int result = addition.addition(10, 20);
        System.out.println(result);

        Addable abc = (a, b) -> {
            int c = a + b;
            return c;
        };
    }
}
