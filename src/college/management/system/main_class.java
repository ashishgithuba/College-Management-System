package college.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    main_class() {
        // Set background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/firstol.png"));
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1500, 750); // Set the bounds for the image
        add(img);

        // Create menu bar
        JMenuBar mb = new JMenuBar();

        // New Information Menu
        JMenu newInfo = new JMenu("New Information");
        newInfo.setForeground(Color.BLACK);
        mb.add(newInfo);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.addActionListener(this);
        newInfo.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.addActionListener(this);
        newInfo.add(studentInfo);

        // View Details Menu
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.BLACK);
        mb.add(details);

        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.addActionListener(this);
        details.add(studentDetails);

        // Apply Leave Menu
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLACK);
        mb.add(leave);

        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        // Leave Details Menu
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.BLACK);
        mb.add(leaveDetails);

        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        // Examinations Menu
        JMenu exams = new JMenu("Examinations");
        exams.setForeground(Color.BLACK);
        mb.add(exams);

        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.addActionListener(this);
        exams.add(enterMarks);

        JMenuItem examResults = new JMenuItem("Examination Results");
        examResults.addActionListener(this);
        exams.add(examResults);

        // Update Information Menu
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.BLACK);
        mb.add(updateInfo);

        JMenuItem updateFaculty = new JMenuItem("Update Faculty Details");
        updateFaculty.addActionListener(this);
        updateInfo.add(updateFaculty);

        JMenuItem updateStudent = new JMenuItem("Update Student Details");
        updateStudent.addActionListener(this);
        updateInfo.add(updateStudent);

        // Fee Details Menu
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLACK);
        mb.add(fee);

        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.addActionListener(this);
        fee.add(feeStructure);

        JMenuItem studentFeeForm = new JMenuItem("Student Fee Form");
        studentFeeForm.addActionListener(this);
        fee.add(studentFeeForm);

        // Utility Menu
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLACK);
        mb.add(utility);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.addActionListener(this);
        utility.add(notepad);

        // About Menu
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLACK);
        mb.add(about);

        JMenuItem aboutApp = new JMenuItem("About");
        aboutApp.addActionListener(this);
        about.add(aboutApp);

        // Exit Menu
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLACK);
        mb.add(exit);

        JMenuItem exitApp = new JMenuItem("Exit");
        exitApp.addActionListener(this);
        exit.add(exitApp);

        setJMenuBar(mb);

        // Frame properties
        setSize(1540, 850);
        setLocation(0, 0);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "New Faculty Information":
                new AddFaculty(); // Ensure this class exists
                break;

            case "New Student Information":
                new AddStudent(); // Ensure this class exists
                break;

            case "View Faculty Details":
                new TeacherDetails(); // Ensure this class exists
                break;

            case "View Student Details":
                new StudentDetails(); // Ensure this class exists
                break;

            case "Faculty Leave":
                new TeacherLeave(); // Ensure this class exists
                break;

            case "Student Leave":
                new StudentLeave(); // Ensure this class exists
                break;

            case "Faculty Leave Details":
                new TeacherLeaveDetails(); // Ensure this class exists
                break;

            case "Student Leave Details":
                new StudentLeaveDetails(); // Ensure this class exists
                break;

            case "Enter Marks":
                new EnterMarks(); // Ensure this class exists
                break;

            case "Examination Results":
                new ExaminationDetails(); // Ensure this class exists
                break;

            case "Update Faculty Details":
                new UpdateTeacher(); // Ensure this class exists
                break;

            case "Update Student Details":
                new updateStudents(); // Ensure this class exists
                break;

            case "Fee Structure":
                new FeeStructure(); // Ensure this class exists
                break;

            case "Student Fee Form":
                new studentfeeform(); // Ensure this class exists
                break;

            case "Calculator":
                try {
                    Runtime.getRuntime().exec("calc.exe"); // Open Calculator
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;

            case "Notepad":
                try {
                    Runtime.getRuntime().exec("notepad.exe"); // Open Notepad
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;

            case "About":
                new About(); // Ensure this class exists
                break;

            case "Exit":
                System.exit(0); // Exit the application
                break;

            default:
                JOptionPane.showMessageDialog(this, "Unknown action: " + command);
        }
    }

    public static void main(String[] args) {
        new main_class();
    }
}
