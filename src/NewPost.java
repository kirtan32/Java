import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class NewPost extends JFrame implements ActionListener,MouseListener,ItemListener
{
	String lab;
	JButton maximize,minimize,submit,filechoose;
	Container cont;
	JPanel pan;
	JComboBox faculty_jcb,event_jcb;
	JLabel select_img,select_faculty,select_event,p_name,img_lab,filechooselab,imagelab;
	JFileChooser jf;
	JTextField p_field;
	JTextArea description;
	ImageResize IR;
	Image im;
	JScrollPane jsp;
	String faculty,event,imagefilename;
	File chooserimage;
	Font f1,f2;
	NewPost()
	{
		cont=getContentPane();
		cont.setLayout(null);
		setLayout(null);
		setUndecorated(true);
		setBounds(550,10,700,960);
		setBackground(Color.black);
		setVisible(true);
		
		ImageIcon img = new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/icon2.png");
		this.setIconImage(img.getImage());
		
		f1=new Font("TimesRoman",Font.BOLD,22);
		f2=new Font("TimesRoman",Font.PLAIN,15);
		
		maximize=new JButton();
		maximize.setLayout(null);
		maximize.setBounds(10,10,20,20);
		maximize.setFocusable(false);
		maximize.setBackground(Color.black);
		maximize.setBorder(new LineBorder(Color.red,1));
		
		minimize=new JButton();
		minimize.setLayout(null);
		minimize.setBounds(40,10,20,20);
		minimize.setFocusable(false);
		minimize.setBackground(Color.black);
		minimize.setBorder(new LineBorder(Color.yellow,1));
		
		pan=new JPanel();
		pan.setLayout(null);
		pan.setBounds(0,0,700,960);
		pan.setBackground(Color.black);
		
		select_faculty=new JLabel("Faculty");
		select_faculty.setLayout(null);
		select_faculty.setBackground(new Color(0,0,0,150));
		select_faculty.setBounds(30,50,100,30);
		select_faculty.setFont(f1);
		select_faculty.setForeground(Color.white);
		
		// add data to jcomboBox faculty
		File f=new File("/home/kirtan/eclipse-workspace/MSU_AD_Sense/Faculty");
		String faculties[]=f.list();
		
		faculty_jcb=new JComboBox();
		faculty_jcb.setBounds(250,50,400,30);
		//faculty_jcb.setLayout(null);
		faculty_jcb.setBackground(Color.black);
		faculty_jcb.setForeground(Color.white);
		faculty_jcb.setFont(f2);
		faculty_jcb.setFocusable(false);
		faculty_jcb.setBorder(null);
		
		faculty_jcb.addItemListener(this);
		
		select_event=new JLabel("Event");
		select_event.setLayout(null);
		select_event.setBackground(Color.black);
		select_event.setFont(f1);
		select_event.setForeground(Color.white);
		select_event.setBounds(30,100,100,30);
		
		event_jcb=new JComboBox();
		event_jcb.setBounds(250,100,400,30);
		event_jcb.setBackground(Color.black);
		event_jcb.setFocusable(false);
		event_jcb.setBorder(null);
		event_jcb.setFont(f2);
		event_jcb.setForeground(Color.white);
		event_jcb.setEnabled(false);
		
		for(int i=0;i<faculties.length;i++)
		{		  
		  faculty_jcb.addItem(faculties[i]);
		}
		p_name=new JLabel("Name of Post");
		p_name.setBackground(Color.black);
		p_name.setLayout(null);
		p_name.setFont(f1);
		p_name.setForeground(Color.white);
		p_name.setBounds(30,150,200,30);
		
		p_field=new JTextField();
		p_field.setBackground(Color.black);
		p_field.setLayout(null);
		p_field.setFont(f1);
		p_field.setBorder(new LineBorder(Color.decode("#FFCF61")));
		p_field.setForeground(Color.white);
		p_field.setBounds(250,150,400,30);
		
		img_lab=new JLabel("Choose Image");
		img_lab.setBackground(Color.black);
		img_lab.setLayout(null);
		img_lab.setFont(f1);
		img_lab.setBorder(null);
		img_lab.setForeground(Color.white);
		img_lab.setBounds(30,200,200,30);
		
		filechoose=new JButton("File");
		filechoose.setBackground(Color.green);
		filechoose.setForeground(Color.black);
		filechoose.setFont(f1);
		filechoose.setBounds(250,240,100,30);
		filechoose.setBorder(null);
		filechoose.setFocusable(false);
		
		filechooselab=new JLabel();
		filechooselab.setBackground(Color.black);
		filechooselab.setLayout(null);
		filechooselab.setFont(new Font("TimesRoman",Font.PLAIN,15));
		filechooselab.setForeground(Color.white);
		filechooselab.setBounds(250,200,400,30);
		filechooselab.setBorder(new LineBorder(Color.decode("#FFCF61")));
		
		imagelab=new JLabel();
		imagelab.setBackground(Color.white);
		imagelab.setLayout(null);
		imagelab.setBounds(30,280,640,380);
		imagelab.setBorder(new LineBorder(Color.decode("#FFCF61")));
		//imagelab.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/Cam02.png"));
		ImageResize IR=new ImageResize("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/Cam01.png",300 ,200 );
		ImageIcon i1=new ImageIcon(IR.Resize());
		imagelab.setIcon(i1);
		
		description=new JTextArea();
		description.setFont(new Font("TimesRoman",Font.PLAIN,18));
		description.setBackground(Color.black);
		description.setForeground(Color.white);
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		//description.setLayout(null);
		//description.setBorder(new LineBorder(Color.white));
		description.setBounds(30,670,640,230);
		
		jsp=new JScrollPane(description);
		//jsp.setLayout(null);
		jsp.setBounds(30,670,640,230);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.getVerticalScrollBar().setBackground(Color.BLACK);
		jsp.getHorizontalScrollBar().setBackground(Color.BLACK);
		//jsp.setBorder(new LineBorder(Color.white));
		//jsp.setBackground(Color.black);
		//jsp.setForeground(Color.white);
		//.setBackground(Color.black);
		//jsp.setForeground(Color.white);
		submit=new JButton("Post");
		submit.setBackground(Color.green);
		submit.setForeground(Color.white);
		submit.setFont(f1);
		submit.setLayout(null);
		submit.setFocusable(false);
		submit.setBorder(null);
		submit.setBounds(500,910,150,40);
		
		pan.add(select_faculty);
		pan.add(faculty_jcb);
		pan.add(select_event);
		pan.add(event_jcb);
		pan.add(p_name);
		pan.add(p_field);
		pan.add(img_lab);
		pan.add(filechoose);
		pan.add(filechooselab);
		pan.add(imagelab);
		pan.add(submit);
		//pan.add(description);
		pan.add(jsp);
		//pan.add(jf);
		
		filechoose.addMouseListener(this);
		filechoose.addActionListener(this);
		
		submit.addActionListener(this);
		submit.addMouseListener(this);
		
		maximize.setActionCommand("x");
		minimize.setActionCommand("-");
		
		maximize.addActionListener(this);
		minimize.addActionListener(this);
		maximize.addMouseListener(this);
		minimize.addMouseListener(this);
		
		cont.add(pan);
		cont.add(minimize);
		cont.add(maximize);
	}
	public void actionPerformed(ActionEvent ae)
	{
		lab=ae.getActionCommand();
		if(lab.equals("x"))
		{
			this.setVisible(false);
		}
		else if(lab.equals("-"))
		{
			setState(this.ICONIFIED);
		}
		else if(lab.equals("File"))
		{
			jf=new JFileChooser();
			jf.showSaveDialog(null);
			jf.setBackground(Color.black);
			jf.setForeground(Color.white);
			jf.setBorder(null);
			filechooselab.setText(jf.getSelectedFile().getAbsolutePath()); 
			filechooselab.setToolTipText(jf.getSelectedFile().getAbsolutePath());
			System.out.println("-->"+jf.getSelectedFile());
			System.out.println("-->"+jf.getSelectedFile().getAbsolutePath());
			System.out.println("-->"+jf.getSelectedFile().getAbsoluteFile());
			chooserimage=new File(jf.getSelectedFile().getAbsolutePath());
			String imfiles[]=jf.getSelectedFile().getAbsolutePath().split("/");
			imagefilename=imfiles[imfiles.length-1];
			System.out.println("-->"+imagefilename);
			IR=new ImageResize(jf.getSelectedFile().getAbsolutePath(),640 ,380 );
			im=IR.Resize();
			ImageIcon i1=new ImageIcon(im);
			imagelab.setIcon(i1);
		}
		else if(lab.equals("Post"))
		{
			try {
				File makingdir=new File("/home/kirtan/eclipse-workspace/MSU_AD_Sense/Faculty/"+faculty_jcb.getSelectedItem().toString()+"/"+event_jcb.getSelectedItem().toString()+"/"+p_field.getText());
				Boolean bool=makingdir.mkdir();
				if(bool)
				{
					File newFileimg = new File("/home/kirtan/eclipse-workspace/MSU_AD_Sense/Faculty/"+faculty_jcb.getSelectedItem().toString()+"/"+event_jcb.getSelectedItem().toString()+"/"+p_field.getText()+"/Image."+getFileExtension(chooserimage));
					System.out.println("------->"+newFileimg.getName());
			        ImageIO.write((BufferedImage)new ImageResize(jf.getSelectedFile().getAbsolutePath(),780 ,400 ).Resize(), getFileExtension(chooserimage), newFileimg);
			        /*construct main image */
			        File newFileimg1 = new File("/home/kirtan/eclipse-workspace/MSU_AD_Sense/Faculty/"+faculty_jcb.getSelectedItem().toString()+"/"+event_jcb.getSelectedItem().toString()+"/"+p_field.getText()+"/Imagemain."+getFileExtension(chooserimage));
					System.out.println("------->"+newFileimg1.getName());
			        ImageIO.write((BufferedImage)new ImageResize(jf.getSelectedFile().getAbsolutePath(),1200 ,800 ).Resize(), getFileExtension(chooserimage), newFileimg1);
			       
			        File newFiletxt = new File("/home/kirtan/eclipse-workspace/MSU_AD_Sense/Faculty/"+faculty_jcb.getSelectedItem().toString()+"/"+event_jcb.getSelectedItem().toString()+"/"+p_field.getText()+"/Description.txt");
			        File newFiledays = new File("/home/kirtan/eclipse-workspace/MSU_AD_Sense/Faculty/"+faculty_jcb.getSelectedItem().toString()+"/"+event_jcb.getSelectedItem().toString()+"/"+p_field.getText()+"/days.txt");
			        File newFileyear = new File("/home/kirtan/eclipse-workspace/MSU_AD_Sense/Faculty/"+faculty_jcb.getSelectedItem().toString()+"/"+event_jcb.getSelectedItem().toString()+"/"+p_field.getText()+"/year.txt");
			        
			        LocalDate currentDate = LocalDate.now(); // 2016-06-17 
			        int dom = currentDate.getDayOfMonth(); // 17 
			        int doy = currentDate.getDayOfYear(); // 169 
			        int y = currentDate.getYear(); // 2016

			        System.out.println("-->"+dom+"-->"+doy+"->"+y);
			       
			        Boolean b1=newFiletxt.createNewFile();
			        Boolean b2=newFiledays.createNewFile();
			        Boolean b3=newFileyear.createNewFile();
			        if(b1 && b2 && b3)
			        {
				        FileWriter fw=new FileWriter(newFiletxt);
				        fw.write(description.getText());
				        fw.close();
				        FileWriter fw1=new FileWriter(newFiledays);
				        fw1.write(""+doy);
				        fw1.close();
				        FileWriter fw2=new FileWriter(newFileyear);
				        fw2.write(""+y);
				        fw2.close();
				        HTMLMail mail=new HTMLMail("shahkirtan742@gmail.com", faculty_jcb.getSelectedItem().toString(), event_jcb.getSelectedItem().toString(), p_field.getText(), getFileExtension(chooserimage), description.getText());
				        mail.sendMail();
						this.setVisible(false);
			        }
			        else
			        {
			           	System.out.println("File txt not Created:");
			        }
				}
				else
				{
					System.out.println("File image is not created:");
				} 
			}
			catch(Exception e)
			{
				
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
    		submit.setBackground(Color.magenta);
    		submit.setForeground(Color.black);
    	}
    	else if(ESource.equals(filechoose))
    	{
    		filechoose.setBackground(Color.magenta);
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
    		submit.setBackground(Color.green);
    		submit.setForeground(Color.white);
    	}
    	else if(ESource.equals(filechoose))
    	{
    		filechoose.setBackground(Color.green);
    	}
    }  
    public void mousePressed(MouseEvent e) 
    {
    	
    }  
    public void mouseReleased(MouseEvent e) 
    {
    	
    }  
    public void itemStateChanged(ItemEvent ie)
	 {
	     String temp=ie.getItem().toString();
		 event_jcb.setEnabled(true);
		 event_jcb.removeAllItems();
		 File f=new File("/home/kirtan/eclipse-workspace/MSU_AD_Sense/Faculty/"+temp);
		 String event[]=f.list();
		 for(int i=0;i<event.length;i++)
		 {		  
		  event_jcb.addItem(event[i]);
		 }
	 }
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
