import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
public class loginForm extends JFrame{
	Container c;
	JLabel uLabel=new JLabel("User Name");
	JLabel pLabel=new JLabel("Password");
	JTextField uname=new JTextField();
	JPasswordField psswd=new JPasswordField();
	JButton lBtn=new JButton("Login");
	JButton cBtn=new JButton("Cancel");
	Cursor cur=new Cursor(Cursor.HAND_CURSOR);
	welcomePage wP;
	loginForm(){
		setTitle("Login Form");
		setBounds(100,100,300,150);
		c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.CYAN);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		uLabel.setBounds(10,30,80,20);
		pLabel.setBounds(10,60,80,20);
		uname.setBounds(110,30,150,20);
		psswd.setBounds(110,60,150,20);
		lBtn.setBounds(30,100,100,20);
		lBtn.setCursor(cur);
		cBtn.setBounds(150,100,100,20);
		cBtn.setCursor(cur);
		cBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				wP=new welcomePage();
                }});
		c.add(uLabel); c.add(pLabel); c.add(uname);
		c.add(psswd); c.add(lBtn); c.add(cBtn);
	}
}
