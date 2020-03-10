import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SendGreetings extends JFrame implements ActionListener,MouseListener
{
	String lab;
	Container cont;
	JPanel main,top;
	SendGreetings(String s)
	{
		super(s);
		cont = getContentPane();
		cont.setLayout(new FlowLayout());
		
		Font f1=new Font("Arial",Font.BOLD,20);
		
		setLayout(null);
		setUndecorated(true);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		lab=ae.getActionCommand();
		if(lab.equals("Login"))
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