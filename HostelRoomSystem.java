import java.util.*;

class Room {
    private static int idCounter = 1;
    private int roomId;
    private int roomNumber;
    private String roomType;
    private double price;
    private String availability;
    private String guestName;

    public Room(int roomNumber, String roomType, double price, String availability) {
        this.roomId = idCounter++;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.availability = availability;
        this.guestName = "";
    }

    public int getRoomId() { return roomId; }
    public int getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public double getPrice() { return price; }
    public String getAvailability() { return availability; }
    public String getGuestName() { return guestName; }
    
    public void setAvailability(String availability) { this.availability = availability; }
    public void setPrice(double price) { this.price = price; }
    public void setRoomType(String roomType) { this.roomType = roomType; }
    public void setGuestName(String guestName) { this.guestName = guestName; }
}

public class HostelRoomSystem {
    private static List<Room> rooms = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        while (true) {
            System.out.println("\n========================================");
            System.out.println("   HOSTEL ROOM ALLOCATION SYSTEM");
            System.out.println("========================================");
            System.out.println("1.  ADD ROOM");
            System.out.println("2.  VIEW ALL ROOMS");
            System.out.println("3.  UPDATE AVAILABILITY");
            System.out.println("4.  UPDATE ROOM DETAILS");
            System.out.println("5.  DELETE ROOM");
            System.out.println("6.  SEARCH BY TYPE");
            System.out.println("7.  SEARCH BY AVAILABILITY");
            System.out.println("8.  SEARCH BY PRICE RANGE");
            System.out.println("9.  SEARCH BY ROOM NUMBER");
            System.out.println("10. ALLOCATE ROOM TO GUEST");
            System.out.println("11. CHECK-OUT GUEST");
            System.out.println("12. VIEW ROOM STATISTICS");
            System.out.println("13. SORT ROOMS");
            System.out.println("0.  EXIT");
            System.out.println("========================================");
            System.out.print("CHOOSE AN OPTION: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addRoom();
                    break;
                case 2:
                    viewRooms();
                    break;
                case 3:
                    updateAvailability();
                    break;
                case 4:
                    updateRoomDetails();
                    break;
                case 5:
                    deleteRoom();
                    break;
                case 6:
                    searchByType();
                    break;
                case 7:
                    searchByAvailability();
                    break;
                case 8:
                    searchByPriceRange();
                    break;
                case 9:
                    searchByRoomNumber();
                    break;
                case 10:
                    allocateRoom();
                    break;
                case 11:
                    checkOutGuest();
                    break;
                case 12:
                    viewStatistics();
                    break;
                case 13:
                    sortRooms();
                    break;
                case 0:
                    System.out.println("\n========================================");
                    System.out.println("   Thank you for using our system!");
                    System.out.println("========================================");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void addRoom() {
        System.out.print("ENTER ROOM NUMBER: ");
        int roomNo = scanner.nextInt();
        scanner.nextLine();

        // Check if room number already exists
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNo) {
                System.out.println("Room number already exists!");
                return;
            }
        }

        System.out.print("ENTER ROOM TYPE (Single/Double/Triple): ");
        String type = scanner.nextLine();

        System.out.print("ENTER ROOM PRICE: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("ENTER AVAILABILITY (Available/Occupied): ");
        String availability = scanner.nextLine();

        rooms.add(new Room(roomNo, type, price, availability));
        System.out.println("Room added successfully!");
    }

    private static void viewRooms() {
        if (rooms.isEmpty()) {
            System.out.println("\nNo rooms available.");
            return;
        }

        System.out.println("\n========================================");
        System.out.println("            CURRENT ROOMS");
        System.out.println("========================================");
        System.out.println(String.format("| %-7s | %-11s | %-9s | %-10s | %-12s | %-15s |", 
            "ROOM ID", "ROOM NUMBER", "ROOM TYPE", "PRICE", "AVAILABILITY", "GUEST NAME"));
        System.out.println("|---------|-------------|-----------|------------|--------------|-----------------|");

        for (Room room : rooms) {
            String guest = room.getGuestName().isEmpty() ? "-" : room.getGuestName();
            System.out.printf("| %-7d | %-11d | %-9s | %-10.2f | %-12s | %-15s |\n",
                    room.getRoomId(), room.getRoomNumber(), room.getRoomType(),
                    room.getPrice(), room.getAvailability(), guest);
        }
        System.out.println("========================================");
    }

    private static void updateAvailability() {
        System.out.print("ENTER ROOM NUMBER TO UPDATE: ");
        int roomNo = scanner.nextInt();
        scanner.nextLine();

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNo) {
                System.out.print("ENTER NEW AVAILABILITY (Available/Occupied): ");
                String availability = scanner.nextLine();
                room.setAvailability(availability);
                System.out.println("Room availability updated successfully!");
                return;
            }
        }
        System.out.println("Room not found!");
    }

    private static void deleteRoom() {
        System.out.print("ENTER ROOM NUMBER TO DELETE: ");
        int roomNo = scanner.nextInt();
        scanner.nextLine();

        Iterator<Room> iterator = rooms.iterator();
        while (iterator.hasNext()) {
            Room room = iterator.next();
            if (room.getRoomNumber() == roomNo) {
                iterator.remove();
                System.out.println("Room deleted successfully!");
                return;
            }
        }
        System.out.println("Room not found!");
    }

    private static void searchByType() {
        System.out.print("ENTER ROOM TYPE TO SEARCH (Single/Double/Triple): ");
        String type = scanner.nextLine();

        System.out.println("\n========================================");
        System.out.println("       ROOMS OF TYPE: " + type);
        System.out.println("========================================");
        System.out.println(String.format("| %-7s | %-11s | %-9s | %-10s | %-12s |", 
            "ROOM ID", "ROOM NUMBER", "ROOM TYPE", "PRICE", "AVAILABILITY"));
        System.out.println("|---------|-------------|-----------|------------|--------------|");

        boolean found = false;
        for (Room room : rooms) {
            if (room.getRoomType().equalsIgnoreCase(type)) {
                found = true;
                System.out.printf("| %-7d | %-11d | %-9s | %-10.2f | %-12s |\n",
                        room.getRoomId(), room.getRoomNumber(), room.getRoomType(),
                        room.getPrice(), room.getAvailability());
            }
        }

        if (!found) {
            System.out.println("No rooms found for the given type.");
        }
        System.out.println("========================================");
    }

    private static void updateRoomDetails() {
        System.out.print("ENTER ROOM NUMBER TO UPDATE: ");
        int roomNo = scanner.nextInt();
        scanner.nextLine();

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNo) {
                System.out.println("\nWhat would you like to update?");
                System.out.println("1. Room Type");
                System.out.println("2. Room Price");
                System.out.println("3. Both");
                System.out.print("Choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1 || choice == 3) {
                    System.out.print("ENTER NEW ROOM TYPE (Single/Double/Triple): ");
                    String type = scanner.nextLine();
                    room.setRoomType(type);
                }

                if (choice == 2 || choice == 3) {
                    System.out.print("ENTER NEW PRICE: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    room.setPrice(price);
                }

                System.out.println("Room details updated successfully!");
                return;
            }
        }
        System.out.println("Room not found!");
    }

    private static void searchByAvailability() {
        System.out.print("ENTER AVAILABILITY STATUS (Available/Occupied): ");
        String status = scanner.nextLine();

        System.out.println("\n========================================");
        System.out.println("       " + status.toUpperCase() + " ROOMS");
        System.out.println("========================================");
        System.out.println(String.format("| %-7s | %-11s | %-9s | %-10s | %-15s |", 
            "ROOM ID", "ROOM NUMBER", "ROOM TYPE", "PRICE", "GUEST NAME"));
        System.out.println("|---------|-------------|-----------|------------|-----------------|");

        boolean found = false;
        for (Room room : rooms) {
            if (room.getAvailability().equalsIgnoreCase(status)) {
                found = true;
                String guest = room.getGuestName().isEmpty() ? "-" : room.getGuestName();
                System.out.printf("| %-7d | %-11d | %-9s | %-10.2f | %-15s |\n",
                        room.getRoomId(), room.getRoomNumber(), room.getRoomType(),
                        room.getPrice(), guest);
            }
        }

        if (!found) {
            System.out.println("No " + status + " rooms found.");
        }
        System.out.println("========================================");
    }

    private static void searchByPriceRange() {
        System.out.print("ENTER MINIMUM PRICE: ");
        double minPrice = scanner.nextDouble();
        System.out.print("ENTER MAXIMUM PRICE: ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("\n========================================");
        System.out.println("   ROOMS IN PRICE RANGE: " + minPrice + " - " + maxPrice);
        System.out.println("========================================");
        System.out.println(String.format("| %-7s | %-11s | %-9s | %-10s | %-12s |", 
            "ROOM ID", "ROOM NUMBER", "ROOM TYPE", "PRICE", "AVAILABILITY"));
        System.out.println("|---------|-------------|-----------|------------|--------------|");

        boolean found = false;
        for (Room room : rooms) {
            if (room.getPrice() >= minPrice && room.getPrice() <= maxPrice) {
                found = true;
                System.out.printf("| %-7d | %-11d | %-9s | %-10.2f | %-12s |\n",
                        room.getRoomId(), room.getRoomNumber(), room.getRoomType(),
                        room.getPrice(), room.getAvailability());
            }
        }

        if (!found) {
            System.out.println("No rooms found in the given price range.");
        }
        System.out.println("========================================");
    }

    private static void searchByRoomNumber() {
        System.out.print("ENTER ROOM NUMBER: ");
        int roomNo = scanner.nextInt();
        scanner.nextLine();

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNo) {
                System.out.println("\n========================================");
                System.out.println("          ROOM DETAILS");
                System.out.println("========================================");
                System.out.println("Room ID         : " + room.getRoomId());
                System.out.println("Room Number     : " + room.getRoomNumber());
                System.out.println("Room Type       : " + room.getRoomType());
                System.out.println("Price           : ₹" + room.getPrice());
                System.out.println("Availability    : " + room.getAvailability());
                System.out.println("Guest Name      : " + (room.getGuestName().isEmpty() ? "-" : room.getGuestName()));
                System.out.println("========================================");
                return;
            }
        }
        System.out.println("Room not found!");
    }

    private static void allocateRoom() {
        System.out.print("ENTER ROOM NUMBER TO ALLOCATE: ");
        int roomNo = scanner.nextInt();
        scanner.nextLine();

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNo) {
                if (room.getAvailability().equalsIgnoreCase("Occupied")) {
                    System.out.println("Room is already occupied!");
                    return;
                }

                System.out.print("ENTER GUEST NAME: ");
                String guestName = scanner.nextLine();

                room.setGuestName(guestName);
                room.setAvailability("Occupied");
                System.out.println("Room allocated successfully to " + guestName + "!");
                return;
            }
        }
        System.out.println("Room not found!");
    }

    private static void checkOutGuest() {
        System.out.print("ENTER ROOM NUMBER FOR CHECK-OUT: ");
        int roomNo = scanner.nextInt();
        scanner.nextLine();

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNo) {
                if (room.getAvailability().equalsIgnoreCase("Available")) {
                    System.out.println("Room is already available!");
                    return;
                }

                String guestName = room.getGuestName();
                room.setGuestName("");
                room.setAvailability("Available");
                System.out.println("Guest " + guestName + " checked out successfully!");
                System.out.println("Room " + roomNo + " is now available.");
                return;
            }
        }
        System.out.println("Room not found!");
    }

    private static void viewStatistics() {
        if (rooms.isEmpty()) {
            System.out.println("\nNo rooms available for statistics.");
            return;
        }

        int totalRooms = rooms.size();
        int occupiedRooms = 0;
        int availableRooms = 0;
        double totalRevenue = 0;
        double totalPrice = 0;

        int singleRooms = 0, doubleRooms = 0, tripleRooms = 0;

        for (Room room : rooms) {
            totalPrice += room.getPrice();
            if (room.getAvailability().equalsIgnoreCase("Occupied")) {
                occupiedRooms++;
                totalRevenue += room.getPrice();
            } else {
                availableRooms++;
            }

            String type = room.getRoomType().toLowerCase();
            if (type.contains("single")) singleRooms++;
            else if (type.contains("double")) doubleRooms++;
            else if (type.contains("triple")) tripleRooms++;
        }

        double occupancyRate = (totalRooms > 0) ? ((double) occupiedRooms / totalRooms) * 100 : 0;
        double avgPrice = (totalRooms > 0) ? totalPrice / totalRooms : 0;

        System.out.println("\n========================================");
        System.out.println("       HOSTEL ROOM STATISTICS");
        System.out.println("========================================");
        System.out.println("Total Rooms          : " + totalRooms);
        System.out.println("Occupied Rooms       : " + occupiedRooms);
        System.out.println("Available Rooms      : " + availableRooms);
        System.out.println("Occupancy Rate       : " + String.format("%.2f", occupancyRate) + "%");
        System.out.println("----------------------------------------");
        System.out.println("Room Distribution:");
        System.out.println("  Single Rooms       : " + singleRooms);
        System.out.println("  Double Rooms       : " + doubleRooms);
        System.out.println("  Triple Rooms       : " + tripleRooms);
        System.out.println("----------------------------------------");
        System.out.println("Average Room Price   : ₹" + String.format("%.2f", avgPrice));
        System.out.println("Current Revenue      : ₹" + String.format("%.2f", totalRevenue));
        System.out.println("Potential Revenue    : ₹" + String.format("%.2f", totalPrice));
        System.out.println("========================================");
    }

    private static void sortRooms() {
        if (rooms.isEmpty()) {
            System.out.println("\nNo rooms available to sort.");
            return;
        }

        System.out.println("\nSort Options:");
        System.out.println("1. Sort by Room Number (Ascending)");
        System.out.println("2. Sort by Room Number (Descending)");
        System.out.println("3. Sort by Price (Low to High)");
        System.out.println("4. Sort by Price (High to Low)");
        System.out.println("5. Sort by Room Type");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                rooms.sort(Comparator.comparingInt(Room::getRoomNumber));
                System.out.println("Rooms sorted by room number (ascending).");
                break;
            case 2:
                rooms.sort(Comparator.comparingInt(Room::getRoomNumber).reversed());
                System.out.println("Rooms sorted by room number (descending).");
                break;
            case 3:
                rooms.sort(Comparator.comparingDouble(Room::getPrice));
                System.out.println("Rooms sorted by price (low to high).");
                break;
            case 4:
                rooms.sort(Comparator.comparingDouble(Room::getPrice).reversed());
                System.out.println("Rooms sorted by price (high to low).");
                break;
            case 5:
                rooms.sort(Comparator.comparing(Room::getRoomType));
                System.out.println("Rooms sorted by room type.");
                break;
            default:
                System.out.println("Invalid option!");
                return;
        }
        viewRooms();
    }
}
