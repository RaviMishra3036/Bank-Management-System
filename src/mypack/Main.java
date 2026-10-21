package mypack;

/*
 * Bank Management System
 * Original author: Ravi Mishra
 * Copyright (c) 2026 Ravi Mishra
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame implements ActionListener
{
	String pin;
	
	JButton b1,b2,b3,b4,b5,b6,b7;
	
	public Main(String pin) {
		super("Main Interface - Ravi Mishra");
		
		this.pin = pin;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm.png"));
		Image i2 = i1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1366, 768);
		add(image);
		
		JLabel lable1 = new JLabel("Please select your Trans-Action");
		lable1.setBounds(380, 140, 400, 30);
		lable1.setForeground(Color.WHITE);
		lable1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		image.add(lable1);
		
		Font  font = new Font("Times New Roman", Font.BOLD, 18);
		
		b1 = new JButton("Deposit");
		b1.setBounds(295, 230, 130, 30);
		b1.setBackground(Color.BLUE);
		b1.setForeground(Color.WHITE);
		b1.setFont(font);
		b1.addActionListener(this);
		image.add(b1);
		
		
		b2 = new JButton("Case Withdrawal");
		b2.setBounds(615, 230, 175, 30);
		b2.setBackground(Color.BLUE);
		b2.setForeground(Color.WHITE);
		b2.setFont(font);
		b2.addActionListener(this);
		image.add(b2);
		
		
		b3 = new JButton("Fast Cash");
		b3.setBounds(295, 275, 130, 30);
		b3.setBackground(Color.BLUE);
		b3.setForeground(Color.WHITE);
		b3.setFont(font);
		b3.addActionListener(this);
		image.add(b3);
		
		
		b4 = new JButton("Mini  Statement");
		b4.setBounds(615, 275, 175, 30);
		b4.setBackground(Color.BLUE);
		b4.setForeground(Color.WHITE);
		b4.setFont(font);
		b4 .addActionListener(this);
		image.add(b4);
		

		b5 = new JButton("Pin Change");
		b5.setBounds(295, 325, 130, 30);
		b5.setBackground(Color.BLUE);
		b5.setForeground(Color.WHITE);
		b5.setFont(font);
		b5.addActionListener(this);
		image.add(b5);
		
		
		b6 = new JButton("Balance Enquiry");
		b6.setBounds(615, 325, 175, 30);
		b6.setBackground(Color.BLUE);
		b6.setForeground(Color.WHITE);
		b6.setFont(font);
		b6.addActionListener(this);
		image.add(b6);
		
		b7 = new JButton("Exit");
		b7.setBounds(615, 370, 175, 30);
		b7.setBackground(Color.BLUE);
		b7.setForeground(Color.WHITE);
		b7.setFont(font);
		b7.addActionListener(this);
		image.add(b7);
		
		
		setSize(1366 , 768);
		setLocation(80,30);
		setUndecorated(true);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			new Deposit(pin);
			setVisible(false);
		}else if(e.getSource() == b2) {
			new Withdrawal(pin);
			setVisible(false);
		}
		else if(e.getSource() == b3) {
			new Fast_Case(pin);
			setVisible(false);
		}
		else if(e.getSource() == b4) {
			new Mini_Statement(pin);
		}
		else if (e.getSource() == b5) {
			new Pin(pin);
			setVisible(false);
		}
		else if(e.getSource() == b6) {
			new Balance_Enquriy(pin);
			setVisible(false);
		}
		else if(e.getSource()== b7) {
			System.exit(0);
		}
		
	}
	public static void main(String[] args) {
		new Main("");
	}
}
