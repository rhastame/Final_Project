package Final_Project;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Login{
    Database database;

    ArrayList<Customer> temp;

    Login(Database database){
        this.database = database;

        new LogInFrame(database);
    }

}
