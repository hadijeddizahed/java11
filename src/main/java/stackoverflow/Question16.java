package stackoverflow;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Question16 {
    public static void main(String[] args) {
        IFL<String> list = IFL.of(Arrays.asList("three", "little", "pig", "k"));
//        System.out.println(list.findMatch(str -> str.length() == 6));
//        System.out.println(list.findMatch(str -> str.length() < 4));

        int number = 5;

        List<String> linkedList = new LinkedList<>();
        Queue<String> queue = new ArrayDeque<>(5);

        for (int i = 0; i < number; i++) {
            linkedList.add(i, String.valueOf(2 * i + 1));
            queue.add(String.valueOf(2 * i + 1));
        }
        System.out.println(String.join("", linkedList));
        for (int i = 1; i < number; i++) {
            linkedList.add(linkedList.size() - 1, ((LinkedList<String>) linkedList).poll());
            System.out.println(String.join("", linkedList));
        }
    }
}

class IFL<T> {
    Supplier<T> head;
    Supplier<IFL<T>> tail;

    IFL(Supplier<T> head, Supplier<IFL<T>> tail) {
        this.head = head;
        this.tail = tail;
    }

    static <T> IFL<T> of(List<? extends T> list) {

        if (list.isEmpty())
            return new IFL<>(null, null);

        return new IFL<T>(
                () -> list.get(0),
                () -> IFL.of(list.subList(1, list.size()))) {
        };
    }

    Optional<T> findMatch(Predicate<? super T> predicate) {
        if (this.head == null)
            return Optional.empty();
        return predicate.test(head.get()) ?
                Optional.of(this.head.get()) :
                this.tail.get().findMatch(predicate);
    }
}