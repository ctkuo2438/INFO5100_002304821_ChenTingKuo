package exercise5.factory;

public class Ship implements Transport{
    @Override
    public void deliver() {
        System.out.println("Delivering by ship over sea...");
    }
    @Override
    public double calculateCost(int distance) {
        return distance * 3.0; // $3 per km
    }
}
