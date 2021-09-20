import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

    System.out.println(calculateSalarySum(text));

  }

  public static int containsRegex(String text)
  {
    String regex = "\\s";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);

    if (matcher.find()) return text.indexOf(matcher.group());

    else return text.lastIndexOf(text.substring(text.length()-1));
  }

  public static int calculateSalarySum(String text){

    int SumSalary = 0;
    String regexDec = "\\d+";
    Pattern patternDecimal = Pattern.compile(regexDec);

    while (text.length() > 0)
    {
      String subStr = null;
      subStr = text.substring(0,containsRegex(text));
      Matcher matcherDecimal = patternDecimal.matcher(subStr);

      if(matcherDecimal.find()) SumSalary += Integer.parseInt(subStr);

      containsRegex(text);

      text = text.replaceFirst(subStr + text.substring(subStr.length(),subStr.length()+1),"");
    }
    return SumSalary;
  }

}