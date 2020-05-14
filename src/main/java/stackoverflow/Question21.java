package stackoverflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question21 {

    public static void main(String[] args) {

        Optional<List<String>> currentItems = Optional.empty();

        List<Token> list = List.of(
                new Token(2000, "type1", 1, 1000),
                new Token(2000, "type1", 2, 1000),
                new Token(2000, "type2", 2, 2000),
                new Token(2000, "type2", 2, 2000),
                new Token(2020, "type2", 1, 1000),
                new Token(2020, "type1", 11, 3000),
                new Token(2020, "type1", 11, 3000),
                new Token(2010, "type1", 1, 1000),
                new Token(2010, "type2", 1, 1000));

//         list.stream()
//                .collect(Collectors.groupingBy(Token::getYear,
//                        Collectors.groupingBy(Token::getType,
//                                Collectors.mapping(t->new TokenAnalysis(t.getType(), t.getValue(), t.getCount()),Collectors.))));


        List<String> tempList = createTempList();

        Map<String, List<String>> map = tempList.stream()
                .map(t -> t.split("\\.", 2))
                .collect(Collectors.toMap(a -> a[0], v -> new ArrayList<>(Collections.singletonList(v[1])), (l1, l2) -> {
                    l1.addAll(l2);
                    return l1;
                }));

        Map<String, List<String>> map2 =  tempList.stream()
                .map(t -> t.split("\\.", 2))
                .collect(Collectors.groupingBy(a->a[0],Collectors.mapping(v->v[1],Collectors.toList())));

        System.out.println(map2);

//

    }

    public static Map<String, List<String>> createMap8(final List<String> tempList) {
        Map<String, List<String>> vlanFoos = new HashMap<String, List<String>>();
        for (int i = 0; i < tempList.size(); i++) {
            String[] idsI = tempList.get(i).split("\\.");
            String vlanI = idsI[idsI.length - 7];
            List<String> fooList = new ArrayList<String>();
            for (int j = 0; j < tempList.size(); j++) {
                String foo = "";
                String[] idsJ = tempList.get(j).split("\\.");
                String vlanJ = idsJ[idsJ.length - 7];
                if (vlanI.equals(vlanJ)) {
                    for (int k = 6; k > 0; k--) {
                        foo = foo + idsJ[idsJ.length - k];
                        if (k != 1) {
                            foo = foo + ".";
                        }
                    }
                }
                if (!foo.isEmpty()) {
                    fooList.add(foo);
                }
            }
            vlanFoos.put(vlanI, fooList);
        }
        return vlanFoos;
    }

    private static List<String> createTempList() {
        List<String> tempList = new ArrayList<String>();
        tempList.add("1.24.75.13.45.91.0");
        tempList.add("1.88.213.110.66.182.127");
        tempList.add("1579.204.45.224.38.12.161");
        tempList.add("1580.204.45.224.38.12.161");
        tempList.add("21.204.45.224.38.12.161");
        tempList.add("39.204.45.224.38.12.161");
        tempList.add("5.12.244.213.2.178.192");
        tempList.add("5.204.45.224.38.12.161");
        tempList.add("5.212.202.109.116.154.217");
        tempList.add("5.212.202.109.116.154.218");
        tempList.add("5.40.153.58.148.24.67");
        tempList.add("5.76.177.205.33.164.80");
        tempList.add("5.84.236.47.13.223.64");
        tempList.add("5.88.213.110.66.182.128");
        return tempList;
    }
}

@AllArgsConstructor
@Setter
@Getter

class Token {
    private int year;
    private String type;
    private int count;
    private int value;
}

@AllArgsConstructor
@Setter@Getter
class TokenAnalysis {
    private String group;
    private int amount;
    private int count;
    private double mean;

    public TokenAnalysis(String group, int amount, int count) {
        this.group = group;
        this.amount = amount;
        this.count = count;
    }
}