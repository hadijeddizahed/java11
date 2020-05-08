package stackoverflow;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Question13 {
    @SuppressWarnings("OptionalGetWithoutIsPresent")

    public static String fullTime;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm a");
    public static ZonedDateTime newTime;

    public static void main(String[] args) {
        String name = null;

        MyObject obj1 = new MyObject(new X(new XX("dd")), new Y(new YY("kk")));

        Optional.ofNullable(obj1.getX());
        List<Supplier<Optional<String>>> suppliers =
                Arrays.asList(() -> Optional.ofNullable(obj1.getX()).map(X::getXX).map(XX::getName),
                        () -> Optional.ofNullable(obj1.getY()).map(Y::getYY).map(YY::getName));

        name = suppliers.stream()
                .map(Supplier::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst().orElse(null);

//        name = Stream.of(
//                Optional.ofNullable(obj1.getX()).map(X::getXX).map(XX::getName),
//                Optional.ofNullable(obj1.getY()).map(Y::getYY).map(YY::getName)
//        )
//                .filter(Optional::isPresent)
//                .map(Optional::get)
//                .findFirst().orElse(null);


        System.out.println(name);

        String esConnectionPropertiesStr = "ID1, 701, REST, 0, $PROJECT_ID),\n" +
                "ID2, 702, ES_USERNAME, 0, $PROJECT_ID),\n" +
                "ID3, 703, ES_PASSWORD, 0, $PROJECT_ID),\n" +
                "ID4, 704, ES_HOST, 0, $PROJECT_ID";

        Function<List<String>, Map<Integer, String>> listToMap = list ->
                IntStream.range(0, list.size())
                        .mapToObj(i -> new AbstractMap.SimpleEntry<>(i + 1, list.get(i)))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(Arrays.stream(esConnectionPropertiesStr.split("\\),"))
                .map(s1 -> Arrays.stream(s1.split(","))
                        .collect(() -> new HashMap<Integer, String>(), (m, s) -> m.put(m.size() + 1, s),
                                (m1, m2) -> {
                                    int offset = m1.size();
                                    m2.forEach((i, s) -> m1.put(i + offset, s));
                                }))
                .collect(Collectors.toList())
        );

        Character[] tokens = {'5', '6', ' ', 'A', '8'};

        System.out.println(Arrays.stream(tokens)
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .collect(Collectors.toCollection(Stack<Integer>::new)));

        Stack<Integer> values = new Stack<>();

        Arrays.stream(tokens)
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .forEach(values::push);

        String str = "Hellooo";
        String x = "1";


        List<List<Integer>> seqList = IntStream.range(0, 10)
                .mapToObj(ArrayList<Integer>::new)
                .collect(Collectors.toList());

        System.out.println(seqList);

        GreetingService greetService1 = message -> System.out.println(GreetingService.salutation + message);
        greetService1.sayMessage(" World");

        int[] array = {1, 2, 3, 2, 4, 5, 6, 7, 8, 1, 0, 4, 5, 6};


        Map<Integer, Integer> map = IntStream.range(0, array.length)
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(array[i], array[i]))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a));

//        Map<Integer, Integer>
//                map2 = Collections.unmodifiableMap(map.entrySet().stream().sorted(Map.Entry.comparingByValue())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a)));
//
//        map2.put(45, 455);

//        System.out.println(map2);

        Map<Character, Integer> characterMap = new HashMap<>();
        characterMap.put('a', 5);
        characterMap.put('b', 20);
        characterMap.put('c', 10);

        List<Character> alphabetList = new ArrayList<>();
        characterMap.forEach((key, value) -> alphabetList.addAll(Collections.nCopies(value, key)));

        System.out.println(alphabetList);
    }
}

enum MessageKeyRegistry {

}

interface GreetingService {
    String salutation = "Hello";

    void sayMessage(String message);
}

class MyObject {
    X x;
    Y y;

    public MyObject(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }
}

class X {

    XX xx;

    public X(XX xx) {
        this.xx = xx;
    }

    public XX getXX() {
        return xx;
    }
}

class XX {
    String name;

    public XX(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Y {

    YY yy;

    public Y(YY yy) {
        this.yy = yy;
    }

    public YY getYY() {
        return yy;
    }
}

class YY {
    String name;

    public YY(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}