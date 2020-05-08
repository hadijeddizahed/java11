package stackoverflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Question15 {

    public static void main(String[] args) {
        List<A> orginalList = new ArrayList<>(List.of(new A(List.of(new B(List.of(new C("123"), new C("7777")))))));


        List<A> result = new ArrayList<>();
        orginalList.forEach(a -> {
            A a1 = new A(new ArrayList<>());
            a.getBList().forEach(b -> {
                B b1 = new B(new ArrayList<>());
                b.getCList().stream().filter(c -> c.getName().equals("123")).forEach(c -> b1.getCList().add(c));
                a1.getBList().add(b1);
            });
            result.add(a1);
        });
        System.out.println(result);



    }
}

@Data
@Getter
@AllArgsConstructor
class A {
    private List<B> bList;
}

@Getter
@Data
@AllArgsConstructor
class B {
    private List<C> cList;
}

@Getter
@Data
@AllArgsConstructor
class C {
    private String name;
}