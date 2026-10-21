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
import java.lang.classfile.instruction.NewMultiArrayInstruction;
import java.util.Random;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

//import jdk.internal.foreign.abi.LinkerOptions.FirstVariadicArg;


public class SingUp extends JFrame implements ActionListener
{
//	JLabel 
	JLabel Name,fName,mName,dob,gen,email,mar,add,city,state,pin;
	
//	JTextField
	JTextField textName,textFname,textMname,textEmail,textAdd,textCity,textState,textPin;
	
//	JDateChooser
	JDateChooser dateChooser;
	
//	JRadioButton
	JRadioButton M , F , O ,M1, M2, O1;

//	JButton

	JButton Next;

//	Using Random Number
	
	Random ran = new Random();
	long l = (ran.nextLong() % 900L) + 1000L;
	String str = " " + Math.abs(l);
	
	public SingUp() {
		super("Application From");
		
//		Image in logo
		
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("Icon/logo.png"));
		Image i1 = i.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel image = new JLabel(i2);
		image.setBounds(20,20,100,100);
		add(image);
		
//		JLabel in Application From
		
		JLabel Ap = new JLabel("Application Id : "+str);
		Ap.setBounds(450, 10, 250, 30);
		Ap.setForeground(Color.RED);
		Ap.setFont(new Font("Times New Roman", Font.BOLD, 24));
		add(Ap);
		

//		JLabel Bank Name
		
		JLabel bn= new JLabel("State Bank of India (SBI)");
		bn.setBounds(200, 50, 400, 30);
		bn.setFont(new Font("Times New Roman", Font.BOLD, 24));
		add(bn);
		
//		JLabel in Personal Details
		
		JLabel ps = new JLabel("Personal Details");
		ps.setBounds(250, 90, 200, 30);
		ps.setFont(new Font("Times New Roman", Font.BOLD, 24));
		add(ps);
		
//		JLabel in UnderLine
		
		JLabel ul = new JLabel("__________________________________________________________________________________________________________________________________");
		ul.setBounds(0, 100, 780, 30);
		add(ul);
		
//		Font 
		
		Font font = new Font("Times New Roman", Font.BOLD, 18);
		Font font1 = new  Font("Times New Roman", Font.BOLD, 14);
//		JLabel User Name
		
		Name = new JLabel("Full Name :");
		Name.setBounds(120, 150, 100, 30);
		Name.setFont(font);
		add(Name);
		
//		JTextField User Input
		textName = new JTextField();
		textName.setBounds(260, 150, 350, 30);
		textName.setFont(font1);
		add(textName);
		
//		JLabel User Father Name
		
		fName = new JLabel("Father Name :");
		fName.setBounds(120, 200, 130, 30);
		fName.setFont(font);
		add(fName);
		
//		JTextField User Input
		textFname = new JTextField();
		textFname.setBounds(260, 200, 350, 30);
		textFname.setFont(font1);
		add(textFname);

		
//		JLabel User Mother Name
		
		mName = new JLabel("Mother Name :");
		mName.setBounds(120, 250, 130, 30);
		mName.setFont(font);
		add(mName);
		
//		JTextField User Input
		textMname = new JTextField();
		textMname.setBounds(260, 250, 350, 30);
		textMname.setFont(font1);
		add(textMname);

//		JLabel User Gender Name
		
		gen = new JLabel("Gender :");
		gen.setBounds(120, 300, 130, 30);
		gen.setFont(font);
		add(gen);
		
//		JRadioButton
		
		M = new JRadioButton("Male");
		M.setBounds(260, 300, 100, 30);
		M.setFont(font);
		M.setBackground(new Color(168, 211, 227));
		add(M);
		
		F = new JRadioButton("Female");
		F.setBounds(390, 300, 100, 30);
		F.setFont(font);
		F.setBackground(new Color(168, 211, 227));
		add(F);
		
		O = new JRadioButton("Other");
		O.setBounds(540, 300, 100, 30);
		O.setFont(font);
		O.setBackground(new Color(168, 211, 227));
		add(O);
		
//		ButtonGroup
		ButtonGroup btn = new ButtonGroup();
		btn.add(M);
		btn.add(F);
		btn.add(O);
		
//		JLabel User Date Of Birth
		
