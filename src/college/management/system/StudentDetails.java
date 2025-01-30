package college.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDetails extends JFrame implements ActionListener {

    Choice choice;
    JTable table;
    JButton search, print, update, add, cancel;

    public StudentDetails() {
        // Set background color
        getContentPane().setBackground(new Color(210, 252, 218));

        // Heading label
        JLabel heading = new JLabel("Search By Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        // Choice dropdown for roll numbers
        choice = new Choice();
        choice.setBounds(180, 20, 150, 20);
        add(choice);

        // Populate the choice dropdown with roll numbers
        populateChoice();

        // JTable for displaying student details
        table = new JTable();
        JScrollPane js = new JScrollPane(table);
        js.setBounds(0, 100, 900, 600);
        add(js);

        // Buttons
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add");
        add.setBounds(220, 70, 80, 20);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(320, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        // Populate the table with student data
        populateTable();

        // JFrame properties
        setLayout(null);
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    // Method to populate the choice dropdown with roll numbers from the database
    private void populateChoice() {
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT rollNo FROM student");

            while (resultSet.next()) {
                choice.add(resultSet.getString("rollNo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to populate the JTable with student details
    private void populateTable() {
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM student");

            if (resultSet != null) {
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Handle button click events
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            searchStudentDetails();
        } else if (e.getSource() == print) {
            printTable();
        } else if (e.getSource() == add) {
            addStudent();
        } else if (e.getSource() == update) {
            updateStudent();
        } else if (e.getSource() == cancel) {
            dispose();
        }
    }

    // Method to search and display student details based on selected roll number
    private void searchStudentDetails() {
        try {
            Conn c = new Conn();
            String selectedRoll = choice.getSelectedItem();
            String query = "SELECT * FROM student WHERE rollNo = '" + selectedRoll + "'";
            ResultSet resultSet = c.statement.executeQuery(query);

            if (resultSet != null) {
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method for printing the table
    private void printTable() {
        try {
            table.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Placeholder method for adding a student
    private void addStudent() {
        setVisible(false);
        new AddStudent(); // Assuming AddStudent class exists
    }

    // Placeholder method for updating a student
    private void updateStudent() {
        JOptionPane.showMessageDialog(this, "Update Student functionality not implemented yet.");
    }

    public static void main(String[] args) {
        new StudentDetails();
    }
}
