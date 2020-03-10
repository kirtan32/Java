import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

class ImagePanel extends JPanel{

    private BufferedImage image;

    public ImagePanel() {
       try {                
          image = ImageIO.read(new File("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/ex/dark2.jpg"));
       } catch (IOException ex) 
       {
    	   System.out.println("Error : "+ex.getMessage());
       }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }
}
public class Main2 extends JFrame implements ActionListener,MouseListener,KeyListener
{
	String lab;
	Container cont;
	main_panel main;
	ImagePanel Start;
	JLabel Start_logo,Start_welcome,Start_softname,Start_power,Start_powername,Start_dev,Start_devname;
	JButton Start_nextlab;
	JButton maximize,minimize,Start_register,Start_post;
	NewRegistration n1;
	NewPost n2;
	int i=0,j=0;
	Font sp1,sp2,sp3;
	Main2(String s)
	{
		super(s);
		cont=getContentPane();
		cont.setLayout(null);
		setLayout(null);
		setUndecorated(true);
		setBounds(300,100,1200,800);
		cont.setBounds(0,0,1200,800);
		
		ImageIcon img = new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/icon2.png");
		this.setIconImage(img.getImage());
		
		maximize=new JButton();
		maximize.setLayout(null);
		maximize.setBounds(10,10,28,28);
		//maximize.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/can3.png"));
		maximize.setFocusable(false);
		//maximize.setBorderPainted(false);
		//maximize.setBackground(Color.black);
//		maximize.setBorder(null);
//		maximize.setContentAreaFilled(false);
//		maximize.setOpaque(false);
//		//ImageResize IR=new ImageResize("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/can1.png", 30, 30);
		//ImageIcon ic=new ImageIcon(IR.Resize());
		
		//maximize.setIcon(ic);
		//maximize.setOpaque(false);
		//maximize.setContentAreaFilled(false);
		maximize.setBorder(new LineBorder(Color.red,1));
		
		minimize=new JButton();
		minimize.setLayout(null);
		minimize.setBounds(50,10,28,28);
		//minimize.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/cir1.jpg"));
		minimize.setFocusable(false);
		//minimize.setBorderPainted(false);
		minimize.setBackground(Color.black);
		minimize.setBorder(new LineBorder(Color.yellow,1));
		
		/*Start_icon=new JLabel();
		Start_icon.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/ex/01.jpg"));
		Start_icon.setLayout(null);
		Start_icon.setBounds(0,0,1200,800);*/
		Font f1=new Font("Arial",Font.BOLD,18);
		Font f2=new Font("Arial",Font.BOLD,40);
		Font f3=new Font("Arial",Font.BOLD,60);
		Font f4=new Font("TimesRoman",Font.PLAIN,18);
		sp1=new Font("TimesRoman",Font.PLAIN,30);
		sp2=new Font("TimesRoman",Font.BOLD,40);
		sp3=new Font("TimesRoman",Font.BOLD,80);
		
		
		Start_welcome=new JLabel("Welcome! To");
		Start_welcome.setLayout(null);
		Start_welcome.setBounds(440,50,500,70);
		Start_welcome.setFont(f2);
		Start_welcome.setForeground(Color.white);
		
		Start_logo=new JLabel();
		Start_logo.setLayout(null);
		Start_logo.setBounds(450,250,300,300);
		Start_logo.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/logo5.png"));
		
		Start_softname=new JLabel("AdEx");
		Start_softname.setLayout(null);
		Start_softname.setBounds(520,500,200,100);
		Start_softname.setForeground(Color.decode("#7FFF00"));
		Start_softname.setFont(f3);
		
		Start_register=new JButton("Register");
		Start_register.setLayout(null);
		Start_register.setBounds(430,620,150,50);
		Start_register.setBackground(Color.decode("#7FFF00"));
		Start_register.setForeground(Color.decode("#FF4040"));
		Start_register.setFont(f1);
		Start_register.setFocusable(false);
		Start_register.setBorder(new LineBorder(Color.green,3));
		Start_register.setToolTipText("New Student Registration");
		
		Start_post=new JButton("Post");
		Start_post.setLayout(null);
		Start_post.setBounds(640,620,150,50);
		Start_post.setBackground(Color.decode("#7FFF00"));
		Start_post.setForeground(Color.decode("#FF4040"));
		Start_post.setFont(f1);
		Start_post.setFocusable(false);
		Start_post.setBorder(new LineBorder(Color.green,3));
		Start_post.setToolTipText("Add New Post");
		
		Start_power=new JLabel("Powered By");
		Start_power.setLayout(null);
		Start_power.setBounds(20,700,400,50);
		Start_power.setForeground(Color.green);
		Start_power.setFont(f1);
		
		Start_powername=new JLabel("Maharaja Sayajirao University of Baroda");
		Start_powername.setLayout(null);
		Start_powername.setBounds(20,740,600,50);
		Start_powername.setForeground(Color.white);
		Start_powername.setFont(f4);
		
		Start_dev=new JLabel("Developed By");
		Start_dev.setLayout(null);
		Start_dev.setBounds(1045,700,150,50);
		Start_dev.setForeground(Color.green);
		Start_dev.setFont(f1);
		
		Start_devname=new JLabel("Base Infinity");
		Start_devname.setLayout(null);
		Start_devname.setBounds(1065,740,120,50);
		Start_devname.setForeground(Color.white);
		Start_devname.setFont(f4);
		
		/*Start_next=new JPanel();
		Start_next.setLayout(null);
		Start_next.setBackground(null);
		Start_next.setBounds(1000,0,200,800);
		Start_next.setVisible(true);
		*/
		Start_nextlab = new JButton();
		Start_nextlab.setBounds(1100,0,100,800);
		Start_nextlab.setLayout(null);
		Start_nextlab.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/2greater.png"));
		Start_nextlab.setBackground(Color.black);
		Start_nextlab.setFont(sp1);
		Start_nextlab.setForeground(Color.white);
		Start_nextlab.setFocusable(false);
		Start_nextlab.setBorder(null);
		Start_nextlab.setContentAreaFilled(false);
		Start_nextlab.setOpaque(false);
		
		Start=new ImagePanel();
		Start.setBounds(0,0,1200,800);
		Start.setLayout(null);
		
		main = new main_panel();
		main.setVisible(false);
		
		Start.add(Start_nextlab);
		Start.add(Start_welcome);
		Start.add(Start_logo);
		Start.add(Start_softname);
		Start.add(Start_register);
		Start.add(Start_post);
		Start.add(Start_power);
		Start.add(Start_powername);
		Start.add(Start_dev);
		Start.add(Start_devname);
		       
		cont.add(Start);
		cont.add(main);
		cont.add(maximize);
		cont.add(minimize);
		//cont.add(scrollPane);
		
		maximize.setActionCommand("x");
		minimize.setActionCommand("-");
		
		Start_nextlab.setActionCommand(">");
		Start_nextlab.addActionListener(this);
		Start_nextlab.addMouseListener(this);
		
		maximize.addActionListener(this);
		minimize.addActionListener(this);
		maximize.addMouseListener(this);
		minimize.addMouseListener(this);
		Start_register.addActionListener(this);
		Start_post.addActionListener(this);
		Start_register.addMouseListener(this);
		Start_post.addMouseListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		
		lab=ae.getActionCommand();
		if(lab.equals("x"))
		{
			try{
				n1.dispose();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			try{
				n2.dispose();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			this.setVisible(false);
			System.exit(0);
		}
		else if(lab.equals("-"))
		{
			setState(this.ICONIFIED);
		}
		else if(lab.equals("Register"))
    	{
			try {
				i++;
				if(i==1)
				{
					n1=new NewRegistration();
				}
				else
				{
					if(n1.isShowing())
					{
						System.out.println("Already in Running");
					}
					else
					{
						n1=new NewRegistration();
					}
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
    	}
    	else if(lab.equals("Post"))
    	{
    		try {
				j++;
				if(j==1)
				{
					n2=new NewPost();
				}
				else
				{
					if(n2.isShowing())
					{
						System.out.println("Already in Running");
					}
					else
					{
						n2=new NewPost();
					}
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
    	}
    	else if(lab.equals(">"))
    	{
    		if(main.isVisible()==false)
        	{
    	    		//cont.remove(Start);
    	    		Start.setVisible(false);
    	    		main.setVisible(true);
    	            System.out.println("In Main Panel after > Pressed:");
        	}
    	}
    	else if(lab.equals("back"))
    	{
    		if(Start.isVisible()==false)
        	{
    	    		//cont.remove(main);
    	    		main.setVisible(false);
    	    		Start.setVisible(true);
    	            System.out.println("In Start Panel after logo Pressed:");
        	}
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
    	else if(ESource.equals(Start_nextlab))
    	{
    		Start_nextlab.setBackground(Color.black);
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
    	else if(ESource.equals(Start_register))
    	{
    		Start_register.setBackground(Color.black);
    		Start_register.setForeground(Color.green);
    	}
    	else if(ESource.equals(Start_post))
    	{
    		Start_post.setBackground(Color.black);
    		Start_post.setForeground(Color.green);
    	}
    	else if(ESource.equals(Start_nextlab))
    	{
    		Start_nextlab.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/1greater.png"));
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
    	else if(ESource.equals(Start_register))
    	{
    		Start_register.setBackground(Color.decode("#7FFF00"));
    		Start_register.setForeground(Color.decode("#FF4040"));
    	}
    	else if(ESource.equals(Start_post))
    	{
    		Start_post.setBackground(Color.decode("#7FFF00"));
    		Start_post.setForeground(Color.decode("#FF4040"));
    	}
    	else if(ESource.equals(Start_nextlab))
    	{
    		//Start_nextlab.setFont(sp1);
    		//Start_nextlab.setBackground(null);
    		//Start_nextlab.setForeground(Color.white);
    		Start_nextlab.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/2greater.png"));
    	}
    }  
    public void mousePressed(MouseEvent e) 
    {
    	AbstractButton ESource = (AbstractButton)e.getSource();
    	if(ESource.equals(Start_nextlab))
    	{
    		Start_nextlab.setBackground(Color.black);
    	}
    }  
    public void mouseReleased(MouseEvent e) 
    {
    	
    }  
    public void keyPressed(KeyEvent e) 
    {
    	if(main.isVisible()==false)
    	{
	    	if (e.getKeyCode()==KeyEvent.VK_ENTER){
	    		cont.remove(Start);
	    		Start.setVisible(false);
	    		main.setVisible(true);
	            System.out.println("In Main Panel after Enter Pressed:");
	        }
    	}
    }  
    public void keyReleased(KeyEvent e) 
    {  
    
    }  
    public void keyTyped(KeyEvent e) 
    {  
    	
    }  
}
