package college.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateTeacher extends JFrame implements ActionListener {

    JTextField textaddress, textphone, textemail, textAadharNo, textqualification, textbranch;
    JLabel textName, textFather, empText, dobdob;
    JButton submit, cancel;
    Choice cEmpID;

    UpdateTeacher() {
        getContentPane().setBackground(new Color(230, 210, 252));
        setLayout(null);

        // Heading
        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 35));
        add(heading);

        // Employee ID Choice
        JLabel empId = new JLabel("Select Employee ID");
        empId.setBounds(50, 100, 200, 20);
        empId.setFont(new Font("serif", Font.PLAIN, 20));
        add(empId);

        cEmpID = new Choice();
        cEmpID.setBounds(250, 100, 200, 20);
        add(cEmpID);

        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT empID FROM teacher");
            while (rs.next()) {
                cEmpID.add(rs.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Name Field
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        name.setForeground(new Color(25, 42, 86));
        add(name);

        textName = new JLabel();
        textName.setBounds(170, 150, 200, 30);
        add(textName);

        // Father's Name
        JLabel fName = new JLabel("Father's Name");
        fName.setBounds(400, 150, 200, 30);
        fName.setFont(new Font("serif", Font.BOLD, 20));
        fName.setForeground(new Color(25, 42, 86));
        add(fName);

        textFather = new JLabel();
        textFather.setBounds(600, 150, 200, 30);
        add(textFather);

        // Employee ID
        JLabel empIDD = new JLabel("Employee ID");
        empIDD.setBounds(50, 200, 200, 30);
        empIDD.setFont(new Font("serif", Font.BOLD, 20));
        empIDD.setForeground(new Color(25, 42, 86));
        add(empIDD);

        empText = new JLabel();
        empText.setBounds(170, 200, 200, 30);
        add(empText);

        // Date of Birth
        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        dob.setForeground(new Color(25, 42, 86));
        add(dob);

        dobdob = new JLabel();
        dobdob.setBounds(600, 200, 150, 30);
        add(dobdob);

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

        // Aadhar No
        JLabel aadharNo = new JLabel("Aadhar No");
        aadharNo.setBounds(50, 350, 200, 30);
        aadharNo.setFont(new Font("serif", Font.BOLD, 20));
        aadharNo.setForeground(new Color(25, 42, 86));
        add(aadharNo);

        textAadharNo = new JTextField();
        textAadharNo.setBounds(170, 350, 200, 30);
        add(textAadharNo);

        // Qualification
        JLabel qualification = new JLabel("Qualification");
        qualification.setBounds(400, 350, 200, 30);
        qualification.setFont(new Font("serif", Font.BOLD, 20));
        qualification.setForeground(new Color(25, 42, 86));
        add(qualification);

        textqualification = new JTextField();
        textqualification.setBounds(600, 350, 150, 30);
        add(textqualification);

        // Department
        JLabel branch = new JLabel("Department");
        branch.setBounds(50, 400, 200, 30);
        branch.setFont(new Font("serif", Font.BOLD, 20));
        branch.setForeground(new Color(25, 42, 86));
        add(branch);

        textbranch = new JTextField();
        textbranch.setBounds(170, 400, 200, 30);
        add(textbranch);

        // Populate Data When Employee ID is Selected
        cEmpID.addItemListener(new ItemListener() {
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
            String query = "SELECT * FROM teacher WHERE empID='" + cEmpID.getSelectedItem() + "'";
            ResultSet rs = c.statement.executeQuery(query);
            if (rs.next()) {
                textName.setText(rs.getString("name"));
                textFather.setText(rs.getString("fname"));
                dobdob.setText(rs.getString("dob"));
                textaddress.setText(rs.getString("address"));
                textphone.setText(rs.getString("phone"));
                textemail.setText(rs.getString("email"));
                textAadharNo.setText(rs.getString("aadharNo"));
                textqualification.setText(rs.getString("qualification"));
                textbranch.setText(rs.getString("department"));
                empText.setText(rs.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String empID = empText.getText();
            String address = textaddress.getText();
            String phone = textphone.getText();
            String email = textemail.getText();
            String aadharNo = textAadharNo.getText();
            String qualification = textqualification.getText();
            String branch = textbranch.getText();

            try {
                String query = "UPDATE teacher SET address='" + address + "', phone='" + phone + "', email='" + email +
                        "', aadharNo='" + aadharNo + "', qualification='" + qualification +
                        "', department='" + branch + "' WHERE empID='" + empID + "'";
                Conn conn = new Conn();
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Teacher details updated successfully!");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateTeacher();
    }
}
