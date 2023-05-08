package Final_Project;

import java.util.ArrayList;

public class Database {
    ArrayList<Customer> Customers = new ArrayList<Customer>();

    public ArrayList<Customer> getCustomers() {
        return Customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        Customers = customers;
    }

    public void addCustomer(ArrayList<Customer> customers, String name, String password){
        customers.add(new Customer());
        customers.get(customers.size()-1).setName(name);
        customers.get(customers.size()-1).setPassword(password);
        customers.get(customers.size()-1).setLogged(0);
        customers.get(customers.size()-1).setRooms(new ArrayList<BookingRoom>());
        customers.get(customers.size()-1).setAdditonal(new ArrayList<AdditionalService>());
    }

}
