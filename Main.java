package Final_Project;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Database database = new Database();
        //ini data dummy

        database.Customers.add(new Customer());
        database.Customers.get(database.Customers.size()-1).setName("tes");
        database.Customers.get(database.Customers.size()-1).setPassword("tes");
        database.Customers.get(database.Customers.size()-1).setRooms(new ArrayList<BookingRoom>());
        database.Customers.get(database.Customers.size()-1).setAdditonal(new ArrayList<AdditionalService>());

        Login login = new Login(database);
    }
}
