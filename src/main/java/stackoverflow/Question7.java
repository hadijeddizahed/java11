package stackoverflow;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question7 {

    public static void main(String[] args) {

        List<List<String>> lists = List.of(List.of("Asdfsd", "Sfsdf", "ddd", "Adasdas", "Asdasdasd", "dd"),
                List.of("s", "f", "r"));
//        List<String> list = Arrays.asList("Addd","sdf","Sdfsdf","sdfsdfsdf");

        Supplier<Stream<List<String>>> supplier = lists::stream;
        System.out.println(Stream.concat(supplier.get().filter(l -> l.size() > 5).flatMap(List::stream)
                        .filter(s -> s.contains("A")),
                supplier.get().filter(l -> l.size() < 5).flatMap(List::stream))
                .collect(Collectors.toList()));





        Set<AlertSide> mySet = EnumSet.allOf(AlertSide.class);
        String result = String.join(",", mySet.stream()
                .map(it -> "'" + it + "'")
                .collect(Collectors.toList()));


        System.out.println(Optional.of(mySet)
                .filter(s -> !s.isEmpty())
                .map(set -> set.stream()

                        .map(AlertSide::name)
                        .collect(Collectors.joining("','", "'", "'")))
                .orElse("nothing"));

        System.out.println(result);
        if (!mySet.isEmpty())
        System.out.println(mySet.stream()

                .map(AlertSide::name)
                .collect(Collectors.joining("','", "'", "'")));
    }

}
enum AlertSide{

}