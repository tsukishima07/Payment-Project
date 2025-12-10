public interface PaymentMethod {
    boolean validatePaymentDetails();

    void pay(double amount);
}
