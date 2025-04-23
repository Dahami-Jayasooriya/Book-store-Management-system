package book.store.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class BookStoreManagementSystem extends JFrame implements ActionListener{
    
    BookStoreManagementSystem() {
        setSize(1366, 565);
        setLocation(100, 100);
        setBounds(100, 100, 1366, 565);
        setLayout(null);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/mainpic5.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1400, 600);
        add(image);
        
        JLabel text = new JLabel("BOOK  STORE  MANAGEMENT  SYSTEM");
        text.setBounds(150,10,1000,80);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);
        
        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN, 24));
        image.add(next);
        
         
        setVisible(true);
        
        
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
             try{
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    
    
   
    public static void main(String[] args){
        new BookStoreManagementSystem();
    }
}
