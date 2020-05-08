package stackoverflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question20 {
    public static void main(String[] args) {
        String str = "!never odd or even";

//        System.out.println(new StringBuilder(str).reverse().toString());

//        System.out.println(palindorme(str));
//        System.out.println(stringScramble("recofrrtr", "coder"));

//        System.out.println(CoinDeterminer(16));

//        List<Integer> coins = Arrays.asList(11, 9, 7, 5, 1);
//
//        int num = 5;
//
//        System.out.println(CoinDeterminer(num));

        String[] gasStations = new String[]{"4", "0:1", "2:2", "1:2", "3:1"};
//        String[] gasStations = new String[]{"3", "0:2", "4:4", "3:1"};
        String[] gasStations2 = new String[]{"4", "1:1", "2:2", "1:2", "0:1"};

        System.out.println(GasStation(gasStations));
    }

    public static String GasStation(String[] strArr) {
        int stationSize = Integer.valueOf(strArr[0]);
        int gives, spend, remindedGallons = 0;
        int startStation=1,index = 1;
        int total = 0;
        while (total <= stationSize) {
            if (index >= strArr.length) {
                index = (index - strArr.length) + 1;
            }
            char[] c = strArr[index].toCharArray();
            gives = (Character.getNumericValue(c[0]) + remindedGallons);
            spend = Character.getNumericValue(c[2]);
            if (gives < spend) {
                if (startStation > stationSize) return "impossible";
                startStation++;
                remindedGallons = 0;
                total = 0;
                index = startStation;
            } else {
                remindedGallons = gives - spend;
                total++;
                index++;
            }
        }
        return String.valueOf(startStation);
    }

    public static int CoinDeterminer(int num) {
        if (num < 0 || num > 250)
            throw new IllegalArgumentException("invalid number!");
        List<Integer> coins = Arrays.asList(11, 9, 7, 5, 1);
        int count = 0, sum = 0;
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < coins.size(); i++) {
            int coin = coins.get(i);
            int j = i;
            sum += coin;
            if (sum <= num) count++;
            while (sum <= num && j < coins.size()) {
                coin = coins.get(j);
                while (sum + coin <= num) {
                    sum += coin;
                    count++;
                }
                j++;
            }
            sum = 0;
            if (count != 0)
                counts.add(count);
            count = 0;
        }
        return Collections.min(counts);
    }

    private static String longestWord(String sen) {
        return Arrays.stream(sen.replaceAll("\\W", " ").split("\\s"))
                .collect(Collectors.toMap(String::length, Function.identity(), (a, b) -> a)).entrySet()
                .stream().max(Comparator.comparingInt(Map.Entry::getKey)).map(Map.Entry::getValue).orElse(null);
    }

    public static String stringScramble(String str1, String str2) {
        Map<Character, Integer> map = str1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(Character::valueOf, o -> 1, (a, b) -> 1));
        return Boolean.toString(str2.chars().map(c -> map.getOrDefault((char) c, 0)).sum() == str2.length());
    }

    private static Boolean palindorme(String str) {
        String temp = str.replaceAll("\\W", " ").replaceAll("\\s", "");
        return temp.equals(new StringBuilder(temp).reverse().toString());
    }
}

@AllArgsConstructor
@Data
@Getter
class Customer {
    private int id;
    private String subscription;
}

@AllArgsConstructor
@Data
@Getter
class Pair {
    int get;
    int need;
}
