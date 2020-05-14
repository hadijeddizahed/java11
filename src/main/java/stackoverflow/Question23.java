package stackoverflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.security.cert.CollectionCertStoreParameters;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question23 {
    public static void main(String[] args) {
        List<String> orderedKeys = List.of("Commerce", "English", "Health & PE", "Humanities",
                "Mathematics", "Music & the Arts", "Science", "Others");

        List<TitleIsbnBean> nonPackageIsbnList = List.of(
                new TitleIsbnBean("title1", "2345556", 1, "English"),
                new TitleIsbnBean("title2", "2345556", 1, "Commerce"),
                new TitleIsbnBean("title3", "2345556", 23, "Commerce"),
                new TitleIsbnBean("title4", "2345556", 1, "Health & PE"),
                new TitleIsbnBean("title5", "2345556", 122, "Health & PE"),
                new TitleIsbnBean("title6", "2345556", 13, "Others"),
                new TitleIsbnBean("title7", "2345556", 14, "Others"),
                new TitleIsbnBean("title8", "2345556", 15, "Others"),
                new TitleIsbnBean("title9", "2345556", 1, "Science"),
                new TitleIsbnBean("title10", "2345556", 1, "Humanities"),
                new TitleIsbnBean("title11", "2345556", 23, "Humanities"),
                new TitleIsbnBean("title13", "2345556", 13, "Humanities"),
                new TitleIsbnBean("title14", "2345556", 1, "Music & the Arts"),
                new TitleIsbnBean("title16", "2345556", 545, "Music & the Arts"),
                new TitleIsbnBean("title17", "2345556", 45, "Mathematics")
        );

        Map<String, List<TitleIsbnBean>> titleListByLearningArea3;

        titleListByLearningArea3 = nonPackageIsbnList.stream()
                .collect(Collectors.groupingBy(TitleIsbnBean::getKeylearningarea,Collectors.toList()));

        Map<String,String> orderMap = orderedKeys.stream()
                .collect(Collectors.toMap(Function.identity(),Function.identity(),(a,b)->a,LinkedHashMap::new));

        Map<String, List<TitleIsbnBean>> titleListByLearningArea2=  orderedKeys.stream()
                .collect(Collectors.toMap(Function.identity(), titleListByLearningArea3::get,(a, b)->a,LinkedHashMap::new));


        Map<String, List<TitleIsbnBean>> titleListByLearningArea = nonPackageIsbnList.stream()
                .collect(Collectors.groupingBy(TitleIsbnBean::getKeylearningarea,
                        () -> new TreeMap<>(Comparator.comparingInt(orderedKeys::indexOf)),
                        Collectors.toList()));

        System.out.println(titleListByLearningArea3);
        System.out.println(titleListByLearningArea2);
        System.out.println(titleListByLearningArea);
        System.out.println(titleListByLearningArea.size());
    }
}

@AllArgsConstructor
@Setter
@Getter

class TitleIsbnBean {

    private String titleName;
    private String isbn;
    private int status;
    private String keylearningarea;

}