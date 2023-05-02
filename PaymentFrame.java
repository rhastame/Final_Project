package Final_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.Color.white;

public class PaymentFrame extends JFrame implements ActionListener {
    private String[] method = new String[]{
            "BCA", "Mandiri", "Syariah"
    };
    Database database;
    int index;
    JButton submitBtn;
    PaymentFrame(int indexx, Database databasee){
        index = indexx;
        database = databasee;
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(10,10,10,10);
        mainPanel.setBackground(new Color(0x5B3C31));


        //Header
        JLabel Header = new JLabel("Payment");
        Header.setFont(new Font("Poppins Light", Font.PLAIN, 30));
        Header.setForeground(white);
        g.weightx = 0;
        g.gridx = 0;
        g.gridy = 0;
        mainPanel.add(Header, g);

        JPanel transaction = new JPanel();
        transaction.setBackground(new Color(0x8A5747));
        JButton btn = new JButton("Test");

        ArrayList<BookingRoom> rooms =database.Customers.get(index).getRooms();
        ArrayList<AdditionalService> adds =database.Customers.get(index).getAdditonal();;

        JLabel string = new JLabel("Kamar Sekian Additional Fee Sekian - Rp. 100000");
        JLabel string2 = new JLabel("Kamar Sekian Additional Fee Sekian - Rp. 100000");


        string.setFont(new Font("Poppins Light", Font.PLAIN, 15));
        string.setForeground(white);

        string.setBounds(0,20,100,20);
        string2.setBounds(0,50,100,20);

        transaction.add(string);
        transaction.add(string2);

        g.fill = GridBagConstraints.HORIZONTAL;
        g.ipadx = 400;
        g.ipady = 200;      //make this component tall
        g.weightx = 0;
        g.gridx = 0;
        g.gridy = 1;
        mainPanel.add(transaction, g);

        JPanel payPanel = new JPanel(new GridBagLayout());
        payPanel.setMinimumSize(getMinimumSize());
        payPanel.setBackground(new Color(0x5B3C31));
        ButtonGroup group = new ButtonGroup();
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

        g.ipady = 0;
        g.ipadx = 0;
        g.weightx = 0;
        g.gridx = 0;
        g.gridy = 2;
        for (int i = 0 ; i < 3 ; i++){
            JLabel paymentby = new JLabel(method[i]);

        }

        mainPanel.add(payPanel, g);



        submitBtn = new JButton("Book");
        submitBtn.setFocusable(false);
        submitBtn.setBackground(white);
        submitBtn.setFont(new Font("Poppins", Font.PLAIN, 10));
        submitBtn.addActionListener(this);
        g.fill = GridBagConstraints.NONE;
        g.weightx = 0;
        g.gridx = 0;
        g.gridy = 3;

        mainPanel.add(submitBtn,g);


        add(mainPanel);
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(this.getMinimumSize());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submitBtn){
            dispose();
            new HomeFrame(index, database);
        }
    }
}

