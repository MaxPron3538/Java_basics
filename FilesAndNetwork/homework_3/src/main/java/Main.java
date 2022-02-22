public class Main {
    public static void main(String[] args) throws Exception {

        Movements movements = new Movements("C:\\Users\\maxpr\\java_basics\\FilesAndNetwork\\files\\movementList.csv");

        System.out.println("Сумы доходов по организациям:");
        movements.outputInfoOfBankTransfers(0);
        System.out.println();
        System.out.println("Сумы расходов по организациям:");
        movements.outputInfoOfBankTransfers(1);
    }
}
