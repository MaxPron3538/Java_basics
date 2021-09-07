import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

  public static void main(String[] args)
  {
    LocalDate date  = LocalDate.of(1996,1,21);
    String period = getPeriodFromBirthday(date);
    System.out.println(period);
  }

  private static String getPeriodFromBirthday(LocalDate birthday)
  {
    LocalDate currentData = LocalDate.now();

    int periodOfYears = currentData.getYear() - birthday.getYear();

    int periodOfMonth = currentData.getMonthValue() + (12 - birthday.getMonthValue());

    if(periodOfMonth >= 12){ periodOfYears += periodOfMonth / 12; periodOfMonth = periodOfMonth % 12;}

    int periodOfDays = currentData.getDayOfMonth() + (birthday.lengthOfMonth() - birthday.getDayOfMonth());

    if(periodOfDays > 31){ periodOfMonth += periodOfDays / 31; periodOfDays = periodOfDays % 31;}

    return String.valueOf(periodOfYears) + " years, " + String.valueOf(periodOfMonth) + " month," + String.valueOf(periodOfDays) + " days";
  }

}
