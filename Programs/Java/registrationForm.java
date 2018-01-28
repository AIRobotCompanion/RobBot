import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
public class registrationForm extends JFrame {
	Container c;
	JLabel r=new JLabel("Register Now");
	JLabel nL=new JLabel("Enter Name");
	JLabel maL=new JLabel("Full email Address");
	JLabel mnL=new JLabel("Mobile number");
	JLabel uL=new JLabel("Username");
	JLabel pL=new JLabel("Password");
	JLabel cpL=new JLabel("Confirm Password");
	JTextField nTF=new JTextField();
	JTextField maTF=new JTextField();
	JTextField mnTF=new JTextField();
	JTextField uTF=new JTextField();
	JPasswordField pPF=new JPasswordField();
	JPasswordField cpPF=new JPasswordField();
	JButton rBtn=new JButton("Register");
	JButton cBtn=new JButton("Cancel");
	Cursor cur=new Cursor(Cursor.HAND_CURSOR);
	String Name,mailID,mobNo,UsrNm,UsrPsw,cUsrPsw;
	sendD2db sd2db;
	registrationForm(){
		setTitle("Registration Form");
		setBounds(100,10,500,300);
		c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.CYAN);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		r.setFont(new Font("Times New Roman",Font.BOLD,20));
		r.setBounds(200,10,200,30);
		nL.setBounds(50,100,200,20);
		nTF.setBounds(250,100,200,20);
		maL.setBounds(50,120,200,20);
		maTF.setBounds(250,120,200,20);
		mnL.setBounds(50,140,200,20);
		mnTF.setBounds(250,140,200,20);
		uL.setBounds(50,160,200,20);
		uTF.setBounds(250,160,200,20);
		pL.setBounds(50,180,200,20);
		pPF.setBounds(250,180,200,20);
		cpL.setBounds(50,200,200,20);
		cpPF.setBounds(250,200,200,20);
		rBtn.setCursor(cur);
		rBtn.setBounds(60,250,100,20);
		rBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Name=nTF.getText(); mailID=maTF.getText(); mobNo=mnTF.getText();
				UsrNm=uTF.getText(); UsrPsw=pPF.getText(); cUsrPsw=cpPF.getText();
				if(UsrPsw.equals(cUsrPsw)==true)
					sd2db=new sendD2db(Name,mailID,mobNo,UsrNm,UsrPsw);
		}});
		cBtn.setBounds(310,250,100,20);
		cBtn.setCursor(cur);
		cBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				welcomePage wp=new welcomePage();
				//System.exit(0);
		}});
		c.add(r);
		c.add(nL); c.add(nTF);
		c.add(maL); c.add(maTF); c.add(mnL); c.add(mnTF); 
		c.add(uL); c.add(uTF);
		c.add(pL); c.add(pPF); c.add(cpL); c.add(cpPF); 
		c.add(rBtn); c.add(cBtn);
	}
}
