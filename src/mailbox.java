import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;

public class mailbox extends JFrame implements ActionListener,MouseListener
{

	JTextField mail;
	String lab;
	JPanel main,succ;
	JLabel name,sent;
	Container cont;
	JButton go,m;
	mailbox(String s)
	{
		super(s);
		cont = getContentPane();
		cont.setLayout(null);
		setLayout(null);
		
		succ=new JPanel();
		succ.setBorder(null);
		succ.setBounds(0,0,650,150);
		succ.setBackground(Color.black);
		
		sent=new JLabel("Success Fully Registered Your Mail");
		sent.setBackground(Color.black);
		sent.setForeground(Color.green);
		sent.setFont(new Font("Arial",Font.BOLD,24));
		sent.setBounds(50,50,400,70);
		
		succ.add(sent);
		cont.add(succ);
		succ.setVisible(false);
		main=new JPanel();
		main.setLayout(null);
		main.setBounds(0,0,650,150);
		main.setBackground(Color.black);
		
		name=new JLabel("Enter Your Mail:");
		name.setBounds(50,10,200,30);
		name.setBackground(Color.white);
		name.setForeground(Color.WHITE);
		name.setFont(new Font("Courier New", Font.BOLD, 18));
		
		m=new JButton("");
		m.setBounds(50,70,50,50);
		m.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/mail3.png"));
		m.setBackground(Color.black);
		m.setFocusable(false);
		m.setBorder(null);
		
		setLayout(null);
		setVisible(true);
		setBounds(800,300,620,170);
		
		Font f=new Font("Arial",Font.BOLD,15);
		
		mail=new JTextField();
		mail.setBounds(100,70,400,50);
		mail.setBackground(Color.black);
		mail.setForeground(Color.white);
		mail.setFont(f);
		mail.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
		
		go=new JButton("Go");
		go.setBounds(500,70,80,50);
		go.setBackground(Color.black);
		go.setForeground(Color.white);
		go.setFocusable(false);
		go.setBorder(null);
		go.setFont(f);
		
		main.add(name);
		main.add(mail);
		main.add(go);
		main.add(m);
		cont.add(main);
		
		go.addActionListener(this);
		go.addMouseListener(this);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		lab=ae.getActionCommand();
		if(lab.equals("Go"))
		{
			if((mail.getText()).equals(""))
			{
				
			}
			else
			{
				String mymail=mail.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("\n Driver Registred Successfully");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/AdEx","root","");
					System.out.println("\nDatabase Connected Successfully");
					
					Statement st=con.createStatement();
					
					//ResultSet rs=st.executeQuery("select * from mytab");
					st.executeUpdate("insert into mails values('kirtan',"+mymail+")");
					System.out.println("successfully Inserted");
					
					st.close();
					con.close();
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				this.setVisible(false);
				dispose();
			}
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
    	EventSource.setForeground(Color.white);//#979D2E
    }  
    public void mousePressed(MouseEvent e) 
    {
    	
    }  
    public void mouseReleased(MouseEvent e) 
    {
    	
    }  
}
