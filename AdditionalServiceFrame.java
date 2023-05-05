package Final_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AdditionalServiceFrame extends JFrame implements MouseListener, ActionListener {
    JLabel title = new JLabel();

    JPanel panel1 = new JPanel();
    JLabel label1 = new JLabel();
    JLabel hasilLabelTanggal = new JLabel();
    JTextField textField1 = new JTextField();

    JPanel panel2 = new JPanel();
    JLabel label2 = new JLabel();
    JComboBox comboBox;

    JPanel panel3 = new JPanel();
    JLabel label3 = new JLabel();
    JSpinner spinnerQuantity;
    SpinnerNumberModel spinnerModel;
    JLabel text = new JLabel();

    JLabel image1 = new JLabel();
    JLabel image2 = new JLabel();
    JLabel image3 = new JLabel();

    JRadioButton spa;
    JRadioButton lounge;
    JRadioButton restaurant;
    JLabel choice = new JLabel();

    JButton button = new JButton();
    Database database;
    int index;

    AdditionalServiceFrame(int indexx, Database databasee){
        ImageIcon logo = new ImageIcon("src/Final_Project/assets/logo1.png");
        this.setIconImage(logo.getImage());

        index = indexx;
        database = databasee;
        title.setText("Additional Service Booking");
        title.setFont(new Font("Times New Roman", Font.BOLD,40));
        title.setVerticalAlignment(JLabel.TOP);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(150,15,500,50);
        title.setBackground(new Color(0,0,0,0));
        title.setOpaque(true);

        panel1.setBounds(30,80,225,90);

        label1.setText("Date");
        label1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        label1.setBounds(0,0,100,40);
        label1.setHorizontalAlignment(JLabel.CENTER);

        textField1.setPreferredSize(new Dimension(225,35));
        textField1.setFont(new Font("Times New Roman",Font.PLAIN,18));
        textField1.setBackground(new Color(0Xb5a191));
        textField1.setCaretColor(Color.BLACK);

        hasilLabelTanggal.setBounds(0,75, 100,10);
        hasilLabelTanggal.setFont(new Font("Times New Roman", Font.PLAIN, 12));

        panel1.add(label1);
        panel1.add(textField1);
        panel1.add(hasilLabelTanggal);

        panel2.setBounds(285,80,225,75);

        label2.setText("Hours");
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        label2.setBounds(0,0,100,40);
        label2.setHorizontalAlignment(JLabel.CENTER);

        String hours[] = {"07:00AM", "08:00AM", "09:00AM", "10:00AM", "11:00AM", "12:00PM", "01:00PM", "02:00PM", "03:00PM", "04:00PM", "05:00PM", "06:00PM", "07:00PM", "08:00PM", "09:00PM", "10:00PM"};

        comboBox = new JComboBox(hours);
        comboBox.setPreferredSize(new Dimension(225,35));
        comboBox.getEditor().getEditorComponent().setBackground(new Color(0Xb5a191));
        comboBox.setBackground(new Color(0Xb5a191));

        panel2.add(label2);
        panel2.add(comboBox);

        panel3.setBounds(540,80,225,75);

        label3.setText("Quantity");
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        label3.setBounds(0,0,100,40);
        label3.setHorizontalAlignment(JLabel.CENTER);
        spinnerModel = new SpinnerNumberModel(1,1,10000,1);
        spinnerQuantity = new JSpinner(spinnerModel);
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

        spinnerQuantity.setPreferredSize(new Dimension(225,35));
        spinnerQuantity.setFont(new Font("Times New Roman",Font.PLAIN,18));
        spinnerQuantity.getEditor().getComponent(0).setBackground(new Color(0Xb5a191));

        panel3.add(label3);
        panel3.add(spinnerQuantity);

        text.setText("Choose Additional Service!");
        text.setFont(new Font("Times New Roman", Font.BOLD,22));
        text.setBounds(260,180,280,30);
        text.setBackground(new Color(0,0,0,0));
        text.setOpaque(true);

        ImageIcon icon = new ImageIcon("src/Final_Project/assets/spaImage.png");
        image1.setIcon(icon);
        image1.setBounds(30,220,225,170);
        ImageIcon icon2 = new ImageIcon("src/Final_Project/assets/lounge.png");
        image2.setIcon(icon2);
        image2.setBounds(285,220,225,170);
        ImageIcon icon3 = new ImageIcon("src/Final_Project/assets/restaurantImage.png");
        image3.setIcon(icon3);
        image3.setBounds(540,220,225,170);

        JLabel Image1desc1 = new JLabel();
        JLabel Image1desc2 = new JLabel();
        JLabel Image1desc3 = new JLabel();
        JLabel Image1desc4 = new JLabel();

        Image1desc1.setBounds(30, 390, 225, 15);
        Image1desc1.setText("- Relax, Recharge & Reconnect");
        Image1desc1.setHorizontalAlignment(JLabel.CENTER);
        Image1desc1.setBackground(new Color(0Xb5a191));
        Image1desc1.setOpaque(true);

        Image1desc2.setBounds(30, 405, 225, 15);
        Image1desc2.setText("- Soak & Sip");
        Image1desc2.setHorizontalAlignment(JLabel.CENTER);
        Image1desc2.setBackground(new Color(0Xb5a191));
        Image1desc2.setOpaque(true);

        Image1desc3.setBounds(30, 420, 225, 15);
        Image1desc3.setText("- Massage");
        Image1desc3.setHorizontalAlignment(JLabel.CENTER);
        Image1desc3.setBackground(new Color(0Xb5a191));
        Image1desc3.setOpaque(true);

        Image1desc4.setBounds(30, 435, 225, 15);
        Image1desc4.setText("- Beauty Facial");
        Image1desc4.setHorizontalAlignment(JLabel.CENTER);
        Image1desc4.setBackground(new Color(0Xb5a191));
        Image1desc4.setOpaque(true);

        JLabel Image2desc1 = new JLabel();
        JLabel Image2desc2 = new JLabel();
        JLabel Image2desc3 = new JLabel();
        JLabel Image2desc4 = new JLabel();

        Image2desc1.setBounds(285, 390, 225, 15);
        Image2desc1.setText("- Offers privacy for suite guests");
        Image2desc1.setHorizontalAlignment(JLabel.CENTER);
        Image2desc1.setBackground(new Color(0Xb5a191));
        Image2desc1.setOpaque(true);

        Image2desc2.setBounds(285, 405, 225, 15);
        Image2desc2.setText("- Complimentary culinary offerings");
        Image2desc2.setHorizontalAlignment(JLabel.CENTER);
        Image2desc2.setBackground(new Color(0Xb5a191));
        Image2desc2.setOpaque(true);

        Image2desc3.setBounds(285, 420, 225, 15);
        Image2desc3.setText("- High–speed wifi connection");
        Image2desc3.setHorizontalAlignment(JLabel.CENTER);
        Image2desc3.setBackground(new Color(0Xb5a191));
        Image2desc3.setOpaque(true);

        Image2desc4.setBounds(285, 435, 225, 15);
        Image2desc4.setText("- Access to the cliff and hydro jet pool");
        Image2desc4.setHorizontalAlignment(JLabel.CENTER);
        Image2desc4.setBackground(new Color(0Xb5a191));
        Image2desc4.setOpaque(true);

        JLabel Image3desc1 = new JLabel();
        JLabel Image3desc2 = new JLabel();
        JLabel Image3desc3 = new JLabel();
        JLabel Image3desc4 = new JLabel();

        Image3desc1.setBounds(540, 390, 225, 15);
        Image3desc1.setText("- Casual dining style");
        Image3desc1.setHorizontalAlignment(JLabel.CENTER);
        Image3desc1.setBackground(new Color(0Xb5a191));
        Image3desc1.setOpaque(true);

        Image3desc2.setBounds(540, 405, 225, 15);
        Image3desc2.setText("- International Cuisine");
        Image3desc2.setHorizontalAlignment(JLabel.CENTER);
        Image3desc2.setBackground(new Color(0Xb5a191));
        Image3desc2.setOpaque(true);

        Image3desc3.setBounds(540, 420, 225, 15);
        Image3desc3.setText("- Casual Dress Code");
        Image3desc3.setHorizontalAlignment(JLabel.CENTER);
        Image3desc3.setBackground(new Color(0Xb5a191));
        Image3desc3.setOpaque(true);

        Image3desc4.setBounds(540, 435, 225, 15);
        Image3desc4.setText("- Features live cooking stations");
        Image3desc4.setHorizontalAlignment(JLabel.CENTER);
        Image3desc4.setBackground(new Color(0Xb5a191));
        Image3desc4.setOpaque(true);

        spa= new JRadioButton("Spa");
        lounge = new JRadioButton("Lounge");
        restaurant = new JRadioButton("Restaurant");

        ButtonGroup group = new ButtonGroup();
        group.add(spa);
        group.add(lounge);
        group.add(restaurant);

        spa.setBounds(115,450,190,40);
        spa.setFont(new Font("Times New Roman", Font.BOLD,15));
        lounge.setBounds(360,450,190,40);
        lounge.setFont(new Font("Times New Roman", Font.BOLD,15));
        restaurant.setBounds(600,450,190,40);
        restaurant.setFont(new Font("Times New Roman", Font.BOLD,15));

//        restaurant.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                dispose();
//                MenuFrame food = new MenuFrame(index, database);
//            }
//        });

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

//        this.add(spinner);

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

        this.add(spa);
        this.add(lounge);
        this.add(restaurant);

        this.add(button);

        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    String selectedRoom;
    String inputDate;
    int count;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            inputDate = textField1.getText();
            if(textField1.getText().isEmpty() || comboBox.getItemCount()==0 || spinnerQuantity.getValue()==null || (!restaurant.isSelected() && !spa.isSelected() && !lounge.isSelected())){
                getToolkit().beep();
                JOptionPane.showMessageDialog(this,"Please fill all the form","Uncompleted form!",JOptionPane.ERROR_MESSAGE);
            }else {
            if (!isValidTanggal(inputDate)) {
                hasilLabelTanggal.setText("Format date must be dd/mm/yyyy");
                hasilLabelTanggal.setForeground(Color.RED);
            } else {
                ArrayList<AdditionalService> adds;
                if(database.Customers.get(index).additonal.isEmpty()){
                    adds  = new ArrayList<>();
                }else{
                    adds = database.Customers.get(index).getAdditonal();
                }
                adds.add(new AdditionalService());
                adds.get(adds.size()-1).setDate(textField1.getText());
                adds.get(adds.size()-1).setHours(comboBox.getSelectedItem().toString());
                adds.get(adds.size()-1).setQuantity((int)spinnerQuantity.getValue());

                if (spa.isSelected()) {
                    selectedRoom = "Spa";
                    adds.get(adds.size()-1).setType(selectedRoom);
                    database.Customers.get(index).setAdditonal(adds);
                    new PaymentFrame(index, database);
                    dispose();
                } else if (lounge.isSelected()) {
                    selectedRoom = "Lounge";
                    adds.get(adds.size()-1).setType(selectedRoom);
                    database.Customers.get(index).setAdditonal(adds);
                    new PaymentFrame(index, database);
                    dispose();
                } else if (restaurant.isSelected()) {
                    selectedRoom = "Restaurant";
                    adds.get(adds.size()-1).setType(selectedRoom);
//                    database.Customers.get(index).setAdditonal(adds);
                    MenuFrame food = new MenuFrame(index, database, adds);
                    dispose();
                }

//                database.Customers.get(index).rooms.add(new BookingRoom());
//                database.Customers.get(index).rooms.get(database.Customers.get(index).rooms.size() - 1).setType(selectedRoom);
//                database.Customers.get(index).rooms.get(database.Customers.get(index).rooms.size() - 1).setQuantity((int) spinnerQuantity.getValue());

            }
            }
        }
    }


    private boolean isValidTanggal(String inputDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false);

        try {
            Date tanggal = formatter.parse(inputDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
