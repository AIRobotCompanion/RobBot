import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class registrationForm extends JFrame implements ActionListener{
	private Container c;
	private JLabel r,nL,maL,mnL,uL,pL,cpL;
	private JTextField nTF,maTF,mnTF,uTF;
	private JPasswordField pPF,cpPF;
	private Cursor cur;
	private String Name,mailID,mobNo,UsrNm,UsrPw,cUsrPw,btn;
	private JButton rBtn, cBtn;
	private boolean done=false;
	registrationForm(){
		setTitle("Registration Form");
		setBounds(100,10,500,300);
		c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.CYAN);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		r=new JLabel("Register Now");
		r.setFont(new Font("Times New Roman",Font.BOLD,20));
		r.setBounds(200,10,200,30);
		add(r);
		nL=new JLabel("Enter Name");
		nL.setBounds(50,100,200,20);
		add(nL);
		nTF=new JTextField();
		nTF.setBounds(250,100,200,20);
		add(nTF);
		maL=new JLabel("Full email Address");
		maL.setBounds(50,120,200,20);
		add(maL);
		maTF=new JTextField();
		maTF.setBounds(250,120,200,20);
		add(maTF);
		mnL=new JLabel("Mobile number");
		mnL.setBounds(50,140,200,20);
		add(mnL);
		mnTF=new JTextField();
		mnTF.setBounds(250,140,200,20);
		add(mnTF);
		uL=new JLabel("Username");
		uL.setBounds(50,160,200,20);
		add(uL);
		uTF=new JTextField();
		uTF.setBounds(250,160,200,20);
		add(uTF);
		pL=new JLabel("Password");
		pL.setBounds(50,180,200,20);
		add(pL);
		pPF=new JPasswordField();
		pPF.setBounds(250,180,200,20);
		add(pPF);
		cpL=new JLabel("Confirm Password");
		cpL.setBounds(50,200,200,20);
		add(cpL);
		cpPF=new JPasswordField();
		cpPF.setBounds(250,200,200,20);
		add(cpPF);

		cur=new Cursor(Cursor.HAND_CURSOR);

		rBtn=new JButton("Register");
		rBtn.setCursor(cur);
		rBtn.setBounds(60,250,100,20);
		rBtn.addActionListener(this);
		add(rBtn);
		cBtn=new JButton("Cancel");
		cBtn.setBounds(310,250,100,20);
		cBtn.setCursor(cur);
		cBtn.addActionListener(this);
		add(cBtn);
	}
	@Override
	public void actionPerformed(ActionEvent e){
		btn=e.getActionCommand();
		if(btn.equals("Register")){
			Name=nTF.getText(); nTF.setText(null);
			mailID=maTF.getText(); maTF.setText(null);
			mobNo=mnTF.getText(); mnTF.setText(null);
			UsrNm=uTF.getText(); uTF.setText(null);
			UsrPw=pPF.getText(); pPF.setText(null);
			cUsrPw=cpPF.getText(); cpPF.setText(null);
			if(UsrPw.equals(cUsrPw)==true)
				sendD2db(Name,mailID,mobNo,UsrNm,UsrPw);
		}
		else if(btn.equals("Cancel"))
			setVisible(false);
		if(done==true){
			setVisible(false);
			new welcomePage();
		}
	}
	private void sendD2db(String n,String ma,String mn,String un,String up){
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
				stmnt.executeUpdate("INSERT INTO Users VALUES(\""+n+"\",\""+ma+"\",\""+mn+"\",\""+un+"\",\""+up+"\")");
				JOptionPane.showMessageDialog(f,"Registration Successful");
				done=true;
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
}
