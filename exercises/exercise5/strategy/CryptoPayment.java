package exercise5.strategy;

public class CryptoPayment implements PaymentStrategy {
    private String walletAddress;
    private String currency;

    public CryptoPayment(String walletAddress, String currency) {
        this.walletAddress = walletAddress;
        this.currency = currency;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Paid $%.2f equivalent using %s wallet: %s...\n",
                amount, currency, walletAddress.substring(0, 8));
    }
}
