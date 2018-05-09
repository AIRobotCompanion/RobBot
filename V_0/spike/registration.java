import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

public class registration extends JFrame implements ActionListener{
	private Container c;
	private JPanel p;
	private JLabel r, nL, maL, mnL, uL, pL, cpL;
	private JTextField nTF, maTF, mnTF, uTF;
	private JPasswordField pPF, cpPF;
	private JButton rBtn, cBtn;
	private Cursor cur=new Cursor(Cursor.HAND_CURSOR);
	private String Name, email, phNo, uNm, uPw, cuPw;
	private String btn;

	registration(){
		setTitle("Registration Form");
		setBounds(100,100,500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.CYAN);

		p = new JPanel();
		p.setBounds(300,100,200,200);
		add(p);

		ImageIcon img = new ImageIcon(new ImageIcon("lib/img/reg.jpg").getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
		p.add(new JLabel(img));

		r=new JLabel("Register Now");
		r.setFont(new Font("Times New Roman",Font.BOLD,20));
		r.setBounds(150,10,200,30);
		add(r);

//		nL=new JLabel("<html>Name<font color='red'>*</font></html>");
		nL=new JLabel("Name");
		nL.setBounds(10,100,80,20);
		add(nL);

		nTF=new JTextField();
		nTF.setBounds(110,100,150,20);
		add(nTF);

//		maL=new JLabel("<html>email<font color='red'>*</font></html>");
		maL=new JLabel("email");
		maL.setBounds(10,120,80,20);
		add(maL);

		maTF=new JTextField();
		maTF.setBounds(110,120,150,20);
		add(maTF);

		mnL=new JLabel("Mobile");
		mnL.setBounds(10,140,80,20);
		add(mnL);

		mnTF=new JTextField();
		mnTF.setBounds(110,140,150,20);
		add(mnTF);

//		uL = new JLabel("<html>Username<font color='red'>*</font></html>");
		uL=new JLabel("Username");
		uL.setBounds(10,160,80,20);
		add(uL);

		uTF=new JTextField();
		uTF.setBounds(110,160,150,20);
		add(uTF);

//		pL = new JLabel("<html>Password<font color='red'>*</font></html>");
		pL=new JLabel("Password");
		pL.setBounds(10,180,80,20);
		add(pL);

		pPF=new JPasswordField();
		pPF.setBounds(110,180,150,20);
		add(pPF);

//		cpL = new JLabel("<html>Confirm<font color='red'>*</font></html>");
		cpL=new JLabel("Confirm");
		cpL.setBounds(10,200,100,20);
		add(cpL);

		cpPF=new JPasswordField();
		cpPF.setBounds(110,200,150,20);
		add(cpPF);

		rBtn=new JButton("Register");
		rBtn.setCursor(cur);
		rBtn.setBounds(30,300,100,30);
		rBtn.addActionListener(this);
		add(rBtn);

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
//			System.exit(0);
		}
		else if(btn.equals("Register")){
			Name=nTF.getText();
			email=maTF.getText();
			phNo=mnTF.getText();
			uNm=uTF.getText();
			uPw=new String(pPF.getPassword());
			cuPw=new String(cpPF.getPassword());
//			System.out.println(Name+"\n"+email+"\n"+phNo+"\n"+uNm+"\n"+uPw+"\n"+cuPw+"\n");

			nTF.setText("");
			maTF.setText("");
			mnTF.setText("");
			uTF.setText("");
			pPF.setText("");
			cpPF.setText("");

			if(uPw.equals(cuPw)==true)
				sendToDB(Name, email, phNo, uNm, uPw);	
		}
	}

	void sendToDB(String n,String ma,String mn,String un,String up){
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
				try{
					stmnt.executeUpdate("INSERT INTO Users VALUES(\""+n+"\",\""+ma+"\",\""+mn+"\",\""+un+"\",\""+up+"\")");
					JOptionPane.showMessageDialog(f,"Registration Successful");
				}catch(Exception e){
					JOptionPane.showMessageDialog(f,"ERROR\nPlese Try Another Username");
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
		new registration();
	}
}
