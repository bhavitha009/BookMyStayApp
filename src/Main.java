import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Add-On Service Selection");

        String reservationId = "Single-1";

        List<Integer> services = new ArrayList<>();

        services.add(500);
        services.add(500);
        services.add(500);

        int totalCost = 0;

        for (int cost : services) {
            totalCost += cost;
        }

        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost + ".0");
    }
}}