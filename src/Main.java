import java.util.*;

class Reservation {
    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

public class Main {

    public static void main(String[] args) {

        System.out.println("Booking History and Reporting\n");

        System.out.println("Booking History Report\n");

        List<Reservation> history = new ArrayList<>();

        history.add(new Reservation("Abhi", "Single"));
        history.add(new Reservation("Subha", "Double"));
        history.add(new Reservation("Vanmathi", "Suite"));

        for (Reservation r : history) {
            System.out.println("Guest: " + r.guestName + ", Room Type: " + r.roomType);
        }
    }
}