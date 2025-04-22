package exercise5;

import exercise5.factory.LogisticsApp;
import exercise5.observer.StockMarket;
import exercise5.observer.StockInvestor;
import exercise5.strategy.ShoppingCart;
import exercise5.strategy.Item;
import exercise5.strategy.CreditCardPayment;
import exercise5.strategy.PayPalPayment;
import exercise5.strategy.CryptoPayment;

public class Main {
    public static void main(String[] args) {
        System.out.println("Design Patterns Demonstration");
        System.out.println("============================\n");

        // Factory Method Pattern Demo
        factoryMethodDemo();

        // Observer Pattern Demo
        observerPatternDemo();

        // Strategy Pattern Demo
        strategyPatternDemo();
    }

    // Factory Method Demo
    private static void factoryMethodDemo() {
        System.out.println("\n1. FACTORY METHOD PATTERN DEMONSTRATION");
        System.out.println("---------------------------------------");
        System.out.println("Scenario: A logistics application that handles different types of transportation");

        LogisticsApp app = new LogisticsApp();
        app.planDelivery("sea");
        app.planDelivery("road");
        app.planDelivery("air");
    }

    // Observer Pattern Demo
    private static void observerPatternDemo() {
        System.out.println("\n\n2. OBSERVER PATTERN DEMONSTRATION");
        System.out.println("----------------------------------");
        System.out.println("Scenario: A stock market notification system");

        // Create a stock subject
        StockMarket stockMarket = new StockMarket();

        // Create observers
        StockInvestor investor1 = new StockInvestor("Alice");
        StockInvestor investor2 = new StockInvestor("Bob");
        StockInvestor investor3 = new StockInvestor("Charlie");

        // Subscribe investors to stock updates
        stockMarket.addObserver(investor1);
        stockMarket.addObserver(investor2);
        stockMarket.addObserver(investor3);

        // Simulate stock price changes
        System.out.println("\nSimulating stock price changes...");
        stockMarket.setStockPrice("AAPL", 175.50);

        // Unsubscribe an investor
        System.out.println("\nBob unsubscribes from updates");
        stockMarket.removeObserver(investor2);

        // More stock updates
        stockMarket.setStockPrice("GOOGL", 142.30);
    }

    // Strategy Pattern Demo
    private static void strategyPatternDemo() {
        System.out.println("\n\n3. STRATEGY PATTERN DEMONSTRATION");
        System.out.println("----------------------------------");
        System.out.println("Scenario: A payment processing system with different payment methods");

        // Create shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Add some items
        cart.addItem(new Item("Laptop", 1299.99));
        cart.addItem(new Item("Mouse", 25.99));
        cart.addItem(new Item("Keyboard", 75.50));

        // Display cart
        cart.displayItems();

        // Process payment with different strategies
        System.out.println("\nProcessing payment with Credit Card...");
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "John Doe", "123", "12/25"));
        cart.checkout();

        System.out.println("\nProcessing payment with PayPal...");
        cart.setPaymentStrategy(new PayPalPayment("john.doe@example.com", "password123"));
        cart.checkout();

        System.out.println("\nProcessing payment with Cryptocurrency...");
        cart.setPaymentStrategy(new CryptoPayment("0xabc123def456", "BTC"));
        cart.checkout();
    }
}