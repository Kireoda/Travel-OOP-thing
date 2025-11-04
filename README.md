# Travel-OOP-thing

We decided to base our project on a Hotel rating system. It lets users record their trips with details like location,
date, rating. Trips could be sorted by date or rating and searched by country.

String - Country
String - Hotel name
Int - beds
Double - hotel price per day
Boolean - booked or not
LocalDate - Start Booking date
LocalDate - End Booking date
LocalDateTime - Check In time

teachers notes
- reservation hotel
- refactor csv file into arrival, departure and how many total beds in the hotels

Start with a menu of countries.
The user selects a country.
Display a list of sorting options for hotels (e.g., sort by rating, price, or favourites).
The user chooses a hotel from the sorted list.
Show a menu with each hotel’s details: Number of beds, Price per day, Whether it’s already booked or not
The user selects a hotel.
The user enters a start date and end date.
The program calculates the total cost based on the number of days and the daily rate.
Display whether the hotel is booked and the total cost.
Ask the user to confirm the booking (“Are you sure you want to book?”).
Once confirmed, display a summary of all booking details.

Stage 1 - What to Deliver (40%)
Entity Definition	≥7 typed fields; encapsulated; validation with clear messages.	6%
CSV Loading	Load exactly 10 rows; print valid-count and a sample listing.	5%
Data Structure Choice	Use ArrayList or LinkedList with justification; show iteration and safe removal.	3%
Ordering & Searching	Implement Comparable (natural order) and one Comparator; show search/sort.	4%
DRY & Defensive Coding	Early exits, helper methods for repeated logic; no duplication hotspots.	3%
Reporting & Output	Brief, readable console output or formatted listing.	3%

Marking: Process & Quality (16%)
Repository Quality	Regular, meaningful commits; branches/tags; balanced contributions.	4%
Unit Testing & Coverage (baseline)	Driver/JUnit for ordering/search; ≥35% coverage; include evidence.	4%
Reporting & Documentation	Concise README/report: design rationale, defensive examples, contribution matrix, reflection.	8%
Reporting guidance (prose, not including code/figures)

Solution Domain	120–250
Design Justification	200–350
Defensive Coding 1 (4–6 examples)	220–400 total
Reflection	100–150 - 1 each
Commit Contributions	50–120
