public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;
    private static double totalCostInAllBaskets = 0;
    private static int totalAmountOfAllBaskets = 0;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items += items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    private static void increaseCount(int count) {
        Basket.count += count;
    }

    public void add(String name,int price){ add(name, price,1,0);}

    public void add(String name,int price,int count,double weight)
    {
        boolean error = false;
        if (!contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
            count + " шт. - " + price;
        totalPrice += count * price;
        totalCostOfGoodsInAllBaskets(count * price);
        amountOfAllGoodsInAllBaskets(count);
        totalWeight += count * weight;
    }

    public static void totalCostOfGoodsInAllBaskets(int totalPrice)
    {
       totalCostInAllBaskets += totalPrice;
    }

    public static void amountOfAllGoodsInAllBaskets(int count)
    {
       totalAmountOfAllBaskets += count;
    }

    public static double averageCostOfGoodsInAllBaskets()
    {
       return totalCostInAllBaskets/totalAmountOfAllBaskets;
    }

    public static double averageCostOfBasket()
    {
        return totalCostInAllBaskets/count;
    }

    public void clear()
    {
        items = "";
        totalPrice = 0;
    }

    public static double getTotalCostInAllBaskets(){return totalCostInAllBaskets;}

    public static int getTotalAmountOfAllBaskets(){return totalAmountOfAllBaskets;}

    public double getTotalWeight() { return totalWeight;}

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
