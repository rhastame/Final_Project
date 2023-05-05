package Final_Project;

import Final_Project.AdditionalService;
import Final_Project.BookingRoom;
import Final_Project.Database;
import Final_Project.HomeFrame;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.awt.Color.red;
import static java.awt.Color.white;

public class PaymentFrame extends JFrame implements ActionListener {
    private String[] method = new String[]{
            "BCA", "Mandiri", "Syariah"
    };
    int index;
    Database database;
    JButton submitBtn;
    ButtonGroup group;
    PaymentFrame(int indexx, Database databasee){
        ImageIcon logoup = new ImageIcon("src/Final_Project/assets/logo1.png");
        this.setIconImage(logoup.getImage());
        index = indexx;
        database = databasee;

        ArrayList<BookingRoom> room = database.Customers.get(index).getRooms();
        ArrayList<AdditionalService> add = database.Customers.get(index).getAdditonal();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0,0,800,600);
        mainPanel.setBackground(new Color(0x5B3C31));

        //Header
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("src/Final_Project/assets/logoPayment.png"));
        logo.setBounds(360,-10,800,150);
        JLabel Header = new JLabel("Transaction Details");
        Header.setFont(new Font("Poppins Light", Font.PLAIN, 24));
        Header.setForeground(white);
        Header.setBounds(313, 120, 800, 20);
        mainPanel.add(logo);
        mainPanel.add(Header);

        //transaction
        Font p = new Font("Poppins Light", Font.PLAIN, 13);
        JPanel transaction = new JPanel();
        transaction.setLayout(null);
        transaction.setBounds(50,160, 700, 300);
        transaction.setBackground(new Color(0x8A5747));
        JLabel hotelName = new JLabel("Galvanize Hotel");
        hotelName.setFont(new Font("Poppins Light", Font.PLAIN, 20));
        hotelName.setForeground(white);
        hotelName.setBounds(295,10,700,20);

        JLabel hotelAddress = new JLabel("Jalan Raya Ubud 6, Bali, Indonesia");
        hotelAddress.setFont(new Font("Poppins Light", Font.PLAIN, 11));
        hotelAddress.setForeground(white);
        hotelAddress.setBounds(277,30,700,13);

        JLabel CheckIn = new JLabel("Check In       :");
        CheckIn.setBounds(10, 73, 700,13);
        CheckIn.setFont(p);
        CheckIn.setForeground(white);

        String checkindate = room.get(room.size()-1).getCheckIn();
        JLabel checkin = new JLabel(checkindate);
        checkin.setBounds(90, 76, 200, 10);
        checkin.setFont(p);
        checkin.setForeground(white);

        JLabel CheckOut = new JLabel("Check Out    :");
        CheckOut.setBounds(9, 86, 700, 13);
        CheckOut.setFont(p);
        CheckOut.setForeground(white);

        String checkoutdate = room.get(room.size()-1).getCheckOut();
        JLabel checkout = new JLabel(checkoutdate);
        checkout.setBounds(90, 88, 200, 10);
        checkout.setFont(p);
        checkout.setForeground(white);

        JLabel typeCheck = new JLabel("Type             :");
        typeCheck.setBounds(12, 99, 100, 13);
        typeCheck.setFont(p);
        typeCheck.setForeground(white);

        String typeroom = room.get(room.size()-1).getType();
        JLabel typee = new JLabel(typeroom);
        typee.setBounds(90, 99, 200, 10);
        typee.setFont(p);
        typee.setForeground(white);

        int subtotalprice = 0;

        int roomprice = 0;
        int quantityroom = room.get(room.size()-1).getQuantity();
        if(typeroom.equals("Deluxe Room")){
            roomprice = 1000000;
        }else if(typeroom.equals("Deluxe Ocean Room")){
            roomprice = 1500000;
        }else if(typeroom.equals("Deluxe Lagoon Room")){
            roomprice = 2000000;
        }
        JLabel type = new JLabel("Rp. "+roomprice+" x "+quantityroom);
        type.setBounds(550, 99, 200, 15);
        type.setFont(p);
        type.setForeground(white);
        subtotalprice+=(roomprice*quantityroom);

        JLabel Date = new JLabel("Date              :");
        Date.setBounds(9, 125, 200, 13);
        Date.setFont(p);
        Date.setForeground(white);

        String dateadd = add.get(add.size()-1).getDate();
        JLabel date = new JLabel(dateadd);
        date.setBounds(90, 125, 200, 10);
        date.setFont(p);
        date.setForeground(white);

        JLabel Time = new JLabel("Time             :");
        Time.setBounds(12, 138, 500, 13);
        Time.setFont(p);
        Time.setForeground(white);

        String timeadd = add.get(add.size()-1).getHours();
        JLabel time = new JLabel(timeadd);
        time.setBounds(90, 135, 200, 20);
        time.setFont(p);
        time.setForeground(white);

        JLabel typeDate = new JLabel("Type              :");
        typeDate.setBounds(9, 151, 700, 13);
        typeDate.setFont(p);
        typeDate.setForeground(white);

        String typeAdd = add.get(add.size()-1).getType();
        JLabel typeadd = new JLabel(typeAdd);
        typeadd.setBounds(90, 150, 200, 15);
        typeadd.setFont(p);
        typeadd.setForeground(white);

        int height = 163;
        int height2 = 163;

        int priceadd = 0;
        int quantityadd = add.get(add.size()-1).getQuantity();

        if(typeAdd.equals("Spa")){
            priceadd = 150000;
            JLabel price = new JLabel("Rp. "+priceadd+" x "+quantityadd);
            price.setBounds(550, 150, 200, 15);
            price.setFont(p);
            price.setForeground(white);
            transaction.add(price);
            subtotalprice+=priceadd;
        }else if(typeAdd.equals("Lounge")){
            priceadd = 175000;
            JLabel price = new JLabel("Rp. "+priceadd+" x "+quantityadd);
            price.setBounds(550, 150, 200, 15);
            price.setFont(p);
            price.setForeground(white);
            transaction.add(price);
            subtotalprice+=priceadd;
        }else if(typeAdd.equals("Restaurant")){
            Map<String, JLabel> labelMap = new HashMap<>();
            Map<String, JLabel> labelMap2 = new HashMap<>();

            for (int i = 0; i < add.get(add.size()-1).menu.size(); i++) {
                System.out.println("hahaha");
                String foods = "typeFood"+i;
                String foodName = add.get(add.size()-1).menu.get(i).getName();
//                labelMap = new HashMap<>();
                JLabel label = new JLabel(foodName);
                labelMap.put(foods, label);
//                labelMap.get(foods).setBounds(30, height, 500, 15);
//                labelMap.get(foods).setFont(p);
//                labelMap.get(foods).setForeground(white);

                String prices = new String("price"+i);
                Integer pricee = add.get(add.size()-1).menu.get(i).getPrice();
                int quantityadd2 = add.get(add.size()-1).menu.get(i).getQuantity();
                String priceee = new String("Rp. "+pricee+" x "+quantityadd2);

                subtotalprice += (pricee*quantityadd2);

//                labelMap2 = new HashMap<>();
                JLabel label2 = new JLabel(String.valueOf(priceee));
                labelMap2.put(prices, label2);
//                labelMap2.get(prices).setBounds(550, height, 200, 15);
//                labelMap2.get(prices).setFont(p);
//                labelMap2.get(prices).setForeground(white);
//                labelMap.get(foods).setText(add.get(add.size()-1).menu.get(i).getName());
            }

            for (JLabel label : labelMap.values()) {
                System.out.println("hihi");
                label.setFont(p);
                label.setForeground(white);
                label.setBounds(30, height, 500, 15);
                transaction.add(label);
                height += 15;
            }

            for(JLabel label2 : labelMap2.values()){
                System.out.println("huhu");
                label2.setFont(p);
                label2.setForeground(white);
                label2.setBounds(550, height2, 200, 15);
                transaction.add(label2);
                height2 += 15;
            }
//            transaction.add(menus);
        }


