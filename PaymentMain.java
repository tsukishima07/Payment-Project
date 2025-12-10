import java.util.Scanner;

public class PaymentMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Payment Interface System ===");
        System.out.println("1. UPI");
        System.out.println("2. Card");
        System.out.println("3. Wallet");
        System.out.print("Choose Payment Method: ");
        int choice = scanner.nextInt();

        System.out.print("Enter Amount: ₹");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        PaymentMethod method = null;

        switch (choice) {
            case 1:
                System.out.print("Enter UPI ID: ");
                String upiId = scanner.nextLine();
                method = new UpiPayment(upiId);
                break;

            case 2:
                System.out.print("Enter Card Number: ");
                String cardNum = scanner.nextLine();
                System.out.print("Enter Card Holder Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Expiry (MM/YY): ");
                String expiry = scanner.nextLine();
                method = new CardPayment(cardNum, name, expiry);
                break;

            case 3:
                System.out.print("Enter Wallet ID: ");
                String walletId = scanner.nextLine();
                method = new WalletPayment(walletId);
                break;

            default:
                System.out.println("Invalid option!");
                System.exit(0);
        }

        PaymentProcessor processor = new PaymentProcessor(method);
        processor.process(amount);

        scanner.close();
    }
}
