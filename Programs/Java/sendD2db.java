import java.sql.*;
import javax.swing.*;
public class sendD2db{
	sendD2db(String n,String ma,String mn,String un,String up){
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
				JOptionPane.showMessageDialog(f,"Data values Sent to MySQL");
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
