package Final_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.border.Border;

import static java.awt.Color.*;
import static javax.swing.BorderFactory.createEmptyBorder;
import static javax.swing.BorderFactory.createLineBorder;


public class HomeFrame extends JFrame implements ActionListener, MouseListener {
    int index;
    Database database;
    JButton[] subpanel = new JButton[3];
    private Color[] colors = new Color[]{
            Color.RED, Color.BLUE,Color.GREEN
    };
    private String[] type = new String[]{
            "spa", "culinary", "lounge"
    };
    protected String[] images = new String[]{
            "spa.png", "culinary.png", "lounge.png"
    };
    JPanel upperSide = new JPanel();
    JPanel previewPanel = new JPanel();
    JButton button = new JButton("Book Now");
    JMenuBar menuBar = new JMenuBar();
    JMenu profile = new JMenu();
    JMenuItem logout = new JMenuItem("Logout");
    JMenuItem history = new JMenuItem("History");
    JDesktopPane desktopPane = new JDesktopPane();

    public HomeFrame(int indexx, Database databasee){
        this.database = databasee;
        index = indexx;
        ImageIcon logo = new ImageIcon("./assets/logo1.png");
        this.setIconImage(logo.getImage());
        //header
        menuBar.add(Box.createHorizontalGlue());
        menuBar.setBackground(new Color(0x5B3C31));
        desktopPane.setBackground(new Color(0x5B3C31));
        profile.setBackground(new Color(0x5B3C31));
        ImageIcon prof = new ImageIcon("./assets/profile.png");
        profile.setIcon(prof);
        menuBar.add(profile);
        profile.add(history);
        profile.addSeparator();
        profile.add(logout);

        history.addActionListener(this);
        logout.addActionListener(this);

        setJMenuBar(menuBar);
        setContentPane(desktopPane);

        //Bagian Atas
        String name = database.Customers.get(index).getName();

        JLabel text = new JLabel( "Welcome " + name + " to the Hotel");

        JLabel label2 = new JLabel( new HomeFrame.ColorIcon(Color.YELLOW, 800, 300) );
        ImageIcon bg = new ImageIcon("./assets/jumbotron2.png");
        label2.setIcon(bg);
        label2.setLayout( new BoxLayout(label2, BoxLayout.Y_AXIS) );
        upperSide.setLayout(new BorderLayout());
        upperSide.setPreferredSize(new Dimension(800,600));

        //Welcome ...
        text.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        text.setForeground(Color.white);
        text.setFont(new Font("Poppins Light", Font.PLAIN, 30));

        //Book Now
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button.setFocusable(false);
        button.setBackground(white);
        button.setFont(new Font("Poppins", Font.PLAIN, 20));
        button.addActionListener(this);

        //add semua bagian atas
        label2.add( Box.createVerticalGlue() );
        label2.add(text);
        label2.add(Box.createRigidArea(new Dimension(0, 20)));
        label2.add(button);
        label2.add( Box.createVerticalGlue() );
        label2.add( Box.createVerticalStrut(10));
        upperSide.add(label2);

        //bagian bawah
        previewPanel.setLayout(new GridBagLayout());
        previewPanel.setPreferredSize(new Dimension(800, 300));
        GridBagConstraints gbc = new GridBagConstraints();
        previewPanel.setBackground(new Color(0x5B3C31));
        previewPanel.setOpaque(true);
        for (int i = 0 ; i < 3 ; i++){
            subpanel[i] = new JButton(new ImageIcon("./assets/" + images[i]));
            subpanel[i].setLayout(new BorderLayout());
            gbc.insets = new Insets(5,5,5,5);


            Color p = new Color(0xB0FFFFFF, true);
            Border whiteline = BorderFactory.createLineBorder(p);
            subpanel[i].setBorder(whiteline);
            subpanel[i].addMouseListener(this);

            previewPanel.add(subpanel[i], gbc);
        }

        //Frame
        setLayout(new GridLayout(2,0));
        add(upperSide);
        add(previewPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800,600);
        setMinimumSize(this.getMinimumSize());
        setVisible(true);
        setLocationRelativeTo(null);
        this.setResizable(false);
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
        for (int i = 0 ; i < 3 ; i++){
            if(e.getSource() == subpanel[i]){
//                System.out.println("hovered!");
                subpanel[i].setIcon(new ImageIcon("./assets/"+type[i]+"hover.png"));
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        for (int i = 0 ; i < 3 ; i++){
            if(e.getSource() == subpanel[i]){
//                System.out.println("keluar!");
                subpanel[i].setIcon(new ImageIcon("./assets/" + images[i]));
            }
        }
    }

    public static class ColorIcon implements Icon
    {
        private Color color;
        private int width, height;
        public ColorIcon(Color color, int width, int height)
        {
            this.color = color;
            this.width = width;
            this.height = height;
        }
        public int getIconWidth()
        {
            return width;
        }

        public int getIconHeight()
        {
            return height;
        }

        public void paintIcon(Component c, Graphics g, int x, int y)
        {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button){
            System.out.println("Pressed!");
            BookingRoomFrame bookingFrame = new BookingRoomFrame(index, database);
            dispose();
        }

        if(e.getSource() instanceof JMenuItem menu){
            if(menu.getText().equals("History")){
                new History(index, database);
                dispose();
            }
        }

        if(e.getSource() instanceof  JMenuItem menu){
            if(menu.getText().equals("Logout")){
                new Login(database);
                dispose();
            }
        }
    }
}