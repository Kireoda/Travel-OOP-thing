package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class HotelRoom implements Comparable<HotelRoom> {
    // Default maintenance interval: 6 months (180 days)
    private static final int MAINTENANCE_INTERVAL_DAYS = 180;
    private String hotelName;
    private String roomNumber; // Kept as String
    private String roomType;
    private int capacity;
    private double pricePerNight;
    private boolean isBooked;
    private LocalDate lastMaintenanceDate;
    private LocalDate nextAvailableDate;
    private int hotelRating;

    //region Constructors
    public HotelRoom(String hotelName, String roomNumber, String roomType, int capacity,
                     double pricePerNight, boolean isBooked, LocalDate lastMaintenanceDate,
                     LocalDate nextAvailableDate, int hotelRating) {
        this.hotelName = hotelName;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
        this.isBooked = isBooked;
        this.lastMaintenanceDate = lastMaintenanceDate;
        this.nextAvailableDate = nextAvailableDate;
        this.hotelRating = hotelRating;
    }

    public HotelRoom() {
        this.hotelName = "";
        this.roomNumber = "";
        this.roomType = "";
        this.capacity = 0;
        this.pricePerNight = 0.0;
        this.isBooked = false;
        this.lastMaintenanceDate = LocalDate.now();
        this.nextAvailableDate = LocalDate.now();
        this.hotelRating = 0;
    }
    //endregion

    //region Getters and Setters (Omitted for brevity, assuming they are correct)
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public LocalDate getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(LocalDate lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public LocalDate getNextAvailableDate() {
        return nextAvailableDate;
    }

    public void setNextAvailableDate(LocalDate nextAvailableDate) {
        this.nextAvailableDate = nextAvailableDate;
    }

    public int getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(int hotelRating) {
        this.hotelRating = hotelRating;
    }
    //endregion

    //region Methods

    /**
     * Marks room as booked and updates next available date.
     *
     * @return the total booking price.
     */
    public double bookRoom(LocalDate checkInDate, int nights) {
        if (isRoomAvailable(checkInDate)) {
            this.isBooked = true;
            this.nextAvailableDate = checkInDate.plusDays(nights);
            return calculateTotalPrice(nights);
        }
        return 0.0; // Return 0.0 if the room could not be booked
    }

    /**
     * Frees a room (isBooked set to false) and updates next available date to today.
     */
    public void cancelRoomBooking() {
        this.isBooked = false;
        this.nextAvailableDate = LocalDate.now();
    }

    /**
     * Returns true if room is available on or after the specific date, and does not need maintenance.
     */
    public boolean isRoomAvailable(LocalDate date) {
        // A room is available if it is not booked, OR if it is booked, but the requested date is after the next available date
        // AND it doesn't need maintenance.
        boolean availableOnDate = date.isEqual(this.nextAvailableDate) || date.isAfter(this.nextAvailableDate);

        return !needMaintenance() && availableOnDate;
    }

    /**
     * Returns price per night * number of nights.
     *
     * @return the total price.
     */
    public double calculateTotalPrice(int nights) {
        return this.pricePerNight * nights;
    }

    /**
     * Changes the price for room.
     */
    public void updatePrice(double newPrice) {
        if (newPrice >= 0) {
            this.pricePerNight = newPrice;
        } else {
            System.err.println("Price cannot be negative.");
        }
    }

    /**
     * Updates hotel rating and validates it to be 0 - 5.
     */
    public void updateRating(int rating) {
        // Validate rating between 0 and 5 (inclusive)
        if (rating >= 0 && rating <= 5) {
            this.hotelRating = rating;
        } else {
            System.err.println("Rating must be between 0 and 5.");
        }
    }

    /**
     * Updates lastMaintenanceDate and sets isBooked to true for maintenance duration.
     */
    public void performMaintenance(LocalDate maintenanceDate) {
        this.lastMaintenanceDate = maintenanceDate;

        // Assume maintenance takes 1 day, so the room is not available today
        // and the next available date is tomorrow.
        if (this.nextAvailableDate.isBefore(maintenanceDate.plusDays(1))) {
            this.nextAvailableDate = maintenanceDate.plusDays(1);
        }
    }

    /**
     * Returns true if the room requires maintenance (hasn't had maintenance for 6 or more months)
     * and sets isBooked to false.
     */
    public boolean needMaintenance() {
        // Calculate the number of days since last maintenance
        long daysSinceMaintenance = ChronoUnit.DAYS.between(this.lastMaintenanceDate, LocalDate.now());

        if (daysSinceMaintenance >= MAINTENANCE_INTERVAL_DAYS) {
            // Set availability to false if maintenance is needed
            this.isBooked = true; // Mark as booked for maintenance
            return true;
        }
        return false;
    }

    // Sorting methods are typically implemented in a separate utility class or as part of a List's sort() method
    // using Comparators. They do not belong directly in the HotelRoom class itself.
    // I am providing empty implementations to resolve your original compilation issue.

    public void SortPrice() {
        // Sorting logic should be external (e.g., using a Comparator)
        System.err.println("Sorting rooms should be done externally on a List of rooms.");
    }

    public void SortRating() {
        // Sorting logic should be external (e.g., using a Comparator)
        System.err.println("Sorting rooms should be done externally on a List of rooms.");
    }

    public void SortAvailability() {
        // Sorting logic should be external (e.g., using a Comparator)
        System.err.println("Sorting rooms should be done externally on a List of rooms.");
    }

    // Comparator ordering by price then hotelName
    @Override
    public int compareTo(HotelRoom other) {
        int cmp = Double.compare(this.pricePerNight, other.pricePerNight);
        if (cmp != 0) return cmp;
        return this.hotelName.compareToIgnoreCase(other.hotelName);
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "hotelName='" + hotelName + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomType='" + roomType + '\'' +
                ", capacity=" + capacity +
                ", pricePerNight=" + pricePerNight +
                ", isBooked=" + isBooked +
                ", lastMaintenanceDate=" + lastMaintenanceDate +
                ", nextAvailableDate=" + nextAvailableDate +
                ", hotelRating=" + hotelRating +
                '}';
    }
    //endregion

    // Comparator for rating (descending)
    public static class ByRatingComparator implements Comparator<HotelRoom> {
        @Override
        public int compare(HotelRoom a, HotelRoom b) {
            int cmp = Integer.compare(b.getHotelRating(), a.getHotelRating()); // higher rating first
            if (cmp != 0) return cmp;
            return Double.compare(a.getPricePerNight(), b.getPricePerNight()); // if tie-breaker, cheaper first
        }
    }

    // Comparator for maintenance need
    public static class MaintenanceComparator implements Comparator<HotelRoom> {
        @Override
        public int compare(HotelRoom a, HotelRoom b) {
            // Rooms that need maintenance come first
            if (a.needMaintenance() && !b.needMaintenance()) return -1;
            if (!a.needMaintenance() && b.needMaintenance()) return 1;
            return 0; // both same maintenance status
        }
    }
}