package Final_Project;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MenuFrame extends JFrame implements ActionListener {
    JLabel restoTitle = new JLabel();

    JLabel subTitle = new JLabel();
    JLabel contentTitle = new JLabel();
    JLabel contentTitle2 = new JLabel();
    JLabel contentTitle3 = new JLabel();

    JLabel menu1 = new JLabel();
    JLabel menu2 = new JLabel();
    JLabel menu3 = new JLabel();
    JLabel menu4 = new JLabel();
    JLabel menu5 = new JLabel();
    JLabel menu6 = new JLabel();
    JLabel menu7 = new JLabel();
    JLabel menu8 = new JLabel();
    JLabel menu9 = new JLabel();

    JLabel price1 = new JLabel();
    JLabel price2 = new JLabel();
    JLabel price3 = new JLabel();
    JLabel price4 = new JLabel();
    JLabel price5 = new JLabel();
    JLabel price6 = new JLabel();
    JLabel price7 = new JLabel();
    JLabel price8 = new JLabel();
    JLabel price9 = new JLabel();

    JTextField textField1 = new JTextField();
    JTextField textField2 = new JTextField();
    JTextField textField3 = new JTextField();
    JTextField textField4 = new JTextField();
    JTextField textField5 = new JTextField();
    JTextField textField6 = new JTextField();
    JTextField textField7 = new JTextField();
    JTextField textField8 = new JTextField();
    JTextField textField9 = new JTextField();

    JLabel image1 = new JLabel();
    JLabel image2 = new JLabel();
    JLabel image3 = new JLabel();

    JButton button = new JButton();
    Database database;
    int index;
    ArrayList<AdditionalService> adds;

    MenuFrame(int indexx, Database databasee, ArrayList<AdditionalService> addss){
        ImageIcon logo = new ImageIcon("./assets/logo1.png");
        this.setIconImage(logo.getImage());
        database = databasee;
        index = indexx;
        adds = addss;
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,800,600);

        ImageIcon background = new ImageIcon("./assets/bgMenu.jpg");
        Image img = background.getImage();
        Image temp = img.getScaledInstance(800,600,Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0,800,600);
        layeredPane.add(back, Integer.valueOf(0));

        restoTitle.setText("Tasty Treats Restaurant");
        restoTitle.setFont(new Font("Times New Roman", Font.BOLD,32));
        restoTitle.setBackground(new Color(0Xb5a191));
        restoTitle.setVerticalAlignment(JLabel.TOP);
        restoTitle.setHorizontalAlignment(JLabel.CENTER);
        restoTitle.setBounds(200,25,400,40);
        restoTitle.setOpaque(true);

        subTitle.setText("Food");
        subTitle.setFont(new Font("Times New Roman", Font.BOLD,25));
        subTitle.setBounds(50,80,200,20);

        contentTitle.setText("Breakfast Menu");
        contentTitle.setFont(new Font("Times New Roman", Font.BOLD,20));
        contentTitle.setBounds(50,115,200,20);

        menu1.setText("Poached Egg Benedict");
        menu1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        menu1.setBounds(50,135,200,35);

        price1.setText("Rp. 60.000,00");
        price1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        price1.setBounds(290, 135, 150, 30);

        textField1.setPreferredSize(new Dimension(200,30));
        textField1.setFont(new Font("Times New Roman",Font.PLAIN,18));
        textField1.setBackground(new Color(0Xb5a191));
        textField1.setBounds(430, 135,60,30);

        menu2.setText("Egg Hash Brown");
        menu2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        menu2.setBounds(50,170,200,35);
        menu2.setBackground(Color.GREEN);

        price2.setText("Rp. 55.000,00");
        price2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        price2.setBounds(290, 170, 150, 30);

        textField2.setPreferredSize(new Dimension(200,30));
        textField2.setFont(new Font("Times New Roman",Font.PLAIN,18));
        textField2.setBackground(new Color(0Xb5a191));
        textField2.setBounds(430, 170,60,30);

        menu3.setText("Ham and Cheese Bake");
        menu3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        menu3.setBounds(50,205,200,35);
        menu3.setBackground(Color.GREEN);

        price3.setText("Rp. 70.000,00");
        price3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        price3.setBounds(290, 205, 150, 30);

        textField3.setPreferredSize(new Dimension(200,30));
        textField3.setFont(new Font("Times New Roman",Font.PLAIN,18));
        textField3.setBackground(new Color(0Xb5a191));
        textField3.setBounds(430, 205,60,30);

        contentTitle2.setText("Lunch / Dinner Menu");
        contentTitle2.setFont(new Font("Times New Roman", Font.BOLD,20));
        contentTitle2.setBounds(50,250,200,20);

        menu4.setText("Salmon Mac and Cheese");
        menu4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        menu4.setBounds(50,270,240,35);
        menu4.setBackground(Color.GREEN);

        price4.setText("Rp. 85.000,00");
        price4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        price4.setBounds(290, 270, 150, 30);

        textField4.setPreferredSize(new Dimension(200,30));
        textField4.setFont(new Font("Times New Roman",Font.PLAIN,18));
        textField4.setBackground(new Color(0Xb5a191));
        textField4.setBounds(430, 270,60,30);

        menu5.setText("Cheeseburger Meat Loaf");
        menu5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        menu5.setBounds(50,305,240,35);
        menu5.setBackground(Color.GREEN);

        price5.setText("Rp. 100.000,00");
        price5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        price5.setBounds(290, 305, 150, 30);

        textField5.setPreferredSize(new Dimension(200,30));
        textField5.setFont(new Font("Times New Roman",Font.PLAIN,18));
        textField5.setBackground(new Color(0Xb5a191));
        textField5.setBounds(430, 305,60,30);

        menu6.setText("Penne all' Amatriciana");
        menu6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        menu6.setBounds(50,340,240,35);
        menu6.setBackground(Color.GREEN);

        price6.setText("Rp. 95.000,00");
        price6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        price6.setBounds(290, 340, 150, 30);

        textField6.setPreferredSize(new Dimension(200,30));
        textField6.setFont(new Font("Times New Roman",Font.PLAIN,18));
        textField6.setBackground(new Color(0Xb5a191));
        textField6.setBounds(430, 340,60,30);

        menu7.setText("Steak and Eggs");
        menu7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        menu7.setBounds(50,375,240,35);
        menu7.setBackground(Color.GREEN);

        price7.setText("Rp. 130.000,00");
        price7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        price7.setBounds(290, 375, 150, 30);

        textField7.setPreferredSize(new Dimension(200,30));
        textField7.setFont(new Font("Times New Roman",Font.PLAIN,18));
        textField7.setBackground(new Color(0Xb5a191));
        textField7.setBounds(430, 375,60,30);

        contentTitle3.setText("Snack Bites");
        contentTitle3.setFont(new Font("Times New Roman", Font.BOLD,20));
        contentTitle3.setBounds(50,420,200,20);

        menu8.setText("Salt Pepper Chicken Bites");
        menu8.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        menu8.setBounds(50,440,240,35);
        menu8.setBackground(Color.GREEN);

        price8.setText("Rp. 40.000,00");
        price8.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        price8.setBounds(290, 440, 150, 30);

        textField8.setPreferredSize(new Dimension(200,30));
        textField8.setFont(new Font("Times New Roman",Font.PLAIN,18));
        textField8.setBackground(new Color(0Xb5a191));
        textField8.setBounds(430, 440,60,30);

        menu9.setText("Popcorn Prawn Rolls w/ Mayo");
        menu9.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        menu9.setBounds(50,475,240,35);
        menu9.setBackground(Color.GREEN);

        price9.setText("Rp. 45.000,00");
        price9.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        price9.setBounds(290, 475, 150, 30);

        textField9.setPreferredSize(new Dimension(200,30));
        textField9.setFont(new Font("Times New Roman",Font.PLAIN,18));
        textField9.setBackground(new Color(0Xb5a191));
        textField9.setBounds(430, 475,60,30);

        ImageIcon icon = new ImageIcon("./assets/img1.png");
        image1.setIcon(icon);
        image1.setBounds(540,95,200,125);
        ImageIcon icon2 = new ImageIcon("./assets/img2.png");
        image2.setIcon(icon2);
        image2.setBounds(540,235,200,125);
        ImageIcon icon3 = new ImageIcon("./assets/img3.png");
        image3.setIcon(icon3);
        image3.setBounds(540,380,200,125);

        button.setBounds(350,520,100,30);
        button.setText("Order");
        button.setFocusable(false);
        button.setFont(new Font("Times New Roman", Font.BOLD, 20));
        button.setBackground(new Color(0Xb5a191));
        button.setBorder(BorderFactory.createEtchedBorder());
        button.addActionListener(this);

        JLayeredPane content = new JLayeredPane();
        content.setBounds(0,0,800,600);
        content.setLayout(null);

        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent key) {
                char karakter = key.getKeyChar();
                if(!((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE))){
                    getToolkit().beep();
                    key.consume();
                }
            }
        });
        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent key) {
                char karakter = key.getKeyChar();
                if(!((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE))){
                    getToolkit().beep();
                    key.consume();
                }
            }
        });
        textField3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent key) {
                char karakter = key.getKeyChar();
                if(!((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE))){
                    getToolkit().beep();
                    key.consume();
                }
            }
        });
        textField4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent key) {
                char karakter = key.getKeyChar();
                if(!((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE))){
                    getToolkit().beep();
                    key.consume();
                }
            }
        });
        textField5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent key) {
                char karakter = key.getKeyChar();
                if(!((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE))){
                    getToolkit().beep();
                    key.consume();
                }
            }
        });
        textField6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent key) {
                char karakter = key.getKeyChar();
                if(!((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE))){
                    getToolkit().beep();
                    key.consume();
                }
            }
        });
        textField7.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent key) {
                char karakter = key.getKeyChar();
                if(!((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE))){
                    getToolkit().beep();
                    key.consume();
                }
            }
        });
        textField8.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent key) {
                char karakter = key.getKeyChar();
                if(!((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE))){
                    getToolkit().beep();
                    key.consume();
                }
            }
        });
        textField9.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent key) {
                char karakter = key.getKeyChar();
                if(!((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE))){
                    getToolkit().beep();
                    key.consume();
                }
            }
        });

        content.add(restoTitle, Integer.valueOf(1));
        content.add(subTitle, Integer.valueOf(1));
        content.add(contentTitle, Integer.valueOf(1));
        content.add(menu1, Integer.valueOf(1));
        content.add(price1, Integer.valueOf(1));
        content.add(textField1,Integer.valueOf(1));
        content.add(menu2, Integer.valueOf(1));
        content.add(price2, Integer.valueOf(1));
        content.add(textField2,Integer.valueOf(1));
        content.add(menu3, Integer.valueOf(1));
        content.add(price3, Integer.valueOf(1));
        content.add(textField3,Integer.valueOf(1));
        content.add(contentTitle2, Integer.valueOf(1));
        content.add(menu4, Integer.valueOf(1));
        content.add(price4, Integer.valueOf(1));
        content.add(textField4,Integer.valueOf(1));
        content.add(menu5, Integer.valueOf(1));
        content.add(price5, Integer.valueOf(1));
        content.add(textField5,Integer.valueOf(1));
        content.add(menu6, Integer.valueOf(1));
        content.add(price6, Integer.valueOf(1));
        content.add(textField6,Integer.valueOf(1));
        content.add(menu7, Integer.valueOf(1));
        content.add(price7, Integer.valueOf(1));
        content.add(textField7,Integer.valueOf(1));
        content.add(contentTitle3, Integer.valueOf(1));
        content.add(menu8, Integer.valueOf(1));
        content.add(price8, Integer.valueOf(1));
        content.add(textField8,Integer.valueOf(1));
        content.add(menu9, Integer.valueOf(1));
        content.add(textField9,Integer.valueOf(1));
        content.add(price9, Integer.valueOf(1));
        content.add(image1);
        content.add(image2);
        content.add(image3);
        content.add(button);

        this.add(content);
        this.add(layeredPane);

        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            ArrayList<Menu> menu = new ArrayList<>();
            menu = inputMenu(menu);
            adds.get(adds.size()-1).setMenu(menu);
            database.Customers.get(index).setAdditonal(adds);

            dispose();
            new PaymentFrame(index, database);
        }
    }
    private ArrayList<Menu> inputMenu(ArrayList<Menu> menu){
        if(!textField1.getText().isEmpty()){
            menu.add(new Menu());
            menu.get(menu.size()-1).setName("Poached Egg Benedict");
            menu.get(menu.size()-1).setPrice(60000);
            menu.get(menu.size()-1).setQuantity(Integer.parseInt(textField1.getText()));
        }if(!textField2.getText().isEmpty()){
            menu.add(new Menu());
            menu.get(menu.size()-1).setName("Egg Hash Brown");
            menu.get(menu.size()-1).setPrice(55000);
            menu.get(menu.size()-1).setQuantity(Integer.parseInt(textField2.getText()));
        }if(!textField3.getText().isEmpty()){
            menu.add(new Menu());
            menu.get(menu.size()-1).setName("Ham and Cheese Bake");
            menu.get(menu.size()-1).setPrice(70000);
            menu.get(menu.size()-1).setQuantity(Integer.parseInt(textField3.getText()));
        }if(!textField4.getText().isEmpty()){
            menu.add(new Menu());
            menu.get(menu.size()-1).setName("Salmon Mac and Cheese");
            menu.get(menu.size()-1).setPrice(85000);
            menu.get(menu.size()-1).setQuantity(Integer.parseInt((textField4.getText())));
        }if(!textField5.getText().isEmpty()){
            menu.add(new Menu());
            menu.get(menu.size()-1).setName("Cheeseburger Meat Loaf");
            menu.get(menu.size()-1).setPrice(100000);
            menu.get(menu.size()-1).setQuantity(Integer.parseInt(textField5.getText()));
        }if(!textField6.getText().isEmpty()){
            menu.add(new Menu());
            menu.get(menu.size()-1).setName("Penne all' Amatriciana");
            menu.get(menu.size()-1).setPrice(100000);
            menu.get(menu.size()-1).setQuantity(Integer.parseInt(textField6.getText()));
        }if(!textField7.getText().isEmpty()){
            menu.add(new Menu());
            menu.get(menu.size()-1).setName("Steak and Eggs");
            menu.get(menu.size()-1).setPrice(100000);
            menu.get(menu.size()-1).setQuantity(Integer.parseInt(textField7.getText()));
        }if(!textField8.getText().isEmpty()){
            menu.add(new Menu());
            menu.get(menu.size()-1).setName("Salt Pepper Chicken Bites");
            menu.get(menu.size()-1).setPrice(100000);
            menu.get(menu.size()-1).setQuantity(Integer.parseInt(textField8.getText()));
        }if(!textField9.getText().isEmpty()){
            menu.add(new Menu());
            menu.get(menu.size()-1).setName("Popcorn Prawn Rolls w/ Mayo");
            menu.get(menu.size()-1).setPrice(100000);
            menu.get(menu.size()-1).setQuantity(Integer.parseInt(textField9.getText()));
        }
        return menu;
    }
}

