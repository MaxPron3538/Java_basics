import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО

      String regex = "[а-яА-Я-]+\\s[а-яА-Я]+\\s[а-яА-Я]+";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(input);

      if(matcher.matches())
      {
        input = input.replaceFirst("","Фамилия:").replaceFirst(" "," Имя:");
        String partOfInput = input.substring(input.lastIndexOf(" "),input.length());
        input = input.replaceFirst(partOfInput,"");
        input += partOfInput.replaceFirst(" "," Отчество:");
        input = input.replaceAll(" ","\n").replaceAll(":",": ");

        System.out.println(input);
      }
      else System.out.println("Введенная строка не является ФИО");

    }
  }

}