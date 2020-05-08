package stackoverflow;

import java.util.*;
import java.util.stream.Collectors;

public class Sample4 {

    private static class Student {
        String name;
        Set<Marks> marks;

        public Student(String name, Set<Marks> marks) {
            this.name = name;
            this.marks = marks;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<Marks> getMarks() {
            return marks;
        }

        public void setMarks(Set<Marks> marks) {
            this.marks = marks;
        }
    }

    private static class Marks {
        double points;

        public Marks(double points) {
            this.points = points;
        }

        public double getPoints() {
            return points;
        }

        public void setPoints(double points) {
            this.points = points;
        }
    }

    public static void main(String[] args) {

        Set<Marks> marks = new LinkedHashSet<>(), marks1 = new LinkedHashSet<>(), marks2 = new LinkedHashSet<>();
        marks.add(new Marks(10.2));
        marks.add(new Marks(2.10));
        marks1.add(new Marks(20));
        marks1.add(new Marks(7));
        marks2.add(new Marks(13));
        marks2.add(new Marks(15));

        List<Student> stds = Arrays.asList(
                new Student("A", marks),
                new Student("C", marks1),
                new Student("B", marks2)
        );

        TreeMap<String, Student> treeMap = stds.stream().collect(Collectors.toMap(Student::getName, student -> student, (a, b) -> b, TreeMap::new));

        List<String> listString = Arrays.asList("83d", "349d", "128");

        System.out.println(listString.stream()
                .map(s -> s.replaceAll("\\D", ""))
                .filter(s -> s.chars().map(i -> Character.getNumericValue(i)).sum() > 10)
                .count());

        System.out.println(Character.getNumericValue('5') + 2);


    }

    static Optional<String> getFullName(Person11 person) {
        if (person.getFamilyName() == null && person.getFirstName() == null) return Optional.empty();
        return Optional.of(person.getFirstName() + " " + person.getFamilyName());
    }


}

class Person11 {
    private String firstName;
    private String familyName;

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }
}

class Company1 {

    private String companyid;

    private List<Employee2> employees;

    public String getCompanyid() {
        return companyid;
    }

    public List<Employee2> getEmployees() {
        return employees;
    }
}

class Employee2 {

    private String employeeId;

    private Company company;

    public String getEmployeeId() {
        return employeeId;
    }

    public Company getCompany() {
        return company;
    }
}