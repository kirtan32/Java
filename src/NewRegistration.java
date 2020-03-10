import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class NewRegistration extends JFrame implements ActionListener,MouseListener
{
	String lab;
	Container cont;
	JPanel pan;
	JButton maximize,minimize,submit,reset;
	JLabel name,mail,logo;
	JTextField namefield,mailfield;
	JTextArea ta;
	int i=0;
	NewRegistration() {
		cont=getContentPane();
		cont.setLayout(null);
		setLayout(null);
		setUndecorated(true);
		setBounds(660,150,500,700);
		setBackground(new Color(0,0,0,150));
		setVisible(true);
		
		ImageIcon img = new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/icon2.png");
		this.setIconImage(img.getImage());
		
		Font f1=new Font("TimesRoman",Font.BOLD,22);
		Font f2=new Font("TimesRoman",Font.PLAIN,20);
		
		maximize=new JButton();
		maximize.setLayout(null);
		maximize.setBounds(10,10,20,20);
		maximize.setFocusable(false);
		//maximize.setBorderPainted(false);
		maximize.setBackground(Color.black);
		maximize.setBorder(new LineBorder(Color.red,1));
		
		minimize=new JButton();
		minimize.setLayout(null);
		minimize.setBounds(40,10,20,20);
		minimize.setFocusable(false);
		//minimize.setBorderPainted(false);
		minimize.setBackground(Color.black);
		minimize.setBorder(new LineBorder(Color.yellow,1));
		
		pan=new JPanel();
		pan.setBackground(new Color(0,0,0,0));
		pan.setLayout(null);
		pan.setVisible(true);
		pan.setBounds(0,0,500,700);
		
		logo=new JLabel();
		logo.setLayout(null);
		logo.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/icon2.png"));
		logo.setBounds(200,30,100,100);
		
		ta=new JTextArea();
		ta.setBackground(new Color(0,0,0,0));
		ta.setBounds(20,150,460,50);
		ta.setText("Register name & mail id to get\nUpdation of MSU Events.");
		ta.setForeground(Color.white);
		ta.setEditable(false);
		ta.setFont(f2);
		
		name=new JLabel("Name");
		name.setLayout(null);
		name.setBounds(20,210,200,50);
		name.setBackground(new Color(0,0,0,0));
		name.setForeground(Color.decode("#BF3EFF"));
		name.setFont(f1);
		
		namefield=new JTextField();
		namefield.setLayout(null);
		namefield.setBackground(Color.black);
		namefield.setForeground(Color.white);
		namefield.setFont(f2);
		namefield.setBounds(20,280,460,60);
		namefield.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));		
		
		mail=new JLabel("E-Mail");
		mail.setLayout(null);
		mail.setBounds(20,360,200,50);
		mail.setBackground(new Color(0,0,0,0));
		mail.setForeground(Color.decode("#BF3EFF")); 
		mail.setFont(f1);
		
		mailfield=new JTextField();
		mailfield.setLayout(null);
		mailfield.setBackground(Color.black);
		mailfield.setForeground(Color.white);
		mailfield.setFont(f2);
		mailfield.setBounds(20,430,460,60);
		mailfield.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
		
		submit=new JButton("Submit");
		submit.setLayout(null);
		submit.setBounds(70,570,150,50);
		submit.setBackground(Color.black);
		submit.setForeground(Color.decode("#FF4040"));
		submit.setFont(f1);
		submit.setFocusable(false);
		submit.setBorder(new LineBorder(Color.green,3));
		
		reset=new JButton("Reset");
		reset.setLayout(null);
		reset.setBounds(280,570,150,50);
		reset.setBackground(Color.black);
		reset.setForeground(Color.decode("#FF4040"));
		reset.setFont(f1);
		reset.setFocusable(false);
		reset.setBorder(new LineBorder(Color.green,3));
		
		pan.add(logo);
		pan.add(ta);
		pan.add(name);
		pan.add(namefield);
		pan.add(mail);
		pan.add(mailfield);
		pan.add(submit);
		pan.add(reset);
		
		cont.add(pan);
		cont.add(maximize);
		cont.add(minimize);
		
		maximize.setActionCommand("x");
		minimize.setActionCommand("-");
		
		maximize.addActionListener(this);
		minimize.addActionListener(this);
		maximize.addMouseListener(this);
		minimize.addMouseListener(this);
		
		submit.addActionListener(this);
		reset.addActionListener(this);
		submit.addMouseListener(this);
		reset.addMouseListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		
		lab=ae.getActionCommand();
		if(lab.equals("x"))
		{
			System.out.println("-->"+namefield.getText()+"  -->"+mailfield.getText());
			this.setVisible(false);
		}
		else if(lab.equals("-"))
		{
			setState(this.ICONIFIED);
		}
		else if(lab.equals("Reset"))
		{
			namefield.setText("");
			mailfield.setText("");
		}
		else if(lab.equals("Submit"))
		{
			if((namefield.getText().equals("")) || (mailfield.getText().equals("")))
			{
				
			}
			else
			{
				i++;
				if(i==1)
				{
				SendMailSSL s1=new SendMailSSL(namefield.getText(),mailfield.getText());
				s1.SendMSG();
				}
			}
			this.setVisible(false);
		}
	}
	public void mouseClicked(MouseEvent e) 
	{  
		AbstractButton ESource = (AbstractButton)e.getSource();
		if(ESource.equals(maximize))
    	{
    		maximize.setBackground(Color.green);
    	}
    	else if(ESource.equals(minimize))
    	{
    		minimize.setBackground(Color.green);
    	}
    }  
    public void mouseEntered(MouseEvent e) 
    {  
    	AbstractButton ESource = (AbstractButton)e.getSource();
    	if(ESource.equals(maximize))
    	{
    		maximize.setBackground(Color.red);
    	}
    	else if(ESource.equals(minimize))
    	{
    		minimize.setBackground(Color.YELLOW);
    	}
    	else if(ESource.equals(submit))
    	{
    		submit.setBackground(Color.darkGray);
    		submit.setForeground(Color.green);
    	}
    	else if(ESource.equals(reset))
    	{
    		reset.setBackground(Color.darkGray);
    		reset.setForeground(Color.green);
    	}
    }  
    public void mouseExited(MouseEvent e) 
    {  
    	AbstractButton ESource = (AbstractButton)e.getSource();
    	if(ESource.equals(maximize))
    	{
    		maximize.setBackground(Color.black);
    	}
    	else if(ESource.equals(minimize))
    	{
    		minimize.setBackground(Color.black);
    	}
    	else if(ESource.equals(submit))
    	{
    		submit.setBackground(Color.black);
    		submit.setForeground(Color.decode("#FF4040"));
    	}
    	else if(ESource.equals(reset))
    	{
    		reset.setBackground(Color.black);
    		reset.setForeground(Color.decode("#FF4040"));
    	}
    }  
    public void mousePressed(MouseEvent e) 
    {
    	
    }  
    public void mouseReleased(MouseEvent e) 
    {
    	
    }  
}
