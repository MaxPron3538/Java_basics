import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

    private Map<String,String> mapContact = new HashMap<>();

    private String regexName = "\\D+";
    private String regexPhone = "\\+?7?[9][0-9][0-9]\\d{7}";

    private Pattern patternName = Pattern.compile(regexName);
    private Pattern patternPhone = Pattern.compile(regexPhone);

    public void addContact(String phone, String name) {

        Matcher matcherPhone = patternPhone.matcher(phone);
        Matcher matcherName = patternName.matcher(name);

        if(matcherPhone.matches() && matcherName.matches())
        {
            if(mapContact.containsKey(phone))
            {
               outputMessage("Такое значение уже есть,вот список");

               for (Map.Entry<String, String> item : mapContact.entrySet()){

                   outputContact(item.getValue(),item.getKey());
               }
               outputMessage("Значение перезаписалось");
            }
            mapContact.put(phone,name);
            outputMessage("Контакт сохранен!");

        }else outputMessage("Неверный формат ввода!");
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
    }

    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку

        for (Map.Entry<String,String> item : mapContact.entrySet()){
            if(item.getKey().equals(phone)) return item.getValue() + " - " + item.getKey();
        }
        return "";
    }

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        TreeSet<String> treeSelectContacts = new TreeSet<>();

        if(mapContact.containsValue(name))
        {
            for (Map.Entry<String, String> item : mapContact.entrySet()){
                if (item.getValue().equals(name)) {
                    treeSelectContacts.add(item.getValue() + " - " + item.getKey());
                }
            }
            return treeSelectContacts;
        }
        return new TreeSet<>();
    }

    public Set<String> getAllContacts(){
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet

        if(!mapContact.isEmpty()){
            return CorretFormatContacts(mapContact);
        }
        return new TreeSet<>();
    }

    public Set<String> CorretFormatContacts(Map<String,String> mapContact)
    {
        String[] arrayPhone = mapContact.keySet().toArray(new String[0]);
        String[] arrayName = mapContact.values().toArray(new String[0]);
        TreeSet<String> treeSet = new TreeSet<>();

        for (int i = 0;i < arrayName.length;i++)
        {
            for (int j = i+1;j < arrayName.length;j++)
            {
                if(arrayName[i].equals(arrayName[j]))
                {
                    arrayPhone[i] += "," + arrayPhone[j];
                    arrayPhone[j] = arrayPhone[j].replace(arrayPhone[j],"");
                    arrayName[j] = arrayName[j].replace(arrayName[j],"");
                }
            }
            treeSet.add(arrayName[i] + " - " + arrayPhone[i]);
        }
        return treeSet;
    }

    public void outputContact(String name,String contact)
    {
        outputMessage(name + " - " + contact);
    }

    public void outputMessage(String message)
    {
        System.out.println(message);
    }

    public String getRegexName(){ return regexName;}

    public String getRegexPhone(){ return regexPhone;}

    public Map<String, String> getMapContacts(){ return mapContact;}

}