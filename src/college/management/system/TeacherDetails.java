package college.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDetails extends JFrame implements ActionListener {


    Choice choice;
    JTable table;
    JButton search, print, update, add, cancel;

    // Constructor
    TeacherDetails() {
        // Set background color
        getContentPane().setBackground(new Color(192, 164, 218));

        // Heading label
        JLabel heading = new JLabel("Search By Employee ID");
        heading.setBounds(20, 20, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(heading);

        // Dropdown for Employee IDs
        choice = new Choice();
        choice.setBounds(220, 20, 150, 20);
        add(choice);

        // Populate dropdown
        populateChoice();

        // JTable for displaying teacher details
        table = new JTable();
        JScrollPane js = new JScrollPane(table);
        js.setBounds(20, 100, 850, 500);
        add(js);

        // Buttons
        search = new JButton("Search");
        search.setBounds(20, 70, 100, 25);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(140, 70, 100, 25);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add");
        add.setBounds(260, 70, 100, 25);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(380, 70, 100, 25);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(500, 70, 100, 25);
        cancel.addActionListener(this);
        add(cancel);

        // Populate the table with teacher data
        populateTable();

        // JFrame properties
        setLayout(null);
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    // Method to populate the dropdown with Employee IDs
    private void populateChoice() {
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT empID FROM teacher");

            while (resultSet.next()) {
                choice.add(resultSet.getString("empID"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error loading Employee IDs.");
            e.printStackTrace();
        }
    }

    // Method to populate the JTable with teacher details
    private void populateTable() {
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM teacher");

            if (resultSet != null) {
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error loading teacher details.");
            e.printStackTrace();
        }
    }

    // Action listener for buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            searchTeacherDetails();
        } else if (e.getSource() == print) {
            printTable();
        } else if (e.getSource() == add) {
            addTeacher();
        } else if (e.getSource() == update) {
            updateTeacher();
        } else if (e.getSource() == cancel) {
            dispose();
        }
    }

    // Method to search teacher details
    private void searchTeacherDetails() {
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM teacher WHERE empID = '" + choice.getSelectedItem() + "'";
            ResultSet resultSet = c.statement.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error searching teacher details.");
            e.printStackTrace();
        }
    }

    // Method to print the JTable
    private void printTable() {
        try {
            table.print();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error printing table.");
            e.printStackTrace();
        }
    }

    // Method to add a new teacher
    private void addTeacher() {
        setVisible(false);
        new AddFaculty(); // Ensure AddTeacher class exists in the same package
    }

    // Method to update teacher details
    private void updateTeacher() {
        JOptionPane.showMessageDialog(this, "Update Teacher functionality not implemented yet.");
    }

    // Main method
    public static void main(String[] args) {
        new TeacherDetails();
    }
}
