public abstract class DataConstants {
  // Users constants
  protected static final String USER_FILE_NAME = "../json/Users.json";
  protected static final String USER_ID = "UUID";
  protected static final String USER_USERNAME = "username";
  protected static final String USER_PASSWORD = "password";
  protected static final String USER_EMAIL = "email";
  protected static final String USER_FIRST_NAME = "firstName";
  protected static final String USER_LAST_NAME = "lastName";
  protected static final String USER_AGE = "age";
  protected static final String USER_ADDRESS = "address";
  protected static final String USER_FREQFLYER = "frequentFlyer";
  protected static final String USER_PASSPORTS = "passports";
  protected static final String USER_BOOKED_SEATS = "bookedSeats";
  protected static final String USER_BOOKED_ROOMS = "bookedRooms";
  protected static final String USER_PREFERENCES = "preferences";

  //Preferences Constants
  protected static final String PREF_FILE_NAME = "../json/UserPreferences.josn";
  protected static final String PREF_ID = "UUID";
  protected static final String PREF_MED_ACCOM = "medicalAccommodation";
  protected static final String PREF_ORIGIN_CODE = "originAirportCode";
  protected static final String PREF_SEAT_TYPE = "seatType";
  protected static final String PREF_BAGGAGE = "numberBaggage";
  protected static final String PREF_AIRLINE = "airline";
  protected static final String PREF_FLIGHT_TYPE = "flightType";

  // Hotels constants
  protected static final String HOTEL_FILE_NAME = "../json/Hotels.json";
  protected static final String HOTEL_ID = "UUID";
  protected static final String HOTEL_NAME = "hotelName";
  protected static final String HOTEL_LOCATION = "location";
  protected static final String HOTEL_ROOMS = "rooms";
  protected static final String HOTEL_PRICE = "price";
  protected static final String HOTEL_RATING = "starRating";
  protected static final String HOTEL_POOL = "hasPool";

  // Rooms constants
  protected static final String ROOM_FILE_NAME = "../json/Rooms.json";
  protected static final String ROOM_ID = "UUID";
  protected static final String ROOM_ROOM_NUM = "roomNumber";
  protected static final String ROOM_NUM_BED = "numberOfBeds";
  protected static final String ROOM_SMOKING = "smoking";
  protected static final String ROOM_BOOKED_DATES = "bookedDates";


  // Flights constants
  protected static final String FLIGHT_FILE_NAME = "../json/Flights.json";
  protected static final String FLIGHT_ID = "UUID";
  protected static final String FLIGHT_FLIGHTNAME = "flightName";
  protected static final String FLIGHT_DEPARTURETIME = "departureTime";
  protected static final String FLIGHT_ARRIVALTIME = "arrivalTime";
  protected static final String FLIGHT_DEPARTURE = "placeOfDeparture";
  protected static final String FLIGHT_DESTINATION = "placeOfArrival";
  protected static final String FLIGHT_AIRLINE = "airline";
  protected static final String FLIGHT_FLIGHTTYPE = "type";
  protected static final String FLIGHT_SEATS = "seats";

  // Seats Constant
  protected static final String SEATS_FILE_NAME = "../json/Seats.json";
  protected static final String SEATS_ID = "UUID";
  protected static final String SEATS_ROW_NUM = "rowNum";
  protected static final String SEATS_AISLE_NUM = "aisleNum";
  protected static final String SEATS_AVAIL = "availability";
  protected static final String SEATS_TYPE = "seatType";
}
