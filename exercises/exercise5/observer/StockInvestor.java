package exercise5.observer;

public class StockInvestor implements Observer {
    private String name;

    public StockInvestor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Notification to " + name + ": " + stockSymbol +
                " stock price changed to $" + price);
    }
}
