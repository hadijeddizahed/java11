package java11.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileNewMethods {
    public static void main(String[] args) throws IOException {

        String path = "C:\\FileTest\\content.txt";
        String content = "Hello World!";

        writeString(path,content);
        String readContent = readString(path);
        assert !readContent.equals(content);

        System.out.println(isSameFile(path, path));
    }

    public static void writeString(String path,String content) throws IOException {

        Files.writeString(Path.of(path),content);
    }

    public static String readString(String path) throws IOException {
        return Files.readString(Path.of(path));
    }

    public static boolean isSameFile(String path1, String path2) throws IOException {
        return Files.isSameFile(Path.of(path1),Path.of(path2));
    }
}
