import java.util.*;

class BookingService {

    private Map<String, Integer> inventory = new HashMap<>();

    public BookingService() {
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);
    }

    public synchronized String bookRoom(String guest, String type) {

        int count = inventory.get(type);

        if (count > 0) {
            int roomNumber = (type.equals("Single")) ? (6 - count)
                    : (type.equals("Double")) ? (4 - count)
                    : (3 - count);

            inventory.put(type, count - 1);

            return "Booking confirmed for Guest: " + guest + ", Room ID: " + type + "-" + roomNumber;
        } else {
            return "No rooms available for " + type;
        }
    }

    public void printInventory() {
        System.out.println("\nRemaining Inventory:");
        System.out.println("Single: " + inventory.get("Single"));
        System.out.println("Double: " + inventory.get("Double"));
        System.out.println("Suite: " + inventory.get("Suite"));
    }
}

public class Main {

    public static void main(String[] args) {

        System.out.println("Concurrent Booking Simulation");

        BookingService service = new BookingService();

        Thread t1 = new Thread(() -> System.out.println(service.bookRoom("Abhi", "Single")));
        Thread t2 = new Thread(() -> System.out.println(service.bookRoom("Vanmathi", "Double")));
        Thread t3 = new Thread(() -> System.out.println(service.bookRoom("Kural", "Suite")));
        Thread t4 = new Thread(() -> System.out.println(service.bookRoom("Subha", "Single")));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        service.printInventory();
    }
}