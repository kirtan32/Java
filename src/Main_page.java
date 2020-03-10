import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Main_page extends JFrame implements ActionListener,MouseListener
{	
	JButton get_updation,upload,searchlogo,downleft,downright;
	JTextField searchtop;
	//String col1,col2;
	String lab;
	Container cont;
	JPanel top,bottom;
	JLabel downmid;
	int i=0;
	Main_page(String s)
	{
		super(s);
		cont = getContentPane();
		cont.setLayout(null);
		setLayout(null);
		i=1;
		
		top=new JPanel();
		top.setBounds(0,0,1500,200);
		top.setLayout(null);
		top.setBackground(Color.black);
		
		Font font = new Font("Arial", Font.BOLD,18);
		searchtop=new JTextField();
		searchtop.setBackground(Color.LIGHT_GRAY);
		searchtop.setLayout(null);
		searchtop.setBounds(400,75,500,50);
		searchtop.setFont(font);
		
		searchlogo=new JButton("");
		searchlogo.setBounds(350,75,50,50);
		searchlogo.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/s1.png"));
		searchlogo.setBackground(Color.white);
		searchlogo.setFocusable(false);
		
		get_updation = new JButton("Register");
		get_updation.setBounds(1000,75,200,50);
		get_updation.setBackground(Color.white);
		get_updation.setForeground(Color.black);
		get_updation.setFont(font);
		get_updation.setFocusable(false);
		get_updation.setContentAreaFilled(true);
		
		//get_updation.setBorder(new RoundedBorder(10));
		
		upload=new JButton("New Post");
		upload.setBounds(1250,75,200,50);
		upload.setBackground(Color.white);
		upload.setForeground(Color.black);
		upload.setFont(font);
		upload.setFocusable(false);
		upload.setContentAreaFilled(true);
		
		bottom=new JPanel();
		bottom.setBounds(0,200,1500,750);
		bottom.setLayout(null);
		bottom.setBackground(Color.white);
		
		downmid=new JLabel();
		downmid.setLayout(null);
		downmid.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/1.jpeg"));
		downmid.setBounds(300,100,1200,500);
		
		downleft=new JButton("<");
		downright=new JButton(">");
		
		Font f1=new Font("TimesRomen",Font.BOLD,30);
		downleft.setFont(f1);
		downright.setFont(f1);
		downleft.setBounds(150,250,100,100);
		downright.setBounds(1200,250,100,100);
		downleft.setOpaque(false);
		downleft.setFocusPainted(false);
		downleft.setBorderPainted(false);
		downleft.setContentAreaFilled(false);
		//downleft.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		
		downright.setOpaque(false);
		downright.setFocusPainted(false);
		downright.setBorderPainted(false);
		downright.setContentAreaFilled(false);
		//downright.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		
		bottom.add(downmid);
		bottom.add(downleft);
		bottom.add(downright);
		
		
		top.add(get_updation);
		top.add(upload);
		top.add(searchtop);
		top.add(searchlogo);
		cont.add(top);
		cont.add(bottom);
		
		downleft.addActionListener(this);
		downright.addActionListener(this);
		get_updation.addMouseListener(this);
		get_updation.addActionListener(this);
		
		upload.addMouseListener(this);
		upload.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		
		lab=ae.getActionCommand();
		if(lab.equals("Register"))
		{
			final SendGreetings m1=new SendGreetings("Mail");
			
		}
		else if(lab.equals("New Post"))
		{
			final login l1=new login("Login");
		}
		else if(lab.equals("<"))
		{
			if(i==1) {i=4;}
			i--;
			downmid.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/"+i+".jpeg"));
		}
		else if(lab.equals(">"))
		{
			if(i==3) {i=0;}
			i++;
			downmid.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/"+i+".jpeg"));
		}
	}
	public void mouseClicked(MouseEvent e) 
	{  
		
    }  
    public void mouseEntered(MouseEvent e) 
    {  
    	AbstractButton EventSource = (AbstractButton)e.getSource();
    	EventSource.setBackground(Color.green);
    }  
    public void mouseExited(MouseEvent e) 
    {  
    	AbstractButton EventSource = (AbstractButton)e.getSource();
    	EventSource.setBackground(Color.white);
    }  
    public void mousePressed(MouseEvent e) 
    {
    	
    }  
    public void mouseReleased(MouseEvent e) 
    {
    	
    }  
}
