import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static final String List = "LIST";

    public static boolean IsDigit(String cotact) throws NumberFormatException
    {
        try
        {
           Long.parseLong(cotact);
           return true;
        }
        catch (NumberFormatException ex)
        {
            return false;
        }
    }

    public static void main(String[] args) {

        PhoneBook book = new PhoneBook();

        while (true){

            String phone="",name ="";
            System.out.println("Введите номер, имя или команду:");

            Scanner in = new Scanner(System.in);
            String contact = in.nextLine();

            if(IsDigit(contact))
            {
                if(!book.getMapContacts().containsKey(contact)) System.out.println("Такого номера  нет в телефонной книге");

                book.outputMessage("Введите имя абонента для номера: " + contact);
                phone = contact;
                name = in.nextLine();
                book.addContact(name,phone);
            }
            else if(!IsDigit(contact) & !contact.equals(List))
            {
                if(!book.getMapContacts().containsValue(contact)) System.out.println("Такого имени нет в телефонной книге");

                book.outputMessage("Введите имя абонента для номера: " + contact);
                name = contact;
                phone = in.nextLine();
                book.addContact(name,phone);
            }
            else if(contact.equals(List))
            {
                for(String obj : book.getAllContacts())
                {
                    book.outputMessage(obj);
                }
            }

        }

    }
}
