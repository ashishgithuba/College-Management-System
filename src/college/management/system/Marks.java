package college.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Marks extends JFrame implements ActionListener {

    String rollno;
    JButton cancel;

    public Marks(String rollno) {
        this.rollno = rollno;

        // Frame settings
        setSize(500, 600);
        setLocation(500, 100);
        setLayout(null);
        getContentPane().setBackground(new Color(210, 252, 248));

        // Heading
        JLabel heading = new JLabel("The Oxford College Of Engineering");
        heading.setBounds(60, 10, 400, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        // Subheading
        JLabel subheading = new JLabel("Result of Examination 2023");
        subheading.setBounds(100, 50, 400, 20);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(subheading);

        // Roll Number
        JLabel lblrollno = new JLabel("Roll Number: " + rollno);
        lblrollno.setBounds(60, 100, 400, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);

        // Semester
        JLabel lblsemester = new JLabel("Semester: ");
        lblsemester.setBounds(60, 130, 400, 20);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsemester);

        // Subject and Marks Labels
        JLabel sub1 = new JLabel();
        sub1.setBounds(100, 200, 400, 20);
        sub1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(100, 230, 400, 20);
        sub2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(100, 260, 400, 20);
        sub3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(100, 290, 400, 20);
        sub4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(100, 320, 400, 20);
        sub5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub5);

        try {
            Conn c = new Conn();

            // Fetch subjects
            ResultSet rs1 = c.statement.executeQuery("SELECT * FROM subject WHERE rollNo = '" + rollno + "'");
            if (rs1.next()) {
                sub1.setText(rs1.getString("sub1"));
                sub2.setText(rs1.getString("sub2"));
                sub3.setText(rs1.getString("sub3"));
                sub4.setText(rs1.getString("sub4"));
                sub5.setText(rs1.getString("sub5"));
            }

            // Fetch marks and semester
            ResultSet rs2 = c.statement.executeQuery("SELECT * FROM marks WHERE rollNo = '" + rollno + "'");
            if (rs2.next()) {
                sub1.setText(sub1.getText() + " ------------ " + rs2.getString("mrk1"));
                sub2.setText(sub2.getText() + " ------------ " + rs2.getString("mrk2"));
                sub3.setText(sub3.getText() + " ------------ " + rs2.getString("mrk3"));
                sub4.setText(sub4.getText() + " ------------ " + rs2.getString("mrk4"));
                sub5.setText(sub5.getText() + " ------------ " + rs2.getString("mrk5"));
                lblsemester.setText("Semester: " + rs2.getString("semester"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        }

        // Cancel Button
        cancel = new JButton("Back");
        cancel.setBounds(180, 500, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new Marks("rollNo"); // Replace "rollNo" with an actual roll number for testing
    }
}
