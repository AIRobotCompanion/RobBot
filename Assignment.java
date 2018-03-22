import java.sql.DriverManager;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; 
public class Assignment implements ActionListener
  {  JFrame f ;
     private JButton btn3=new JButton("SignUp");
     private JButton btn4=new JButton("SignIn");
     JLabel l0;
     public  Assignment()
     {    f= new JFrame("Java Assignment");
          f.setVisible(true);
          f.setBounds(200,200,500,400);
          f.getContentPane().setBackground(new Color(100,100,100));
          f.setLayout(null);
          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          f.setTitle("JAVA ASSINMENT");
          l0 = new JLabel("World of Siyapa");
          l0.setBounds(150,50,400,40);
          l0.setForeground(Color.blue);
          l0.setFont(new Font("Serif", Font.BOLD,30));
	  btn3.setBounds(150,170,100,30);
          btn4.setBounds(270,170,100,30);
          f.add(l0);
          f.add(btn4);
          f.add(btn3);
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		f.getContentPane().add(btn3);
		btn3.addActionListener(this);
                btn4.addActionListener(this);
	}
       public void actionPerformed(ActionEvent e)
            {  if(e.getSource()==btn3)
                    {   
                        new Registration();
                        f.dispose();     }
                 else if(e.getSource()==btn4)
                  {     
                         new Login();     
                       f.dispose();  }
             }
	public static void main(String[] args) {
		new Assignment();
	}
}
 ///
 class Login implements ActionListener 
{    JLabel e,p;
     JTextField t;
     JPasswordField pass;
    JFrame f1;
    JTextField email,password;
    JButton enter,Back;
    Login()
    {    
         f1 = new JFrame("Login Page");
         f1.setVisible(true);
         f1.setBounds(200,150,600,400);
         //f1.setSize(500,500);
         f1.setLayout(null);
         f1.getContentPane().setBackground(new Color(40,100,50));
         f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         e=new JLabel("Email id");
         e.setForeground(Color.blue);
         e.setFont(new Font("Serif", Font.BOLD, 20));
         p=new JLabel("Password");
         p.setForeground(Color.blue);
         p.setFont(new Font("Serif", Font.BOLD, 20));
         p.setBounds(100,150,200,30);
         e.setBounds(100,100,200,30);
         t=new JTextField();
          t.setText("email id");
         //t.setInputPropmt(" please");
         t.setBounds(250,100,250,30);
         t.setFont(new Font("Serif", Font.BOLD, 20));
         pass = new JPasswordField();
         pass.setBounds(250,150,250,30);
         pass.setFont(new Font("Serif", Font.BOLD, 20));
         enter = new JButton("Enter");
         enter.setBounds(275,250,100,35);
         enter.setFont(new Font("Serif", Font.BOLD, 20));
         enter.addActionListener(this);
	 Back = new JButton("Back");
 	 Back.setBounds(400,250,100,35);
         Back.setFont(new Font("Serif", Font.BOLD, 20));
         Back.addActionListener(this);	
         f1.add(enter);
         f1.add(e);
         f1.add(p);
         f1.add(pass);
         f1.add(t);
         f1.add(Back);
          }
   
