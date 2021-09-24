import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.

      input = input.replaceAll("-","").replaceAll(" ","");
      input = input.replaceAll("[(]","")
              .replaceAll("[)]","");
      String regex = "[+][7]\\d{10}|[8]\\d{10}|\\d{10}";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(input);

      if (matcher.matches())
      {
        if(input.contains("+")) input = input.replaceFirst("[+]","");
        if(input.contains("8")) input = input.replaceFirst("8","7");
        if(input.length() == 10) input = input.replaceFirst("","7");
        System.out.println(input);

      }else System.out.println("Неверный формат номера");
    }
  }

}
