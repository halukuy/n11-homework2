import java.time.LocalDate;

class Invoice {
    private static int idCounter = 1;

    private int invoiceId;
    private LocalDate date;
    private double amount;

    public Invoice(LocalDate date, double amount) {
        this.invoiceId = idCounter++;
        this.date = date;
        this.amount = amount;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
