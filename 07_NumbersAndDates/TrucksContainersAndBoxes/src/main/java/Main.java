import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();

        int countContainers = 1,countTrucks = 1;

        for(int i = 0;i < Integer.parseInt(boxes);i++)
        {
            if(i % (27 * 12) == 0){
                System.out.print("\nГрузовик: " + countTrucks); countTrucks +=1; }

            if(i % 27 == 0){
                System.out.print("\r\n\tКонтейнер: " + countContainers); countContainers +=1; }

            System.out.print("\r\n\t\t" +"Ящик: " + (i + 1));
        }
        System.out.println("\r\nНеобходимо:\r\nгрузовиков - " + (countTrucks-1) + " шт.\r\nконтейнеров - " + (countContainers-1) + " шт.");


    // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }
}
