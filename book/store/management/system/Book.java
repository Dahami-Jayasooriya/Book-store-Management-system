package book.store.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Book extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    
    Book()  {
        
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
       

          
      JLabel l1 = new JLabel("Book Id");
      l1.setBounds(30, 10, 100, 20);
      add(l1);
      
      JLabel l2 = new JLabel("Book Name");
      l2.setBounds(200, 10, 100, 20);
      add(l2);

      
      JLabel l3 = new JLabel("Availability");
      l3.setBounds(370, 10, 100, 20);
      add(l3);

      JLabel l4 = new JLabel("Book Type");
      l4.setBounds(540, 10, 100, 20);
      add(l4);

      JLabel l5 = new JLabel("Book price");
      l5.setBounds(710, 10, 100, 20);
      add(l5);

      JLabel l6 = new JLabel("Author");
      l6.setBounds(880, 10, 100, 20);
      add(l6);


      
      
      
      table = new JTable();
      table.setBounds(0, 40, 1000, 400);
      add(table);
      
      
      
      try{
          Conn c = new Conn();
          ResultSet rs = c.s.executeQuery("select * from book");
          table.setModel(DbUtils.resultSetToTableModel(rs));
      }catch (Exception e){
          e.printStackTrace();
      }
      
      back = new JButton("Back");
      back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
      back.addActionListener(this);
      back.setBounds(200, 500, 120, 30);
      add(back);

      setBounds(300, 200, 1050, 600);
      setVisible(true);        

}

    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
public static void main (String[] args){
  new Book();
}
}

