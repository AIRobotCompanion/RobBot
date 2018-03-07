import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class loginForm extends JFrame implements ActionListener{
	private Container c;
	private JLabel nL, pL;
	private JTextField nTF;
	private JPasswordField pPF;
	private JButton lBtn, cBtn;
	private Cursor cur=new Cursor(Cursor.HAND_CURSOR);
	private String uNm, uPw, btn;
	private JFrame f;
	welcomePage wP;
	private boolean d=false;
	loginForm(){
		setTitle("Login Form");
		setBounds(100,100,300,150);
		c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.CYAN);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		nL=new JLabel("User Name");
		nL.setBounds(10,30,80,20);
		add(nL);
		pL=new JLabel("Password");
		pL.setBounds(10,60,80,20);
		add(pL);
		nTF=new JTextField();
		nTF.setBounds(110,30,150,20);
		add(nTF);
		pPF=new JPasswordField();
		pPF.setBounds(110,60,150,20);
		add(pPF);
		lBtn=new JButton("Login");
		lBtn.setBounds(30,100,100,20);
		lBtn.setCursor(cur);
		lBtn.addActionListener(this);
		add(lBtn);
		cBtn=new JButton("Cancel");
		cBtn.setBounds(150,100,100,20);
		cBtn.setCursor(cur);
		cBtn.addActionListener(this);
		add(cBtn);
	}
	@Override
	public void actionPerformed(ActionEvent e){
		btn=e.getActionCommand();
		if(btn.equals("Login")){
			uNm=nTF.getText(); nTF.setText(null);
			uPw=pPF.getText(); pPF.setText(null);
			validation(uNm,uPw);
		}
		else if(btn.equals("Cancel") || d==true){
			setVisible(false);
			wP=new welcomePage();
		}
	}
	void validation(String uNm,String uPw){
		String url="jdbc:mysql://localhost:3306/";
		String dbNm="RobBot?autoReconnect=true&useSSL=false";
		String driver="com.mysql.jdbc.Driver";
		String usrNm="root";
		String psswd="password";
		String[] R = new String[2];
		try{
			f=new JFrame();
			Class.forName(driver);//newInstance();
			try{
				Connection conn=DriverManager.getConnection(url+dbNm,usrNm,psswd); 	
				Statement stmnt=conn.createStatement();
				ResultSet rs=stmnt.executeQuery("SELECT * FROM Users WHERE UNm=\""+uNm+"\"AND UPsswd=\""+uPw+"\"");
				while(rs.next()){
					try{
						String name=rs.getString("Name");
						String email=rs.getString("email");
						String mob=rs.getString("Mob");
						String uname=rs.getString("UNm");
						String upsswd=rs.getString("UPsswd");
						d=true;
						JOptionPane.showMessageDialog(f,"Login Successful");
						System.out.format("%s, %s, %s, %s, %s, %s\n",name,email,mob,uname,upsswd);
					}catch(SQLException sqle){
						JOptionPane.showMessageDialog(f,"Login Failed");
					}
				}
			}catch(SQLException sqle){
				JOptionPane.showMessageDialog(f,"Error...Consult Terminal Window");
				System.out.println("SQL Exception thrown: "+sqle);
				sqle.printStackTrace();
			}finally{
				if(conn!=null)
					conn.close(); conn=null;
			}
		}catch(ClassNotFoundException cnf){
			System.out.println("Driver could not be loaded: "+cnf);
		}
	}
}
