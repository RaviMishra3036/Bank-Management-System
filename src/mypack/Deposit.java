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
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener
{
	String pin;
	JTextField text;
	JButton submit,back;
	
	public Deposit(String pin) {
		super("Deposit");
		
		this.pin = pin;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm.png"));
		Image i2 = i1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1366, 768);
		add(image);
		
		JLabel label = new JLabel("ENETR AMOUNT YOU WANT TO DEPOSIT");
		label.setBounds(390, 150, 350, 30);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		image.add(label);
		
		text = new JTextField();
		text.setBounds(390, 200, 320, 30);
		text.setFont(new Font("Times New Roman", Font.BOLD, 12));
		image.add(text);
		
		
		submit = new JButton("Deposit");
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
			String amount = text.getText();
			Date date = new Date();
			if(e.getSource() == submit) {
				if(text.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Deposit");
				}
				else {
					database db = new database();
					db.statement.executeUpdate("insert into amount values('"+pin+"', '"+date+"','Deposit', '"+amount+"')");
					JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Main(pin);
				}
			}else if(e.getSource()==back) {
				setVisible(false);
				new Main(pin);
			}
		}
		catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new Deposit("");
	}
}
