import java.util.ArrayList;
import java.util.Scanner;
class Room {
    private String name;
    private boolean booked;
    private boolean occupied;
    private boolean acOn;
    private boolean lightsOn;
    public Room(String name) {
        this.name = name;
        this.booked = false;
        this.occupied = false;
        this.acOn = false;
        this.lightsOn = false;
    }
    public String getName() {
        return name;
    }
    public void bookRoom() {
        if (!booked) {
            booked = true;
            System.out.println(name + " has been booked.");
        } else {
            System.out.println(name + " is already booked.");
        }
    }
    public void releaseRoom() {
        booked = false;
        occupied = false;
        acOn = false;
        lightsOn = false;
        System.out.println(name + " booking has been released.");
    }
    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
        if (occupied) {
            acOn = true;
            lightsOn = true;
            System.out.println(name + " is now occupied. AC and lights are ON.");
        } else {
            acOn = false;
            lightsOn = false;
            System.out.println(name + " is now empty. AC and lights are OFF.");
        }
    }
    @Override
    public String toString() {
        return name + " | Booked: " + booked +
                " | Occupied: " + occupied +
                " | AC: " + (acOn ? "ON" : "OFF") +
                " | Lights: " + (lightsOn ? "ON" : "OFF");
    }
}
public class SmartOfficeApp {
    private static ArrayList<Room> rooms = new ArrayList<Room>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        rooms.add(new Room("Conference Room A"));
        rooms.add(new Room("Conference Room B"));
        rooms.add(new Room("Conference Room C"));
        while (true) {
            System.out.println("\n--- Smart Office Facility ---");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Release Room");
            System.out.println("4. Set Occupancy");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine(); // Read line safely
            int choice = 0;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number 1-5.");
                continue;
            }
            if (choice == 5) {
                System.out.println("Exiting... Smart office shutting down.");
                break;
            }
            switch (choice) {
                case 1:
                    viewRooms();
                    break;
                case 2:
                    bookRoom();
                    break;
                case 3:
                    releaseRoom();
                    break;
                case 4:
                    setOccupancy();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
    private static void viewRooms() {
        System.out.println("\n--- Room Status ---");
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println((i + 1) + ". " + rooms.get(i));
        }
    }
    private static void bookRoom() {
        viewRooms();
        System.out.print("Enter room number to book: ");
        int num = readRoomNumber();
        if (num != -1) rooms.get(num - 1).bookRoom();
    }
    private static void releaseRoom() {
        viewRooms();
        System.out.print("Enter room number to release: ");
        int num = readRoomNumber();
        if (num != -1) rooms.get(num - 1).releaseRoom();
    }
    private static void setOccupancy() {
        viewRooms();
        System.out.print("Enter room number to update occupancy: ");
        int num = readRoomNumber();
        if (num == -1) return;
        System.out.print("Is the room occupied? (true/false): ");
        String occInput = scanner.nextLine();
        boolean occ = Boolean.parseBoolean(occInput.trim());
        rooms.get(num - 1).setOccupied(occ);
    }
    private static int readRoomNumber() {
        String input = scanner.nextLine();
        int num = -1;
        try {
            num = Integer.parseInt(input);
            if (num <= 0 || num > rooms.size()) {
                System.out.println("Invalid room number.");
                return -1;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Enter a number.");
            return -1;
        }
        return num;
    }
}
