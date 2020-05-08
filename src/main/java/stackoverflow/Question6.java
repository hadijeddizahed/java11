package stackoverflow;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Question6 {
    public static void main(String[] args) {
        List<Setting> currentSettings = Arrays.asList(new Setting("a", "fff"),
                new Setting("b", "fff"));

        Map<String, Object> newSettings = new HashMap<>();
        newSettings.put("a", true);
        newSettings.put("b", true);
        newSettings.put("c", true);


        List<String> s = currentSettings.stream()
                .collect(Collectors
                        .collectingAndThen(Collectors
                                        .mapping(Setting::getSettingName, Collectors.toSet()),
                                settingName -> newSettings.keySet().stream().filter(key -> !settingName.contains(key)).collect(toList())
                        )
                );

        System.out.println(s);

        List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 5, 4, 2);

        List<MonthlyBalancedBooking> entries = Arrays.asList(new MonthlyBalancedBooking(1, 12d),
                new MonthlyBalancedBooking(1, 19d),
                new MonthlyBalancedBooking(8, 12d),
                new MonthlyBalancedBooking(8, 8d));


        System.out.println(entries.stream()
                .collect(collectingAndThen(
                        groupingBy(MonthlyBalancedBooking::getValidFor,
                                summingDouble(MonthlyBalancedBooking::getAmount)),
                        map -> map.entrySet().stream()
                                .map(entry -> new Balance(entry.getValue(), entry.getKey()))))
                .collect(toList()));
        System.out.println(entries.stream()
                .collect(groupingBy(MonthlyBalancedBooking::getValidFor,
                        collectingAndThen(mapping(MonthlyBalancedBooking::getAmount, reducing(0d, Double::sum)), d -> d)
                )));
        System.out.println();
        List<Balance> balances = new ArrayList<>(entries.stream()
                .map(m -> new Balance(m.amount, m.validFor))
                .collect(toMap(Balance::getKey, Function.identity(), Balance::merge)).values());

        System.out.println(balances);

    }

    public List<Balance> mapToBalancesWithSumAmounts(List<MonthlyBalancedBooking> entries) {
        Map<Integer, Double> map = entries.stream()
                .collect(groupingBy(MonthlyBalancedBooking::getValidFor,
                        mapping(MonthlyBalancedBooking::getAmount, Collectors.reducing(0d, Double::sum))));
        return map
                .entrySet()
                .stream()
                .map(localDateDoubleEntry -> new Balance(localDateDoubleEntry.getValue(), localDateDoubleEntry.getKey()))
                .collect(toList());
    }
}

class Balance {

    private Double value;
    private Integer key;

    public Balance(Double value, Integer key) {
        this.value = value;
        this.key = key;
    }

    public Balance merge(Balance b) {
        this.value += b.getValue();
        return this;
    }

    public Double getValue() {
        return value;
    }

    public Integer getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "value=" + value +
                ", key=" + key +
                '}';
    }
}

class MonthlyBalancedBooking {
    Integer validFor;
    Double amount;

    public MonthlyBalancedBooking(Integer validFor, Double amount) {
        this.validFor = validFor;
        this.amount = amount;
    }

    public Integer getValidFor() {
        return validFor;
    }

    public Double getAmount() {
        return amount;
    }
}

class Setting {
    private String settingName;

    private String settingValue;

    public Setting(String settingName, String settingValue) {
        this.settingName = settingName;
        this.settingValue = settingValue;
    }

    public String getSettingName() {
        return settingName;
    }

    public String getSettingValue() {
        return settingValue;
    }
}
