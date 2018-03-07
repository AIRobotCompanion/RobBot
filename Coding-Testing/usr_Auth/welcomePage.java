import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
public class welcomePage extends JFrame implements ActionListener{	
	private JLabel welcome, choice;
	private JButton lBtn, rBtn, xBtn;
	private Cursor cur=new Cursor(Cursor.HAND_CURSOR);
	private String btn;
	registrationForm rF;
	loginForm lF;
	private Container c;
	welcomePage(){
		setTitle("Welcome Page");
		setBounds(150,100,500,500);
		c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.GREEN);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		welcome=new JLabel("Welcome to RobBot");
		welcome.setBounds(150,50,300,100);
		welcome.setFont(new Font("SansSerif",Font.BOLD,20));
		add(welcome);
		choice=new JLabel("Please choose correct option");
		choice.setBounds(150,150,300,50);
		add(choice);
		lBtn=new JButton("Login");
		lBtn.setBounds(150,200,100,30);
		lBtn.setCursor(cur);
		lBtn.addActionListener(this);
		add(lBtn);
		rBtn=new JButton("Register");
		rBtn.setBounds(250,200,100,30);
		rBtn.setCursor(cur);
		rBtn.addActionListener(this);
		add(rBtn);
		xBtn=new JButton("Close");
		xBtn.setBounds(200,250,100,50);
		xBtn.setCursor(cur);
		xBtn.addActionListener(this);
		add(xBtn);
	}
	@Override
	public void actionPerformed(ActionEvent e){
		btn=e.getActionCommand();
		if(btn.equals("Login")){
			setVisible(false);
			lF=new loginForm();
		}
		else if(btn.equals("Register")){
			setVisible(false);
			rF=new registrationForm();
		}
		else if(btn.equals("Close")){
			setVisible(false);
			System.exit(0);
		}
	}
}
