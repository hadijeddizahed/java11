package stackoverflow;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.groupingBy;

public class Question8 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(new Employee(1, "A", LocalDate.now()),
                new Employee(1, "A1", LocalDate.now().plusDays(1)),
                new Employee(2, "B1", LocalDate.now()),
                new Employee(2, "B", LocalDate.now().minusDays(1)));

        Collection<Employee> collection = employees.stream()
                .collect(groupingBy(Employee::getId,
                        collectingAndThen(maxBy(Comparator.comparing(Employee::getUpdatedDate)),
                                employee -> employee.orElse(null)))).values();

        List<Employee> result = new ArrayList<>(collection);
        Collection<Employee> emps = employees.stream()
                .collect(Collectors.toMap(Employee::getId, e -> e,
                        (e1, e2) -> e1.getUpdatedDate()
                                .compareTo(e2.getUpdatedDate()) >= 0 ? e1 : e2)).values();
        System.out.println(emps);


    }
}

class Employee {
    final int id;
    final String name;
    final LocalDate updatedDate;

    public Employee(int id, String name, LocalDate updatedDate) {
        this.id = id;
        this.name = name;
        this.updatedDate = updatedDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", updatedDate=" + updatedDate +
                '}';
    }
}