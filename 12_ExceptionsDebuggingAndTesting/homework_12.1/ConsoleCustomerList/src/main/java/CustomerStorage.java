import java.util.*;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data)throws Exception{
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
        final int AMOUNT_INDEX = 4;

            String[] components = data.split("\\s+");

            if (components.length != AMOUNT_INDEX) throw new IllegalArgumentException("Incorrect length of input data");

            if(!components[INDEX_EMAIL].matches("^[A-Za-z0-9+_.-]+@(.+)$")) throw new IllegalArgumentException("Incorrect input email");

            if(!components[INDEX_PHONE].matches("\\+\\d{7,12}")) throw new IllegalArgumentException("Incorrect input number phone");

            String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));

    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}