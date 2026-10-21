package mypack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SingUp3 extends JFrame implements ActionListener {

    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9;
    JRadioButton r1, r2, r3, r4, s1, s2, s3, s4, s5, s6, check;
    JButton submit, cancel;
    String formn;

    public SingUp3(String formn) {
        this.formn = formn;
        setTitle("Application Form");

        // Image in logo
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("Icon/logo.png"));
        Image i1 = i.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(20, 20, 100, 100);
        add(image);

        // JLabel in page number 
        JLabel page = new JLabel("Page No : 03 ");
        page.setBounds(550, 10, 250, 30);
        page.setForeground(Color.DARK_GRAY);
        page.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(page);

        // JLabel in Application Form
        JLabel Ap = new JLabel("Application Id : ");
        Ap.setBounds(240, 10, 250, 30);
        Ap.setForeground(Color.RED);
        Ap.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(Ap);

        JLabel f = new JLabel(formn);
        f.setFont(new Font("Times New Roman", Font.BOLD, 24));
        f.setBounds(420, 10, 250, 30);
        f.setForeground(Color.RED);
        add(f);

        // JLabel Bank Name
        JLabel bn = new JLabel("State Bank of India (SBI)");
        bn.setBounds(200, 50, 400, 30);
        bn.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(bn);

        // JLabel in Personal Details
        JLabel ps = new JLabel("Account Details");
        ps.setBounds(250, 90, 200, 30);
        ps.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(ps);

        // JLabel in UnderLine
        JLabel ul = new JLabel("__________________________________________________________________________________________________________________________________");
        ul.setBounds(0, 100, 780, 30);
        add(ul);

        // Fonts 
        Font font = new Font("Times New Roman", Font.BOLD, 18);
        Font font1 = new Font("Times New Roman", Font.BOLD, 14);
        Font font2 = new Font("Times New Roman", Font.BOLD, 10);

        // Account Type
        label1 = new JLabel("Account Type :");
        label1.setBounds(90, 150, 150, 30);
        label1.setFont(font);
        add(label1);

        r1 = new JRadioButton("Saving Account");
        r1.setBounds(90, 180, 150, 30);
        r1.setFont(font1);
        r1.setBackground(new Color(168, 211, 227));
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBounds(350, 180, 200, 30);
        r2.setFont(font1);
        r2.setBackground(new Color(168, 211, 227));
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setBounds(90, 210, 150, 30);
        r3.setFont(font1);
        r3.setBackground(new Color(168, 211, 227));
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(350, 210, 250, 30);
        r4.setFont(font1);
        r4.setBackground(new Color(168, 211, 227));
        add(r4);

        // Card Number
        label2 = new JLabel("Card Number :");
        label2.setBounds(90, 260, 200, 30);
        label2.setFont(font);
        add(label2);

        label3 = new JLabel("(Your 16-digit Card Number)");
        label3.setBounds(90, 280, 250, 30);
        label3.setFont(font2);
        add(label3);

        label4 = new JLabel("XXXX-XXXX-XXXX-8998");
        label4.setBounds(350, 260, 250, 30);
        label4.setFont(font);
        add(label4);

        label5 = new JLabel("(It would appear on atm card/cheque Book and Statements)");
        label5.setBounds(350, 280, 300, 30);
        label5.setFont(font2);
        add(label5);

        // PIN
        label6 = new JLabel("PIN :");
        label6.setBounds(90, 330, 200, 30);
        label6.setFont(font);
        add(label6);

        label7 = new JLabel("(4-digit Password)");
        label7.setBounds(90, 350, 250, 30);
        label7.setFont(font2);
        add(label7);

        label8 = new JLabel("XXXX");
        label8.setBounds(350, 330, 250, 30);
        label8.setFont(font);
        add(label8);

        // Services Required
        label9 = new JLabel("Services Required:");
        label9.setBounds(90, 400, 250, 30);
        label9.setFont(font);
        add(label9);

        s1 = new JRadioButton("ATM CARD");
        s1.setBounds(90, 440, 200, 30);
        s1.setFont(font1);
        s1.setBackground(new Color(168, 211, 227));
        add(s1);

        s2 = new JRadioButton("Internet Banking");
        s2.setBounds(350, 440, 200, 30);
        s2.setFont(font1);
        s2.setBackground(new Color(168, 211, 227));
        add(s2);

        s3 = new JRadioButton("Mobile Banking");
        s3.setBounds(90, 480, 150, 30);
        s3.setFont(font1);
        s3.setBackground(new Color(168, 211, 227));
        add(s3);

        s4 = new JRadioButton("Cheque Book");
        s4.setBounds(350, 480, 250, 30);
        s4.setFont(font1);
        s4.setBackground(new Color(168, 211, 227));
        add(s4);

        s5 = new JRadioButton("E-Statement");
        s5.setBounds(90, 520, 150, 30);
        s5.setFont(font1);
        s5.setBackground(new Color(168, 211, 227));
        add(s5);

        s6 = new JRadioButton("Email Alerts");
        s6.setBounds(350, 520, 250, 30);
        s6.setFont(font1);
        s6.setBackground(new Color(168, 211, 227));
        add(s6);

        // Declaration checkbox
        check = new JRadioButton("I here by declares that the above entered details correct to the best of my knowledge.", true);
        check.setBounds(90, 570, 580, 30);
        check.setFont(font1);
        check.setBackground(new Color(168, 211, 227));
        add(check);

        // Buttons
        submit = new JButton("Submit");
        submit.setBounds(110, 630, 100, 40);
        submit.setFont(font);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(400, 630, 100, 40);
        cancel.setFont(font);
        cancel.addActionListener(this);
        add(cancel);

        // Display Size
        setSize(700, 730);
        getContentPane().setBackground(new Color(168, 211, 227));
        setLocation(430, 40);
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit)
        {
            String atype = "";
            if (r1.isSelected()) {
                atype = "Saving Account";
            } else if (r2.isSelected()) {
                atype = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                atype = "Current Account";
            } else if (r4.isSelected()) { // Fixed: checked r4 instead of r3 again
                atype = "Recurring Deposit Account";
            }

            Random ran = new Random();
            long first7 = (ran.nextLong() % 90000000L) + 14899630000000L;
            String cardno = "" + Math.abs(first7);

            long first3 = (ran.nextLong() % 9000L) + 1000L;
            String pin = "" + Math.abs(first3);

            // Fixed: Use independent if statements to accumulate multiple services
            String sr = "";
            if (s1.isSelected()) {
                sr += " ATM CARD";
            }
            if (s2.isSelected()) {
                sr += " Internet Banking";
            }
            if (s3.isSelected()) {
                sr += " Mobile Banking";
            }
            if (s4.isSelected()) {
                sr += " Cheque Book";
            }
            if (s5.isSelected()) {
                sr += " E-Statement";
            }
            if (s6.isSelected()) {
                sr += " Email Alerts";
            }

            try {
                if (atype.equals("")) 
                {
                    JOptionPane.showMessageDialog(null, "Please select an Account Type");
                } 
                else if (!check.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please accept the declaration");
                } 
                else {
                    database db = new database();
                    String q1 = "insert into signupthree values('" + formn + "', '" + atype + "','" + cardno + "','" + pin + "','" + sr.trim() + "')";
                    String q2 = "insert into login values('" + formn + "','" + cardno + "','" + pin + "')";
                    
                    db.statement.executeUpdate(q1);
                    db.statement.executeUpdate(q2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number : " + cardno + "\nPin : " + pin);
                    new Deposit(pin);
                    setVisible(false);
                }
            } 
            catch (Exception e2) {
                e2.printStackTrace();
            }
        } 
        else if (e.getSource() == cancel) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new SingUp3("");
    }
}