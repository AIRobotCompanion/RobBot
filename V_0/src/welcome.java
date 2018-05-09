import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class welcome extends JFrame implements ActionListener{
	private Container c;
	private JLabel welcome, choice;
	private JButton lBtn, rBtn, xBtn;
	private Cursor cur=new Cursor(Cursor.HAND_CURSOR);
	private String btn;

	welcome(){
		setTitle("Welcome Page");
		setBounds(100,100,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.ORANGE);

		welcome=new JLabel("Welcome to eExam");
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

		xBtn=new JButton("Exit");
		xBtn.setBounds(200,250,100,50);
		xBtn.setCursor(cur);
		xBtn.addActionListener(this);
		add(xBtn);
	}
	@Override
        public void actionPerformed(ActionEvent e){
		btn = e.getActionCommand();
		if(btn.equals("Login")){
			setVisible(false);
			new login();
		}
		else if(btn.equals("Register")){
			setVisible(false);
			new registration();
		}
		else if(btn.equals("Exit")){
			setVisible(false);
			System.exit(0);
		}
	}
	public static void main(String[] args){
		new welcome();
	}
}
