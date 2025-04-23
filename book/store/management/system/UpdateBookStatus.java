package book.store.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateBookStatus extends JFrame implements ActionListener {
    JButton back, update, check;
    JTextField tfbook, tfname, tfavailable;
    Choice ccustomer;
    UpdateBookStatus()  {
        
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
       
      JLabel text = new JLabel("Update Book Status");
      text.setFont(new Font("Tahoma", Font.PLAIN, 25));
      text.setBounds(30, 20, 250, 30);
      text.setForeground(Color.BLUE);
      add(text);
      
      JLabel lblid = new JLabel ("Customer Id");
      lblid.setBounds(30, 90, 150, 25);
      add(lblid);
      
      ccustomer = new Choice();
      ccustomer.setBounds(200, 90, 150, 25);
      add(ccustomer);
      
      
      try {
          Conn c = new Conn();
          ResultSet rs = c.s.executeQuery("select * from customer");
          while(rs.next()){
              ccustomer.add(rs.getString("number"));
          }
      }catch (Exception e){
          e.printStackTrace();
      }
      
      

      
        JLabel lblbookid = new JLabel("Book Id");
        lblbookid.setBounds(30, 150, 100, 20);
        add(lblbookid);
        
        tfbook = new JTextField();
        tfbook.setBounds(200, 150, 150, 25);
        add(tfbook);

        
        
        JLabel lblbookname = new JLabel("Book Name");
        lblbookname.setBounds(30, 210, 100, 20);
        add(lblbookname);
    
        tfname = new JTextField();
        tfname.setBounds(200, 210, 150, 25);
        add(tfname);

        
        
        
        JLabel lblavailability = new JLabel("Availability");
        lblavailability.setBounds(30, 270, 100, 20);
        add(lblavailability);
        
        tfavailable= new JTextField();
        tfavailable.setBounds(200, 270, 150, 25);
        add(tfavailable);

            
       
             
      check = new JButton("Check");
      check.setBackground(Color.BLACK);
      check.setForeground(Color.WHITE);
      check.addActionListener(this);
      check.setBounds(30, 350, 100, 30);
      add(check);
      
      
      update = new JButton("Update");
      update.setBackground(Color.BLACK);
      update.setForeground(Color.WHITE);
      update.addActionListener(this);
      update.setBounds(150, 350, 100, 30);
      add(update);
      
      
      back = new JButton("Back");
      back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
      back.addActionListener(this);
      back.setBounds(270, 350, 100, 30);
      add(back);
      
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpic1.jpg"));
      Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(400, 50, 500, 300);
      add(image);
      

      setBounds(300, 200, 980, 450);
      setVisible(true);        

}

    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource () == check){
                String id = ccustomer.getSelectedItem();
                String query = "select * from customer  where number  = '"+id+"'";
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()){
                        tfbook.setText(rs.getString("book"));
                    }
                   
                    ResultSet rs2 = c.s.executeQuery("select * from book where bookid =  '"+tfbook.getText()+"'");
                    while(rs2.next()){
                        tfname.setText(rs2.getString ("bookname"));
                        tfavailable.setText(rs2.getString("availability"));   
                    }
                               
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource () == update ){
            String number = ccustomer.getSelectedItem();
            String book = tfbook.getText();
            String name = tfname.getText();
            String available = tfavailable.getText();
            
            try {
                Conn c = new Conn();
                c.s.executeUpdate("update book set availability = '"+available+"', bookname = '"+name+"' where bookid = '"+book+"' ");
                
                JOptionPane.showMessageDialog(null, "Data Update Successfully");
                
                
             setVisible(false);
             new Reception();
                
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
             new Reception();
        }
    }
    
    
    
public static void main (String[] args){
  new UpdateBookStatus();
}
}

