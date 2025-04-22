package exercise5.factory;

public class Airplane implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by airplane in the air...");
    }
    @Override
    public double calculateCost(int distance) {
        return distance * 10.0; // $10 per km
    }
}