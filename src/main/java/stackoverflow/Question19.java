package stackoverflow;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question19 {
    public static void main(String[] args) {


        Map<String, Map<Food, List<String>>> fruitBasket = new HashMap<>();
        fruitBasket.put("basket1", Collections.singletonMap(Food.FRUITS, Arrays.asList("apple", "banana")));
        fruitBasket.put("basket2", Collections.singletonMap(Food.FRUITS, Arrays.asList("orange", "kiwi")));
        fruitBasket.put("basket3", Collections.singletonMap(Food.FRUITS, Arrays.asList("banana", "orange")));

        Map<String, Map<Food, List<String>>> veggieBasket = new HashMap<>();
        veggieBasket.put("basket1", Collections.singletonMap(Food.VEGGIES, Arrays.asList("Tomato", "Onion")));
        veggieBasket.put("basket2", Collections.singletonMap(Food.VEGGIES, Arrays.asList("Onion", "Potato")));
        veggieBasket.put("basket3", Collections.singletonMap(Food.VEGGIES, Arrays.asList("Potato", "Tomato")));


        Map<String, Map<Food, List<String>>> res = new HashMap<>();

        Map<String, Map<Food, List<String>>> groceryBasket =
                Stream.concat(fruitBasket.entrySet().stream(),veggieBasket.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().entrySet().stream()
                                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)),
                        (a, b) -> { a.putAll(b);return a; }
                        )
                );
        Map<String, Map<Food, List<String>>> groceryBasket2 =
                Stream.concat(fruitBasket.entrySet().stream(), veggieBasket.entrySet().stream())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> {
                            Map<Food, List<String>> innerMap = new HashMap<>(a);
                            innerMap.putAll(b);
                            return innerMap;
                        }));

        System.out.println(groceryBasket2);


    }
}

enum Food {
    FRUITS, VEGGIES;
}