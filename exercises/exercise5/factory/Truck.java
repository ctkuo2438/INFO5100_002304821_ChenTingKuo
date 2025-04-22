package exercise5.factory;

public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by truck on land...");
    }
    @Override
    public double calculateCost(int distance) {
        return distance * 1.5; // $1.5 per km
    }
}
