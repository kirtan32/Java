import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener,MouseListener
{
	JButton submit,reset;
	JLabel user,pass,login;
	JTextField userfield,passfield;
	Container cont;
	JPanel main,top;
	String lab;
	login(String s)
	{
		super(s);
		cont = getContentPane();
		cont.setLayout(new FlowLayout());
		
		Font f=new Font("Arial",Font.BOLD,15);
		
		setLayout(null);
		setVisible(true);
		setBounds(500,200,500,700);
		
		login=new JLabel("AdEx Login");
		login.setBackground(Color.black);
		login.setForeground(Color.green);
		login.setBounds(120,50,300,100);
		login.setFont(new Font("Times New Romen", Font.BOLD, 40));
		
		user=new JLabel("User Name");
		user.setBackground(Color.white);
		user.setForeground(Color.decode("#C3337B"));
		user.setFont(new Font("Times New Romen", Font.BOLD, 22));
		user.setBounds(20,70,300,50);
		
		userfield=new JTextField();
		userfield.setBackground(Color.white);
		userfield.setForeground(Color.black);
		userfield.setFont(f);
		userfield.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		userfield.setBounds(20,130,400,50);
		
		pass=new JLabel("Password");
		pass.setBackground(Color.white);
		pass.setForeground(Color.decode("#C3337B"));
		pass.setFont(new Font("Arial", Font.BOLD, 22));
		pass.setBounds(20,190,300,50);
		
		passfield=new JTextField();
		passfield.setForeground(Color.black);
		passfield.setBackground(Color.white);
		passfield.setFont(f);
		passfield.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		passfield.setBounds(20,250,400,50);
		
		submit=new JButton("Login");
		submit.setBackground(Color.white);
		submit.setForeground(Color.decode("#390044"));
		submit.setFocusable(false);
		submit.setBounds(20,350,150,70);
		submit.setFont(new Font("Arial", Font.BOLD, 25));
		submit.setBorder(null);
		
		reset=new JButton("Reset");
		reset.setBackground(Color.white);
		reset.setForeground(Color.decode("#390044"));
		reset.setFocusable(false);
		reset.setBounds(200,350,150,70);
		reset.setFont(new Font("Arial", Font.BOLD, 25));
		reset.setBorder(null);
		
		top=new JPanel();
		top.setLayout(null);
		top.setBounds(0,0,500,200);
		top.setBackground(Color.black);
		
		main=new JPanel();
		main.setLayout(null);
		main.setBounds(0,200,500,500);
		main.setBackground(Color.white);
		
		top.add(login);
		main.add(user);
		main.add(userfield);
		main.add(pass);
		main.add(passfield);
		main.add(submit);
		main.add(reset);
		cont.add(top);
		cont.add(main);
		
		submit.addActionListener(this);
		submit.addMouseListener(this);
		
		reset.addActionListener(this);
		reset.addMouseListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		lab=ae.getActionCommand();
		if(lab.equals("Login"))
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("\n Driver Registred Successfully");
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/msudb","root","");
				System.out.println("\nDatabase Connected Successfully");
				
				Statement st=con.createStatement();
				
				ResultSet rs=st.executeQuery("select * from mytab");
				
				
				rs.close();
				st.close();
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
				setVisible(false);
				dispose();
		}
		else if(lab.equals("Reset"))
		{
			
		}
	}
	public void mouseClicked(MouseEvent e) 
	{  
		
    }  
    public void mouseEntered(MouseEvent e) 
    {  
    	AbstractButton EventSource = (AbstractButton)e.getSource();
    	EventSource.setForeground(Color.green);
    }  
    public void mouseExited(MouseEvent e) 
    {  
    	AbstractButton EventSource = (AbstractButton)e.getSource();
    	EventSource.setForeground(Color.decode("#390044"));
    }  
    public void mousePressed(MouseEvent e) 
    {
    	
    }  
    public void mouseReleased(MouseEvent e) 
    {
    	
    }  
}
