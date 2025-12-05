import java.sql.*;
import java.util.Scanner;

public class HostelRoomSystem {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        while (true) {
            System.out.println("\nHOSTEL ROOM ALLOCATION SYSTEM");
            System.out.println("1. ADD ROOM");
            System.out.println("2. VIEW ROOMS");
            System.out.println("3. UPDATE AVAILABILITY");
            System.out.println("4. DELETE ROOM");
            System.out.println("5. SEARCH BY TYPE");
            System.out.println("0. EXIT");
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
                    deleteRoom();
                    break;
                case 5:
                    searchByType();
                    break;
                case 0:
                    System.out.println("Exiting system. Thank you!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void addRoom() {
        try (Connection connection = DBConnection.getConnection()) {
            System.out.print("ENTER ROOM NUMBER: ");
            int roomNo = scanner.nextInt();
            scanner.nextLine();

            System.out.print("ENTER ROOM TYPE (Single/Double/Triple): ");
            String type = scanner.nextLine();

            System.out.print("ENTER ROOM PRICE: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("ENTER AVAILABILITY (Available/Occupied): ");
            String availability = scanner.nextLine();

            String sql = "INSERT INTO rooms (room_number, room_type, price, availability) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, roomNo);
                statement.setString(2, type);
                statement.setDouble(3, price);
                statement.setString(4, availability);

                statement.executeUpdate();
                System.out.println("Room added successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewRooms() {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM rooms";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                System.out.println("\nCURRENT ROOMS:");
                System.out.println("| ROOM ID | ROOM NUMBER | ROOM TYPE | PRICE      | AVAILABILITY |");
                System.out.println("|---------|-------------|-----------|------------|--------------|");

                boolean hasData = false;
                while (resultSet.next()) {
                    hasData = true;
                    int roomId = resultSet.getInt("room_id");
                    int roomNumber = resultSet.getInt("room_number");
                    String roomType = resultSet.getString("room_type");
                    double price = resultSet.getDouble("price");
                    String availability = resultSet.getString("availability");

                    System.out.printf("| %-7d | %-11d | %-9s | %-10.2f | %-12s |\n",
                            roomId, roomNumber, roomType, price, availability);
                }
                
                if (!hasData) {
                    System.out.println("No rooms available.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void updateAvailability() {
        try (Connection connection = DBConnection.getConnection()) {
            System.out.print("ENTER ROOM NUMBER TO UPDATE: ");
            int roomNo = scanner.nextInt();
            scanner.nextLine();

            System.out.print("ENTER NEW AVAILABILITY (Available/Occupied): ");
            String availability = scanner.nextLine();

            String sql = "UPDATE rooms SET availability = ? WHERE room_number = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, availability);
                statement.setInt(2, roomNo);

                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Room availability updated successfully!");
                } else {
                    System.out.println("Room not found!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteRoom() {
        try (Connection connection = DBConnection.getConnection()) {
            System.out.print("ENTER ROOM NUMBER TO DELETE: ");
            int roomNo = scanner.nextInt();
            scanner.nextLine();

            String sql = "DELETE FROM rooms WHERE room_number = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, roomNo);

                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Room deleted successfully!");
                } else {
                    System.out.println("Room not found!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void searchByType() {
        try (Connection connection = DBConnection.getConnection()) {
            System.out.print("ENTER ROOM TYPE TO SEARCH (Single/Double/Triple): ");
            String type = scanner.nextLine();

            String sql = "SELECT * FROM rooms WHERE room_type = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, type);
                ResultSet resultSet = statement.executeQuery();

                System.out.println("\nROOMS OF TYPE: " + type);
                System.out.println("| ROOM ID | ROOM NUMBER | ROOM TYPE | PRICE      | AVAILABILITY |");
                System.out.println("|---------|-------------|-----------|------------|--------------|");

                boolean found = false;
                while (resultSet.next()) {
                    found = true;
                    int roomId = resultSet.getInt("room_id");
                    int roomNumber = resultSet.getInt("room_number");
                    String roomType = resultSet.getString("room_type");
                    double price = resultSet.getDouble("price");
                    String availability = resultSet.getString("availability");

                    System.out.printf("| %-7d | %-11d | %-9s | %-10.2f | %-12s |\n",
                            roomId, roomNumber, roomType, price, availability);
                }

                if (!found) {
                    System.out.println("No rooms found for the given type.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
