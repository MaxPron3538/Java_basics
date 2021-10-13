import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoolNumbers
{
    static ArrayList<String> numbersCar = new ArrayList<>();

    public static List<String> beautifulNumber(int number){

        ArrayList<String> bNumbers = new ArrayList<>();
        String regex = "(\\d)\\1+\\d+?";
        Pattern pattern = Pattern.compile(regex);

        for(int count = 0;count <= number;count++)
        {
            Matcher matcher = pattern.matcher(String.valueOf(count));
            if(matcher.matches()) bNumbers.add(String.valueOf(count));
        }
        return bNumbers;
    }
    public static List<String> generateCoolNumbers()
    {
        String[] arrSymbols = new String[]{"А","В","Е","К","М","Н","О","Р","С","Т","У","Х"};
        List<String> numbers = beautifulNumber(999);
        List<String> region = beautifulNumber(199);

        for(long i = 0;i < 3000000;i++)
        {
            int countFS = (int)(Math.random() * 11);
            int countSS = (int)(Math.random() * 11);
            int countTS = (int)(Math.random() * 11);
            int countNum = (int)(Math.random() * numbers.size());
            int countRegion = (int)(Math.random() * region.size());

            if(Integer.parseInt(region.get(countRegion)) < 10 ) region.set(countRegion,"0" + region.get(countRegion));
            if(Integer.parseInt(numbers.get(countNum)) < 10) numbers.set(countNum,"0" + numbers.get(countNum));

            numbersCar.add(arrSymbols[countFS] + numbers.get(countNum)
                     + arrSymbols[countSS] + arrSymbols[countTS] + region.get(countRegion));
        }
        return numbersCar;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number)
    {
        return list.contains(number);
    }

    public static boolean binarySearchInList(List<String> sortedList,String number)
    {

        int condition = Collections.binarySearch(sortedList,number);

        if(condition >= 0) return true;

        return false;

        /*
        TODO:
         Это мой собственный бинарный поиск,так как думал что нужно в ручную реализовать:)

        if(sortedList.size()>1){
            int condition = sortedList.get(sortedList.size() / 2).compareTo(number);
            List<String> subList;

            if (condition > 0){
                subList = sortedList.subList(0, sortedList.size() / 2);
                binarySearchInList(subList, number);
            }
            if (condition < 0){
                subList = sortedList.subList(sortedList.size() / 2, sortedList.size());
                binarySearchInList(subList, number);
            }
            return true;
        }
        return  false;

         */
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number)
    {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number)
    {
        return treeSet.contains(number);
    }

}

