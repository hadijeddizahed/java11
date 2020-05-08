package stackoverflow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FileSystem {

    public static void main(String args[]) throws Exception {


        Map<String,String> map = new HashMap<>();
        map.put("name","firstName");
        map.put("address","location");
        map.put("university","college");

        List<Map<String,Object>>  maps = Arrays.asList(
                Map.of("name","Tim","address","New York","education",Map.of("university","XYZ" )),
                Map.of("name","Tim","address","New York"));



        new HashMap<>().clear();

        map.clear();


    }

    private static void getFileInBatch() {
        int MAX_INDEX = 1000;
        List<String> result = new ArrayList<>();

        try (Stream<Path> walk = Files.walk(Paths.get("C://FileTest"))) {

                List<String> batchResult = walk.filter(p -> Files.isRegularFile(p) && p.getFileName().toString().endsWith(".txt"))
//                        .sorted(Comparator.comparingInt(FileSystem::pathToInt))
                        .map(Path::toString).limit(MAX_INDEX).collect(Collectors.toList());

                batchResult.forEach(System.out::println);
                System.out.println(batchResult.size());
                result.addAll(batchResult);
                System.out.println(batchResult);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static int pathToInt(final Path path) {
        return Integer.parseInt(path.getFileName()
                .toString()
                .replaceAll("Aamir(\\d+).txt", "$1")
        );
    }

    private static void createListFile() throws IOException {
        for (int i = 0; i < 3000; i++) {
            File file = new File("C://FileTest/Aamir" + i + ".txt");

            if (file.createNewFile()) {

                System.out.println(file.getName() + " is created!");
            }
        }
    }

}

@AllArgsConstructor
@Getter
class Data{

    private String name;
    private String address;
    private Education education;
}

@AllArgsConstructor
@Getter
class Education{
    private String university;
}