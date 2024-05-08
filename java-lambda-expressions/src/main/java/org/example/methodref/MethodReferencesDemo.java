package org.example.methodref;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface Printable {
    void print(String msg);
}

public class MethodReferencesDemo {

    public void display(String msg) {
        msg = msg.toUpperCase();
        System.out.println(msg);
    }

    public static int addition(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        // 1. Method reference to a static method
        // lambda expression
        Function<Integer, Double> function = (input) -> Math.sqrt(input);
        System.out.println(function.apply(4));

        // using method reference
        Function<Integer, Double> functionMethodRef = Math::sqrt;
        System.out.println(functionMethodRef.apply(8));

        // lambda expression
        BiFunction<Integer, Integer, Double> biFunctionLambda = Math::pow;
        System.out.println(biFunctionLambda.apply(2, 3));

        // using method reference
        BiFunction<Integer, Integer, Integer> biFunctionMethodRef = MethodReferencesDemo::addition;
        System.out.println(biFunctionMethodRef.apply(5, 6));


        // 2. Method reference to an instance method of an object
        MethodReferencesDemo methodReferencesDemo = new MethodReferencesDemo();

        // lambda expression
        Printable printable = msg -> methodReferencesDemo.display(msg);
        printable.print("test");

        // using method reference
        Printable printableMethodRef = methodReferencesDemo::display;
        printableMethodRef.print("test2");


        /**
         * 3. Reference to the instance method of an arbitrary object
         * Sometimes, we call a method of argument in the lambda expression
         * In that case, we can use a method reference to call an instance
         * method of an arbitrary object of a specific type.
         */

        Function<String, String> stringFunction = (input) -> input.toLowerCase();
        System.out.println(stringFunction.apply("Hello World!"));

        // using method reference
        Function<String, String> stringFunctionMethodRef = String::toLowerCase;
        System.out.println(stringFunctionMethodRef.apply("Nguyen Dang Duy"));
//
        String[] strArray = {"A", "E", "I", "O", "U", "a", "e", "i", "o", "u"};
        // using lambda
//        Arrays.sort(strArray, (s1, s2) -> s1.compareToIgnoreCase(s2));
//         Arrays.stream(strArray).forEach((str) -> System.out.print(str + " "));
//        Arrays.stream(strArray).forEach(System.out::print);
//        System.out.println();

        // using method reference
        Arrays.sort(strArray, String::compareToIgnoreCase);
        Arrays.stream(strArray).forEach((str) -> System.out.print(str + " "));
//
//        // 4. reference to a constructor
//        List<String> fruits = new ArrayList<>();
//        fruits.add("Banana");
//        fruits.add("apple");
//        fruits.add("mango");
//        fruits.add("watermelon");
//
//        Function<List<String>, Set<String>> setFunction = strList -> new HashSet<>(strList);
//        System.out.println(setFunction.apply(fruits));
//
//        // using method reference
//        Function<List<String>, Set<String>> setFunctionMethodRef = HashSet::new;
//        System.out.println(setFunctionMethodRef.apply(fruits));

    }
}
