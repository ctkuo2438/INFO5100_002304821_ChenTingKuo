package exercise5.observer;

import java.util.*;

public class StockMarket implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private Map<String, Double> stocks = new HashMap<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (String stockSymbol : stocks.keySet()) {
            for (Observer observer : observers) {
                observer.update(stockSymbol, stocks.get(stockSymbol));
            }
        }
    }

    public void setStockPrice(String stockSymbol, double price) {
        System.out.println("StockMarket: " + stockSymbol + " price updated to $" + price);
        stocks.put(stockSymbol, price);
        notifyObservers();
    }
}
