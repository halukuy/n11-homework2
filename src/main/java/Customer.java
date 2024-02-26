import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Customer {
    private static int idCounter = 1;

    private int customerId;
    private String name;
    private String sector;
    private List<Invoice> invoices;

    public Customer(String name, String sector) {
        this.customerId = idCounter++;
        this.name = name;
        this.sector = sector;
        this.invoices = new ArrayList<>();
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getSector() {
        return sector;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public void createOrder(double amount) {
        Invoice newInvoice = new Invoice(LocalDate.now(), amount);
        invoices.add(newInvoice);
        System.out.println("Sipariş oluşturuldu: " + newInvoice);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", sector='" + sector + '\'' +
                '}';
    }
    public static void listAllCustomers(List<Customer> customers) {
        customers.forEach(System.out::println);
    }

    public static List<Customer> filterCustomersWithChar(List<Customer> customers, char filterChar) {
        return customers.stream()
                .filter(customer -> customer.getName().contains(String.valueOf(filterChar)))
                .collect(Collectors.toList());
    }

    public static double calculateTotalAmountInJune(List<Customer> customers) {
        return customers.stream()
                .filter(customer -> customer.getInvoices().stream()
                        .anyMatch(invoice -> invoice.getDate().getMonth() == LocalDate.of(2024, 6, 1).getMonth()))
                .flatMap(customer -> customer.getInvoices().stream())
                .mapToDouble(Invoice::getAmount)
                .sum();
    }

    public static List<Invoice> getAllInvoices(List<Customer> customers) {
        return customers.stream()
                .flatMap(customer -> customer.getInvoices().stream())
                .collect(Collectors.toList());
    }

    public static List<Invoice> getInvoicesOverAmount(List<Customer> customers, double amount) {
        return customers.stream()
                .flatMap(customer -> customer.getInvoices().stream())
                .filter(invoice -> invoice.getAmount() > amount)
                .collect(Collectors.toList());
    }

    public static double calculateAverageAmountOver(List<Customer> customers, double amount) {
        return customers.stream()
                .flatMap(customer -> customer.getInvoices().stream())
                .filter(invoice -> invoice.getAmount() > amount)
                .mapToDouble(Invoice::getAmount)
                .average()
                .orElse(0);
    }

    public static List<String> getCustomerNamesWithLowAmountInvoices(List<Customer> customers, double amount) {
        return customers.stream()
                .filter(customer -> customer.getInvoices().stream()
                        .anyMatch(invoice -> invoice.getAmount() < amount))
                .map(Customer::getName)
                .collect(Collectors.toList());
    }

    public static List<String> getSectorOfCustomersWithAverageAmountBelow(List<Customer> customers, double averageAmount) {
        return customers.stream()
                .filter(customer -> customer.getInvoices().stream()
                        .filter(invoice -> invoice.getDate().getMonth() == LocalDate.of(2024, 6, 1).getMonth())
                        .mapToDouble(Invoice::getAmount)
                        .average()
                        .orElse(0) < averageAmount)
                .map(Customer::getSector)
                .collect(Collectors.toList());
    }

    public static void createOrderForCustomer(Customer customer, double amount) {
        Invoice newOrder = new Invoice(LocalDate.now(), amount);
        customer.addInvoice(newOrder);
        System.out.println("New order created for customer " + customer.getName() + " with amount: " + amount);
    }
}