package stackoverflow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShuffleList {
    public static void main(String[] args) {

        Set<String> set1 = Set.of("abc","xyz","mnop");
        Set<String> set2 = Set.of("hello.world.mnop", "hello.world", "foo.bar");

        Map<String, String> newMap = new HashMap<String, String>();
        newMap.put("o","one");
        newMap.put("v",null);
        System.out.println(newMap.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey().toUpperCase(), o -> o.getValue())));


        List<Integer> numbers = List.of(12,3,454,67,2333,2,3,12,232);

        System.out.println(numbers.stream().limit(100).collect(Collectors.toList()));

//        numbers.stream()
//                .collect(Collectors.toMap(o -> o,integer -> integer));
//        Integer max = Integer.MIN_VALUE;
//        Integer min = Integer.MAX_VALUE;
//
//        MaxMin maxMin = new MaxMin(Integer.MAX_VALUE,Integer.MIN_VALUE);
//        for (Integer number:numbers){
//            if (number > maxMin.getMax())
//                max = number;
//            if (number < min)
//                min = number;
//        }
//        BinaryOperator<MaxMin> findMaxMin = (maxMin1, maxMin2) -> {
//
//            if (maxMin1.getMin() > maxMin2.getMin())
//                maxMin1.setMin(maxMin2.getMin());
//            if (maxMin1.getMax() < maxMin2.getMax())
//                maxMin1.setMax(maxMin2.getMax());
//            return maxMin1;
//        };
//        System.out.println(numbers.stream()
//                .map(num -> new MaxMin(num, num))
//                .reduce(findMaxMin::apply).get());
//
//        System.out.println(max);
//        System.out.println(min);
    }

    private Map<String, String> toUpperKeys(Map<String, String> map) {
        //Method 1 : Throwing NullPointerExpecption because Map.Entry::getValue is null
//        return map.entrySet().stream()
//                .collect(Collectors.toMap(e -> e.getKey().toUpperCase(), Map.Entry::getValue));

        //Method 2 : Working fine
        Map<String, String> newMap = new HashMap<String, String>();
        for(Map.Entry<String, String> e : map.entrySet()) {
            newMap.put(e.getKey().toUpperCase(), e.getValue());
        }
        return newMap;
    }


}

class MaxMin{
    Integer min;
    Integer max;

    public MaxMin() {
    }

    public MaxMin(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "MaxMin{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }
}

