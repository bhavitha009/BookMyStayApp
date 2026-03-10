import java.util.*;

class Reservation {

    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

class BookingQueue {

    Queue<Reservation> queue = new LinkedList<>();

    void addRequest(Reservation r) {
        queue.add(r);
    }

    Reservation getNextRequest() {
        return queue.poll();
    }

    boolean hasRequests() {
        return !queue.isEmpty();
    }
}

class InventoryService {

    HashMap<String, Integer> inventory = new HashMap<>();

    InventoryService() {
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 2);
        inventory.put("Suite Room", 1);
    }

    boolean isAvailable(String roomType) {
        return inventory.getOrDefault(roomType, 0) > 0;
    }

    void decrementRoom(String roomType) {
        inventory.put(roomType, inventory.get(roomType) - 1);
    }
}

class BookingService {

    HashMap<String, Set<String>> allocatedRooms = new HashMap<>();

    String allocateRoom(String roomType) {

        allocatedRooms.putIfAbsent(roomType, new HashSet<>());

        Set<String> assigned = allocatedRooms.get(roomType);

        String roomId = roomType.replace(" ", "") + "-" + (assigned.size() + 1);

        assigned.add(roomId);

        return roomId;
    }
}

public class Main {

    public static void main(String[] args) {

        System.out.println("Book My Stay - Version 6.1");
        System.out.println("Reservation Confirmation & Room Allocation\n");

        BookingQueue bookingQueue = new BookingQueue();
        InventoryService inventory = new InventoryService();
        BookingService bookingService = new BookingService();

        bookingQueue.addRequest(new Reservation("Alice", "Single Room"));
        bookingQueue.addRequest(new Reservation("Bob", "Double Room"));
        bookingQueue.addRequest(new Reservation("Charlie", "Single Room"));

        while (bookingQueue.hasRequests()) {

            Reservation request = bookingQueue.getNextRequest();

            System.out.println("Processing request for " + request.guestName);

            if (inventory.isAvailable(request.roomType)) {

                String roomId = bookingService.allocateRoom(request.roomType);

                inventory.decrementRoom(request.roomType);

                System.out.println("Reservation Confirmed");
                System.out.println("Room Type : " + request.roomType);
                System.out.println("Assigned Room ID : " + roomId + "\n");

            } else {

                System.out.println("No rooms available for " + request.roomType + "\n");

            }
        }
    }
}