package book.store.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchBook extends JFrame implements ActionListener {
    JTable table;
    JButton back, submit;
    JComboBox booktype;
    JCheckBox available;
    
    SearchBook()  {
        
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
       
      JLabel text = new JLabel("Search for Book");
      text.setFont(new Font("Tahoma", Font.PLAIN, 20));
      text.setBounds(400, 30, 200, 30);
      add(text);
      
      JLabel lblbook = new JLabel ("Book Type");
      lblbook.setBounds(50, 100, 100, 20);
      add(lblbook);
      
      booktype = new JComboBox(new String[] {"Children's  book", "Short stories", "Detective stories", "Romanse novels", "Historical novals"});
      booktype.setBounds(150, 100, 150, 25);
      booktype.setBackground(Color.WHITE);
      add(booktype);
      
      available = new JCheckBox("only display Available");
      available.setBounds(650, 100, 150, 25);
      available.setBackground(Color.WHITE);
      add(available);

      
      JLabel l1 = new JLabel("Book Id");
      l1.setBounds(50, 160, 100, 20);
      add(l1);
      
      JLabel l2 = new JLabel("Book Name");
      l2.setBounds(200, 160, 100, 20);
      add(l2);

      
      JLabel l3 = new JLabel("Availability");
      l3.setBounds(400, 160, 100, 20);
      add(l3);

      JLabel l4 = new JLabel("Book Type");
      l4.setBounds(550, 160, 100, 20);
      add(l4);

      JLabel l5 = new JLabel("Book price");
      l5.setBounds(700, 160, 100, 20);
      add(l5);

      JLabel l6 = new JLabel("Author");
      l6.setBounds(850, 160, 100, 20);
      add(l6);


      
      
      
      table = new JTable();
      table.setBounds(0, 200, 1000, 300);
      add(table);
      
      
      
      try{
          Conn c = new Conn();
          ResultSet rs = c.s.executeQuery("select * from book");
          table.setModel(DbUtils.resultSetToTableModel(rs));
      }catch (Exception e){
          e.printStackTrace();
      }
      
      
      submit = new JButton("Submit");
      submit.setBackground(Color.BLACK);
      submit.setForeground(Color.WHITE);
      submit.addActionListener(this);
      submit.setBounds(300, 520, 120, 30);
      add(submit);
      
      
      
      back = new JButton("Back");
      back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
      back.addActionListener(this);
      back.setBounds(500, 520, 120, 30);
      add(back);

      setBounds(300, 200, 1000, 600);
      setVisible(true);        

}

    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource () == submit){
            try {
                String query = "select * from book where booktype = '"+booktype.getSelectedItem()+"'";
                String query2 = "select * from book  where availability = 'Available'AND booktype = '"+booktype.getSelectedItem()+"'";
                
                Conn conn = new Conn();
                ResultSet rs;
                if (available.isSelected()){
                    rs = conn.s.executeQuery(query2);
                }else {
                    rs = conn.s.executeQuery(query2);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch (Exception e){
                e.printStackTrace();
            }
       }else {
             setVisible(false);
             new Reception();
        }
    }
    
    
    
public static void main (String[] args){
  new SearchBook();
}
}

