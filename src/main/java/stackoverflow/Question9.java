package stackoverflow;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question9 {
    public static void main(String[] args) {
        Map<Status, Student1> map = new HashMap<>();
        List<Student1> studentList = new ArrayList<>();
        studentList.forEach(student -> student.getStatusAndMarks().keySet().forEach(status -> map.put(status, student)));

        List<Optional<String>> allMessages = new ArrayList<>();

        Set<Status> allStatuses = new HashSet<>();

//Iterative : Working
        Set<Set<String>> set = new HashSet<>();
        set.forEach(statusMessage -> statusMessage.stream().map(status -> Optional.of("")).filter(Optional::isPresent).findFirst().ifPresent(allMessages::add));

    }
}

class Student1 {
    private Map<Status, Marks> statusAndMarks;

    public Map<Status, Marks> getStatusAndMarks() {
        return statusAndMarks;
    }

    public void setStatusAndMarks(Map<Status, Marks> statusAndMarks) {
        this.statusAndMarks = statusAndMarks;
    }
}

enum Status{

}

enum Marks{

}

