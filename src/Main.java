import java.util.*;

class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Booking Validation");

        try {
            System.out.print("Enter guest name: ");
            String name = sc.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = sc.nextLine();

            validateRoomType(roomType);

            System.out.println("Booking successful for " + name);

        } catch (InvalidBookingException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }

        sc.close();
    }

    public static void validateRoomType(String roomType) throws InvalidBookingException {

        if (!(roomType.equals("Single") ||
                roomType.equals("Double") ||
                roomType.equals("Suite"))) {

            throw new InvalidBookingException("Invalid room type selected.");
        }
    }
}