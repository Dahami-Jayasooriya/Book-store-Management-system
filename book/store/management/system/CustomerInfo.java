package book.store.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    
    CustomerInfo()  {
        
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
       
      
      JLabel l1 = new JLabel("Name");
      l1.setBounds(10, 10, 100, 20);
      add(l1);
      
      JLabel l2 = new JLabel("Id");
      l2.setBounds(160, 10, 100, 20);
      add(l2);

      
      JLabel l3 = new JLabel("Mobile");
      l3.setBounds(290, 10, 100, 20);
      add(l3);

      JLabel l4 = new JLabel("Gender");
      l4.setBounds(410, 10, 100, 20);
      add(l4);

      JLabel l5 = new JLabel("Address");
      l5.setBounds(540, 10, 100, 20);
      add(l5);

      JLabel l6 = new JLabel("Book");
      l6.setBounds(640, 10, 100, 20);
      add(l6);


      JLabel l7 = new JLabel("Entry date");
      l7.setBounds(790, 10, 100, 20);
      add(l7);

      
      
      table = new JTable();
      table.setBounds(0, 40, 1000, 400);
      add(table);
      
      
      
      try{
          Conn c = new Conn();
          ResultSet rs = c.s.executeQuery("select * from customer");
          table.setModel(DbUtils.resultSetToTableModel(rs));
      }catch (Exception e){
          e.printStackTrace();
      }
      
      back = new JButton("Back");
      back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
      back.addActionListener(this);
      back.setBounds(420, 500, 120, 30);
      add(back);

      setBounds(300, 200, 1000, 600);
      setVisible(true);        

}

    
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
public static void main (String[] args){
  new CustomerInfo();
}
}
