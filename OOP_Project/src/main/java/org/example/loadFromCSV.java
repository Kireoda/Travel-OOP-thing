public static List<HotelRoom> loadFromCSV(String filename) {

    List<HotelRoom> list = new ArrayList<>();

    try (Scanner sc = new Scanner(new File(filename))) {
        int row = 0;
        while (sc.hasNextLine()) {
            row++;
            String line = sc.nextLine();
            String[] cols = line.split(",");

            if (cols.length >= 9) {
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
                    list.add(hr);
                } catch (Exception e) {
                    System.out.println("Invalid row " + row + ": " + e.getMessage());
                }
            } else {
                System.out.println("Skipping row " + row + ": not enough columns");
            }
        }


    } catch (FileNotFoundException e) {
        System.err.println("CSV file not found: " + filename);
    }
    return list;
}