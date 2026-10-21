package mypack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JTextField t1;
	JPasswordField pf;
	JButton btn,btn1,btn2;
	
	public Login() {
		
//		Title 
		
		super("Bank Management System");
	
//		JLabel
		
		l1 = new JLabel("Bank Management System");
		l1.setBounds(250, 5, 350, 40);
		l1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		l1.setForeground(Color.WHITE);
		this.add(l1);
		
//		JLabel
		
		l2 = new JLabel("CARD NO : ");
		l2.setBounds(50, 120, 100, 30);
		l2.setFont( new Font("Times New Roman", Font.BOLD, 16));
		l2.setForeground(Color.WHITE);
		this.add(l2);
		
//		JTextField
		
		t1 = new JTextField();
		t1.setBounds(150, 120, 150, 30);
		this.add(t1);
		
//		JLabel
		
		l3 = new JLabel("PIN : ");
		l3.setBounds(50, 160, 100, 30);
		l3.setFont( new Font("Times New Roman", Font.BOLD, 16));
		l3.setForeground(Color.WHITE);
		this.add(l3);
		
//		JTextField
		
		pf = new JPasswordField();
		pf.setBounds(150, 160, 150, 30);
		this.add(pf);
		
//		JButton
		
		btn = new JButton("SING IN");
		btn.setBounds(50, 220, 100, 30);
		btn.setFont( new Font("Times New Roman", Font.BOLD, 16));
		btn.addActionListener(this);
		this.add(btn);
		
//		JButton
		
		btn1 = new JButton("CLEAR");
		btn1.setBounds(200, 220, 100, 30);
		btn1.setFont( new Font("Times New Roman", Font.BOLD, 16));
		btn1.addActionListener(this);
		this.add(btn1);
		
//		JButton
		
		btn2 = new JButton("SING UP");
		btn2.setBounds(50, 280, 250, 30);
		btn2.setFont( new Font("Times New Roman", Font.BOLD, 16));
		btn2.addActionListener(this);
		this.add(btn2);
		
		
//		JLabel
		l4 = new JLabel("Devlop by Ravi Mishra");
		l4.setBounds(680, 400, 150, 40);
		l4.setFont( new Font("Times New Roman", Font.BOLD, 12));
		this.add(l4);
		
//		Image
		
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("Icon/bg.png"));
		Image i1 = i.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel image = new JLabel(i2);
		image.setBounds(0, 0, 850, 480);
		add(image);
		
		setSize(850,480);
		setLocation(450, 200);
//		setUndecorated(true);
		setResizable(false);
		setLayout(null);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	    try {
	        if(e.getSource() == btn) {
	            
	            database db = new database();
	            String cardno = t1.getText();
	            String pin = pf.getText();
	            
	            String q = "select * from login where card_number = '" + cardno + "' and pin_number = '" + pin + "'";
	            
	            ResultSet resultSet = db.statement.executeQuery(q);
	            if(resultSet.next()) {
	                setVisible(false);
	                new Main(pin);
	            } else {
	                JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
	            }
	        }
	        else if(e.getSource() == btn1) {
	            t1.setText("");
	            pf.setText("");
	        }
	        else if(e.getSource() == btn2){
	            new SingUp();
	            dispose();
	        }
	    }
	    catch (Exception E) {
	        E.printStackTrace();
	    }
	}
	public static void main(String[] args) {
		new Login();
	}
}
