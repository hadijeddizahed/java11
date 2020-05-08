package java11.optional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalSamples {
    public static void main(String[] args) {

        Optional<String> optional = Optional.empty();

        System.out.println(optional.isEmpty());


        ifPresentOrElse(null);
        ifPresentOrElse("Text");

        findName("Ali").ifPresent(System.out::println);
        findName("Amin").ifPresent(System.out::println);

        System.out.println(names(List.of("Ali","Babak","Ala")));

    }


    // since java 9
    public static void ifPresentOrElse(String search) {

        Optional<String> optional = Optional.ofNullable(search);

        optional.ifPresentOrElse(
                s -> System.out.println(s + " is present!"),
                () -> System.out.println("is not present!")
        );
    }

    // since java 9
    public static Optional<String> findName(String name) {
        return search(name).or(() -> search2(name));
    }

    private static Optional<String> search(String name) {
        return Stream.of("Ali", "Reza").filter(s -> s.equals(name)).findFirst();
    }

    private static Optional<String> search2(String name) {
        return Stream.of("Ali", "Reza", "Amin").filter(s -> s.equals(name)).findFirst();
    }
    //-------------------------------------------------

    /**
     * @since java 9
     * @param list
     * @return list of names
     */
    public static List<String> names(List<String> list){
        return list.stream()
                .map(OptionalSamples::search)
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
    }
}
