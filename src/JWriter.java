import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.UUID;

/**
 * JWriter Class Writes to the JSON Files
 */
public class JWriter extends DataConstants {

  /**
   * Saves Users to the JSON files
   */
  public static void saveUsers() {
    Users users = Users.getInstance();
    ArrayList<User> userList = users.getUsers();
    JSONArray jsonUsers = new JSONArray();

    for (int i = 0; i < userList.size(); i++) {
      jsonUsers.add(getUserJSON(userList.get(i)));
    }

    try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
      file.write(jsonUsers.toJSONString());
      file.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets a User From the JSON Files
   * 
   * @param user The user that will be accessed
   * @return the details of the user from the JSON
   */
  public static JSONObject getUserJSON(User user) {
    JSONObject userDetails = new JSONObject();
    userDetails.put(USER_ID, user.getId().toString());
    userDetails.put(USER_USERNAME, user.getUserName());
    userDetails.put(USER_PASSWORD, user.getPassword());
    userDetails.put(USER_EMAIL, user.getEmail());
    userDetails.put(USER_FIRST_NAME, user.getFirstName());
    userDetails.put(USER_LAST_NAME, user.getLastName());
    userDetails.put(USER_AGE, user.getAge());
    userDetails.put(USER_ADDRESS, user.getAddress());
    userDetails.put(USER_FREQFLYER, user.getFreqFlyerStatus());
    userDetails.put(USER_BOOKED_SEATS, saveUserSeats(user));
    userDetails.put(USER_BOOKED_ROOMS, saveUserRooms(user));

    return userDetails;
  }

  /**
   * Saves the designated seats for the listed user
   * 
   * @param user The user that the seats will be saved for
   * @return the seats that the user has booked
   */
  public static JSONArray saveUserSeats(User user) {
    JSONArray bookedSeats = new JSONArray();
    ArrayList<UUID> seatUUIDs = user.getBookedSeatIDs();
    if (seatUUIDs != null) {
      for (int i = 0; i < seatUUIDs.size(); i++) {
        UUID id = seatUUIDs.get(i);
        bookedSeats.add(id.toString());
      }
    }
    return bookedSeats;
  }

  /**
   * Saves the designated rooms for the listed user
   * 
   * @param user the user the rooms will be saved for
   * @return the rooms the user has booked
   */
  public static JSONArray saveUserRooms(User user) {
    JSONArray bookedRooms = new JSONArray();
    ArrayList<UUID> roomUUIDs = user.getBookedSeatIDs();
    if (roomUUIDs != null) {
      for (int i = 0; i < roomUUIDs.size(); i++) {
        UUID id = roomUUIDs.get(i);
        bookedRooms.add(id.toString());
      }
    }
    return bookedRooms;
  }

  /**
   * Saves the users preferences to the JSON
   */
  public static void savePreferences() {
    Preferences preferences = Preferences.getInstance();
    JSONArray jsonUserPreferences = new JSONArray();
    jsonUserPreferences.add(getPreferenceJSON(preferences));

    try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
      file.write(jsonUserPreferences.toJSONString());
      file.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Accesses preferences from the JSON
   * 
   * @param preference the preference that will be aquired
   * @return the preferences of the user
   */
  public static JSONObject getPreferenceJSON(Preferences preference) {
    // Preferences preference = new Preferences();
    JSONObject userPreferences = new JSONObject();
    userPreferences.put(PREF_ID, preference.getId().toString());
    userPreferences.put(PREF_MED_ACCOM, preference.getMedicalAccomodation());
    userPreferences.put(PREF_ORIGIN_CODE, preference.getAirportOrigin());
    userPreferences.put(PREF_SEAT_TYPE, preference.getSeatType());
    userPreferences.put(PREF_BAGGAGE, preference.getNumBaggage());
    userPreferences.put(PREF_AIRLINE, preference.getAirline());
    userPreferences.put(PREF_FLIGHT_TYPE, preference.getFlightType());

    return userPreferences;

  }

  /**
   * Saves the current flight to the JSON
   */
  public static void saveFlights() {
    Flights flight = Flights.getInstance();
    ArrayList<Flight> flightList = flight.getFlights();
    JSONArray jsonFlights = new JSONArray();

    for (int i = 0; i < flightList.size(); i++) {
      jsonFlights.add(getFlightJSON(flightList.get(i)));
    }
    try (FileWriter file = new FileWriter(FLIGHT_FILE_NAME)) {
      file.write(jsonFlights.toJSONString());
      file.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets desired flight from JSON Files
   * 
   * @param flight the flight to be accessed
   * @return the details of the flight that is aquired from the JSON
   */
  public static JSONObject getFlightJSON(Flight flight) {
    JSONObject flightDetails = new JSONObject();
    flightDetails.put(FLIGHT_ID, flight.getUUID().toString());
    flightDetails.put(FLIGHT_FLIGHTNAME, flight.getFlightName().toString());
    flightDetails.put(FLIGHT_DEPARTURETIME, flight.getDepartureTime());
    flightDetails.put(FLIGHT_ARRIVALTIME, flight.getArrivalTime());
    flightDetails.put(FLIGHT_DEPARTURE, flight.getDeparture());
    flightDetails.put(FLIGHT_DESTINATION, flight.getDestination());
    flightDetails.put(FLIGHT_AIRLINE, flight.getAirline());
    flightDetails.put(FLIGHT_FLIGHTTYPE, flight.getFlightType());
    flightDetails.put(FLIGHT_SEATS, saveFlightSeats(flight));

    return flightDetails;
  }
  
  public static JSONArray saveFlightSeats(Flight flight) {
    JSONArray flightSeats = new JSONArray();
    ArrayList<UUID> seatUUIDs = new ArrayList<UUID>();
    for (Seat seat : flight.getSeats()) {
      seatUUIDs.add(seat.getUUID());
    }
    if (seatUUIDs != null) {
      for (int i = 0; i < seatUUIDs.size(); i++) {
        UUID id = seatUUIDs.get(i);
        flightSeats.add(id.toString());
      }
    }
    return flightSeats;
  }

  public static void saveHotels() {
    Hotels hotels = Hotels.getInstance();
    ArrayList<Hotel> hotelList = hotels.getHotels();
    JSONArray jsonHotels = new JSONArray();

    for (int i = 0; i < hotelList.size(); i++) {
      jsonHotels.add(getHotelJSON(hotelList.get(i)));
    }

    try (FileWriter file = new FileWriter(HOTEL_FILE_NAME)) {
      file.write(jsonHotels.toJSONString());
      file.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static JSONObject getHotelJSON(Hotel hotel) {
    JSONObject hotelDetails = new JSONObject();
    hotelDetails.put(HOTEL_ID, hotel.getUUID().toString());
    hotelDetails.put(HOTEL_NAME, hotel.getHotelName());
    hotelDetails.put(HOTEL_LOCATION, hotel.getLocation());
    hotelDetails.put(HOTEL_PRICE, hotel.getPrice());
    hotelDetails.put(HOTEL_RATING, hotel.getStarRating());
    hotelDetails.put(HOTEL_POOL, hotel.getHasPool());
    hotelDetails.put(HOTEL_ROOMS, saveHotelRooms(hotel));

    return hotelDetails;
  }

  public static JSONArray saveHotelRooms(Hotel hotel) {
    JSONArray hotelRooms = new JSONArray();
    ArrayList<UUID> roomUUIDs = new ArrayList<UUID>();
    for (Room room : hotel.getRooms()) {
      roomUUIDs.add(room.getUUID());
    }
    if (roomUUIDs != null) {
      for (int i = 0; i < roomUUIDs.size(); i++) {
        UUID id = roomUUIDs.get(i);
        hotelRooms.add(id.toString());
      }
    }
    return hotelRooms;
  }
}
