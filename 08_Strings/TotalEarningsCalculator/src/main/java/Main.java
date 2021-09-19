import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

public class Main {

  public static int designateNumericSymbol(char[] str)
  {
    int count = 0;

    while (count<str.length){

      if (Character.isDigit(str[count])) count++;

      else return 1;
    }
    return 0;
  }

  public static int selectRegularSymbol(String text,int offset)
  {
    String offsetStr = text.substring(offset+1);

    if(offsetStr.contains(" ")) return text.indexOf(" ",offset+1);

    else return text.lastIndexOf(text.substring(text.length()));
  }

  public static void main(String[] args) {
    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

    //TODO: напишите ваш код, результат вывести в консоль

    int sumSalary = 0,count = 0,offset = 0;
    String subStr = new String("");

    while (count < text.length())
    {
      if(text.indexOf(subStr) != text.lastIndexOf(subStr) & text.indexOf(subStr) >= offset)
        offset = text.indexOf(subStr) + subStr.length();

      else offset = text.lastIndexOf(subStr) + subStr.length();

      subStr = text.substring(offset,selectRegularSymbol(text,offset));
      String word = subStr.trim();
      count+= subStr.length();

      if (designateNumericSymbol(word.toCharArray()) == 0)
        sumSalary += Integer.parseInt(String.valueOf(word));
    }
    System.out.println(sumSalary);
  }
}