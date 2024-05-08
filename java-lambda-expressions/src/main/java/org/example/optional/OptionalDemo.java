package org.example.optional;

import org.example.OptionalExtend;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        String name = "duy";

//        Optional<String> emailOptional = Optional.of(name);
//        System.out.println(emailOptional);

//        Optional<String> stringOptional = Optional.ofNullable(name);
//        System.out.println(stringOptional);

        Optional<String> stringOptional = Optional.ofNullable(name);
        String defaultOptional = stringOptional.orElse("default name");
        System.out.println(defaultOptional);


//        stringOptional.orElseThrow();

        String result = "abc";

        Optional<String> optionalStr = Optional.of(result);
        optionalStr.filter(res -> res.contains("abc"))
                .map(String::trim)
                .ifPresent(res -> System.out.println(res));

    }

    public void get() {
        throw  new NoSuchElementException("Hi");
    }
}
