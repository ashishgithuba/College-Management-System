package college.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class updateStudents extends JFrame implements ActionListener {

    JTextField textaddress, textphone, textemail, textAadharNo, textcourse, textbranchs;
    JLabel textName, textFather, dobdob;
    JButton submit, cancel;
    Choice cRollNo;

    updateStudents() {
        getContentPane().setBackground(new Color(230, 210, 252));
        setLayout(null);

        // Heading
        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 35));
        add(heading);

        // Roll Number Choice
        JLabel rollNo = new JLabel("Select Roll No");
        rollNo.setBounds(50, 100, 200, 20);
        rollNo.setFont(new Font("serif", Font.PLAIN, 20));
        add(rollNo);

        cRollNo = new Choice();
        cRollNo.setBounds(250, 100, 200, 20);
        add(cRollNo);

        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT rollNo FROM student");
            while (rs.next()) {
                cRollNo.add(rs.getString("rollNo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Name Field
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        textName = new JLabel();
        textName.setBounds(170, 150, 200, 30);
        add(textName);

        // Father's Name
        JLabel fName = new JLabel("Father's Name");
        fName.setBounds(400, 150, 200, 30);
        fName.setFont(new Font("serif", Font.BOLD, 20));
        add(fName);

        textFather = new JLabel();
        textFather.setBounds(600, 150, 200, 30);
        add(textFather);

        // Date of Birth
        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 200, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        add(dob);

        dobdob = new JLabel();
        dobdob.setBounds(170, 200, 200, 30);
        add(dobdob);

        // Address
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        add(address);

        textaddress = new JTextField();
        textaddress.setBounds(170, 250, 200, 30);
        add(textaddress);

        // Phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 200, 30);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        add(phone);

        textphone = new JTextField();
        textphone.setBounds(600, 250, 150, 30);
        add(textphone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 200, 30);
        email.setFont(new Font("serif", Font.BOLD, 20));
        add(email);

        textemail = new JTextField();
        textemail.setBounds(170, 300, 200, 30);
        add(textemail);

        // Aadhar No
        JLabel aadharNo = new JLabel("Aadhar No");
        aadharNo.setBounds(50, 350, 200, 30);
        aadharNo.setFont(new Font("serif", Font.BOLD, 20));
        add(aadharNo);

        textAadharNo = new JTextField();
        textAadharNo.setBounds(170, 350, 200, 30);
        add(textAadharNo);

        // Course
        JLabel course = new JLabel("Course");
        course.setBounds(400, 350, 200, 30);
        course.setFont(new Font("serif", Font.BOLD, 20));
        add(course);

        textcourse = new JTextField();
        textcourse.setBounds(600, 350, 150, 30);
        add(textcourse);

        // Branch
        JLabel branchs = new JLabel("Branch");
        branchs.setBounds(50, 400, 200, 30);
        branchs.setFont(new Font("serif", Font.BOLD, 20));
        add(branchs);

        textbranchs = new JTextField();
        textbranchs.setBounds(170, 400, 200, 30);
        add(textbranchs);

        // Populate Data When Roll Number is Selected
        cRollNo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                fetchData();
            }
        });

        // Submit Button
        submit = new JButton("Update");
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

        setSize(900, 700);
        setLocation(350, 50);
        setVisible(true);

        fetchData();
    }

    void fetchData() {
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM student WHERE rollNo='" + cRollNo.getSelectedItem() + "'";
            ResultSet rs = c.statement.executeQuery(query);
            if (rs.next()) {
                textName.setText(rs.getString("name"));
                textFather.setText(rs.getString("fname"));
                dobdob.setText(rs.getString("dob"));
                textaddress.setText(rs.getString("address"));
                textphone.setText(rs.getString("phone"));
                textemail.setText(rs.getString("email"));
                textAadharNo.setText(rs.getString("aadharNo"));
                textcourse.setText(rs.getString("course"));
                textbranchs.setText(rs.getString("branchs"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String rollNo = cRollNo.getSelectedItem();
            String address = textaddress.getText();
            String phone = textphone.getText();
            String email = textemail.getText();
            String aadharNo = textAadharNo.getText();
            String course = textcourse.getText();
            String branchs = textbranchs.getText();

            try {
                String query = "UPDATE student SET address='" + address + "', phone='" + phone + "', email='" + email +
                        "', aadharNo='" + aadharNo + "', course='" + course +
                        "', branchs='" + branchs + "' WHERE rollNo='" + rollNo + "'";
                Conn conn = new Conn();
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student details updated successfully!");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new updateStudents();
    }
}
