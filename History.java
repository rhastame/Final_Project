package Final_Project;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class History extends JFrame { JLabel labelTitle = new JLabel();
    JLabel subTitle1 = new JLabel();
    JLabel subTitle2 = new JLabel();
    Database database;
    int index;

    History(int indexx, Database database){
        ImageIcon logo = new ImageIcon("./assets/logo1.png");
        this.setIconImage(logo.getImage());
        this.index = indexx;
        this.database = database;
//        temps = customers;
        this.setTitle("History Booking Transaction");

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,800,600);

        ImageIcon background = new ImageIcon("./assets/bgH.jpg");
        Image img = background.getImage();
        Image temp = img.getScaledInstance(800,600,Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0,800,600);
        layeredPane.add(back, Integer.valueOf(0));

        JLabel backBtn = new JLabel();
        ImageIcon backI= new ImageIcon("./assets/back.png");
        backBtn.setIcon(backI);
        backBtn.setBounds(16,16,50,50);
        backBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
                new HomeFrame(index,database);
            }
        });

        add(backBtn);

        Color coklatTua = new Color(181,161,145, 161);
        labelTitle.setText("Your Booking History");
        labelTitle.setFont(new Font("Times New Roman", Font.BOLD,40));
        labelTitle.setBackground(coklatTua);
        labelTitle.setVerticalAlignment(JLabel.TOP);
        labelTitle.setHorizontalAlignment(JLabel.CENTER);
        labelTitle.setBounds(200,25,400,50);
        labelTitle.setOpaque(true);

        subTitle1.setText("Room Hotel");
        subTitle1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        subTitle1.setHorizontalAlignment(JLabel.CENTER);
        subTitle1.setBounds(45,100,700,40);
        subTitle1.setBackground(new Color(0xC2B5A191, true));
        subTitle1.setOpaque(true);

        String[] titleName = {"Check In", "Check Out", "Type", "Quantity Room"};

        ArrayList<BookingRoom> rooms =database.Customers.get(index).getRooms();

        ArrayList<AdditionalService> adds =database.Customers.get(index).getAdditonal();;


        Object[][] data = new Object[rooms.size()][4];
        for(int i=0; i<rooms.size();i++){
            BookingRoom room = rooms.get(i);
            data[i][0] = room.getCheckIn();
            data[i][1] = room.getCheckOut();
            data[i][2] = room.getType();
            data[i][3] = room.getQuantity();
        }

        JTable table1 = new JTable(data, titleName);
        table1.getTableHeader().setBounds(45,140,700,25);
        table1.getTableHeader().setBackground(new Color(0Xb5a191));
        table1.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 18));

        //diadjust disini
        int height1 = 15* rooms.size();

        table1.setBounds(45,165,700,height1);
        table1.setBackground(new Color(0Xe8d1bf));
        table1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        table1.setEnabled(false);

        subTitle2.setText("Additional Service");
        subTitle2.setFont(new Font("Times New Roman", Font.BOLD, 24));
        subTitle2.setHorizontalAlignment(JLabel.CENTER);

        subTitle2.setBounds(45,330,700,40);
        subTitle2.setBackground(new Color(0xC2B5A191, true));
        subTitle2.setForeground(Color.BLACK);
        subTitle2.setOpaque(true);

        String[] titleName2 = {"Date", "Hours", "Type", "Quantity"};
        Object[][] data2 = new Object[adds.size()][4];
        for(int i=0; i<rooms.size();i++){
            AdditionalService add = adds.get(i);
            data2[i][0] = add.getDate();
            data2[i][1] = add.getHours();
            data2[i][2] = add.getType();
            data2[i][3] = add.getQuantity();
        }

        JTable table2 = new JTable(data2, titleName2);
        table2.getTableHeader().setBounds(45,370,700,25);
        table2.getTableHeader().setBackground(new Color(0Xb5a191));
        table2.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 18));
        //diadjust disini
        int height2 = 15* adds.size();
        table2.setBounds(45,395,700,height2);
        table2.setBackground(new Color(0Xe8d1bf));
        table2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        table2.setEnabled(false);

        JLayeredPane content = new JLayeredPane();
        content.setBounds(0,0,800,600);
        content.setLayout(null);

        content.add(labelTitle, Integer.valueOf(1));
        content.add(subTitle1,Integer.valueOf(1));
        content.add(table1.getTableHeader(),Integer.valueOf(1));
        content.add(table1,Integer.valueOf(1));
        content.add(subTitle2,Integer.valueOf(1));
        content.add(table2.getTableHeader(),Integer.valueOf(1));
        content.add(table2,Integer.valueOf(1));

        this.add(content);
        this.add(layeredPane);

        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
