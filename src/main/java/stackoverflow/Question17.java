package stackoverflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Question17 {
    public static void main(String[] args) {


        List<Person> personList = List.of(
                new Person("John",
                        "Doe",
                        "USA"),
                new Person("Tom",
                        "Fury",
                        "USA"),
                new Person("Zhi",
                        "Ching",
                        "China"),
                new Person(
                        "Siddhi",
                        "Patel",
                        "India"),
                new Person(
                        "Qi",
                        "Qiaoqiao",
                        "China"
                ),
                new Person("Monica",
                        "Singh",
                        "India"

                ),
                new Person(

                        "Freddie",
                        "Mercury", null

                ),
                new Person(
                        "John",
                        "Lennon", null

                ));


        System.out.println();

        personList.stream()
                .collect(Collectors.groupingBy(p -> p.getCountry() == null ? "other" : p.getCountry(),
                        Collectors.collectingAndThen(Collectors.toList(),
                                people -> people.stream().sorted(Comparator.comparing(Person::getFirstName)).collect(Collectors.toList()))))
                .values();


        List<BookingRoom> bookingRooms = List.of(new BookingRoom(1,LocalDateTime.now(),LocalDateTime.now().plusDays(23)),
                new BookingRoom(2,LocalDateTime.now(),LocalDateTime.now().plusDays(1)),
                new BookingRoom(3,LocalDateTime.now(),LocalDateTime.now().plusDays(3)),
                new BookingRoom(4,LocalDateTime.now(),LocalDateTime.now().plusDays(2)),
                new BookingRoom(5,LocalDateTime.now(),LocalDateTime.now().plusDays(3)));




    }
}

@Setter
@Getter
@AllArgsConstructor
class Person {
    private String firstName;
    private String lastName;
    private String country;
}

@Setter@Getter
@AllArgsConstructor
class BookingRoom{

    private Integer id;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}