
public class Main {

    public static void main(String[] args) {

        String line = "Каждый охотник желает знать где сидит фазан";

        char[] arrOfWord = line.toCharArray();
        String[] arrStr = new String[arrOfWord.length];

        for(int i = 0;i < arrOfWord.length;i++)
           arrStr[i] = String.valueOf(arrOfWord[i]);
        
        String[] arrReverse = ReverseArray.reverse(arrStr);

        for(String i : arrReverse) System.out.println(i);
    }
}
