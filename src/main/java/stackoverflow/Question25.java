package stackoverflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Question25 {
    public static void main(String[] args) {

        Item1 item1 = new Item1();
        item1.setName("item1");
        Item1 item2 = new Item1();
        item2.setName("item2");
        item2.setMoveToLast(true);
        Item1 item3 = new Item1();
        item3.setName("item3");
        Item1 item4 = new Item1();
        item4.setName("item4");

        List<Item1> items = new ArrayList<>(Arrays.asList(item1, item2, item3, item4));

        List<Item1> result = new ArrayList<>();

        Map<Boolean, List<Item1>> partitionBy = items.stream()
                .collect(Collectors.partitioningBy(Item1::isMoveToLast));
        items =Stream.of(partitionBy.get(false), partitionBy.get(true))
                .flatMap(List::stream)
                .collect(Collectors.toList());


        System.out.println(items);


    }


}

@AllArgsConstructor
@Data
@NoArgsConstructor
class Item1 {
    private int order;
    private String name;
    private boolean isMoveToLast;

}