     public void actionPerformed(ActionEvent e) 
        {   
            //if valid check for that if it is then call 
			
 		if(e.getSource()==enter)
                  {  String Pass=null,s=null;
@SuppressWarnings("unchecked") String exet="select * from student where EMAIL =\'"+t.getText()+"\' and PASSWORD =  \'"+pass.getText()+"\'";
			Statement stmt = null;
			try{
			String url="jdbc:oracle:thin:@sticker-Lenovo-G50-80:1521:xe";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver connceted");
			Connection con=DriverManager.getConnection(url,"login","loginpassword");
			//System.out.println("connection is getting"+exet);			
			PreparedStatement ps=con.prepareStatement(exet);
			//stmt = con.createStatement();			
			ResultSet rs=ps.executeQuery();
			System.out.println(exet);
			if(rs!=null)
 			{	while(rs.next())
   				s=rs.getString(2);
				if(s!=null)
		 		new Welcome(s);
			}
			else{
				JOptionPane.showMessageDialog(enter,"invalid entry");			
					}
			}catch(Exception ex){
 				//	ex.printStackTrace();
 				System.out.println("some error is generated");
					}
		}	
		else
  		 {  
		     new Assignment();
                        f1.dispose(); }
                  }

}
class Welcome {
   JFrame w;
    JLabel l;
    Welcome(String s)
    {
      w= new JFrame("Welcome Page");
      w.setVisible(true);
       w.setBounds(200,150,600,400);
         w.setLayout(null);
         w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     String we=  "<html>Hey<br> " +s+ "<br>Welcome in the World of siyapa</html>";
      l=new JLabel(we);
       l.setFont(new Font("Serif", Font.BOLD, 40));
      l.setBounds(100,50,400,200);
      w.getContentPane().setBackground(new Color(100,50,200));
      l.setForeground(new Color(100,50,40));
      w.add(l); 
} 
}
class Registration extends JFrame implements ActionListener 
  { 
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField tf1, tf2, tf5, tf6, tf7;
    JButton btn1,btn2,Back;
    JPasswordField p1,p2;
 
    Registration()
     {
        setVisible(true);
        setSize(700,500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registration Form in Java");
        getContentPane().setBackground(new Color(100,200,150));
        l1 = new JLabel("Registration Form");
        l1.setForeground(new Color(75,100,200));
        l1.setFont(new Font("Serif", Font.BOLD, 30));
   	//JTextField.setFont(new Font("Serif", Font.BOLD, 20));
        l2 = new JLabel("Name:");
        l3 = new JLabel("Email-ID:");
        l4 = new JLabel("Create Passowrd:");
        l5 = new JLabel("Confirm Password:");
        l6 = new JLabel("Country:");
        l7 = new JLabel("State:");
        l8 = new JLabel("Phone No:"); 
        tf1 = new JTextField();
        tf2 = new JTextField();
        p1 = new JPasswordField();
        p2 = new JPasswordField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
 
        btn1 = new JButton("Submit");
        btn2 = new JButton("Clear");
 
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        
        l1.setBounds(130, 30, 400, 30);
        l2.setBounds(80, 80, 200, 30);
        l3.setBounds(80, 120, 200, 30);
        l4.setBounds(80, 160, 200, 30);
        l5.setBounds(80, 200, 200, 30);
        l6.setBounds(80, 240, 200, 30);
        l7.setBounds(80, 280, 200, 30);
        l8.setBounds(80, 320, 200, 30);
        tf1.setBounds(300,80, 200, 30);
        tf2.setBounds(300, 120, 200, 30);
        p1.setBounds(300, 160, 200, 30);
        p2.setBounds(300, 200, 200, 30);
        tf5.setBounds(300, 240, 200, 30);
        tf6.setBounds(300, 280, 200, 30);
        tf7.setBounds(300, 320, 200, 30);
        btn1.setBounds(185, 380, 100, 30);
        btn2.setBounds(315, 380, 100, 30);
       	 Back = new JButton("Back");
 	 Back.setBounds(450,380,100,30);
         Back.setFont(new Font("Serif", Font.BOLD, 20));
         Back.addActionListener(this);	
	 add(Back);
        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(tf2);
        add(l4);
        add(p1);
        add(l5);
        add(p2);
        add(l6);
        add(tf5);
        add(l7);
        add(tf6);
        add(l8);
        add(tf7);
        add(btn1);
        add(btn2);
    }
 
    public void actionPerformed(ActionEvent e) 
     {
        if (e.getSource() == btn1)
         {
            int x = 0;
            String s1 = tf1.getText();
            String s2 = tf2.getText();
 
            char[] s3 = p1.getPassword();
            char[] s4 = p2.getPassword(); 
            String s8 = new String(s3);
            String s9 = new String(s4);
 
            String s5 = tf5.getText();
            String s6 = tf6.getText();
            String s7 = tf7.getText();
            if (s8.equals(s9))//suppose
           {
                try
               {
                 Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("system driver is loaded");
 		  String url="jdbc:oracle:thin:@sticker-Lenovo-G50-80:1521:xe";
                    Connection con = DriverManager.getConnection(url,"login","loginpassword");
		System.out.println("connection is getting");
                    PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?,?)");
                    ps.setString(1, s1);
                    ps.setString(2, s2);
                    ps.setString(3, s8);
                    ps.setString(4, s5);
                    ps.setString(5, s6);
                    ps.setInt(6, Integer.parseInt(s7));
                    ResultSet rs = ps.executeQuery();
                    x++;
                  if (x > 0) 
                    {
                             JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");
 			     new Assignment(); 
                              dispose();                    
                    }
                }
          catch (Exception ex) 
                {   
                    JOptionPane.showMessageDialog(btn1, "Some error is generated");
                   // System.out.println(ex);
                }
	}
          else
           {
                JOptionPane.showMessageDialog(btn1, "Password Does Not Match");
            } 
        }
        else if(e.getSource()==Back)
         {
             new Assignment();
             dispose();
             } 
          else
       {
            tf1.setText("");
            tf2.setText("");
            p1.setText("");
            p2.setText("");
            tf5.setText("");
            tf6.setText("");
            tf7.setText("");
        }
    } 
}
