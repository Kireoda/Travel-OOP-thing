package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelRoomTest {

    @Test
    void testCompareTo() {
        // Room1 cheaper than Room2
        HotelRoom cheapRoom = new HotelRoom("HotelA", "101", "Single", 2, 100, false,
                LocalDate.now(), LocalDate.now(), 3);
        HotelRoom expensiveRoom = new HotelRoom("HotelB", "102", "Double", 2, 150, false,
                LocalDate.now(), LocalDate.now(), 4);

        List<HotelRoom> rooms = new ArrayList<>();
        rooms.add(expensiveRoom);
        rooms.add(cheapRoom);

        Collections.sort(rooms);

        assertEquals("HotelA", rooms.get(0).getHotelName());
        assertEquals("HotelB", rooms.get(1).getHotelName());
    }

    @Test
    void bookRoom() {
    }

    @Test
    void cancelRoomBooking() {
    }

    @Test
    void isRoomAvailable() {
    }

    @Test
    void calculateTotalPrice() {
    }

    @Test
    void updatePrice() {
    }

    @Test
    void updateRating() {
    }

    @Test
    void performMaintenance() {
    }

    @Test
    void needMaintenance() {
    }

    @Test
    void sortPrice() {
    }

    @Test
    void sortRating() {
    }

    @Test
    void sortAvailability() {
    }

    @Test
    void testToString() {
    }
}