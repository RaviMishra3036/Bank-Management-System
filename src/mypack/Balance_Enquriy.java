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

public class Balance_Enquriy extends JFrame implements ActionListener
{
	 
	String pin;
	
	JButton back;
	
	JLabel label2;
	
	Balance_Enquriy(String pin) {
		
		this.pin = pin;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm.png"));
		Image i2 = i1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1366, 768);
		add(image);
		
		JLabel label = new JLabel("YOUR CURRENT BALANCE");
		label.setBounds(430, 150, 380, 30);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		image.add(label);
		
		JLabel label1 = new JLabel("Available Balance");
		label1.setBounds(480, 170, 380, 30);
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		image.add(label1); 
		
		label2 = new JLabel();
		label2.setBounds(480, 220, 380, 30);
		label2.setForeground(Color.WHITE);
		label2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		image.add(label2); 
		
		
		back = new JButton("Back");
		back.setBounds(690, 370, 100, 33);
		back.setBackground(new Color(125, 255, 255));
		back.addActionListener(this);
		image.add(back);
		
		 int balance =0;
	        try{
	            database db = new database();
	            ResultSet resultSet = db.statement.executeQuery("Select * from amount where pin = '"+pin+"'");
	            while (resultSet.next()){
	                if (resultSet.getString("type").equals("Deposit")){
	                    balance += Integer.parseInt(resultSet.getString("amount"));
	                }else {
	                    balance -= Integer.parseInt(resultSet.getString("amount"));
	                }
	            }
	        }catch (Exception e){
	            e.printStackTrace();
	        }

	        label2.setText(""+balance);
		
		setSize(1366 , 768);
		setLocation(80,30);
		setUndecorated(true);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
        new Main(pin);
	}
	public static void main(String[] args) {
		new Balance_Enquriy("");
	}
}
