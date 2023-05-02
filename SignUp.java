package Final_Project;

public class SignUp{
    Database database;
    SignUp(Database databasee){
        database=databasee;
        SignUpFrame signUpFrame = new SignUpFrame(database);
    }
}
