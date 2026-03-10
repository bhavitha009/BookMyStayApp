import java.util.HashMap;

class Room {

    String roomType;
    double price;

    Room(String roomType, double price) {
        this.roomType = roomType;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Room Type : " + roomType);
        System.out.println("Price     : $" + price);
    }
}

class RoomInventory {

    private HashMap<String, Integer> inventory;

    RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 0);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}

public class Main {

    public static void main(String[] args) {

        System.out.println("Book My Stay - Version 4.1");
        System.out.println("Room Search & Availability Check\n");

        RoomInventory inventory = new RoomInventory();

        Room single = new Room("Single Room", 100);
        Room doub = new Room("Double Room", 180);
        Room suite = new Room("Suite Room", 300);

        Room[] rooms = {single, doub, suite};

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.roomType);

            if (available > 0) {

                room.displayDetails();
                System.out.println("Available Rooms : " + available);
                System.out.println();
            }
        }
    }
}