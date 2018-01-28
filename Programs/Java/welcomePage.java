import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
public class welcomePage extends JFrame{
	Container c;
	JLabel welcome=new JLabel("Welcome to eExam");
	JLabel choice=new JLabel("Please choose correct option");
	JButton lBtn=new JButton("Login");
	JButton rBtn=new JButton("Register");
	JButton xBtn=new JButton("Close");
	Cursor cur=new Cursor(Cursor.HAND_CURSOR);
	registrationForm rF;
	loginForm lF;
	welcomePage(){
		setTitle("Welcome Page");
		setBounds(100,100,500,500);
		c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.GREEN);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		welcome.setBounds(150,50,300,100);
		welcome.setFont(new Font("SansSerif",Font.BOLD,20));
		choice.setBounds(150,150,300,50);
		lBtn.setBounds(150,200,100,30);
		lBtn.setCursor(cur);
		lBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				lF=new loginForm();
		}});
		rBtn.setBounds(250,200,100,30);
		rBtn.setCursor(cur);
		rBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				rF=new registrationForm();
		}});
		xBtn.setBounds(200,250,100,50);
		xBtn.setCursor(cur);
		xBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				System.exit(0);
		}});
		c.add(welcome); c.add(choice);
		c.add(lBtn); c.add(rBtn),c.add(xBtn);
	}
}
