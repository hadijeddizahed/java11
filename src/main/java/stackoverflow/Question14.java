package stackoverflow;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Question14 {
    public static void main(String[] args) throws JsonProcessingException {


        List<LocaleBook> list = Arrays.asList(
                new LocaleBook("alice", "Alice in the wonderland", new Locale("GB", "en")),
                new LocaleBook("matrix", "The Matrix", new Locale("TH", "en")),
                new LocaleBook("christtree", "The Christmas Tree", new Locale("GB", "en")));

        String[] stringNum = new String[]{"1", "2", "3", "4", "5", "6", "7"};

        List<Integer> intNums = Arrays.stream(stringNum)
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        List<Integer> intNums2 = Arrays.stream(stringNum)
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());


        System.out.println();
//        System.out.println(list.stream().collect(Collectors.toMap(LocaleBook::getLocale,
//                lb -> new NewPoJo(lb.getLocale().getCountry(), lb.getLocale().getLanguage(),
//                        new ArrayList<>(Collections.singletonList(new KeyValuePair(lb.getBookId(), lb.getBookName())))), (a, b) -> {
//                    a.getLocaleBooks().addAll(b.getLocaleBooks());
//                    return a;
//                })).values());


        String s = "aabbcceeeddd";

        boolean valid = "aabbcceeeddd".chars()
                .boxed()
                .collect(groupingBy(Function.identity(), counting()))
                .values().stream()
                .reduce((a, b) -> a == b ? a : -1L)
                .map(v -> v > 0)
                .get();

        System.out.println(valid);

        System.out.println(validate(s));

        TreeMap<Long, Long> map2 = "aabbeedddd".chars()
                .boxed()
                .collect(groupingBy(Function.identity(), counting()))
                .values().stream()
                .collect(groupingBy(Function.identity(), TreeMap::new, counting()));

        boolean valid2 = map2.size() == 1 ||        // there is only a single char frequency
                (map2.size() == 2 &&              // there are two and there is only 1 extra char
                        ((map2.lastKey() - map2.firstKey()) * map2.lastEntry().getValue() <= 1));

        System.out.println(valid2);


        List<User> response = List.of(new User("userId1",
                "admin",
                "000008"), new User("userId1",
                "admin",
                "000007"), new User("userId2",
                "analyst",
                "000001"));

        response.stream()
                .collect(Collectors.groupingBy(User::getUserId, Collectors.mapping(user -> user, Collectors.toList())));

        response.stream()
                .collect(Collectors.toMap(User::getUserId, Function.identity(),
                        (u1, u2) -> {
                            u1.setAccessCode(u1.getAccessCode().concat(",").concat(u2.getAccessCode()));
                            return u1;
                        }))
                .values();
        System.out.println();


    }

    public static boolean validate(String line) {
        Map<Character, Long> map = line.chars().mapToObj(c -> (char) c)
                .collect(groupingBy(Function.identity(), counting()));
        Long minValue = map.values().stream().min(Long::compareTo).orElse(0l);
        return map.values().stream().mapToLong(a -> Math.abs(a - minValue)).sum() <= 1;
    }

    private static List<Long> distinctFrequencies(String line) {
        return line.chars().mapToObj(c -> (char) c)
                .collect(groupingBy(Function.identity(),
                        counting()))
                .values().stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private static boolean distinctFrequencies2(String line) {
        return line.chars().mapToObj(c -> (char) c)
                .collect(groupingBy(Function.identity(), counting()))
                .values().stream().reduce(0l, (a, b) -> Math.abs(a - b)) <= 1;
    }
}

class User {

    private String userId;
    private String role;
    private String accessCode;

    public User(String userId, String role, String accessCode) {
        this.userId = userId;
        this.role = role;
        this.accessCode = accessCode;
    }

    public String getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", role='" + role + '\'' +
                ", accessCode='" + accessCode + '\'' +
                '}';
    }
}

class NewPoJo {
    private String country;

    private String language;

    private List<KeyValuePair> localeBooks;
    //setters & getters


    public NewPoJo(String country, String language, List<KeyValuePair> localeBooks) {
        this.country = country;
        this.language = language;
        this.localeBooks = localeBooks;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<KeyValuePair> getLocaleBooks() {
        return localeBooks;
    }

    public void setLocaleBooks(List<KeyValuePair> localeBooks) {
        this.localeBooks = localeBooks;
    }

    @Override
    public String toString() {
        return "NewPoJo{" +
                "country='" + country + '\'' +
                ", language='" + language + '\'' +
                ", localeBooks=" + localeBooks +
                '}';
    }
}

class KeyValuePair {

    private String label;

    private String value;
    //setters & getters


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public KeyValuePair(String label, String value) {
        this.label = label;
        this.value = value;
    }
}

class LocaleBook {
    private String bookId;

    private String bookName;

    private Locale locale;
    //setters & getters


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public LocaleBook(String bookId, String bookName, Locale locale) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.locale = locale;
    }
}

class Locale {
    private String country;

    private String language;
    //setters & getters


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Locale(String country, String language) {
        this.country = country;
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locale locale = (Locale) o;
        return Objects.equals(country, locale.country) &&
                Objects.equals(language, locale.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, language);
    }
}