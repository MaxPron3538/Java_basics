import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

public class Main {

  public static int designateNumericSymbol(char[] str)
  {
    int count = 0;

    while (count<str.length){

      if (str[count] >= 48 & str[count] <= 58) count++;

      else return 1;
    }
    return 0;
  }

  public static String selectRegularSymbol(String text)
  {
    if(text.contains(" ")) return " ";

    else return text.substring(text.length()-1);
  }

  public static void main(String[] args) {
    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

    //TODO: напишите ваш код, результат вывести в консоль

    int sumSalary = 0;
    text = text.trim();

    while (text.length() > 0) {

      String subStr = text.substring(0, text.indexOf(selectRegularSymbol(text)));
      text = text.replaceFirst(subStr + selectRegularSymbol(text), "");

      if (designateNumericSymbol(subStr.toCharArray()) == 0)
        sumSalary += Integer.parseInt(String.valueOf(subStr));
    }
    System.out.println(sumSalary);
  }
}