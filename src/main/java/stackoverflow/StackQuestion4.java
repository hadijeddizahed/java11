//package stackoverflow;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//
//public class StackQuestion4 {
//    public static void main(String[] args) throws JsonProcessingException {
//        String jsonData = "[{\"section\":\"1A\", \"branch\":\"science\", \"studentName\":\"abc\", \"marks\":50}, {\"section\":\"1A\", \"branch\":\"science\", \"studentName\":\"sss\", \"marks\":20}, {\"section\":\"1A\", \"branch\":\"science\", \"studentName\":\"asd\", \"marks\":40}, {\"section\":\"1A\", \"branch\":\"Maths\", \"studentName\":\"www\", \"marks\":10}, {\"section\":\"1A\", \"branch\":\"Maths\", \"studentName\":\"abc\", \"marks\":70}, {\"section\":\"1A\", \"branch\":\"Maths\", \"studentName\":\"abc\", \"marks\":86}, {\"section\":\"2A\", \"branch\":\"Maths\", \"studentName\":\"abc\", \"marks\":55}, {\"section\":\"2A\", \"branch\":\"Maths\", \"studentName\":\"abc\", \"marks\":89}, {\"section\":\"2A\", \"branch\":\"Maths\", \"studentName\":\"abc\", \"marks\":12},{\"section\":\"2A\", \"branch\":\"physical\", \"studentName\":\"abc\", \"marks\":\"failed\"},{\"section\":\"2A\", \"branch\":\"physical\", \"studentName\":\"abc\", \"marks\":\"passed\"}]";
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        Map<String, Map<String, List<Integer>>> map =
//                Arrays.stream(objectMapper.readValue(jsonData, Student[].class))
//                    .collect(Collectors.groupingBy(Student::getSection,
//                            Collectors.groupingBy(Student::getBranch,
//                                 Collectors.mapping(Student::getMarks,
//                                      Collectors.collectingAndThen(Collectors.toList(), l -> {
//                                         Optional<Integer> max = Optional.empty(),
//                                                 min = Optional.empty(),
//                                                 totalFailed = Optional.empty();
//                                              if (l.get(0) instanceof Integer) {
//                                                  min = l.stream()
//                                                     .map(o -> Integer.valueOf(o.toString()))
//                                                          .min(Integer::compareTo);
//                                                  max = l.stream()
//                                                     .map(o -> Integer.valueOf(o.toString()))
//                                                          .max(Integer::compareTo);
//                                              } else
//                                                  totalFailed = Optional.of(l.stream()
//                                                          .filter(o -> o.toString().equals("failed")).toArray().length);
//                                              return Stream.of(min, max, totalFailed)
//                                                      .filter(Optional::isPresent)
//                                                      .map(Optional::get)
//                                                      .collect(Collectors.toList());
//                                      })))));
//
//        System.out.println(map);
//        System.out.println(map.entrySet().stream()
//                .map(Statistics::new)
//                .collect(Collectors.toList()));
//    }
//}
//
//class Student1 {
//    private String section;
//    private String branch;
//    private String studentName;
//    private Object marks;
//
//    public String getSection() {
//        return section;
//    }
//
//    public String getBranch() {
//        return branch;
//    }
//
//    public String getStudentName() {
//        return studentName;
//    }
//
//    public Object getMarks() {
//        return marks;
//    }
//
//    public Student() {
//    }
//
//    @Override
//    public String toString() {
//        return "{" +
//                "\"section\":" + '"' + section + '\"' +
//                ", \"branch\":" + '"' + branch + '\"' +
//                ", \"studentName\":" + '"' + studentName + '\"' +
//                ", \"marks\":" + marks +
//                '}';
//    }
//}
//
//class Statistics {
//    private String section;
//    private MinMax science;
//    private MinMax maths;
//    private long totalFailed;
//
//    public Statistics() {
//    }
//
//    public Statistics(Map.Entry<String, Map<String, List<Integer>>> entry) {
//        this.section = entry.getKey();
//
//        List<Integer> maths = entry.getValue().getOrDefault("Maths", Collections.emptyList());
//        if (!maths.isEmpty())
//            this.maths = new MinMax(maths.get(0), maths.get(1));
//
//        List<Integer> science = entry.getValue().getOrDefault("science", Collections.emptyList());
//        if (!science.isEmpty())
//            this.science = new MinMax(science.get(0), science.get(1));
//
//
//        this.totalFailed = entry.getValue().getOrDefault("physical", Collections.emptyList()).get(0);
//
//    }
//
//    @Override
//    public String toString() {
//        return
//                "section='" + section + '\'' +
//                        ", science=" + science +
//                        ", maths=" + maths +
//                        ", totalFailed=" + totalFailed;
//    }
//}
//
//class MinMax {
//    Integer min;
//    Integer max;
//
//    public MinMax(Integer min, Integer max) {
//        this.min = min;
//        this.max = max;
//    }
//
//    @Override
//    public String toString() {
//        return
//                "(" + min + "-" + max + ")";
//    }
//}
