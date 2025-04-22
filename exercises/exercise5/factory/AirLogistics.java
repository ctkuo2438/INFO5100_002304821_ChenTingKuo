package exercise5.factory;

public class AirLogistics implements LogisticsFactory {
    @Override
    public Transport createTransport() {
        return new Airplane();
    }
}
