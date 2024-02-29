# Müşteri ve Fatura Yönetim Sistemi

Bu Java projesi, müşterilerin ve faturaların yönetimini sağlayan basit bir sistemdir. Aşağıda proje hakkında temel bilgiler ve örnek kullanımlar bulunmaktadır.

## Proje Yapısı

- **Customer.java:** Müşteri sınıfını içerir.
- **Invoice.java:** Fatura sınıfını içerir.
- **Main.java:** Ana uygulama sınıfını içerir ve temel kullanım örneklerini içerir.

## Temel Fonksiyonlar

1. **Müşteri Oluşturma ve Sipariş Verme:**
   - `createOrderForCustomer(Customer customer, double amount)` fonksiyonu ile müşteriye yeni bir sipariş ekleyebilirsiniz.

2. **Müşteri Listeleme ve Filtreleme:**
   - `listAllCustomers(List<Customer> customers)` ile tüm müşterileri listeleyebilirsiniz.
   - `filterCustomersWithChar(List<Customer> customers, char filterChar)` ile belirli bir karakter içeren müşterileri filtreleyebilirsiniz.

3. **Fatura İşlemleri:**
   - `calculateTotalAmountInJune(List<Customer> customers)` ile Haziran ayındaki toplam fatura tutarını hesaplayabilirsiniz.
   - `getAllInvoices(List<Customer> customers)` ile tüm faturaları listeleyebilirsiniz.
   - `getInvoicesOverAmount(List<Customer> customers, double amount)` ile belirli bir tutarın üzerindeki faturaları filtreleyebilirsiniz.
   - `calculateAverageAmountOver(List<Customer> customers, double amount)` ile belirli bir tutarın üzerindeki faturaların ortalamasını hesaplayabilirsiniz.
   - `getCustomerNamesWithLowAmountInvoices(List<Customer> customers, double amount)` ile belirli bir tutarın altındaki faturalara sahip müşterilerin isimlerini alabilirsiniz.
   - `getSectorOfCustomersWithAverageAmountBelow(List<Customer> customers, double averageAmount)` ile belirli bir ortalamanın altındaki faturalara sahip müşterilerin sektörlerini alabilirsiniz.

## Kullanım

Projenin temel kullanımı `Main.java` sınıfında örneklenmiştir. Aşağıda bazı örnekler bulunmaktadır:

```java
// Müşteri listesini oluştur
List<Customer> customers = new ArrayList<>();
customers.add(new Customer("Haluk", "Food"));
customers.add(new Customer("Uyumsal", "Finance"));

// Tüm müşterileri listele
Customer.listAllCustomers(customers);

// Yeni sipariş oluştur
Customer.createOrderForCustomer(customers.get(0), 1600);

// 'C' harfi içeren müşterileri filtrele
List<Customer> filteredCustomers = Customer.filterCustomersWithChar(customers, 'C');
filteredCustomers.forEach(System.out::println);

// Diğer örnekler için Main.java dosyasını inceleyin.
