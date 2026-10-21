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
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Fast_Case extends JFrame implements ActionListener
{
	String pin;
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	
	Fast_Case(String pin) {
		
		this.pin = pin;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm.png"));
		Image i2 = i1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1366, 768);
		add(image);
		
		JLabel lable1 = new JLabel("Select Withdrawal Amount");
		lable1.setBounds(380, 140, 400, 30);
		lable1.setForeground(Color.WHITE);
		lable1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		image.add(lable1);
		
		Font  font = new Font("Times New Roman", Font.BOLD, 18);
		
		b1 = new JButton("Rs. 100");
		b1.setBounds(295, 230, 130, 30);
		b1.setBackground(Color.BLUE);
		b1.setForeground(Color.WHITE);
		b1.setFont(font);
		b1.addActionListener(this);
		image.add(b1);
		
		
		b2 = new JButton("Rs. 300");
		b2.setBounds(615, 230, 175, 30);
		b2.setBackground(Color.BLUE);
		b2.setForeground(Color.WHITE);
		b2.setFont(font);
		b2.addActionListener(this);
		image.add(b2);
		
		
		b3 = new JButton("Rs. 500");
		b3.setBounds(295, 275, 130, 30);
		b3.setBackground(Color.BLUE);
		b3.setForeground(Color.WHITE);
		b3.setFont(font);
		b3.addActionListener(this);
		image.add(b3);
		
		
		b4 = new JButton("Rs. 1000");
		b4.setBounds(615, 275, 175, 30);
		b4.setBackground(Color.BLUE);
		b4.setForeground(Color.WHITE);
		b4.setFont(font);
		b4 .addActionListener(this);
		image.add(b4);
		

		b5 = new JButton("Rs. 2000");
		b5.setBounds(295, 325, 130, 30);
		b5.setBackground(Color.BLUE);
		b5.setForeground(Color.WHITE);
		b5.setFont(font);
		b5.addActionListener(this);
		image.add(b5);
		
		
		b6 = new JButton("Rs. 5000");
		b6.setBounds(615, 325, 175, 30);
		b6.setBackground(Color.BLUE);
		b6.setForeground(Color.WHITE);
		b6.setFont(font);
		b6.addActionListener(this);
		image.add(b6);
		
		b7 = new JButton("Rs. 10000");
		b7.setBounds(295, 370, 130, 30);
		b7.setBackground(Color.BLUE);
		b7.setForeground(Color.WHITE);
		b7.setFont(font);
		b7.addActionListener(this);
		image.add(b7);
		
		b8 = new JButton("Back");
		b8.setBounds(615, 370, 175, 30);
		b8.setBackground(Color.BLUE);
		b8.setForeground(Color.WHITE);
		b8.setFont(font);
		b8.addActionListener(this);
		image.add(b8);
		
		
		setSize(1366 , 768);
		setLocation(80,30);
		setUndecorated(true);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b8) {
			setVisible(false);
			new Main(pin);
		}else {
			String amount = ((JButton)e.getSource()).getText().substring(4);
			database db = new database();
			Date date = new Date();
			try {
				ResultSet resultSet = db.statement.executeQuery("select * from amount where pin ='"+pin+"'");
				int balance =0;
				while (resultSet.next()) {
					if(resultSet.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(resultSet.getString("amount"));
					}
					else {
						balance -= Integer.parseInt(resultSet.getString("amount"));
					}
				}
				String num = "17";
				
				if (e.getSource() != b7 && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }
				db.statement.executeUpdate("insert into amount values('"+pin+"','"+date+"', 'withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
			} 
			catch (Exception e2) {
				e2.printStackTrace();
			}
			 setVisible(false);
	         new Main(pin);
		}
		
	}
	public static void main(String[] args) {
		new Fast_Case("");
	}
}
