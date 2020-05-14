package stackoverflow;

import lombok.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

class Joke {
    private static final long serialVersionUID = 1L;

    public static void main(String args[]) {


        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 6);
        map.put(2, 9);
        map.put(4, 2);
        map.put(3, 1);
        map.put(8, 10);
        map.put(5, 10);


//        List<Map.Entry<Integer, Integer>> toSort = new ArrayList<>();
//        for (Map.Entry<Integer, Integer> k : map.entrySet()) {
//            toSort.add(k);
//        }
//        toSort.sort(Map.Entry.comparingByValue());
//        Map<Integer, Integer> reMap = new LinkedHashMap<>();
//        for (Map.Entry<Integer, Integer> k : toSort) {
//            reMap.putIfAbsent(map.pollFirstEntry().getKey(), k.getValue());
//        }
//
//        System.out.println(reMap);

        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        Integer[] numbers = new Integer[]{8, 4, 2, 2, 1};

        List<String> userUid = Arrays.asList("uid1", "uid3", "uid5", "uid2", "uid4", "uid0");

        System.out.println(userUid.stream()
                .sorted(Comparator.comparing(Object::toString).thenComparing(s -> !s.equals("uid2")))
                .collect(Collectors.toList()));

        List<String> res = userUid.parallelStream().sorted()
                .filter(u -> !u.equals("uid2"))
                .collect(ArrayList::new, (l, s) -> {
                    if (l.isEmpty()) l.add("uid2");
                    l.add(s);
                }, List::addAll);

        System.out.println(res);
        Comparator<String> comparator = (o1, o2) -> {
            if (o1.equals("uid2")) return -1;
            if (o2.equals("uid2")) return 1;
            return o1.compareTo(o2);
        };

        Collections.sort(userUid, comparator);

        System.out.println(userUid);

        String message = "Value{A=10,B=20,C=30,D=700-2-1, Bourke STREET, SOUTH 2/28 QUEEN ST,E=40,F=50}";

        String num = "1253";

        System.out.println();
        System.out.println(num.substring(0, 2)
                .chars()
                .map(c -> Character.getNumericValue(c))
                .filter(n -> n % 2 == 1)
                .sum());
        System.out.println(num.chars()
                .filter(Character::isDigit)
                .limit(2)
                .map(Character::getNumericValue)

                .sum());

        List<Sales> sales = Arrays.asList(new Sales("2", "3", "city1", "state1", 10),
                new Sales("2", "3", "city1", "state1", 5));

        System.out.println();

        sales.stream()
                .collect(groupingBy(Sales::getState,
                        groupingBy(Sales::getCity,
                                reducing(new Sales("Total", "2000", "", "", 0), (a, b) -> {
                                    a.setState(b.getState());
                                    a.setCity(b.getCity());
                                    a.setSales(a.getSales() + b.getSales());
                                    return a;
                                }))));
//        System.out.println(sales.stream()
//                .collect(groupingBy(Sales::getState,
//                        Collectors.toMap(Sales::getCity, Function.identity(),
//                                (s1, s2) -> new Sales(s1.month, s1.year, s1.city, s1.state, s1.getSales() + s2.getSales())))));
//        System.out.println(sales);


        List<Transaction> transactions = Arrays.asList(
                new Transaction("brian", 2011, 300, "X", "M1"),
                new Transaction("brian", 2012, 1000, "T", "M1"),
                new Transaction("brian", 2011, 400, "S", "M2"),
                new Transaction("brian", 2012, 710, "X", "M1"),
                new Transaction("brian", 2012, 700, "X", "M2"),
                new Transaction("brian", 2012, 950, "T", "M1")
        );

        Collection<Map<String, Result>> maps = new ArrayList<>();

        List<Result> s = maps.stream()
                .flatMap(m -> m.values().stream())
                .collect(toList());

        List<Result> list = maps.stream()
                .map(Map::values)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        Function<List<Result>, Result> average = l -> new Result(l.stream()
                .mapToDouble(Result::getAvg).average().orElse(0d), l.get(0).getYear(), l.get(0).getMethod());


        System.out.println();
        Map<Integer, Map<String, Result>> result2 = transactions.stream().collect(
                groupingBy(Transaction::getYear,
                        groupingBy(Transaction::getMethod,
                                mapping(t -> new Result((double) t.getValue(), t.getYear(), t.getMethod()),
                                        collectingAndThen(Collectors.toList(), average::apply)))));

        Map<Integer, Map<String, Result>> result = transactions.stream().collect(
                groupingBy(Transaction::getYear,
                        groupingBy(Transaction::getMethod,
                                Collectors.mapping(t -> new Result((double) t.getValue(), t.getYear(), t.getMethod()),
                                        Collectors.toList()))))
                .entrySet().stream()
                .map(r -> new AbstractMap.SimpleEntry<>(r.getKey(), r.getValue()
                        .entrySet().stream().map(v ->
                                new AbstractMap.SimpleEntry<>(v.getKey(), average.apply(v.getValue())))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(result);


    }

    private Comparator<? super BusinessPartnerAssignmentDetail> getComparator(List<Supplier<BPADComparator>> bpadComparators,
                                                                              PortfolioFilterDto portfolioFilterDto) {
        return bpadComparators
                .stream()
                .filter(bpadComparator -> bpadComparator.get().type().equals(""))
                .findFirst().map(Supplier::get)
                .map(BPADComparator::compare)
                .orElse(null);
    }

    private static Map<Integer, Integer> impl() {
        return Map.of(ThreadLocalRandom.current().nextInt(50), ThreadLocalRandom.current().nextInt(18));
    }
}

@Setter@Getter
@AllArgsConstructor
class Transaction {
    private final String trader;
    private final int year;
    private final int value;
    private String type;
    private String method;


}

@AllArgsConstructor
@Setter@Getter
@NoArgsConstructor
class Result {
    private Double avg;
    private int year;
    private String method;
}

interface BPADComparator {

    Comparator<BusinessPartnerAssignmentDetail> compare();

    String type();
}

class CompareBySegmentType implements BPADComparator {
    @Override
    public Comparator<BusinessPartnerAssignmentDetail> compare() {
        return Comparator.comparing(BusinessPartnerAssignmentDetail::getSegmentType, Comparator.nullsLast(Comparator.reverseOrder()));
    }

    @Override
    public String type() {
        return "segmentType";
    }
}

class CompareByDisplayName implements BPADComparator {

    @Override
    public Comparator<BusinessPartnerAssignmentDetail> compare() {
        return Comparator.comparing(BusinessPartnerAssignmentDetail::getDisplayName, Comparator.nullsLast(Comparator.reverseOrder()));
    }

    @Override
    public String type() {
        return "displayName";
    }
}

@Setter@Getter
class PortfolioFilterDto {
    private String fieldOfficeDescription;
    private String locationDescription;
    private String segmentType;
    private String displayName;

}

@Setter@Getter
class BusinessPartnerAssignmentDetail {
    private String fieldOfficeDescription;
    private String locationDescription;
    private String segmentType;
    private String displayName;

}

@Setter@Getter
@AllArgsConstructor
class Sales {
    String month;
    String year;
    String city;
    String state;
    int sales;
}



@AllArgsConstructor
class Company {
    String name;
    Logo logo;
}

@Setter@Getter
@AllArgsConstructor
class Logo {
    int color; //can have values=1 (green),2 (red),3 (blue) ...
    String name;
    String address;
}