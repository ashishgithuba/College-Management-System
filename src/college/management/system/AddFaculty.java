package college.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Random;

public class AddFaculty extends JFrame implements ActionListener {
    JTextField textName, textFather, textaddress, textphone, textemail, textM10, textM12, textAadharNo;
    JLabel empText;
    JDateChooser cdob;
    JComboBox<String> courseBox, departmentBox;
    JButton submit, cancel;

    // Generate a Random Employee ID
    Random ran = new Random();
    long f4 = Math.abs(ran.nextLong() % 900L) + 1000L;

    AddFaculty() {
        // Set Frame Background Color
        getContentPane().setBackground(new Color(204, 255, 229)); // Soft Mint Green
        setLayout(null);


        // Heading
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        heading.setForeground(new Color(54, 69, 79));
        add(heading);

        // Name Field
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        name.setForeground(new Color(25, 42, 86));
        add(name);

        textName = new JTextField();
        textName.setBounds(170, 150, 200, 30);
        add(textName);

        // Father's Name
        JLabel fName = new JLabel("Father's Name");
        fName.setBounds(400, 150, 200, 30);
        fName.setFont(new Font("serif", Font.BOLD, 20));
        fName.setForeground(new Color(25, 42, 86));
        add(fName);

        textFather = new JTextField();
        textFather.setBounds(600, 150, 200, 30);
        add(textFather);

        // Employee ID
        JLabel empID = new JLabel("Employee ID");
        empID.setBounds(50, 200, 200, 30);
        empID.setFont(new Font("serif", Font.BOLD, 20));
        empID.setForeground(new Color(25, 42, 86));
        add(empID);

        empText = new JLabel("OX" + f4);
        empText.setBounds(170, 200, 200, 30);
        empText.setFont(new Font("serif", Font.BOLD, 20));
        empText.setForeground(new Color(25, 42, 86));
        add(empText);

        // Date of Birth
        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        dob.setForeground(new Color(25, 42, 86));
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(600, 200, 150, 30);
        add(cdob);

        // Address
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        address.setForeground(new Color(25, 42, 86));
        add(address);

        textaddress = new JTextField();
        textaddress.setBounds(170, 250, 200, 30);
        add(textaddress);

        // Phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 200, 30);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        phone.setForeground(new Color(25, 42, 86));
        add(phone);

        textphone = new JTextField();
        textphone.setBounds(600, 250, 150, 30);
        add(textphone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 200, 30);
        email.setFont(new Font("serif", Font.BOLD, 20));
        email.setForeground(new Color(25, 42, 86));
        add(email);

        textemail = new JTextField();
        textemail.setBounds(170, 300, 200, 30);
        add(textemail);

        // 10th Marks
        JLabel M10 = new JLabel("Class X(%)");
        M10.setBounds(50, 350, 200, 30);
        M10.setFont(new Font("serif", Font.BOLD, 20));
        M10.setForeground(new Color(25, 42, 86));
        add(M10);

        textM10 = new JTextField();
        textM10.setBounds(170, 350, 200, 30);
        add(textM10);

        // 12th Marks
        JLabel M12 = new JLabel("Class XII(%)");
        M12.setBounds(400, 350, 200, 30);
        M12.setFont(new Font("serif", Font.BOLD, 20));
        M12.setForeground(new Color(25, 42, 86));
        add(M12);

        textM12 = new JTextField();
        textM12.setBounds(600, 350, 200, 30);
        add(textM12);

        // Aadhar No
        JLabel AadharNo = new JLabel("Aadhar No");
        AadharNo.setBounds(50, 400, 200, 30);
        AadharNo.setFont(new Font("serif", Font.BOLD, 20));
        AadharNo.setForeground(new Color(25, 42, 86));
        add(AadharNo);

        textAadharNo = new JTextField();
        textAadharNo.setBounds(170, 400, 200, 30);
        add(textAadharNo);

        // Qualification
        JLabel Qualification = new JLabel("Qualification");
        Qualification.setBounds(50, 450, 200, 30);
        Qualification.setFont(new Font("serif", Font.BOLD, 20));
        Qualification.setForeground(new Color(25, 42, 86));
        add(Qualification);

        String[] courses = {"B.Tech", "PhD", "BCA", "MCA", "MCom"};
        courseBox = new JComboBox<>(courses);
        courseBox.setBounds(170, 450, 200, 30);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);

        // Department
        JLabel Department = new JLabel("Department");
        Department.setBounds(400, 450, 200, 30);
        Department.setFont(new Font("serif", Font.BOLD, 20));
        Department.setForeground(new Color(25, 42, 86));
        add(Department);

        String[] departments = {"Computer Science", "IT", "Mechanical", "Civil", "Electrical", "ECE"};
        departmentBox = new JComboBox<>(departments);
        departmentBox.setBounds(600, 450, 200, 30);
        departmentBox.setBackground(Color.WHITE);
        add(departmentBox);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 150, 40);
        submit.setBackground(new Color(50, 205, 50));
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("serif", Font.BOLD, 20));
        submit.addActionListener(this);
        add(submit);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 150, 40);
        cancel.setBackground(new Color(220, 20, 60));
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif", Font.BOLD, 20));
        cancel.addActionListener(this);
        add(cancel);

        // Frame Properties
        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String name = textName.getText();
            String fatherName = textFather.getText();
            String empID = empText.getText();

            // Get the date from the JDateChooser and format it
            String dob = null;
            if (cdob.getDate() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                dob = sdf.format(cdob.getDate());  // This formats the date into "yyyy-MM-dd"
            }

            String address = textaddress.getText();
            String phone = textphone.getText();
            String email = textemail.getText();
            String x = textM10.getText();
            String xii = textM12.getText();
            String aadharNo = textAadharNo.getText();
            String course = (String) courseBox.getSelectedItem();
            String department = (String) departmentBox.getSelectedItem();

            try {
                String q = "INSERT INTO teacher (name, fname, empID, dob, address, phone, email, class_X, class_XII, aadharNo, qualification, department) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                Conn c = new Conn();
                PreparedStatement pstmt = c.getConnection().prepareStatement(q);

                pstmt.setString(1, name);
                pstmt.setString(2, fatherName);
                pstmt.setString(3, empID);
                pstmt.setString(4, dob);  // Inserting formatted date here
                pstmt.setString(5, address);
                pstmt.setString(6, phone);
                pstmt.setString(7, email);
                pstmt.setString(8, x);
                pstmt.setString(9, xii);
                pstmt.setString(10, aadharNo);
                pstmt.setString(11, course);
                pstmt.setString(12, department);

                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Details Inserted");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new AddFaculty();
    }
}
