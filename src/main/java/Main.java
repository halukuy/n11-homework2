import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Haluk", "Food"));
        customers.add(new Customer("Uyumsal", "Finance"));

        System.out.println("All customers:");
        Customer.listAllCustomers(customers);
    }
}
