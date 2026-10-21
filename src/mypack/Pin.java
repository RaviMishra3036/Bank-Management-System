/*
 * Bank Management System
 * Original author: Ravi Mishra
 * Copyright (c) 2026 Ravi Mishra
 */

package mypack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Pin extends JFrame implements ActionListener
{
	String pin;
	JButton submit,back;
	
	
	JPasswordField p1,p2;
	
	Pin(String pin) {
		
		this.pin = pin;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm.png"));
		Image i2 = i1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1366, 768);
		add(image);
		
		JLabel label = new JLabel("CHANGE YOUR PIN");
		label.setBounds(450, 150, 380, 30);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Times New Roman", Font.BOLD, 24));
		image.add(label);
		
				
		JLabel label1 = new JLabel("Create New PIN :");
		label1.setBounds(330, 200, 380, 30);
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		image.add(label1);
		
		p1 = new JPasswordField();
		p1.setBounds(460, 200, 180, 25);
		p1.setForeground(Color.BLACK);
		p1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		image.add(p1);
		
		JLabel label2 = new JLabel("Confirm PIN :");
		label2.setBounds(330, 240, 380, 30);
		label2.setForeground(Color.WHITE);
		label2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		image.add(label2);
		

		p2 = new JPasswordField();
		p2.setBounds(460, 240, 180, 25);
		p2.setForeground(Color.BLACK);
		p2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		image.add(p2);
		
		
		submit = new JButton("Change");
		submit.setBounds(690, 320, 100, 33);
		submit.setBackground(new Color(125, 255, 255));
		submit.addActionListener(this);
		image.add(submit);
		
		back = new JButton("Back");
		back.setBounds(690, 370, 100, 33);
		back.setBackground(new Color(125, 255, 255));
		back.addActionListener(this);
		image.add(back);
		
		setSize(1366 , 768);
		setLocation(80,30);
		setUndecorated(true);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			
			String pin1 = p1.getText();
			String pin2 = p2.getText(); 
			
			if(e.getSource()==submit) {
				if(pin1.equals("")) {
					 JOptionPane.showMessageDialog(null,"Enter New PIN");
	                 return;
				}
				if (pin2.equals("")){
	                    JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
	                    return;
	            }
				
				if(!pin1.equals(pin2)) {
					 JOptionPane.showMessageDialog(null,"Entered PIN does not match");
		             return;
				}
				 
				 database db = new database();
				 
				 String q1 = "update amount set pin = '"+pin1+"' where pin = '"+pin+"'";
	             String q2 = "update login set pin_number = '"+pin1+"' where pin_number = '"+pin+"'";
	             String q3 = "update signupthree set pin_number = '"+pin1+"' where pin_number = '"+pin+"'";

	             db.statement.executeUpdate(q1);
	             db.statement.executeUpdate(q2);
	             db.statement.executeUpdate(q3);

	             JOptionPane.showMessageDialog(null,"PIN changed successfully");
	             setVisible(false);
	             new Main(pin1);
			}
			else if (e.getSource()==back) {
                new Main(pin);
                setVisible(false);
            }		
		} 
		catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Pin("");
	}
}
