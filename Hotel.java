import java.time.LocalDate;
import java.time.LocalDateTime;


class Hotel {
    private String country;
    private String hotelName;
    private int beds;
    private double pricePerDay;
    private boolean isBooked;
    private LocalDate startBookingDate;
    private LocalDate endBookingDate;
    private LocalDateTime checkInTime;

    // figure out how to input csv file into constructor

    //region Constructors
    public Hotel(String country, String hotelName, int beds, double pricePerDay,
                 boolean isBooked, LocalDate startBookingDate, LocalDate endBookingDate,
                 LocalDateTime checkInTime) {
        this.country = country;
        this.hotelName = hotelName;
        this.beds = beds;
        this.pricePerDay = pricePerDay;
        this.isBooked = isBooked;
        this.startBookingDate = startBookingDate;
        this.endBookingDate = endBookingDate;
        this.checkInTime = checkInTime;
    }

    public Hotel() {
        this.country = "";
        this.hotelName = "";
        this.beds = 0;
        this.pricePerDay = 0.0;
        this.isBooked = false;
        this.startBookingDate = LocalDate.now();
        this.endBookingDate = LocalDate.now().plusDays(7);
        this.checkInTime = LocalDateTime.now();
    }
    //endregion

    //region Getters and Setters
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public LocalDate getStartBookingDate() {
        return startBookingDate;
    }

    public void setStartBookingDate(LocalDate startBookingDate) {
        this.startBookingDate = startBookingDate;
    }

    public LocalDate getEndBookingDate() {
        return endBookingDate;
    }

    public void setEndBookingDate(LocalDate endBookingDate) {
        this.endBookingDate = endBookingDate;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }
//endregion

    public String toString() {
        return "Hotel{" +
                "country='" + country + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", beds=" + beds +
                ", pricePerDay=" + pricePerDay +
                ", isBooked=" + isBooked +
                ", startBookingDate=" + startBookingDate +
                ", endBookingDate=" + endBookingDate +
                ", checkInTime=" + checkInTime +
                '}';
    }

    //region Methods
    public int calculateDaysBooked() {
        return (int) this.endBookingDate.toEpochDay() - (int) this.startBookingDate.toEpochDay(); // toEpochDay() was aied
    }

    public double calculateTotalPrice() {
        return this.calculateDaysBooked() * this.pricePerDay;
    }

    //endregion
}
