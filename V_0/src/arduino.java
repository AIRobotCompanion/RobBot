import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.PrintWriter;
import com.fazecast.jSerialComm.*;
public class arduino extends JFrame implements ActionListener{
	private Container c;
	private SerialPort p;
	private JButton sBtn, xBtn, cBtn;	// switch, exit, connect
	private JButton lBtn, rBtn, fBtn, bBtn, oBtn;	// left, right, front, back, OFF
	protected JComboBox<String> pL;		// Port List
	private String btn;
	private PrintWriter op;
	private int isConnected=0;

	arduino(){
		setTitle("Arduino-Java");
		setBounds(10,10,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.YELLOW);

		pL = new JComboBox<String>();
		pL.setBounds(50,100,100,30);
		add(pL);

		cBtn = new JButton("Connect");
		cBtn.setBounds(200,100,100,30);
		cBtn.addActionListener(this);
		add(cBtn);

		xBtn = new JButton("Exit");
		xBtn.setBounds(350,100,100,50);
		xBtn.addActionListener(this);
		add(xBtn);

		lBtn = new JButton("Left");
		lBtn.setBounds(100,250,100,50);
		lBtn.addActionListener(this);
		add(lBtn);

		rBtn = new JButton("Right");
		rBtn.setBounds(300,250,100,50);
		rBtn.addActionListener(this);
		add(rBtn);

		fBtn = new JButton("Front");
		fBtn.setBounds(200,200,100,50);
		fBtn.addActionListener(this);
		add(fBtn);

		bBtn = new JButton("Back");
		bBtn.setBounds(200,300,100,50);
		bBtn.addActionListener(this);
		add(bBtn);

		oBtn = new JButton("OFF");
		oBtn.setBounds(200,250,100,50);
		oBtn.addActionListener(this);
		add(oBtn);

		SerialPort[] portNames = SerialPort.getCommPorts();
		for(int i=0; i<portNames.length; i++)
			pL.addItem(portNames[i].getSystemPortName());
	}
	public static void main(String[] args){
		new arduino();
	}
	@Override
	public void actionPerformed(ActionEvent e){
		btn = e.getActionCommand();
		if(btn.equals("Connect")){
			p = SerialPort.getCommPort(pL.getSelectedItem().toString());
			p.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER,0,0);
			System.out.println(p);
			if(p.openPort()){
				isConnected=1;
				cBtn.setText("Disconnect");
				pL.setEnabled(false);
			}
		}else if(btn.equals("Disconnect")){
			p.closePort();
			pL.setEnabled(true);
			cBtn.setText("Connect");
			isConnected=0;
		}else if(btn.equals("Exit")){
			System.exit(0);
		}else{
			if(isConnected==1){
				op = new PrintWriter(p.getOutputStream());
				if(btn.equals("Left")){
					op.print("L");
					op.flush();
					System.out.println("LEFT");
				}else if(btn.equals("Right")){
					op.print("R");
					op.flush();
					System.out.println("RIGHT");
				}else if(btn.equals("Front")){
					op.print("F");
					op.flush();
					System.out.println("FRONT");
				}else if(btn.equals("Back")){
					op.print("B");
					op.flush();
					System.out.println("BACK");
				}else if(btn.equals("OFF")){
					op.print("X");
					op.flush();
					System.out.println("All OFF");
				}
			}else{
				JFrame f=new JFrame();
				JOptionPane.showMessageDialog(f,"Please Connect with a Device");
			}
		}
	}
}
