package stackoverflow;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question26 {
    public static void main(String[] args) {
        List<Item> items = List.of(
                new Item("B", "C"),
                new Item("D", "E"),
                new Item("A", "B"),
                new Item("E", "F"),
                new Item("C", "D"));

        Map<String, String> map = items.stream()
                .collect(Collectors.toMap(Item::getStart, Item::getEnd));

 

        System.out.println(map);

        System.out.println(route(map, "B", "E"));



    }

    private static Map<String, String> route(Map<String, String> map, String start, String end) {
        Map<String, String> result = new LinkedHashMap<>();
        if (!map.containsKey(start)) return null;
        String nextRoute = start;
        while (!map.get(nextRoute).equals(end))
            result.put(nextRoute, (nextRoute = map.get(nextRoute)));
        result.put(nextRoute, map.get(nextRoute));

        return result;
    }


    @Data
    @AllArgsConstructor
    class Transaction {

        private String heading;
        private LocalDate date;
        private BigDecimal amount;

    }

    private static class Item {
        private final String start;
        private final String end;

        private Item(String start, String end) {
            this.start = start;
            this.end = end;
        }

        public String getStart() {
            return this.start;
        }

        public String getEnd() {
            return this.end;
        }
    }
}
