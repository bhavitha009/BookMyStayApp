import java.util.LinkedList;
import java.util.Queue;

class Reservation {

    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    void displayRequest() {
        System.out.println("Guest : " + guestName + " requested " + roomType);
    }
}

class BookingRequestQueue {

    private Queue<Reservation> queue;

    BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    public void addRequest(Reservation reservation) {
        queue.add(reservation);
        System.out.println("Booking request added for " + reservation.guestName);
    }

    public void displayRequests() {
        System.out.println("\nCurrent Booking Requests (FIFO Order)\n");

        for (Reservation r : queue) {
            r.displayRequest();
        }
    }
}

public class Main {

    public static void main(String[] args) {

        System.out.println("Book My Stay - Version 5.1");
        System.out.println("Booking Request Queue (First-Come-First-Served)\n");

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        Reservation r1 = new Reservation("Alice", "Single Room");
        Reservation r2 = new Reservation("Bob", "Double Room");
        Reservation r3 = new Reservation("Charlie", "Suite Room");

        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        bookingQueue.displayRequests();
    }
}
