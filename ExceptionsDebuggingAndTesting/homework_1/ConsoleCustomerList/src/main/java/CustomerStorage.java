import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws Exception {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        if (components[INDEX_NAME].matches("[А-ЯЁ][а-яё]+") &&
        components[INDEX_SURNAME].matches("[А-ЯЁ][а-яё]+") &&
        components[INDEX_PHONE].matches("\\+7[0-9]{10}") &&
        components[INDEX_EMAIL].matches("[a-z._-]+@[a-z]+.[a-z]{2,5}")) {
            String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
        } else {
            throw new Exception();
        }



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