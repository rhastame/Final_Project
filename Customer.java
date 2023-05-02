package Final_Project;

import java.util.ArrayList;

public class Customer {
    String name;
    String password;

    String phone;
    String credit;
    ArrayList<BookingRoom> rooms;
    ArrayList<AdditionalService> additonal;

    public ArrayList<BookingRoom> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<BookingRoom> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<AdditionalService> getAdditonal() {
        return additonal;
    }

    public void setAdditonal(ArrayList<AdditionalService> additonal) {
        this.additonal = additonal;
    }

    int logged;

    public int getLogged() {
        return logged;
    }

    public void setLogged(int logged) {
        this.logged = logged;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getCredit() {
        return credit;
    }
}