		dob = new JLabel("Date Of Birth :");
		dob.setBounds(120, 350, 130, 30);
		dob.setFont(font);
		add(dob);
	
//		JDateChooser 
		dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(168, 211, 227));
        dateChooser.setBounds(260, 350, 350, 30);
        dateChooser.setFont(font1);
        add(dateChooser);

		
//		JLabel User Email id

		email = new JLabel("Email Id :");
		email.setBounds(120, 400, 130, 30);
		email.setFont(font);
		add(email);

//		JTextField Enter user email id

		textEmail = new JTextField();
		textEmail .setBounds(260, 400, 350, 30);
		textEmail .setFont(font1);
		add(textEmail );

//		JLabel Marital status

		mar = new JLabel("Marital status : ");
		mar.setBounds(120, 450, 130, 30);
		mar.setFont(font);
		add(mar);

//		JRadioButton

		M1 = new JRadioButton("Married");
		M1.setBounds(260, 450, 100, 30);
		M1.setFont(font);
		M1.setBackground(new Color(168, 211, 227));
		add(M1);

		M2 = new JRadioButton("UnMarried");
		M2.setBounds(390, 450, 150, 30);
		M2.setFont(font);
		M2.setBackground(new Color(168, 211, 227));
		add(M2);

		O1 = new JRadioButton("Other");
		O1.setBounds(540, 450, 100, 30);
		O1.setFont(font);
		O1.setBackground(new Color(168, 211, 227));
		add(O1);

//		ButtonGroup
		ButtonGroup btn1 = new ButtonGroup();
		btn1.add(M1);
		btn1.add(M2);
		btn1.add(O1);

//		JLabel Address

		add = new JLabel("Address");
		add.setBounds(120, 500, 130, 30);
		add.setFont(font);
		add(add);

//		JTextField user address

		textAdd = new JTextField();
		textAdd.setBounds(260, 500, 350, 30);
		textAdd.setFont(font1);
		add(textAdd);


//		JLabel City

		city = new JLabel("City : ");
		city.setBounds(120, 550, 130, 30);
		city.setFont(font);
		add(city);

//		JTextField user input city

		textCity = new JTextField();
		textCity.setBounds(260, 550, 350, 30);
		textCity.setFont(font1);
		add(textCity);

//		JLabel State

		state = new JLabel("State : ");
		state.setBounds(120, 600, 130, 30);
		state.setFont(font);
		add(state);

//		JTextField user State

		textState = new JTextField();
		textState.setBounds(260, 600, 350, 30);
		textState.setFont(font1);
		add(textState);

//		JLabel PIN Code

		pin = new JLabel("PIN Code : ");
		pin.setBounds(120, 650, 130, 30);
		pin.setFont(font);
		add(pin);

//		JTextField user PIN Code

		textPin = new JTextField();
		textPin.setBounds(260, 650, 350, 30);
		textPin.setFont(font1);
		add(textPin);

//		JButton next 

		Next = new JButton("Next");
		Next.setBounds(510,700,100,30);
		Next.setFont(font);
		Next.addActionListener(this);
		add(Next);

//		Display Size
		
		setSize(700, 780);
		getContentPane().setBackground(new Color(168, 211, 227));
		setLocation(430,40);
		setResizable(false);
		setLayout(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String formn = str;
		String name = textName.getText();
		String fname = textFname.getText();
		String mname = textMname.getText();
		
		String gender = null;
		if(M.isSelected()) {
			gender = "Male";
		}
		else if (F.isSelected()) {
			gender = "Female";
		}
		else if (O.isSelected()) {
			gender = "Other";
		}
		String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		
		String Email = textEmail.getText();
		
		String marital = null;
		if(M1.isSelected()) {
			marital = "Married";
		}
		else if(M2.isSelected()) {
			marital = "UnMarried";
		}
		else if (O1.isSelected()) {
			marital = "Other";
		}
		
		String add = textAdd.getText();
		String city = textCity.getText();
		String state = textState.getText();
		String pin = textPin.getText(); 
		
		try {
			if(textName.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Fill all the fields");
			}
			else {
				database db = new database();
				String q = "insert into signup values('"+formn+"', '"+name+"','"+fname+"','"+mname+"','"+gender+"','"+dob+"','"+Email+"','"+marital+"', '"+add+"', '"+city+"','"+state+"','"+pin+"')";
				db.statement.executeUpdate(q);
				new SingUp2(str);   
				this.setVisible(false);
			}
			
		} 
		catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new SingUp();
	}
}
