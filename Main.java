package Final_Project;

import java.util.ArrayList;

public class Main {
//    Database setDefault(Database database){
//        database.Customers.add(new Customer());
//        database.Customers.get(database.Customers.size()-1).setName("tes");
//        database.Customers.get(database.Customers.size()-1).setPassword("a");
//        return database;
//    }

//    void flow(){
//        Database database = new Database();
//        database = setDefault(database);
//
//        SignUp signup = new SignUp(database);
//        signup.signup();
//    }

    public static void main(String[] args) {
        Database database = new Database();

        database.Customers.add(new Customer());
        database.Customers.get(database.Customers.size()-1).setName("tes");
        database.Customers.get(database.Customers.size()-1).setPassword("tes");
        database.Customers.get(database.Customers.size()-1).setRooms(new ArrayList<BookingRoom>());
        database.Customers.get(database.Customers.size()-1).setAdditonal(new ArrayList<AdditionalService>());

        Login login = new Login(database);
//        login.login();
//        SignUp signup = new SignUp(database);
//        signup.signup();
//
//        Main main = new Main();
//        main.flow();
    }
}
