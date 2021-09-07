import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.time.*;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 5;
        int month = 9;
        int year = 2020;

        System.out.println(collectBirthdays(year,month,day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM y");

        LocalDate today = LocalDate.now();

        LocalDate birthday = LocalDate.of(year,month,day);

        DayOfWeek dayOfWeek = birthday.getDayOfWeek();

        if(birthday.equals(LocalDate.now())) return "0" + " - " + birthday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)) + " - " + dayOfWeek.getDisplayName(TextStyle.SHORT,Locale.US);

        String period = new String();

        for(int i = 0;i <= LocalDate.now().getYear() - year;i++)
        {
            birthday = LocalDate.of(year + i,month,day);

            if(birthday.isBefore(today))

            period += i + " - " + birthday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)) + " - " + dayOfWeek.getDisplayName(TextStyle.SHORT,Locale.US)  + System.lineSeparator();

            if(birthday.equals(today)) return period += i +" - " + birthday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)) + " - " + dayOfWeek.plus(1).getDisplayName(TextStyle.SHORT,Locale.US);

        }
        return period;
    }
}
