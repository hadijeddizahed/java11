package stackoverflow;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Question22 {
    public static void main(String[] args) {
        Human h = new Human() {
            @Override
            public void sing() {
                           }
        };
h.sing();
h.sing();

        Human h2 = new Human() {
            @Override
            public void sing() {
                int a = 2;
                System.out.println(++a);
            }
        };
    }

    public AA getAValue() {
        int[] arr = new int[7];
        Function<int[], Optional<AA>> checkCondition = this::checkSomeCondition;

        for (int i = 0; i < 10; i++) {
           return IntStream.range(0, 3)
                    .mapToObj(index -> checkCondition.apply(arr))
                    .filter(aa -> !aa.isPresent())
                    .map(Optional::get).findFirst().get();
        }
        return AA.UNKNOWN;
    }

    public Optional<AA> checkSomeCondition(int[] arr) {
        if (arr[0] == arr[1]) {
            return arr[0] == 2 ? Optional.of(AA.VALUE_1) : Optional.of(AA.VALUE_2);
        }
        return Optional.empty();
    }
}
interface Human{
     int a = 0;
     void sing();
}
enum AA {
    UNKNOWN, VALUE_1, VALUE_2;
}
