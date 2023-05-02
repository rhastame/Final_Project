package Final_Project;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Login{
    Database database;

//    LogInFrame logInFrame = new LogInFrame(database.Customers);
//    Customer current = new Customer();
    ArrayList<Customer> temp;

    Login(Database database){
        this.database = database;
//        temp = customers;
//    }

//    public void login(){
        new LogInFrame(database);

//        checkLogged();
//        return current;
    }

//    public void checkLogged(){
//        for (int i = 0; i < database.getCustomers().size(); i++) {
//            if(database.getCustomers().get(i).getLogged()==1){
//                current = database.getCustomers().get(i);
//                return;
//            }
//        }
//    }
}
