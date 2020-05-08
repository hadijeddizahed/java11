package java11.localvariable;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaLocalVar {

    public static void main(String[] args) {

        List<String> list = List.of("Hi","Hello","there","Java 11",null);

        List<String> upperCaseList = list.stream()
                .map(s->s.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(upperCaseList);
    }
}
