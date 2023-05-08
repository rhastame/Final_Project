package Final_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class LogInFrame extends JFrame implements ActionListener {
    Image image;
    JButton loginBtn;
    Font font1 = new Font("Sans Sherif", Font.PLAIN,13);

    Font font = new Font("Sans Sherif", Font.PLAIN,16);
    Color color = new Color(255, 255, 255, 144);
    JButton submitBtn;
    JTextField nameTxt;
    JPasswordField passwordTxt;
    int index;
    Database database;
    LogInFrame(Database databasee){
//        temp = customers;
        database = databasee;
//    }

//    public void openFrame(){
        ImageIcon logo = new ImageIcon("src/Final_Project/assets/logo1.png");
        this.setIconImage(logo.getImage());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,500);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,700,500);

        ImageIcon background = new ImageIcon("./assets/bg.jpg");
        Image img = background.getImage();
        Image temp = img.getScaledInstance(700,500,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0,700,500);
        layeredPane.add(back, Integer.valueOf(0));

        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());

        container.setOpaque(true);
        JPanel marginTop = new JPanel();
        JPanel marginBottom = new JPanel();
        JPanel marginRight = new JPanel();
        JPanel marginLeft = new JPanel();
        JPanel content = new JPanel();

        marginBottom.setLayout(new BoxLayout(marginBottom, BoxLayout.Y_AXIS));

        marginBottom.setBorder(BorderFactory.createEmptyBorder(20,0,10,0));
        submitBtn = new JButton("Submit");
        submitBtn.setFocusable(false);
        submitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginBtn = new JButton("Don't have an account? Click Here!");
        loginBtn.setFocusable(false);
        loginBtn.setFont(new Font("Montserrat", Font.PLAIN,13));
        loginBtn.setBackground(Color.white);
        loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
                SignUp signup = new SignUp(database);
//                signup.signup();
            }
        });
        marginBottom.add(submitBtn);
        marginBottom.add(Box.createRigidArea(new Dimension(10,10)));
        marginBottom.add(loginBtn);
         marginRight.setPreferredSize(new Dimension(90,20));
        marginLeft.setPreferredSize(new Dimension(90,20));

        content.setPreferredSize(new Dimension(30,60));
        content.setLayout(new GridLayout(2,2,0,15));

        marginTop.setPreferredSize(new Dimension(40,120));
        marginTop.setLayout(new GridBagLayout());
        marginTop.setBorder(BorderFactory.createEmptyBorder(30,10,40,10));

        container.setBounds(42, 100,600,275);

        JLabel loginLbl = new JLabel("Log-In");
        marginTop.add(loginLbl);
        loginLbl.setFont(new Font("Poppins", Font.BOLD,50));

        JLabel nameLbl = new JLabel(
                "Name                               :");
        JLabel passwordLbl = new JLabel(
                "Password                         :");

        NumberFormat amountFormat = NumberFormat.getNumberInstance();

        nameTxt = new JTextField();
        passwordTxt = new JPasswordField();
        nameTxt.setFont(font1);
        passwordTxt.setFont(font1);

        nameLbl.setFont(font);
        passwordLbl.setFont(font);

        nameTxt.setFont(font);
        passwordTxt.setFont(font);

        content.add(nameLbl);
        content.add(nameTxt);

        content.add(passwordLbl);
        content.add(passwordTxt);

        container.add(marginTop, BorderLayout.NORTH);
        container.add(content, BorderLayout.CENTER);
        container.add(marginBottom, BorderLayout.SOUTH);
        container.add(marginLeft, BorderLayout.WEST);
        container.add(marginRight, BorderLayout.EAST);

        content.setBackground(color);
        marginLeft.setBackground(color);
        marginBottom.setBackground(color);
        marginRight.setBackground(color);
        marginTop.setBackground(color);
        container.setBackground(color);

        submitBtn.addActionListener(this);
        this.add(container);
        this.add(layeredPane);
        this.setVisible(true);

    }

    String username;
    String password;
//    Customer current = new Customer();

    @Override
    public void actionPerformed(ActionEvent e) {
        username = nameTxt.getText();
        password = new String(passwordTxt.getPassword());
        if (e.getSource() == submitBtn) {
            if (database.Customers.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Sign-Up first", "No Data Here", JOptionPane.ERROR_MESSAGE);
            } else {
                if (validation(username, password) == -1) {
                    JOptionPane.showMessageDialog(this, "Please enter the correct username or password", "Invalid Input!", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Enjoy exploring our palace!", "Welcome to Galvanize Hotel!", JOptionPane.INFORMATION_MESSAGE);
                    index = checkLogged();
                    HomeFrame homeFrame = new HomeFrame(index, database);
                    this.dispose();
//                index = 150;
                }
            }
        }
    }

    public int checkLogged(){
        Customer curr = new Customer();
        for (int i = 0; i < database.Customers.size(); i++) {
            if(database.Customers.get(i).getLogged()==1){
                database.Customers.get(i).setLogged(0);
                return i;
            }
        }
        return -1;
    }

    public int validation(String name, String password){
        for (int i = 0; i < database.Customers.size(); i++) {
            System.out.println(database.Customers.get(i).getName());
            System.out.println(database.Customers.get(i).getPassword());
            System.out.println(database.Customers.get(i).getLogged());

            if(name.equals(database.Customers.get(i).getName())){
                System.out.println("masuk sini");
                if(password.equals(database.Customers.get(i).getPassword())){
                    System.out.println("disini");
                    database.Customers.get(i).setLogged(1);
                    return i;
                }
            }
        }
        return -1;
    }

}

