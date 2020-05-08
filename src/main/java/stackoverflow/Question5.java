package stackoverflow;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Question5 {
    public static void main(String[] args) throws JsonProcessingException {

        String process = "{\n" +
                "  \"name\": \"process1\",\n" +
                "  \"listProcessDetail\": [\n" +
                "    {\n" +
                "      \"id\": \"456\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"666\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"555\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        String student = "{\n" +
                "  \"name\": \"Kevin\",\n" +
                "  \"age\": \"22\",\n" +
                "  \"listCourses\": [\n" +
                "    {\n" +
                "      \"courseName\": \"Math\",\n" +
                "      \"listCoursesDetail\": [\n" +
                "        {\n" +
                "          \"id\": \"666\",\n" +
                "          \"grade\": \"88\",\n" +
                "          \"professor\": \"Xavier\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"144\",\n" +
                "          \"grade\": \"90\",\n" +
                "          \"professor\": \"Marcus\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"555\",\n" +
                "          \"grade\": \"100\",\n" +
                "          \"professor\": \"Joe\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";


        ObjectMapper mapper = new ObjectMapper();
        Process process1 = mapper.readValue(process, Process.class);

        Student student1 = mapper.readValue(student, Student.class);

        Set<String> ids = process1.getListProcessDetail().stream().map(ProcessDetail::getId).collect(Collectors.toSet());



        student1.getListCourses()
                .stream().filter(c -> c.getListCoursesDetail().stream().anyMatch(d -> ids.contains(d.getId()))).collect(Collectors.toList());
        student1.getListCourses().forEach(c -> c.getListCoursesDetail().removeIf(Predicate.not(d -> ids.contains(d.getId()))));



    }
}

class Student {

    private String name;
    private String age;
    private List<Course> listCourses;

    public Student() {
    }

    public Student(String name, String age, List<Course> listCourses) {
        this.name = name;
        this.age = age;
        this.listCourses = listCourses;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public List<Course> getListCourses() {
        return listCourses;
    }
}

class Course {

    private String courseName;
    private List<CourseDetail> listCoursesDetail;

    public Course() {
    }

    public Course(String courseName, List<CourseDetail> listCoursesDetail) {
        this.courseName = courseName;
        this.listCoursesDetail = listCoursesDetail;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<CourseDetail> getListCoursesDetail() {
        return listCoursesDetail;
    }
}

class CourseDetail {

    private String id;
    private String grade;
    private String professor;

    public CourseDetail() {
    }

    public CourseDetail(String id, String grade, String professor) {
        this.id = id;
        this.grade = grade;
        this.professor = professor;
    }

    public String getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }

    public String getProfessor() {
        return professor;
    }
}

class Process {

    private String name;
    private List<ProcessDetail> listProcessDetail;

    public Process() {
    }

    public Process(String name, List<ProcessDetail> listProcessDetail) {
        this.name = name;
        this.listProcessDetail = listProcessDetail;
    }

    public String getName() {
        return name;
    }

    public List<ProcessDetail> getListProcessDetail() {
        return listProcessDetail;
    }
}

class ProcessDetail {

    private String id;

    public ProcessDetail() {
    }

    public ProcessDetail(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    //Setters and getters
}