//        JLabel typeFood1 = new JLabel("Nasgor");
//        typeFood1.setBounds(30, height, 100, 15);
//        typeFood1.setFont(p);
//        typeFood1.setForeground(white);
//        JLabel price1 = new JLabel(100000);
//        price1.setBounds(550, height, 200, 15);
//        price1.setFont(p);
//        price1.setForeground(white);
//        transaction.add(typeFood1);
//        transaction.add(price1);
//
//        height += 15;
//        JLabel typeFood2 = new JLabel("Migor");
//        typeFood2.setBounds(30, height, 100, 15);
//        typeFood2.setFont(p);
//        typeFood2.setForeground(white);
//        JLabel price2 = new JLabel("Rp. 100000 x 2");
//        price2.setBounds(550, height, 200, 15);
//        price2.setFont(p);
//        price2.setForeground(white);
//        transaction.add(typeFood2);
//        transaction.add(price2);

        JLabel subtotal = new JLabel("Subtotal");
        subtotal.setBounds(10, height+20, 200, 13);
        subtotal.setFont(p);
        subtotal.setForeground(white);
        JLabel subtotalQ = new JLabel("Rp. "+subtotalprice);
        subtotalQ.setBounds(550, height+20, 200, 13);
        subtotalQ.setFont(p);
        subtotalQ.setForeground(white);
        JLabel tax = new JLabel("Tax (10%)");
        tax.setBounds(10, height+33, 200, 13);
        tax.setFont(p);
        tax.setForeground(white);
        JLabel taxQ = new JLabel("Rp. "+subtotalprice*0.01);
        taxQ.setBounds(550, height+33, 200, 13);
        taxQ.setFont(p);
        taxQ.setForeground(white);
        JLabel total = new JLabel("Total");
        total.setBounds(10, height+47, 200, 13);
        total.setFont(new Font("Poppins Light", Font.BOLD, 15));
        total.setForeground(white);
        int totall = (int) (subtotalprice + (subtotalprice*0.01));
        JLabel totalQ = new JLabel("Rp. "+totall);
        totalQ.setBounds(550,height+47,200,15);
        totalQ.setFont(new Font("Poppins Light", Font.BOLD, 15));
        totalQ.setForeground(white);

        transaction.add(hotelName);
        transaction.add(hotelAddress);
        transaction.add(CheckIn);
        transaction.add(CheckOut);
        transaction.add(typeCheck);
        transaction.add(type);
        transaction.add(checkin);
        transaction.add(checkout);
        transaction.add(Date);
        transaction.add(Time);
        transaction.add(typeDate);
        transaction.add(typee);
        transaction.add(date);
        transaction.add(time);
        transaction.add(typeadd);

        transaction.add(subtotal);
        transaction.add(subtotalQ);
        transaction.add(tax);
        transaction.add(taxQ);
        transaction.add(total);
        transaction.add(totalQ);

        mainPanel.add(transaction);

        JPanel payPanel = new JPanel(null);
        payPanel.setBounds(0, 480, 800, 20);
        payPanel.setBackground(new Color(0x5B3C31));
        group = new ButtonGroup();
        payPanel.setLayout(new GridBagLayout());
        Font pop = new Font("Poppins Light", Font.PLAIN, 10);
        JLabel text = new JLabel("Payment : ");
        text.setForeground(white);
        text.setFont(pop);
        payPanel.add(text);
        for (int i = 0 ; i < 3 ; i++){
            JRadioButton radio = new JRadioButton(method[i]);
            radio.setBackground(new Color(0x5B3C31));
            radio.setForeground(white);
            radio.setFocusable(false);
            radio.setFont(pop);
            group.add(radio);
            payPanel.add(radio);
        }

        mainPanel.add(payPanel);


        //submit button
        submitBtn = new JButton("Book");
        submitBtn.setBounds(360,510, 80,30);
        submitBtn.setFocusable(false);
        submitBtn.setBackground(white);
        submitBtn.setFont(new Font("Poppins", Font.PLAIN, 14));
        submitBtn.addActionListener(this);
        mainPanel.add(submitBtn);


        add(mainPanel);
        setLayout(null);
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(this.getMinimumSize());
        setLocationRelativeTo(null);
        setVisible(true);
    }

//    public static void main(String[] args) {
//        new Payment();
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submitBtn){
            ButtonModel selectedMethod = group.getSelection();
            if (selectedMethod == null) {
                getToolkit().beep();
                JOptionPane.showMessageDialog(this,"Please choose the payment method","Uncompleted form!",JOptionPane.ERROR_MESSAGE);
            } else {
                new HomeFrame(index, database);
            }
        }
    }
}
