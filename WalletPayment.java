public class WalletPayment extends AbstractPayment {

    private String walletId;

    public WalletPayment(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public boolean validatePaymentDetails() {
        return walletId != null && walletId.startsWith("WAL");
    }

    @Override
    public void pay(double amount) {
        super.pay(amount);
        if (validatePaymentDetails()) {
            System.out.println("Paid ₹" + amount + " using Wallet ID: " + walletId);
        } else {
            System.out.println("Invalid Wallet ID!");
        }
    }
}
