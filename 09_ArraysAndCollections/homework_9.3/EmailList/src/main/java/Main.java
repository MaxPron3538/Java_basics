import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String WRONG_COMMAND_INPUT = "Неверная команда ввода";
    public static final String List = "LIST";
    public static final String Add = "ADD";


    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
*/
    public static void main(String[] args)
    {
        String regexComm = "ADD|LIST";
        Pattern patternComm = Pattern.compile(regexComm);
        Scanner scanner = new Scanner(System.in);
        EmailList emailList = new EmailList();

        while (true)
        {
            String input = scanner.nextLine();
            Matcher matcher = patternComm.matcher(input);

            if (input.equals("0") | !matcher.find()){
                System.out.println(WRONG_COMMAND_INPUT);
                continue;
            }

            switch (matcher.group()) {
                case Add: {

                    input = input.replaceFirst(Add + "\\s*", "");
                    emailList.add(input);
                    break;
                }
                case List: {

                    emailList.outputList();
                    break;
                }
            }
        }
    }
}
