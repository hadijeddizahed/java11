package java9;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalFeatures {
    public static void main(String[] args) {

        List<String> languages = Arrays.asList("Java", "C#", "c++", null);


        System.out.println(languages.stream()
                .map(OptionalFeatures::toUpperCase)
                .flatMap(Optional::stream)
                .collect(Collectors.toList()));

        Optional<Integer> optionalInteger = Optional.empty();

        optionalInteger.ifPresentOrElse(i->plusOne(i),()->plusTwo(2));

        System.out.println(optionalInteger.or(() -> Optional.of(plusTwo(3))).get());
    }


    private static Optional<String> toUpperCase(String str) {
        return Optional.ofNullable(str).map(String::toUpperCase);
    }


    private static int plusOne(int a){
        System.out.println("plusOne is called....");
        return a++;
    }

    private static int plusTwo(int a){
        System.out.println("plusTwo is called....");
        return a+2;
    }
}
