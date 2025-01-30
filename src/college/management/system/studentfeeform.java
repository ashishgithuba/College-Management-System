package college.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class studentfeeform extends JFrame implements ActionListener {

    Choice crollNumber;
    JComboBox  courseBox,branchBox,semesterBox ;
    JLabel textName, textFName;
    JLabel totalAmount;
    JButton pay,update,back;

    studentfeeform() {
        // Set background color
        getContentPane().setBackground(new Color(210, 252, 251));
        setLayout(null);

        // Add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(400, 50, 500, 300);
        add(img);

        // Roll Number Label and Choice
        JLabel rollNumber = new JLabel("Select Roll Number");
        rollNumber.setBounds(40, 60, 150, 20);
        rollNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(rollNumber);

        crollNumber = new Choice();
        crollNumber.setBounds(200, 60, 150, 20);
        add(crollNumber);

        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from student");
            while (rs.next()) {
                crollNumber.add(rs.getString("rollNo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JLabel course = new JLabel("Course");
        course.setBounds(40, 180, 150, 20);
        course.setFont(new Font("Tahoma", Font.BOLD, 16));
        course.setForeground(new Color(25, 42, 86));
        add(course);

        String[] courses = {"BTech", "PhD", "BCA", "MCA", "MCom"};
        courseBox = new JComboBox<>(courses);
        courseBox.setBounds(200, 180, 150, 20);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);

        // Branch

        JLabel branch = new JLabel("Branch");
        branch.setBounds(40, 220, 150, 20);
        branch.setFont(new Font("Tahoma", Font.BOLD, 16));
        branch.setForeground(new Color(25, 42, 86));
        add(branch);

        String[] branchs= {"Computer Science", "IT", "Mechanical", "Civil", "Electrical", "ECE"};
        branchBox = new JComboBox<>(branchs);
        branchBox.setBounds(200, 220, 150, 20);
        branchBox.setBackground(Color.WHITE);
        add(branchBox);

JLabel textsemester=new JLabel( "Semester");
textsemester.setBounds(40,260,150,20);
add(textsemester);



String semester[]={"semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
semesterBox=new JComboBox(semester);
semesterBox.setBounds(200,260,150,20);
add(semesterBox);

JLabel total=new JLabel("Total Payable");
total.setBounds(40,300,150,20);
add(total);

totalAmount=new JLabel();
totalAmount.setBounds(200,300,150,20);
add(totalAmount);

update=new JButton("Update");
update.setBounds(30,380,100,25);
update.addActionListener(this);
add(update);

        pay=new JButton("pay");
        pay.setBounds(150,380,100,25);
        pay.addActionListener(this);
        add(pay);

        back=new JButton("Back");
        back.setBounds(270,380,100,25);
        back.addActionListener(this);
        add(back);


        // Name Label
        JLabel name = new JLabel("Name");
        name.setBounds(40, 100, 150, 20);
        add(name);

        textName = new JLabel();
        textName.setBounds(200, 100, 150, 20);
        add(textName);

        // Father's Name Label
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(40, 140, 150, 20);
        add(fname);

        textFName = new JLabel();
        textFName.setBounds(200, 140, 150, 20);
        add(textFName);

        // Populate initial data for the first roll number
        try {
            Conn c = new Conn();
            String query = "select * from student where rollNo = '" + crollNumber.getSelectedItem() + "'";
            ResultSet rs = c.statement.executeQuery(query);
            if (rs.next()) {
                textName.setText(rs.getString("name"));
                textFName.setText(rs.getString("fname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add ItemListener to Choice
        crollNumber.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where rollNo = '" + crollNumber.getSelectedItem() + "'";
                    ResultSet rs = c.statement.executeQuery(query);
                    if (rs.next()) {
                        textName.setText(rs.getString("name"));
                        textFName.setText(rs.getString("fname"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Frame settings
        setSize(900, 500);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==update)
{
    String course=(String) courseBox.getSelectedItem();
    String semester=(String) semesterBox.getSelectedItem();
    try
    {
        Conn c=new Conn();
ResultSet resultSet=c.statement.executeQuery("select * from fee where course='"+course+"'");
while (resultSet.next())

{
    totalAmount.setText(resultSet.getString(semester));
}
    }catch (Exception E)
    {
        E.printStackTrace();
    }
}else if (e.getSource()==pay)
{
    String rollno=crollNumber.getSelectedItem();
    String course=(String) courseBox.getSelectedItem();
    String semester=(String)semesterBox.getSelectedItem();
    String branch=(String)branchBox.getSelectedItem();
    String total=totalAmount.getText();
    try {

            Conn c=new Conn();
            String query="insert into feecollege values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
            c.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"fee Submitted successfull");

        }catch(Exception E)
    {
        E.printStackTrace();
    }
}else {
    setVisible(false);
}

    }

    public static void main(String[] args) {
        new studentfeeform();
    }
}
