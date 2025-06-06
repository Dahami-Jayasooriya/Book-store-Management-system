package book.store.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    
    Dashboard() {
        setBounds(0, 0, 1550, 1000);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/picture1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);
        
        JLabel text = new JLabel("THE BOOK STORE WELCOMES YOU");
        text.setBounds(400, 80, 1000, 50);
        text.setFont(new Font("Tahoma", Font.PLAIN, 46));
        text.setForeground(Color.BLACK);
        image.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        image.add(mb);
        
        JMenu BookStore = new JMenu("BookStore Management");
        BookStore.setForeground(Color.RED);
        mb.add(BookStore);
        
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this); 
        BookStore.add(reception);
        
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);
        
        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this); 
        admin.add(addemployee);
        
        JMenuItem addbook = new JMenuItem("ADD BOOK");
        addbook.addActionListener(this); 
        admin.add(addbook);
        
        setVisible(true);            
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("ADD EMPLOYEE")) {
            new AddEmployee();
        } else if (ae.getActionCommand().equals("ADD BOOK")) {
            new AddBook();
        } else if (ae.getActionCommand().equals("RECEPTION")) {
            new Reception();
        }
    }
    
    public static void main (String[] args) {
        new Dashboard();
    }   
}