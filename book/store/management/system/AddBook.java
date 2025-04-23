package book.store.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBook extends JFrame implements ActionListener{
    
    JButton add, cancel;
    JTextField tfbook, tfname, tfprice, tfauthor;
    JComboBox typecombo, availablecombo;
    AddBook (){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Books");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        
        JLabel lblbookid = new JLabel("BOOK ID");
        lblbookid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblbookid.setBounds(60, 80, 120, 30);
        add(lblbookid);
        
        tfbook = new JTextField();
        tfbook.setBounds(200, 80, 150, 30);
        add(tfbook);

        
        
        JLabel lblbookname = new JLabel("BOOK NAME");
        lblbookname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblbookname.setBounds(60, 130, 120, 30);
        add(lblbookname);
    
        tfname = new JTextField();
        tfname.setBounds(200, 130, 150, 30);
        add(tfname);

        
        
        
        JLabel lblavailability = new JLabel("AVAILABLE");
        lblavailability.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailability.setBounds(60, 180, 120, 30);
        add(lblavailability);
        
        String availableOPtions[] = { "Available", "Occupied"};
        availablecombo = new JComboBox(availableOPtions);
        availablecombo.setBounds(200, 180, 150, 30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        

        
        JLabel lbltype = new JLabel("BOOK TYPE");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltype.setBounds(60, 230, 120, 30);
        add(lbltype);
        
        String typeOPtions[] = { "Children's  book", "Short stories", "Detective stories", "Romanse novels", "Historical novals"};
        typecombo = new JComboBox(typeOPtions);
        typecombo.setBounds(200, 230, 150, 30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);
        
      
        
        JLabel lblprice = new JLabel("BOOK PRICE");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblprice.setBounds(60, 280, 120, 30);
        add(lblprice);
        
        tfprice = new JTextField();
        tfprice.setBounds(200, 280, 150, 30);
        add(tfprice);
        
        
        JLabel lblauthor = new JLabel("ADD AUTHORS");
        lblauthor.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblauthor.setBounds(60, 330, 120, 30);
        add(lblauthor);

        
        tfauthor = new JTextField();
        tfauthor.setBounds(200, 330, 150, 30);
        add(tfauthor);
        
        
        add = new JButton("Add Book");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 380, 130, 30);
        add.addActionListener(this);
        add(add);
        
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(230, 380, 130, 30);
        cancel.addActionListener(this);

        
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/picture2.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 30, 500, 300);
        add(image);
        setBounds(330, 200, 940, 470);
        setVisible(true);   
    }
    
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == add){
            String bookid = tfbook.getText();
            String bookname = tfname.getText();
            String availability = (String) availablecombo.getSelectedItem();
            String type = (String) typecombo.getSelectedItem();
            String price = tfprice.getText();
            String author = tfauthor.getText();

                        
            try{
                Conn conn = new Conn();
                String str = "insert into book values('"+bookid+"', '"+bookname+"', '"+availability+"',  '"+type+"', '"+price+"', '"+author+"' )";
                
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "New book Added Successfully");
                
                setVisible(false);
                
            }catch (Exception e){
                e.printStackTrace();
            }
            
            
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new AddBook();
    }
    
}
