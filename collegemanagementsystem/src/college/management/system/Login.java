package college.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textFieldName;
    JPasswordField passwordField;
    JButton login, Back;

    public Login() {
        // Username Label and Field
        JLabel LableName = new JLabel("UserName");
        LableName.setBounds(40, 20, 100, 20);
        add(LableName);

        textFieldName = new JTextField();
        textFieldName.setBounds(150, 20, 150, 20);
        add(textFieldName);

        // Password Label and Field
        JLabel Lablepass = new JLabel("Password");
        Lablepass.setBounds(40, 70, 100, 20);
        add(Lablepass);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 20);
        add(passwordField);

        // Buttons
        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLUE);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        Back = new JButton("Back");
        Back.setBounds(180, 140, 120, 30);
        Back.setBackground(Color.BLUE);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);

        // First Image (small image on the right)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/user1.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350, 20, 200, 200);
        add(img);

        // Background Image
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/back.jpg"));
        Image i12 = i11.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(i12);
        JLabel image = new JLabel(i13);
        image.setBounds(0, 0, 600, 300);
        add(image);

        // Frame settings
        setSize(600, 300); // Set frame size
        setLocation(500, 260); // Set frame location on the screen
        setLayout(null);
        setVisible(true); // Make the frame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String username = textFieldName.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);

            // Hardcoded credentials
            String validUsername = "oxford";
            String validPassword = "ise123";

            // Check if entered username and password match the hardcoded credentials
            if (username.equals(validUsername) && password.equals(validPassword)) {
                setVisible(false); // Close login window
                new main_class(); // Transition to the next screen
            } else {
                // Show error message if login fails
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            setVisible(false); // Close the login window when 'Back' is clicked
        }
    }

    public static void main(String[] args) {
        new Login(); // Create an instance of the Login class
    }
}
