package stackoverflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Question18 {
    public static void main(String[] args) {
        List<String> priorities = Arrays.asList("NV", "PH", "OO", "DR");

        List<Item0> availableItems = List.of(new Item0(1, "OO"),
                new Item0(11,"PH"),
                new Item0(13,"OO"),
                new Item0(14,"DR"),
                new Item0(12,"OO"),
                new Item0(15,"PH"),
                new Item0(16,"OO")
        );

        Collections.min(availableItems, Comparator.comparingInt(o -> priorities.indexOf(o.getType())));
        List<String> s = new ArrayList<>();

        priorities.forEach(s::add);

        TreeMap<Integer, List<Item0>> groupByType = availableItems.stream()
                .collect(Collectors.groupingBy(item -> priorities.indexOf(item.getType()), TreeMap::new, Collectors.toList()));
        System.out.println(groupByType.firstEntry().getValue().get(0));

        Map<String, Map<String, Integer>> mapMap = Map.of("aaa", Map.of("bbb", 233), "ddd", Map.of("ccc", 5555));
        Map<String, Map<String, Integer>> mapMap2 = Map.of("aaa", Map.of("bbb2", 2332), "ddd2", Map.of("ccc2", 55552));

        Map<String, Map<String, Integer>> result = new HashMap<>(mapMap);
        result.putAll(mapMap2);
        System.out.println(result);


        Map<String, Integer> map = new HashMap<>();
        for (Map<String, Integer> stringIntegerMap : mapMap.values()) {
            map.putAll(stringIntegerMap);
        }

        System.out.println(map);

        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        for (Map<String, Integer> stringIntegerMap : mapMap.values()) {
            stringIntegerHashMap.putAll(stringIntegerMap);
        }
        Map<String, Integer> ma = stringIntegerHashMap;

        System.out.println(ma);

        List<itemsDTO> list = new ArrayList<>(Arrays.asList(new itemsDTO(1,"kg","chicken"),
                new itemsDTO(2,"kg","chicken"),
                new itemsDTO(1,"kg","beaf")));
        BinaryOperator<itemsDTO> sumQuantity = (a, b) -> {
            a.setQuantity(a.getQuantity() + b.getQuantity());
            return a;
        };
        System.out.println(list.stream().collect(Collectors.toMap(itemsDTO::getIngredient, Function.identity(), sumQuantity)).values()
                .stream().map(itemsDTO::toString).collect(Collectors.toList()));
//        list  = new ArrayList<>(list.stream().collect(Collectors.toMap(itemsDTO::getIngredient, Function.identity(), sumQuantity)).values());

//        System.out.println(list.stream()
//                .collect(Collectors.groupingBy(itemsDTO::getIngredient, Collectors.collectingAndThen())));

        System.out.println(list);
    }


    private static itemsDTO apply(itemsDTO i1, itemsDTO i2) {
        i1.setQuantity(i1.getQuantity() + i2.getQuantity());
        return i1;
    }
}

@Data
@AllArgsConstructor
@Getter
class itemsDTO {

    double quantity;
    String unit;
    String ingredient;

}

@Data
@AllArgsConstructor
@Getter
class MyClass {

    String property1;

    Map<String, Object> property2;

}

@Data
@AllArgsConstructor
@Getter
class Item0 {
    private Integer id;
    private String type;
}