import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  static String exception = "Введенная строка не является ФИО";

  public static int selectRegularSymbol(String text)
  {
    if(text.contains(" ")) return text.indexOf(" ");

    else return text.lastIndexOf(text.substring(text.length()));
  }

  public static boolean isCyrillic(char arr[]) {

    boolean result = false;
    for(int i = 0;i < arr.length;i++)
    {
      if(arr[i] == ' ' | arr[i] == '-') continue;

      if(Character.isDigit(arr[i])) result = false;

      if (Character.UnicodeBlock.of(arr[i]) == Character.UnicodeBlock.CYRILLIC)
        result = true;
      else return result;
    }
    return result;
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
     //TODO:напишите ваш код тут, результат вывести в консоль.
      // При невалидном ФИО вывести в консоль: Введенная строка не является ФИО

      if(input.substring(0,selectRegularSymbol(input)).length() == input.length()){ System.out.println(exception); return;}

      ArrayList<String> fullName  = new ArrayList<>();

      if(isCyrillic(input.toCharArray()))
      {
        String partOfName = null;

        while (input.length() > 0)
         {
           if(input.substring(0,selectRegularSymbol(input)).equals(partOfName)){ System.out.println(exception); return;}

           partOfName = input.substring(0, selectRegularSymbol(input));
           input = input.replaceFirst(partOfName, "");
           fullName.add(partOfName);
           input = input.trim();
         }
         System.out.println("Фамилия: " + fullName.get(0) + "\n" + "Имя: " + fullName.get(1) + "\n" + "Отчество: " + fullName.get(2));
     }
     else System.out.println(exception);
    }
  }

}