package java11.string;

public class StringNewMethods {
    public static void main(String[] args) {
        var hiJava = "Hi Java 11";


        var newContent = hiJava.repeat(2);// the repeat() method repeats string n times.
        System.out.println(newContent.equals(hiJava.concat(hiJava)));

        var isBlank = " ";
        System.out.println(isBlank.isBlank());

        var isEmpty = "";
        System.out.println(isEmpty.isEmpty());

        var text = " Hello World! ";
        System.out.println(text);
        var textStrip = text.strip(); // " Hello World! "--> "Hello World!"
        System.out.println(textStrip);

        var stripTrailing = text.stripTrailing().concat("again!");
        System.out.println(stripTrailing);

        var stripLeading = text.stripLeading().concat("again!");
        System.out.println(stripLeading);

        var lines = "this\ntext\nhas\n?\nlines!";
        System.out.println(lines.replace('\n',' ')+lines.lines().count());

    }


}
