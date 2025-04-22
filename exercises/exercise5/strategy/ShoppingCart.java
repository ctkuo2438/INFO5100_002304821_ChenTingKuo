package exercise5.strategy;

import java.util.*;

public class ShoppingCart {
    private List<Item> items = new ArrayList<>();
    private PaymentStrategy paymentStrategy;

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        double total = calculateTotal();
        paymentStrategy.pay(total);
    }

    public void displayItems() {
        System.out.println("\nShopping Cart Items:");
        System.out.println("--------------------");
        for (Item item : items) {
            System.out.printf("- %s: $%.2f\n", item.getName(), item.getPrice());
        }
        System.out.printf("Total: $%.2f\n", calculateTotal());
    }

    private double calculateTotal() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }
}
