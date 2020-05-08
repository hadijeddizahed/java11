package stackoverflow;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question2 {
    public static void main(String[] args) {
//        Map<String, Object> m1 = new HashMap<String, Object>();
//        m1.put("name", "alex");
//        m1.put("age", "40");
//        List<Map<String,Object>> l1 = new ArrayList<>();
//        l1.add(m1);
//        m1 = new HashMap<String, Object>();
//        m1.put("name", "alex");
//        m1.put("state", "Texas");
//        l1.add(m1);
//
//        m1 = new HashMap<String, Object>();
//        m1.put("name", "alice");
//        m1.put("age", "35");
//        l1.add(m1);
//        m1 = new HashMap<String, Object>();
//        m1.put("name", "alice");
//        m1.put("state", "Arizona");
//        l1.add(m1);
//
//        m1 = new HashMap<String, Object>();
//        m1.put("name", "bob");
//        m1.put("age", "25");
//        l1.add(m1);
//        m1 = new HashMap<String, Object>();
//        m1.put("name", "bob");
//        m1.put("state", "Utah");
//        l1.add(m1);
//
//
//        List<List<List<String>>> lists = List.of(List.of(Arrays.asList("a","b"),Arrays.asList("c","b")),
//                List.of(Arrays.asList("x"),Arrays.asList("y")));
//
//        System.out.println(lists.stream()
//                .flatMap(Collection::stream)
//                .collect(Collectors.toList()));
//        List<Set<String>> result = new ArrayList<>();
//        List<List<String>> result2 =
//                lists.stream()
//                        .map(x -> x.stream()
//                                .flatMap(List::stream)
//                                .distinct()
//                                .collect(Collectors.toList()))
//                        .collect(Collectors.toList());
//        lists.forEach(list -> result.add(list.stream()
//                .flatMap(List::stream)
//                .collect(Collectors.toSet())));
//
//        System.out.println(lists.stream()
//                .collect(() -> new ArrayList<Set<String>>(),
//                        (sets, l) -> sets.add(l.stream().flatMap(List::stream).collect(Collectors.toSet())), List::addAll));
//
//        System.out.println(result2);

        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map1 = Map.of("containertype","check2","items",Arrays.asList(Map.of("d1","St"),Map.of("d1","St"),Map.of("d1","St")));
        Map<String,Object> map2 = Map.of("containertype","check2","items",Arrays.asList(Map.of("d1","St"),Map.of("d1","St"),Map.of("d1","Pt")));


    }

    public Move getChoice() {

        Optional<Move> move = Optional.empty();
        while (!move.isPresent()) {
            System.out.println("Enter move code : R => Rock, P => Paper, S => Scissors");
            move = Move.fromMnemonic('P');
        }
        return move.get();
    }
}
enum Move

{

    ROCK('R'), PAPER('P'), SCISSORS('S');

    private final char mnemonic;
    public static Move[] values = values();

    Move(char mnemonic) {
        this.mnemonic = mnemonic;
    }

    public static Optional<Move> fromMnemonic(char playerInput) {
        return Arrays.stream(values).filter(v -> v.mnemonic == playerInput).findFirst();
    }
}