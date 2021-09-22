import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    String text = "Hello, We are looking for highly intelligent individuals. To find them, we have devised a test." +
                  "There is a message hidden in this image. Find it, and it will lead you on the road to finding us." +
                  "We look forward to meeting the few that will make it all the way through." +
                  "Good luck." +
                  "3301" + "\n" +
                  "No one knows who sets it or what the prize is at the end, but Cicada 3301 is back for its third year, and the internet has gone wild." +
                  "The hardest puzzle on the internet is not, perhaps, something to be attempted on whim during a quiet January afternoon." +
                  "But ever since I first heard about Cicada 3301, a mysterious event somewhere at the intersection of a game, a competition and a job interview," +
                  "I'd wanted to test my mettle. It couldn't be that hard, right?";

    System.out.println(splitTextIntoWords(text));
  }

  public static String splitTextIntoWords(String text) {
    //TODO реализуйте метод

    String regexPunctuation =  "[.,;!?-]";
    String regexNumber = "\\d";
    String regexSpace = "\\s+";

    if(text == "") return "";

    text = text.replaceAll(regexPunctuation," ")
            .replaceAll(regexNumber,"")
                 .replaceAll(regexSpace,"\n");

    text = text.trim();

    return text;
  }

}