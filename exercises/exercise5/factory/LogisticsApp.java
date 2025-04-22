package exercise5.factory;

public class LogisticsApp {
    public void planDelivery(String transportType) {
        LogisticsFactory factory;

        if (transportType.equalsIgnoreCase("road")) {
            factory = new RoadLogistics();
        } else if (transportType.equalsIgnoreCase("sea")) {
            factory = new SeaLogistics();
        } else if (transportType.equalsIgnoreCase("air")) {
            factory = new AirLogistics();
        } else {
            System.out.println("Unknown transport type: " + transportType);
            return;
        }

        Transport transport = factory.createTransport();

        System.out.println("\nSelected transport: " + transportType.toUpperCase());
        transport.deliver();
        int distance = 1000; // Example distance in km
        System.out.printf("Cost for %d km: $%.2f\n", distance, transport.calculateCost(distance));
    }
}
