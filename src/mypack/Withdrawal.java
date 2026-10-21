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
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener
{
	String pin;
	JTextField text;
	JButton submit,back;
	
	public Withdrawal(String pin) {
		super("Deposit");
		
		this.pin = pin;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm.png"));
		Image i2 = i1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1366, 768);
		add(image);
		
		JLabel label = new JLabel("MAXIMUM WITHDRAWAL AMOUNT IS RS-10,000");
		label.setBounds(375, 150, 380, 30);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		image.add(label);
		
		JLabel label1 = new JLabel("Please enter your amount");
		label1.setBounds(480, 170, 380, 30);
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		image.add(label1);
		
		text = new JTextField();
		text.setBounds(390, 200, 320, 30);
		text.setFont(new Font("Times New Roman", Font.BOLD, 12));
		image.add(text);
		
		
		submit = new JButton("Withdrawal");
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
		if(e.getSource() == submit) {
			try { 
				String amount = text.getText();
				Date date = new Date();
				
				if(text.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
				}
				else {
					database db = new database();
					ResultSet resultSet = db.statement.executeQuery("select * from amount where pin = '"+pin+"'");
					int balance = 0;
					while (resultSet.next()) {
						if(resultSet.getString("type").equals("Deposit")) {
							balance += Integer.parseInt(resultSet.getString("amount"));
						}
						else {
							balance -= Integer.parseInt(resultSet.getString("amount"));
						}
					}
					if (balance < Integer.parseInt(amount)) {
						JOptionPane.showMessageDialog(null, "Insuffient Balance");
						return;
					}
				
					db.statement.executeUpdate("insert into amount values('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "' )");
					JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
					setVisible(false);
					new Main(pin);
				}
			} 
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		else if(e.getSource()==back) {
			setVisible(false);
			new Main(pin);
		}
	}
	public static void main(String[] args) {
		new Withdrawal("");
	}
}
