import java.time.LocalDate;
import java.util.*;

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
}