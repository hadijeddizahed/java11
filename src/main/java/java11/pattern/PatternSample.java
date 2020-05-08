package java11.pattern;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class PatternSample {
    public static void main(String[] args) {

        Predicate<String> IS_THREE_DIGIT_NUMBER = Pattern.compile("^[0-9]{3}").asMatchPredicate();

        List<String> numbers = List.of("123","b23","876","2","asd");

        numbers.forEach(s-> System.out.println(IS_THREE_DIGIT_NUMBER.test(s)));
    }
}
