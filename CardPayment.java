public class CardPayment extends AbstractPayment {

    private String cardNumber;
    private String cardHolder;
    private String expiryDate;

    public CardPayment(String cardNumber, String cardHolder, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean validatePaymentDetails() {
        return cardNumber != null && cardNumber.length() == 16 && expiryDate.contains("/");
    }

    @Override
    public void pay(double amount) {
        super.pay(amount);
        if (validatePaymentDetails()) {
            System.out.println("Paid ₹" + amount + " using Card ending with: "
                    + cardNumber.substring(cardNumber.length() - 4));
        } else {
            System.out.println("Invalid Card Details!");
        }
    }
}
