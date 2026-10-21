package mypack;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini_Statement extends JFrame implements ActionListener
{
	String pin;
    JButton button;
    public Mini_Statement(String pin) 
    {	
        this.pin = pin;
        
        getContentPane().setBackground(new Color(0, 180, 196));
        setSize(400,600);
        setLocation(490, 120);
        setUndecorated(true);
        setLayout(null);
        

        JLabel label1 = new JLabel();
        label1.setBounds(20,140,400,200);
        label1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(label1);

        JLabel label2 = new JLabel("SBI Mini Statement");
        label2.setFont(new Font("Times New Roman", Font.BOLD, 24));
        label2.setBounds(100,20,250,20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20,80,300,20);
        label3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(20,400,300,20);
        label4.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(label4);

        try{
            database db = new database();
            ResultSet resultSet = db.statement.executeQuery("select * from login where pin_number = '"+pin+"'");
            while (resultSet.next()){
                label3.setText("Card Number:  "+ resultSet.getString("card_number").substring(0,4) + "XXXXXXXX"+ resultSet.getString("card_number").substring(12));
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

        try{
            int balance =0;
            database db = new database();
            ResultSet resultSet = db.statement.executeQuery("select * from amount where pin = '"+pin+"'");
            while (resultSet.next()){

                label1.setText(label1.getText() + "<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+ "<br><br><html>");

                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            label4.setText("Your Total Balance is Rs "+balance);
        }catch (Exception e){
            e.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(150,500,100,25);
        button.addActionListener(this);
        button.setBackground(new Color(40, 43, 191));
        button.setForeground(Color.WHITE);
        add(button);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	setVisible(false);
    	
    }
    public static void main(String[] args) {
		new Mini_Statement("");
	}
}
