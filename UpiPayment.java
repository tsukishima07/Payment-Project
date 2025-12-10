public class UpiPayment extends AbstractPayment {

    private String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean validatePaymentDetails() {
        return upiId != null && upiId.contains("@");
    }

    @Override
    public void pay(double amount) {
        super.pay(amount);
        if (validatePaymentDetails()) {
            System.out.println("Paid ₹" + amount + " using UPI ID: " + upiId);
        } else {
            System.out.println("Invalid UPI ID!");
        }
    }
}
