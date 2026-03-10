import java.util.HashMap;

class RoomInventory {

    private HashMap<String, Integer> inventory;

    RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public void displayInventory() {
        System.out.println("Current Room Inventory\n");

        for (String room : inventory.keySet()) {
            System.out.println(room + " : " + inventory.get(room) + " available");
        }
    }
}

public class Main {

    public static void main(String[] args) {

        System.out.println("Book My Stay - Version 3.1");
        System.out.println("Centralized Room Inventory Management\n");

        RoomInventory inventory = new RoomInventory();

        inventory.displayInventory();

        System.out.println("\nChecking availability for Double Room:");
        System.out.println("Available : " + inventory.getAvailability("Double Room"));

    }
}