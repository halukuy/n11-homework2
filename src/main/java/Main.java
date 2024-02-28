import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Haluk", "Food"));
        customers.add(new Customer("Uyumsal", "Finance"));

        System.out.println("All customers:");
        Customer.listAllCustomers(customers);

        // Yeni sipariş oluşturma
        Customer.createOrderForCustomer(customers.get(0), 1600);

        // Kullanıcı adında 'C' harfi bulunan müşteriler
        System.out.println("\nC harfi içeren müşteriler:");
        List<Customer> filteredCustomers = Customer.filterCustomersWithChar(customers, 'C');
        filteredCustomers.forEach(System.out::println);

        // Haziran ayındaki toplam fatura tutarı
        System.out.println("\nHaziran ayındaki toplam fatura tutarı:");
        double juneTotalAmount = Customer.calculateTotalAmountInJune(customers);
        System.out.println(juneTotalAmount);

        // Sistemdeki tüm faturalar
        System.out.println("\nSistemdeki tüm faturalar:");
        List<Invoice> allInvoices = Customer.getAllInvoices(customers);
        allInvoices.forEach(System.out::println);

        // Sistemdeki 1500TL üstündeki faturalar
        System.out.println("\nSistemdeki 1500TL üstündeki faturalar:");
        List<Invoice> invoicesOver1500 = Customer.getInvoicesOverAmount(customers, 1500);
        invoicesOver1500.forEach(System.out::println);

        // Sistemdeki 1500TL üstündeki faturaların ortalaması
        System.out.println("\nSistemdeki 1500TL üstündeki faturaların ortalaması:");
        double averageAmountOver1500 = Customer.calculateAverageAmountOver(customers, 1500);
        System.out.println(averageAmountOver1500);

        // Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimleri
        System.out.println("\n500TL altındaki faturalara sahip müşterilerin isimleri:");
        List<String> customerNamesWithLowAmountInvoices = Customer.getCustomerNamesWithLowAmountInvoices(customers, 500);
        customerNamesWithLowAmountInvoices.forEach(System.out::println);

        // Haziran ayındaki faturalarının ortalaması 750 altı olan firmaların sektörleri
        System.out.println("\nHaziran ayındaki faturalarının ortalaması 750 altı olan firmaların sektörleri:");
        List<String> sectorOfCustomersWithAverageAmountBelow750 = Customer.getSectorOfCustomersWithAverageAmountBelow(customers, 750);
        sectorOfCustomersWithAverageAmountBelow750.forEach(System.out::println);


    }
}
