package java11.string;

public class StringNewMethods {
    public static void main(String[] args) {
        var hiJava = "Hi Java 11";

        var newContent = hiJava.repeat(2);// Hi Java 11Hi Java 11
        System.out.println(newContent.equals(hiJava.concat(hiJava)));

    }


}
