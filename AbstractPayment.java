public abstract class AbstractPayment implements PaymentMethod {
    protected double amount;

    @Override
    public void pay(double amount) {
        this.amount = amount;
    }
}
