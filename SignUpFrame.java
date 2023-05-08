package Final_Project;

import Final_Project.Database;
import Final_Project.LogInFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class SignUpFrame extends JFrame implements ActionListener {
    JButton loginBtn;
    Font font = new Font("Sans Sherif", Font.PLAIN,15);
    Font font1 = new Font("Sans Sherif", Font.PLAIN,13);
    Color color = new Color(255, 255, 255, 144);
    JButton submitBtn;
    JTextField nameTxt;
    JPasswordField passwordTxt;
    JTextField creditTxt;
    JTextField phoneTxt;
    Database database;
    ArrayList<Customer> temp;

    SignUpFrame(Database database){
        this.database = database;

        ImageIcon logo = new ImageIcon("./assets/logo1.png");
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
        submitBtn.addActionListener(this);

        loginBtn = new JButton("Already have an account? Click here!");
        loginBtn.setFont(new Font("Montserrat", Font.PLAIN,10));
        loginBtn.setFocusable(false);
        loginBtn.setBackground(Color.white);
        loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
                Login login = new Login(database);
            }
        });


        marginBottom.add(submitBtn);
        marginBottom.add(Box.createRigidArea(new Dimension(10,10)));
        marginBottom.add(loginBtn);

        marginRight.setPreferredSize(new Dimension(90,20));
        marginLeft.setPreferredSize(new Dimension(90,20));

        content.setPreferredSize(new Dimension(30,200));
        content.setLayout(new GridLayout(4,2,0,25));

        marginTop.setPreferredSize(new Dimension(40,100));
        marginTop.setLayout(new GridBagLayout());
        marginTop.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        container.setBounds(42, 52,600,375);

        JLabel loginLbl = new JLabel("Sign-Up");
        marginTop.add(loginLbl);
        loginLbl.setFont(new Font("Poppins", Font.BOLD,50));

        JLabel nameLbl = new JLabel(
                "Name                                :");
        JLabel passwordLbl = new JLabel(
                "Password                         :");
        JLabel phoneLbl = new JLabel(
                "Phone Number                :");
        JLabel creditLbl = new JLabel(
                "Credit Card Number        :");

        NumberFormat amountFormat = NumberFormat.getNumberInstance();

        nameTxt = new JTextField();
        passwordTxt = new JPasswordField();

        phoneTxt = new JTextField();
        phoneTxt.setColumns(10);
        phoneTxt.setEditable(true);

        creditTxt = new JTextField();
        creditTxt.setColumns(10);

        phoneTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent key) {
                char karakter = key.getKeyChar();
                if(!((karakter >= '0') && (karakter <= '9') && phoneTxt.getText().length()<12 || (karakter == KeyEvent.VK_BACK_SPACE))){
                    getToolkit().beep();
                    key.consume();
                    JOptionPane.showMessageDialog(null,"12 Numbers Only","", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        creditTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent key) {
                char karakter = key.getKeyChar();
                if(!((karakter >= '0') && (karakter <= '9') && creditTxt.getText().length()<16 || (karakter == KeyEvent.VK_BACK_SPACE))){
                    getToolkit().beep();
                    key.consume();
                    JOptionPane.showMessageDialog(null,"16 Numbers Only","", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        nameTxt.setFont(font1);
        passwordTxt.setFont(font1);
        phoneTxt.setFont(font1);
        creditTxt.setFont(font1);

        nameLbl.setFont(font);
        passwordLbl.setFont(font);
        phoneLbl.setFont(font);
        creditLbl.setFont(font);
        nameTxt.setFont(font);
        passwordTxt.setFont(font);
        phoneTxt.setFont(font);
        creditTxt.setFont(font);

        content.add(nameLbl);
        content.add(nameTxt);

        content.add(passwordLbl);
        content.add(passwordTxt);

        content.add(phoneLbl);
        content.add(phoneTxt);

        content.add(creditLbl);
        content.add(creditTxt);

        container.add(marginTop, BorderLayout.NORTH);
        container.add(content, BorderLayout.CENTER);
        container.add(marginBottom, BorderLayout.SOUTH);
        container.add(marginLeft, BorderLayout.WEST);
        container.add(marginRight, BorderLayout.EAST);

        content.setBackground(color);
        marginLeft.setBackground(color);
        marginRight.setBackground(color);
        marginTop.setBackground(color);
        marginBottom.setBackground(color);
        container.setBackground(color);

        this.add(container);
        this.add(layeredPane);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn){
            String name = nameTxt.getText();
            String pass = new String(passwordTxt.getPassword());
            if(nameTxt.getText().isEmpty() || passwordTxt.getPassword().length == 0 || phoneTxt.getText().isEmpty() || creditTxt.getText().isEmpty()){
                getToolkit().beep();
                JOptionPane.showMessageDialog(this,"Please fill all the form","Complete form!",JOptionPane.ERROR_MESSAGE);
            }else{
                int cek = checkRegistered(name,pass);
                System.out.println(cek);
                if(cek == 1){
                    JOptionPane.showMessageDialog(this,"Please go to log-in frame","Account already registered",JOptionPane.ERROR_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(this, "Enjoy exploring our palace!", "Welcome to Galvanize Hotel!", JOptionPane.INFORMATION_MESSAGE);
                    Customer current = new Customer();
                    database.addCustomer(database.Customers, name, pass);
                    
                    int index = database.Customers.size()-1;
                    this.dispose();
                    HomeFrame homeFrame = new HomeFrame(index, database);
                }
            }
         }
    }

    public int checkRegistered(String name, String pass){
        for (int i = 0; i < database.Customers.size(); i++) {
            if(name.equals(database.Customers.get(i).getName())){
                if(pass.equals(database.Customers.get(i).getPassword())){
                    return 1;
                }
            }
        }
        return -1;
    }
}
