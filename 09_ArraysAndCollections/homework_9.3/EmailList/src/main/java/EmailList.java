import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EmailList {

    private TreeSet<String> emailTree = new TreeSet<String>();
    private Map<String,String> domenName = new HashMap<String,String>();
    private String WRONG_EMAIL_ANSWER = "Неверный формат email";

    EmailList()
    {
        domenName.put("@skillbox",".ru");
        domenName.put("@mail",".ru");
        domenName.put("@gmail",".com");
        domenName.put("@yahoo",".com");
        domenName.put("@mozilla",".org");
    }

    public void addDomenName(String key,String domenName)
    {
        this.domenName.put(key,domenName);
    }

    public void add(String email) {
        // TODO: валидный формат email добавляется

         String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.?[a-z]{2,3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if(!matcher.matches()){
            System.out.println(WRONG_EMAIL_ANSWER);
            return;
        }

        String nameOfServer = email.substring(email.indexOf("@"),email.length());

        for(Map.Entry<String,String> item : domenName.entrySet())
        {
           if(nameOfServer.matches(item.getKey()))
           {
              if(!nameOfServer.matches(item.getValue())) email += item.getValue();
           }
           else if(!nameOfServer.contains(".")) return;
        }

        if(emailTree.contains(email.toLowerCase())) return;

        emailTree.add(email);
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        return List.copyOf(emailTree).stream().sorted().collect(Collectors.toList());
    }

    public void outputList(){

        getSortedEmails().forEach(System.out::println);
    }

}
