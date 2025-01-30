package college.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About() {
        // Frame settings
        setSize(700, 500);
        setLocation(400, 150);
        setLayout(null);
        getContentPane().setBackground(new Color(252, 228, 210));

        // Heading
        JLabel heading = new JLabel("The Oxford College Of Engineering");
        heading.setBounds(50, 20, 600, 40); // Position the text at the top
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);

        // Image Icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(50, 80, 300, 200); // Position image below the heading
        add(img);

        // Developer Name
        JLabel name = new JLabel("Developed by: Ashish Kumar Singh");
        name.setBounds(50, 300, 600, 40); // Position below the image
        name.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(name);

        // Contact
        JLabel contact = new JLabel("Email: aks06012004@gmail.com");
        contact.setBounds(50, 350, 600, 40); // Position below the developer name
        contact.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(contact);

        // Footer message
        JLabel footer = new JLabel("Dedicated to Excellence in Education");
        footer.setBounds(50, 400, 600, 40); // Position at the bottom
        footer.setFont(new Font("Tahoma", Font.ITALIC, 18));
        add(footer);

        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }
}
