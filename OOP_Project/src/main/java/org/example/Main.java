package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Load rooms from CSV
        List<HotelRoom> rooms = loadFromCSV("data/hotelRooms.csv");

        // Show number of valid rooms and a sample
        System.out.println("Loaded " + rooms.size() + " valid rooms");
        rooms.stream().limit(3).forEach(System.out::println);

        //sorting by price (natural order)
        rooms.sort(null);
        System.out.println("\nRooms sorted by price:");
        rooms.stream().limit(3).forEach(System.out::println);

        //sorting by rating
        rooms.sort(new HotelRoom.ByRatingComparator());
        System.out.println("\nRooms sorted by rating:");
        rooms.stream().limit(3).forEach(System.out::println);

        //sorting by maintenance need
        rooms.sort(new HotelRoom.MaintenanceComparator());
        System.out.println("\nRooms sorted by maintenance need:");
        rooms.stream().limit(3).forEach(System.out::println);

    }
    // CSV loader
    public static List<HotelRoom> loadFromCSV(String filename) {
        List<HotelRoom> rooms = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(filename))) {
            int row = 0;

            while (sc.hasNextLine()) {
                row++;
                String line = sc.nextLine();
                String[] cols = line.split(",");

                if (cols.length < 9) {
                    System.out.println("Skipping row " + row + ": not enough columns");
                } else {
                    try {
                        HotelRoom hr = new HotelRoom(
                                cols[0],
                                cols[1],
                                cols[2],
                                Integer.parseInt(cols[3]),
                                Double.parseDouble(cols[4]),
                                Boolean.parseBoolean(cols[5]),
                                LocalDate.parse(cols[6]),
                                LocalDate.parse(cols[7]),
                                Integer.parseInt(cols[8])
                        );
                        rooms.add(hr);
                    } catch (Exception e) {
                        System.out.println("Invalid row " + row + ": " + e.getMessage());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("CSV file not found: " + filename);
        }

        return rooms;
    }
}
