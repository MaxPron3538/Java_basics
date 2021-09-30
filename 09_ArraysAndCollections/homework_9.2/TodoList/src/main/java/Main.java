import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();

    private static final String List = "LIST";
    private static final String Add = "ADD";
    private static final String Edit = "EDIT";
    private static final String Delete = "DELETE";

    public static void main(String[] args)
    {
       // TODO: написать консольное приложение для работы со списком дел todoList

        System.out.println("Доступне команды: \nADD\nLIST\nEDIT\nDELETE");
        System.out.println("формат ввода: [команда] [номер записи] [имя]");
        System.out.println("При команде LIST ввести только команду.\nПри команде DELETE ввести только команду и номер записи,которую хотите удалить.");

        while(true)
       {
           System.out.println("Введите команду:");

           int index = -1;

           Scanner in = new Scanner(System.in);
           String inputArg = in.nextLine();
           String[] arrayArg = inputArg.split(" ");
           String regexNum = "\\d\\s|\\s\\d";

           if(inputArg.equals(Add) | inputArg.equals(Edit) | inputArg.equals(Delete)) continue;

           for (String toDo : arrayArg)
               if (toDo.matches("\\d")){ index = Integer.parseInt(toDo); break;}

           switch (arrayArg[0])
           {
               case Add: {
                   inputArg = inputArg.replace(Add + " ", "").replaceFirst(regexNum,"");
                   todoList.add(index, inputArg);
                   break;
               }
               case List: {
                   todoList.outputList();
                   break;
               }
               case Edit: {
                   inputArg = inputArg.replace(Edit + " ", "").replaceFirst(regexNum,"");
                   todoList.edit(inputArg, index);
                   break;
               }
               case Delete: {
                   todoList.delete(index);
               }
           }
       }
    }
}
