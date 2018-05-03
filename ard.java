import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.PrintWriter;
import com.fazecast.jSerialComm.*;
public class ard extends JFrame implements ActionListener{
	protected SerialPort p;
	private JFrame f;
	private JButton sBtn, xBtn, cBtn;	// switch, exit, connect
	private JButton lBtn, rBtn, fBtn, bBtn, oBtn;	// left, right, front, back, OFF
	protected JComboBox<String> pL;		// Port List
	public int ledState=0;
	protected String btn;
	protected PrintWriter op;
	ard(){
		f = new JFrame();
		f.setTitle("Arduino-Java");
		f.setLayout(new FlowLayout());
		f.setSize(1000,500);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);

		pL = new JComboBox<String>();
		f.add(pL);

		cBtn = new JButton("Connect");
		cBtn.addActionListener(this);
		f.add(cBtn);

		xBtn = new JButton("Exit");
		xBtn.addActionListener(this);
		f.add(xBtn);

		lBtn = new JButton("Left");
		lBtn.addActionListener(this);
		f.add(lBtn);

		rBtn = new JButton("Right");
		rBtn.addActionListener(this);
		f.add(rBtn);

		fBtn = new JButton("Front");
		fBtn.addActionListener(this);
		f.add(fBtn);

		bBtn = new JButton("Back");
		bBtn.addActionListener(this);
		f.add(bBtn);

		oBtn = new JButton("OFF");
		oBtn.addActionListener(this);
		f.add(oBtn);

		SerialPort[] portNames = SerialPort.getCommPorts();
		for(int i=0; i<portNames.length; i++)
			pL.addItem(portNames[i].getSystemPortName());
	}
	public static void main(String[] args){
		new ard();
	}
	@Override
	public void actionPerformed(ActionEvent e){
		btn = e.getActionCommand();
		if(btn.equals("Connect")){
			p = SerialPort.getCommPort(pL.getSelectedItem().toString());
			p.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER,0,0);
			System.out.println(p);
			if(p.openPort()){
				cBtn.setText("Disconnect");
				pL.setEnabled(false);
			}
		}else if(btn.equals("Disconnect")){
			p.closePort();
			pL.setEnabled(true);
			cBtn.setText("Connect");
		}else if(btn.equals("Exit")){
			System.exit(0);
		}else{
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
		}
	}
}
