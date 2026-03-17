import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation");

        // Existing reservation
        String reservationId = "Single-1";
        String roomType = "Single";

        // Inventory (before cancellation)
        int singleRooms = 5;

        // Stack for rollback (LIFO)
        Stack<String> rollbackStack = new Stack<>();

        // Cancel booking
        rollbackStack.push(reservationId);
        singleRooms++;  // restore inventory

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);

        System.out.println("\nRollback History (Most Recent First):");

        while (!rollbackStack.isEmpty()) {
            System.out.println("Released Reservation ID: " + rollbackStack.pop());
        }

        System.out.println("\nUpdated Single Room Availability: " + singleRooms);
    }
}