package exercise5.factory;

public class SeaLogistics implements LogisticsFactory {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
