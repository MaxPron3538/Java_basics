import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    private static String url = "jdbc:mysql://localhost:3306/skillbox";
    private static String user = "root";
    private static String pass = "tiptop";
    private static int tabMax = 2;

    public static void main(String[] args) {

       try
       {
          Connection connection = DriverManager.getConnection(url,user,pass);

          Statement statement = connection.createStatement();
          ResultSet maxColumn = statement.executeQuery("SELECT max(Char_Length(name)) as max_column FROM COURSES");
          maxColumn.next();

          int base = Integer.parseInt(maxColumn.getString("max_column"))+tabMax;

          ResultSet set = statement.executeQuery(" SELECT name,count(Courses.id)/Month(max(subscription_date)) AS average_quantity FROM COURSES,Subscriptions WHERE COURSES.id = Subscriptions.course_id group by COURSES.name");

          System.out.println("Название курса                      | среднее количество покупок в месяц");
          System.out.println("------------------------------------------------------------------------");

          while(set.next())
          {
              int off = base - set.getString("name").length();
              String tab = Arrays.stream(new String[off]).map(s -> "" + " ").collect(Collectors.joining());
              System.out.println(set.getString("name") + tab + "|  " + set.getString("average_quantity"));
          }

          connection.close();

       }catch (Exception ex){
           ex.printStackTrace();
       }

    }
}
