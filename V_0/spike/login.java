import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
	private Container c;
	private JPanel p;
	private JLabel uL, pL;
	private JTextField uNm;
	private JPasswordField uPw;
	private JButton lBtn, cBtn;
	private Cursor cur=new Cursor(Cursor.HAND_CURSOR);
	//welcomePage wP;
	private String btn, un, up;

	login(){
		setTitle("Login Form");
		setBounds(100,100,500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.GREEN);

		p = new JPanel();
		p.setBounds(300,100,200,200);
		add(p);

		ImageIcon img = new ImageIcon(new ImageIcon("lib/img/log.jpg").getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
		p.add(new JLabel(img));

		uL=new JLabel("Username");
		uL.setBounds(10,100,80,20);
		add(uL);

		pL=new JLabel("Password");
		pL.setBounds(10,130,80,20);
		add(pL);

		uNm=new JTextField();
		uNm.setBounds(110,100,150,20);
		add(uNm);

		uPw=new JPasswordField();
		uPw.setBounds(110,130,150,20);
		add(uPw);

		lBtn=new JButton("Login");
		lBtn.setBounds(30,300,100,30);
		lBtn.addActionListener(this);
		lBtn.setCursor(cur);
		add(lBtn);
		
		cBtn=new JButton("Cancel");
		cBtn.setBounds(150,300,100,30);
		cBtn.setCursor(cur);
		cBtn.addActionListener(this);
		add(cBtn);
	}
	@Override
        public void actionPerformed(ActionEvent e){
		btn = e.getActionCommand();
		if(btn.equals("Cancel")){
			setVisible(false);
			new welcome();
			//System.exit(0);
		}
		else if(btn.equals("Login")){
			un=uNm.getText();
			up=new String(uPw.getPassword());
//			System.out.println(un + " " + up);
			uNm.setText("");
			uPw.setText("");
			getFromDB(un, up);			
		}
	}

	void getFromDB(String un,String up){
		String url="jdbc:mysql://localhost:3306/";
		String dbNm="RobBot?autoReconnect=true&useSSL=false";
		String driver="com.mysql.jdbc.Driver";
		String usrNm="root";
		String psswd="password";
		JFrame f;
		try{
			Class.forName(driver);//newInstance();
			f=new JFrame();
			try{
				Connection conn=DriverManager.getConnection(url+dbNm,usrNm,psswd); 	
				Statement stmnt=conn.createStatement();
//				stmnt.executeUpdate("SELECT * FROM Users WHERE uNm=\""+un+"\" AND uPw=\""+up+"\";");

				try{				
					ResultSet rs = stmnt.executeQuery("SELECT * FROM Users WHERE uNm=\""+un+"\" AND uPw=\""+up+"\";");
					if(rs.next()){
						String name = rs.getString("Name");
//						System.out.println(name);
						JOptionPane.showMessageDialog(f,"Login Successful\nWelcome "+name);
						setVisible(false);
						new arduino();
					}
					else
						JOptionPane.showMessageDialog(f,"Login Failed\nPlease Try Again");
				}catch(SQLException e){
					System.out.println(e);
				}finally{
					if (stmnt != null) { stmnt.close(); }
				}
				if(conn!=null){
					conn.close();
					conn=null;
				}
			}catch(SQLException sqle){
				JOptionPane.showMessageDialog(f,"Error...Consult Terminal Window");
				System.out.println("SQL Exception thrown: "+sqle);
				sqle.printStackTrace();
			}
		}catch(ClassNotFoundException cnf){
			System.out.println("Driver could not be loaded: "+cnf);
		}
	}

	public static void main(String[] args){
		new login();
	}
}
