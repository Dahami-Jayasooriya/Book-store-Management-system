package book.store.management.system;



import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField tfnumber, tfid, tfname, tfaddress;
    JRadioButton rmale, rfemale;
    Choice cbook;
    JLabel checkintime;
    JButton add, back;

    AddCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setFont(new Font("Raleway", Font.PLAIN, 20));
        text.setBounds(100, 20, 300, 30);
        add(text);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Raleway", Font.PLAIN, 20));
        lblname.setBounds(35, 80, 100, 20);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 80, 150, 25);
        add(tfname);

        JLabel lblid = new JLabel("ID No");
        lblid.setFont(new Font("Raleway", Font.PLAIN, 20));
        lblid.setBounds(35, 120, 100, 20);
        add(lblid);
      
        tfid = new JTextField();
        tfid.setBounds(200, 120, 150, 25);
        add(tfid);

        JLabel lblnumber = new JLabel("Mobile");
        lblnumber.setFont(new Font("Raleway", Font.PLAIN, 20));
        lblnumber.setBounds(35, 160, 100, 20);
        add(lblnumber);
      
        tfnumber = new JTextField();
        tfnumber.setBounds(200, 160, 150, 25);
        add(tfnumber);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(35, 200, 100, 20);
        lblgender.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblgender);
      
        rmale = new JRadioButton("Male");
        rmale.setBounds(200, 200, 60, 25);
        rmale.setBackground(Color.WHITE);
        add(rmale);
      
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(270, 200, 100, 25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rmale);
        genderGroup.add(rfemale);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setFont(new Font("Raleway", Font.PLAIN, 20));
        lbladdress.setBounds(35, 240, 100, 20);
        add(lbladdress);
      
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 240, 150, 25);
        add(tfaddress);
      
        JLabel lblbook = new JLabel("Book Id");
        lblbook.setFont(new Font("Raleway", Font.PLAIN, 20));
        lblbook.setBounds(35, 280, 100, 20);
        add(lblbook);
      
        cbook = new Choice();
      
        try {
            Conn conn = new Conn();
            String query = "select * from book where availability = 'available'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                cbook.add(rs.getString("bookid"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
      
        cbook.setBounds(200, 280, 150, 25);
        add(cbook);

        Date date = new Date();
      
        JLabel lbldate = new JLabel("Entry date");
        lbldate.setFont(new Font("Raleway", Font.PLAIN, 20));
        lbldate.setBounds(35, 320, 100, 20);
        add(lbldate);
      
        checkintime = new JLabel("" + date);
        checkintime.setBounds(200, 320, 150, 25);
        checkintime.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(checkintime);

        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50, 410, 120, 30);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 410, 120, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/pic6.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 300, 400);
        add(image);

        setBounds(350, 200, 800, 550);
        setVisible(true);        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {        
            String name = tfname.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String gender = null;
             
            if (rmale.isSelected()) {
                gender = "Male";                        
            } else {
                gender = "Female";
            }
             
            String address = tfaddress.getText();
            String book = cbook.getSelectedItem();
            String date = checkintime.getText();
             
            try {
                String query = "insert into customer values('" + name + "', '" + id + "', '" + number + "', '" + gender + "', '" + address + "', '" + book + "', '" + date + "')";
                String query2 = "update book set availability = 'Occupied' where bookid = '" + book + "' ";
                 
                Conn conn = new Conn();
                 
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                 
                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
                 
                setVisible(false);
                new Reception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }

}

