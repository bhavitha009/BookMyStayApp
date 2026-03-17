import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Add-On Service Selection");

        String reservationId = "Single-1";

        List<Integer> services = new ArrayList<>();

        services.add(500);   // Breakfast
        services.add(500);   // WiFi
        services.add(500);   // Spa

        int totalCost = 0;

        for(int cost : services) {
            totalCost += cost;
        }

        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost + ".0");
    }
}