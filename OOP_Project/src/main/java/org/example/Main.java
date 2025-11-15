package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        //Load rooms from CSV
        List<HotelRoom> rooms = HotelRoom.loadFromCSV("hotelrooms.csv"); // put in correct file name once created
        System.out.println("Valid entries loaded: " + rooms.size());

        //Show a sample (first 3)
        System.out.println("\nSample (first 3 rooms):");
        for (int i = 0; i < Math.min(3, rooms.size()); i++) {
            System.out.println(rooms.get(i));
        }

        //Sort by natural order (Comparable: price then name)
        Collections.sort(rooms);
        System.out.println("\nSorted by price (natural order):");
        rooms.forEach(System.out::println);

        //Sort by rating (Comparator)
        rooms.sort(new HotelRoom.ByRatingComparator());
        System.out.println("\nSorted by rating (descending):");
        rooms.forEach(System.out::println);

        //Optional: sort by maintenance need
        rooms.sort(new HotelRoom.MaintenanceComparator());
        System.out.println("\nSorted by maintenance need:");
        rooms.forEach(System.out::println);

        //Demonstrate safe removal (Iterator)
        Iterator<HotelRoom> it = rooms.iterator();
        while (it.hasNext()) {
            if (it.next().getPricePerNight() < 50) it.remove(); // remove cheap rooms
        }
        System.out.println("\nAfter removing rooms under €50:");
        rooms.forEach(System.out::println);
    }
}
