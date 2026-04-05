public class OrderTest {
    public static void main(String[] args) {
        OrderAction orderAction = new OrderAction();

        OrderCalculator calculator = orderAction;
        calculator.calculateTotal(10.0, 2);

        OrderPlacer placer = orderAction;
        placer.placeOrder("John Doe", "123 Main St");

        InvoiceGenerator invoiceGen = orderAction;
        invoiceGen.generateInvoice("order_123.pdf");

        NotificationSender notifier = orderAction;
        notifier.sendEmailNotification("johndoe@example.com");
    }
}
