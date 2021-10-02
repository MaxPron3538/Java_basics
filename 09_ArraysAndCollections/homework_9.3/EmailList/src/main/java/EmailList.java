import java.util.*;
import java.util.stream.Collectors;

public class EmailList {

    private TreeSet<String> emailTree = new TreeSet<String>();
    private ArrayList<String> ArrList = new ArrayList<>();

    public void add(String email) {
        // TODO: валидный формат email добавляется

        if(email.contains("ru") & !email.contains(".") | !email.contains("@")) return;

        if((email.contains("skillbox") & !email.contains(".ru")) | (email.contains("mail")
                & !email.contains(".ru"))) email = email.concat(".ru");

        if(ArrList.contains(email.toLowerCase())) return;

        ArrList.add(email);
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
