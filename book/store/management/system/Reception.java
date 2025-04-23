package book.store.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {
    
    JButton newCustomer, books, allEmployee, customers, bookstatus, searchbook, logout;
    
    Reception(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10, 50, 200, 30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        books = new JButton("Books");
        books.setBounds(10, 110, 200, 30);
        books.setBackground(Color.BLACK);
        books.setForeground(Color.WHITE);
        books.addActionListener(this);
        add(books);

        allEmployee = new JButton("All Employee");
        allEmployee.setBounds(10, 170, 200, 30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.addActionListener(this);
        add(allEmployee);

        customers = new JButton("Customer Info");
        customers.setBounds(10, 230, 200, 30);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        customers.addActionListener(this);
        add(customers);
        
        bookstatus = new JButton("Update Book Status");
        bookstatus.setBounds(10, 290, 200, 30);
        bookstatus.setBackground(Color.BLACK);
        bookstatus.setForeground(Color.WHITE);
        bookstatus.addActionListener(this);
        add(bookstatus);
        
        
        searchbook = new JButton("Search Book");
        searchbook.setBounds(10, 350, 200, 30);
        searchbook.setBackground(Color.BLACK);
        searchbook.setForeground(Color.WHITE);
        searchbook.addActionListener(this);
        add(searchbook);
        
        logout = new JButton("Logout");
        logout.setBounds(10, 410, 200, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo1.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 30, 500, 470);
        add(image);
        
        setBounds(350, 200, 800, 570);
        setVisible(true);      
    }
    
   

        public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == newCustomer){
            setVisible(false);
            new AddCustomer();
        }else if (ae.getSource() == books){
            setVisible(false);
            new Book();
        }else if (ae.getSource() == allEmployee){
            setVisible(false);
            new EmployeeInfo();
        }else if (ae.getSource() == customers){
            setVisible(false);
            new CustomerInfo();
        }else if (ae.getSource() == searchbook){
            setVisible(false);
            new SearchBook ();
        }else if (ae.getSource() == bookstatus) {
            setVisible (false);
            new UpdateBookStatus ();
        }else if (ae.getSource () == logout){
            setVisible(false);
            System.exit(0);
        }
    }
    
    
    public static void main(String[] args){
        new Reception();
    }
}