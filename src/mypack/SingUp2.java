package mypack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SingUp2 extends JFrame implements ActionListener
{
	String formn;
	
//	JLabel
	
	JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9;
	
//	JComboBox
	
	JComboBox comboBox1,comboBox2,comboBox3,comboBox4,comboBox5;
	
//	JTextField
	
	JTextField textPan, textAadhar;
	
//	JRadioButton
	
	JRadioButton r1,r2, e1,e2;
	
//	JButton
	
	JButton Next;
	
	SingUp2(String formn) {
		super("Application From");
//		Image in logo
		
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("Icon/logo.png"));
		Image i1 = i.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel image = new JLabel(i2);
		image.setBounds(20,20,100,100);
		add(image);
		
//		Application number get 
		
		this.formn = formn;
		
//		JLabel in page number 
		
		JLabel page = new JLabel("Page No : 02 ");
		page.setBounds(550, 10, 250, 30);
		page.setForeground(Color.DARK_GRAY);
		page.setFont(new Font("Times New Roman", Font.BOLD, 16));
		add(page);
		
//		JLabel in Application From
		
		JLabel Ap = new JLabel("Application Id : ");
		Ap.setBounds(240, 10, 250, 30);
		Ap.setForeground(Color.RED);
		Ap.setFont(new Font("Times New Roman", Font.BOLD, 24));
		add(Ap);
		
		JLabel f= new JLabel(formn);
		f.setFont(new Font("Times New Roman", Font.BOLD, 24));
		f.setBounds(420, 10, 250, 30);
		f.setForeground(Color.RED);
		add(f);

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

//		JLabel
		
		label1 = new JLabel("Religion :");
		label1.setBounds(90, 150, 100, 30);
		label1.setFont(font);
		add(label1);
		
//		JComboBox
		String religion[] =  {"Select","Hindu","Muslim","Sikh", "Christian", "Other"};
		
		comboBox1 = new JComboBox(religion);
		comboBox1.setBounds(260, 150, 350, 30);
		comboBox1.setBackground(new Color(168, 211, 227));
		comboBox1.setFont(font1);
		add(comboBox1);
		
//		JLabel
		
		label2 = new JLabel("Category :");
		label2.setBounds(90, 200, 100, 30);
		label2.setFont(font);
		add(label2);
		
//		JComboBox
		String category[] =  {"Select","General","OBC","SC", "ST", "Other"};
		
		comboBox2 = new JComboBox(category);
		comboBox2.setBounds(260, 200, 350, 30);
		comboBox2.setBackground(new Color(168, 211, 227));
		comboBox2.setFont(font1);
		add(comboBox2);
		
//		JLabel
		
		label3 = new JLabel("Income :");
		label3.setBounds(90, 250, 100, 30);
		label3.setFont(font);
		add(label3);
		
//		JComboBox
		String income[] =  {"Select","Null","<1,50,000","<2,50,000", "5,00,000", "Upto 10,00,000","Above 10,00,000"};
		
		comboBox3 = new JComboBox(income);
		comboBox3.setBounds(260, 250, 350, 30);
		comboBox3.setBackground(new Color(168, 211, 227));
		comboBox3.setFont(font1);
		add(comboBox3);
		
//		JLabel
		
		label4 = new JLabel("Educational :");
		label4.setBounds(90, 300, 150, 30);
		label4.setFont(font);
		add(label4);
		
//		JComboBox
		String educational[] = {"Select","Non-Graduate","Graduate","Post-Graduate", "Doctrate", "Others"};
		
		comboBox4 = new JComboBox(educational);
		comboBox4.setBounds(260, 300, 350, 30);
		comboBox4.setBackground(new Color(168, 211, 227));
		comboBox4.setFont(font1);
		add(comboBox4);
		
		
//		JLabel
		
		label5 = new JLabel("Occupation :");
		label5.setBounds(90, 350, 150, 30);
		label5.setFont(font);
		add(label5);
		
//		JComboBox
		String occupation[] = {"Select","Salaried","Self-Employed","Business", "Student", "Retired", "Other"};
		
		comboBox5 = new JComboBox(occupation);
		comboBox5.setBounds(260, 350, 350, 30);
		comboBox5.setBackground(new Color(168, 211, 227));
		comboBox5.setFont(font1);
		add(comboBox5);
		
		
//		JLabel
		
		label6 = new JLabel("PAN Number :");
		label6.setBounds(90, 400, 150, 30);
		label6.setFont(font);
		add(label6);
		
//		JTextField
		
		textPan = new JTextField();
		textPan.setBounds(260, 400, 350, 30);
		textPan.setFont(font1);
		add(textPan);
		
//		JLabel
		
		label7 = new JLabel("Aadhar Number :");
		label7.setBounds(90, 450, 150, 30);
		label7.setFont(font);
		add(label7);
		
//		JTextField
		
		textAadhar = new JTextField();
		textAadhar.setBounds(260, 450, 350, 30);
		textAadhar.setFont(font1);
		add(textAadhar);
		
//		JLabel
		
		label8 = new JLabel("Senior Citizen :");
		label8.setBounds(90, 500, 150, 30);
		label8.setFont(font);
		add(label8);
		
//		JRadioButton
		
		r1 = new JRadioButton("Yes");
	    r1.setFont(font1);
	    r1.setBackground(new Color(168, 211, 227));
	    r1.setBounds(260, 500, 100, 30);
	    add(r1);
	     
	    r2 = new JRadioButton("No");
	    r2.setFont(font1);
	    r2.setBackground(new Color(168, 211, 227));
	    r2.setBounds(360, 500,100,30);
	    add(r2);
	     
//		ButtonGroup

	    ButtonGroup b = new ButtonGroup();
	    b.add(r1);
	    b.add(r2);
	     
//		JLabel
			
		label9 = new JLabel("Existing Account :");
		label9.setBounds(90, 550, 150, 30);
		label9.setFont(font);
		add(label9);
			
//		JRadioButton
			
		e1 = new JRadioButton("Yes");
		e1.setFont(font1);
		e1.setBackground(new Color(168, 211, 227));
		e1.setBounds(260, 550, 100, 30);
		add(e1);
		    
		e2 = new JRadioButton("No");
		e2.setFont(font1);
		e2.setBackground(new Color(168, 211, 227));
		e2.setBounds(360, 550,100,30);
		add(e2);
		
//		ButtonGroup
		
		ButtonGroup b1 = new ButtonGroup();
	    b1.add(e1);
	    b1.add(e2);
	    
//	    JButton
	    Next = new JButton("Next");
		Next.setBounds(510,600,100,30);
		Next.setFont(font);
		Next.addActionListener(this);
		add(Next);		
		
//		Display Size
		
		setSize(700, 700);
		getContentPane().setBackground(new Color(168, 211, 227));
		setLocation(430,40);
		setResizable(false);
		setLayout(null);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String rel = (String) comboBox1.getSelectedItem();
		String cate = (String) comboBox2.getSelectedItem();
		String income = (String) comboBox3.getSelectedItem();
		String edu = (String) comboBox4.getSelectedItem();
		String occup = (String) comboBox5.getSelectedItem();
		
		String pan = textPan.getText();
		String aadhar = textAadhar.getText();
		
		String scitizan =" ";
		if((r1.isSelected())) {
			scitizan = "Yes";
		}else if(r2.isSelected()) {
			scitizan = "No";
		}
		
		String eaccount =" ";
		if((e1.isSelected())) {
			eaccount = "Yes";
		}else if(e2.isSelected()) {
			eaccount = "No";
		}
		
		try {
			if(textPan.getText().equals("") || textAadhar.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Fill all the fields");
			}
			else {
				database db = new database();
				String q = "insert into signuptwo values('"+formn+"', '"+rel+"','"+cate+"','"+income+"','"+occup+"','"+pan+"','"+aadhar+"','"+scitizan+"', '"+eaccount+"')";
				db.statement.executeUpdate(q);
				new SingUp3(formn);   
				this.setVisible(false);
			}
			
		} 
		catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new SingUp2("");
	}
}
