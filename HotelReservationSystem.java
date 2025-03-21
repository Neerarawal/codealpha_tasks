import java.util.*;

class Room {
    int roomNumber;
    String type;
    boolean isBooked;

    public Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isBooked = false;
    }

    public void bookRoom() {
        if (!isBooked) {
            isBooked = true;
            System.out.println("Room " + roomNumber + " booked successfully!");
        } else {
            System.out.println("Room " + roomNumber + " is already booked!");
        }
    }

    public void cancelBooking() {
        if (isBooked) {
            isBooked = false;
            System.out.println("Booking for Room " + roomNumber + " has been cancelled.");
        } else {
            System.out.println("Room " + roomNumber + " was not booked.");
        }
    }

    public String toString() {
        return "Room " + roomNumber + " (" + type + ") - " + (isBooked ? "Booked" : "Available");
    }
}

public class HotelReservationSystem {
    private static List<Room> rooms = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeRooms();
        
        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    viewRooms();
                    break;
                case 2:
                    bookRoom();
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeRooms() {
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(103, "Suite"));
    }

    private static void viewRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    private static void bookRoom() {
        System.out.print("Enter Room Number to Book: ");
        int roomNumber = scanner.nextInt();
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                room.bookRoom();
                return;
            }
        }
        System.out.println("Room not found!");
    }

    private static void cancelBooking() {
        System.out.print("Enter Room Number to Cancel Booking: ");
        int roomNumber = scanner.nextInt();
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                room.cancelBooking();
                return;
            }
        }
        System.out.println("Room not found!");
    }
}
