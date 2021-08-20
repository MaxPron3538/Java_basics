public class Main {
    public static void main(String[] args)
    {
        Container container = new Container(24);
        container.addCount(5672);
        System.out.println(container.getCount());

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

        for(int i = 0;i <= 63;i++)
        {
            char c = (char) (1040 + i);

            if(i == 6) System.out.println((char)1025 + "-" + 1025);

            if(i == 38) System.out.println((char)1105 + "-" + 1105);

            else System.out.println(c + "-" + (1040 + i));
        }


    }
}
