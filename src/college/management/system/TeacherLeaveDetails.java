package college.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeaveDetails extends JFrame implements ActionListener {
    Choice choiceEmpID;
    JTable table;
JButton search,cancle,print;
    TeacherLeaveDetails() {
        getContentPane().setBackground(new Color(250, 172, 206));

        JLabel heading = new JLabel("Search By Employee ID");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        choiceEmpID = new Choice();
        choiceEmpID.setBounds(180, 20, 150, 20);
        add(choiceEmpID);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select empID from teacher");
            while (resultSet.next()) {
                choiceEmpID.add(resultSet.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 100, 900, 600);
        add(scrollPane);

search=new JButton("search");
search.setBounds(20,70,80,20);
search.addActionListener(this);
add(search);

        print=new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        cancle=new JButton("cancle");
        cancle.setBounds(220,70,80,20);
        cancle.addActionListener(this);
        add(cancle);


        setSize(900, 700);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==search)
       {
           String query="select * from teacherleave where empID ='"+choiceEmpID.getSelectedItem()+"'";
           try
           {
               Conn c=new Conn();
               ResultSet resultSet=c.statement.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(resultSet));
           }
           catch (Exception E)
           {
               E.printStackTrace();
           }
       } else if (e.getSource()==print) {
           try
           {
               table.print();
           }catch (Exception E)
           {
               E.printStackTrace();
           }

           
       }
       else{
           setVisible(false);
       }

    }

    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }
}
