package exercise5.factory;

public class RoadLogistics implements LogisticsFactory {
    @Override
    public Transport createTransport() {
        return new Truck(); // create Truck() instance
    }
}
