package Final_Project;


import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookingRoomFrame extends JFrame implements ActionListener {
    JLabel title = new JLabel();

    JPanel panel1 = new JPanel();
    JLabel label1 = new JLabel();
    JTextField textField1 = new JTextField();

    JPanel panel2 = new JPanel();
    JLabel label2 = new JLabel();
    JTextField textField2 = new JTextField();

    JLabel hasilLabelCheckIn = new JLabel();
    JLabel hasilLabelCheckOut = new JLabel();

    JPanel panel3 = new JPanel();
    JLabel label3 = new JLabel();
    JLabel text = new JLabel();

    JLabel image1 = new JLabel();
    JLabel image2 = new JLabel();
    JLabel image3 = new JLabel();

    JSpinner spinnerQuantity;
    SpinnerNumberModel spinnerModel;
    JRadioButton deluxeRoom;
    JRadioButton deluxeOceanRoom;
    JRadioButton deluxeLagoonRoom;
    JLabel choice = new JLabel();

    JButton button = new JButton();

    int index;
    Database database;
    BookingRoomFrame(int indexx, Database databasee){
        ImageIcon logo = new ImageIcon("src/Final_Project/assets/logo1.png");
        this.setIconImage(logo.getImage());

        database = databasee;
        index = indexx;
        title.setText("Room Booking");
        title.setFont(new Font("Times New Roman", Font.BOLD,40));
        title.setVerticalAlignment(JLabel.TOP);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(200,15,400,50);
        title.setBackground(new Color(0,0,0,0));
        title.setOpaque(true);

        panel1.setBounds(30,80,225,90);
//        panel1.setBackground(Color.RED);

        label1.setText("Check In");
        label1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        label1.setBounds(0,0,100,40);
//        label1.setBackground(Color.CYAN);
        label1.setHorizontalAlignment(JLabel.CENTER);

        textField1.setPreferredSize(new Dimension(225,35));
        textField1.setFont(new Font("Times New Roman",Font.PLAIN,18));
//        textField1.setForeground(Color.gray);
//        textField1.setBackground(Color.GRAY);
        textField1.setBackground(new Color(0Xb5a191));
        textField1.setCaretColor(Color.BLACK);
//        textField1.setText("DD/MM/YY");

        hasilLabelCheckIn.setBounds(0,75, 100,10);
        hasilLabelCheckIn.setFont(new Font("Times New Roman", Font.PLAIN, 12));

        panel1.add(label1);
        panel1.add(textField1);
        panel1.add(hasilLabelCheckIn);


        panel2.setBounds(285,80,225,90);
//        panel2.setBackground(Color.BLUE);

        label2.setText("Check Out");
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        label2.setBounds(0,0,100,40);
//        label2.setBackground(Color.CYAN);
        label2.setHorizontalAlignment(JLabel.CENTER);

        textField2.setPreferredSize(new Dimension(225,35));
        textField2.setFont(new Font("Times New Roman",Font.PLAIN,18));
//        textField2.setForeground(Color.gray);
//        textField2.setBackground(Color.GRAY);
        textField2.setBackground(new Color(0Xb5a191));
        textField2.setCaretColor(Color.BLACK);
//        textField2.setText("DD/MM/YY");

        hasilLabelCheckOut.setBounds(0,75, 100,10);
        hasilLabelCheckOut.setFont(new Font("Times New Roman", Font.PLAIN, 12));

        panel2.add(label2);
        panel2.add(textField2);
        panel2.add(hasilLabelCheckOut);

        panel3.setBounds(540,80,225,75);
//        panel3.setBackground(Color.GREEN);

        label3.setText("Quantity");
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        label3.setBounds(0,0,100,40);
//        label3.setBackground(Color.CYAN);
        label3.setHorizontalAlignment(JLabel.CENTER);

        spinnerModel = new SpinnerNumberModel(1,1,10000,1);
        spinnerQuantity = new JSpinner(spinnerModel);

        spinnerQuantity.setPreferredSize(new Dimension(225,35));
        spinnerQuantity.setFont(new Font("Times New Roman",Font.PLAIN,18));
//        spinnerQuantity.setBackground(new Color(0Xb5a191));
        spinnerQuantity.getEditor().getComponent(0).setBackground(new Color(0Xb5a191));
        spinnerQuantity.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent key) {
                char karakter = key.getKeyChar();
                if(!((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE))){
                    getToolkit().beep();
                    key.consume();
//                    JOptionPane.showMessageDialog(null,"16 Numbers Only","", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        panel3.add(label3);
        panel3.add(spinnerQuantity);

        text.setText("Choose Room Type !");
        text.setFont(new Font("Times New Roman", Font.BOLD,22));
        text.setBounds(300,185,200,20);
        text.setBackground(new Color(0,0,0,0));
        text.setOpaque(true);

        ImageIcon icon = new ImageIcon("src/Final_Project/assets/room1.png");
        image1.setIcon(icon);
        image1.setBounds(30,220,225,170);
        ImageIcon icon2 = new ImageIcon("src/Final_Project/assets/room2.png");
        image2.setIcon(icon2);
        image2.setBounds(540,220,225,170);
        ImageIcon icon3 = new ImageIcon("src/Final_Project/assets/room3.png");
        image3.setIcon(icon3);
        image3.setBounds(285,220,225,170);

        JLabel Image1desc1 = new JLabel();
        JLabel Image1desc2 = new JLabel();
        JLabel Image1desc3 = new JLabel();
        JLabel Image1desc4 = new JLabel();

        Image1desc1.setBounds(30, 390, 225, 15);
        Image1desc1.setText("- 65m/699ft");
        Image1desc1.setHorizontalAlignment(JLabel.CENTER);
        Image1desc1.setBackground(new Color(0Xb5a191));
        Image1desc1.setOpaque(true);

        Image1desc2.setBounds(30, 405, 225, 15);
        Image1desc2.setText("- Up to 2 Guest");
        Image1desc2.setHorizontalAlignment(JLabel.CENTER);
        Image1desc2.setBackground(new Color(0Xb5a191));
        Image1desc2.setOpaque(true);

        Image1desc3.setBounds(30, 420, 225, 15);
        Image1desc3.setText("- 1 King Bed");
        Image1desc3.setHorizontalAlignment(JLabel.CENTER);
        Image1desc3.setBackground(new Color(0Xb5a191));
        Image1desc3.setOpaque(true);

        Image1desc4.setBounds(30, 435, 225, 15);
        Image1desc4.setText("- Garden View");
        Image1desc4.setHorizontalAlignment(JLabel.CENTER);
        Image1desc4.setBackground(new Color(0Xb5a191));
        Image1desc4.setOpaque(true);

        JLabel Image2desc1 = new JLabel();
        JLabel Image2desc2 = new JLabel();
        JLabel Image2desc3 = new JLabel();
        JLabel Image2desc4 = new JLabel();

        Image2desc1.setBounds(285, 390, 225, 15);
        Image2desc1.setText("- 65m/699ft");
        Image2desc1.setHorizontalAlignment(JLabel.CENTER);
        Image2desc1.setBackground(new Color(0Xb5a191));
        Image2desc1.setOpaque(true);

        Image2desc2.setBounds(285, 405, 225, 15);
        Image2desc2.setText("- Up to 3 Guest");
        Image2desc2.setHorizontalAlignment(JLabel.CENTER);
        Image2desc2.setBackground(new Color(0Xb5a191));
        Image2desc2.setOpaque(true);

        Image2desc3.setBounds(285, 420, 225, 15);
        Image2desc3.setText("- 1 King Bed / 2 Twin Bed");
        Image2desc3.setHorizontalAlignment(JLabel.CENTER);
        Image2desc3.setBackground(new Color(0Xb5a191));
        Image2desc3.setOpaque(true);

        Image2desc4.setBounds(285, 435, 225, 15);
        Image2desc4.setText("- Garden View");
        Image2desc4.setHorizontalAlignment(JLabel.CENTER);
        Image2desc4.setBackground(new Color(0Xb5a191));
        Image2desc4.setOpaque(true);

        JLabel Image3desc1 = new JLabel();
        JLabel Image3desc2 = new JLabel();
        JLabel Image3desc3 = new JLabel();
        JLabel Image3desc4 = new JLabel();

        Image3desc1.setBounds(540, 390, 225, 15);
        Image3desc1.setText("- 80m/861ft");
        Image3desc1.setHorizontalAlignment(JLabel.CENTER);
        Image3desc1.setBackground(new Color(0Xb5a191));
        Image3desc1.setOpaque(true);

        Image3desc2.setBounds(540, 405, 225, 15);
        Image3desc2.setText("- Up to 3 Guest");
        Image3desc2.setHorizontalAlignment(JLabel.CENTER);
        Image3desc2.setBackground(new Color(0Xb5a191));
        Image3desc2.setOpaque(true);

        Image3desc3.setBounds(540, 420, 225, 15);
        Image3desc3.setText("- 1 King Bed / 2 Twin Bed");
        Image3desc3.setHorizontalAlignment(JLabel.CENTER);
        Image3desc3.setBackground(new Color(0Xb5a191));
        Image3desc3.setOpaque(true);

        Image3desc4.setBounds(540, 435, 225, 15);
        Image3desc4.setText("- Garden View");
        Image3desc4.setHorizontalAlignment(JLabel.CENTER);
        Image3desc4.setBackground(new Color(0Xb5a191));
        Image3desc4.setOpaque(true);

        deluxeRoom = new JRadioButton("Deluxe Room");
        deluxeOceanRoom = new JRadioButton("Deluxe Ocean Room");
        deluxeLagoonRoom = new JRadioButton("Deluxe Lagoon Room");

        ButtonGroup group = new ButtonGroup();
        group.add(deluxeRoom);
        group.add(deluxeOceanRoom);
        group.add(deluxeLagoonRoom);

        deluxeRoom.setBounds(80,450,190,40);
        deluxeRoom.setFont(new Font("Times New Roman", Font.BOLD,15));
        deluxeOceanRoom.setBounds(320,450,190,40);
        deluxeOceanRoom.setFont(new Font("Times New Roman", Font.BOLD,15));
        deluxeLagoonRoom.setBounds(567,450,190,40);
        deluxeLagoonRoom.setFont(new Font("Times New Roman", Font.BOLD,15));

        button.setBounds(350,500,100,40);
        button.setText("Next");
        button.setFocusable(false);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Times New Roman", Font.BOLD, 25));
        button.setBackground(new Color(0Xb5a191));
        button.setBorder(BorderFactory.createEtchedBorder());
        button.addActionListener(this);

        this.add(title);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);

        this.add(text);

        this.add(image1);
        this.add(image2);
        this.add(image3);

        this.add(Image1desc1);
        this.add(Image1desc2);
        this.add(Image1desc3);
        this.add(Image1desc4);

        this.add(Image2desc1);
        this.add(Image2desc2);
        this.add(Image2desc3);
        this.add(Image2desc4);

        this.add(Image3desc1);
        this.add(Image3desc2);
        this.add(Image3desc3);
        this.add(Image3desc4);

        this.add(deluxeRoom);
        this.add(deluxeOceanRoom);
        this.add(deluxeLagoonRoom);

        this.add(button);

        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    String selectedRoom;
    String checkInDate;
    String checkOutDate;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            checkInDate = textField1.getText();
            checkOutDate = textField2.getText();
            if(textField1.getText().isEmpty() || textField2.getText().isEmpty() || spinnerQuantity.getValue()==null || (!deluxeRoom.isSelected() && !deluxeOceanRoom.isSelected() && !deluxeLagoonRoom.isSelected())) {
                getToolkit().beep();
                JOptionPane.showMessageDialog(this, "Please fill all the form", "Complete form!", JOptionPane.ERROR_MESSAGE);
            }else {
                if (!isValidDate(checkInDate) || !isValidTanggalCheckInCheckOut(checkInDate, checkOutDate)) {
                    hasilLabelCheckIn.setText("Format date must be dd/mm/yyyy");
                    hasilLabelCheckIn.setForeground(Color.RED);
                    hasilLabelCheckOut.setText("Format date must be dd/mm/yyyy");
                    hasilLabelCheckOut.setForeground(Color.RED);
                } else {
                    if (deluxeRoom.isSelected()) {
                        selectedRoom = "Deluxe Room";
                    } else if (deluxeOceanRoom.isSelected()) {
                        selectedRoom = "Deluxe Ocean Room";
                    } else if (deluxeLagoonRoom.isSelected()) {
                        selectedRoom = "Deluxe Lagoon Room";
                    }
                    System.out.println(selectedRoom);
                    System.out.println((int) spinnerQuantity.getValue());
                    System.out.println(index);

                    ArrayList<BookingRoom> rooms;
                    if(database.Customers.get(index).rooms.isEmpty()){
                        rooms  = new ArrayList<>();
                    }else{
                        rooms = database.Customers.get(index).getRooms();
                    }
                    rooms.add(new BookingRoom());
                    rooms.get(rooms.size()-1).setCheckIn(textField1.getText());
                    rooms.get(rooms.size()-1).setCheckOut(textField2.getText());
                    rooms.get(rooms.size()-1).setType(selectedRoom);
                    rooms.get(rooms.size()-1).setQuantity((int)spinnerQuantity.getValue());

                    database.Customers.get(index).setRooms(rooms);

//                database.Customers.get(index).rooms.add(new BookingRoom());
//                database.Customers.get(index).rooms.get(database.Customers.get(index).rooms.size() - 1).setType(selectedRoom);
//                database.Customers.get(index).rooms.get(database.Customers.get(index).rooms.size() - 1).setQuantity((int) spinnerQuantity.getValue());

//                    System.out.println(database.Customers.get(index).rooms.get(database.Customers.get(index).rooms.size() - 1).getType());
//                    System.out.println(database.Customers.get(index).rooms.get(database.Customers.get(index).rooms.size() - 1).getQuantity());

                    new AdditionalServiceFrame(index, database);
                    dispose();
                }
            }
        }
    }

    private boolean isValidDate(String checkInDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false);

        try {
            Date tanggal = formatter.parse(checkInDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean isValidTanggalCheckInCheckOut(String checkInDate, String checkOutDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false);

        try {
            Date checkIn = formatter.parse(checkInDate);
            Date checkOut = formatter.parse(checkOutDate);

            if (checkOut.before(checkIn)) {
                return false;
            }

            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}

