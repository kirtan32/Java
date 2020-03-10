import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.stream.Stream;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
class ImagePanel1 extends JPanel{

    private BufferedImage image;

    public ImagePanel1() {
       try {                
          image = ImageIO.read(new File("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/ex/main_top1.jpg"));
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
public class main_top_panel extends JPanel implements ActionListener,MouseListener
{
	JButton logo;
	JLabel logoname;
	JTextArea jt;
	JScrollPane jsc;
	Font f0,f1,f2;
	String lab;
	JButton left,right,main_menu;
	JButton pic;
	String picpath[],picdesc[];
	JPanel updationpanel;
	int counter=0;
	JLabel updation;
	Hashtable<String,String> table = new Hashtable<String,String>(); 
	//top menu
	JPanel top_menu;
	public JButton menu,pre,dark;
	JLabel darkmode;
	public int darkflag=1;
	
	main_top_panel()
	{
		setBounds(0,0,1200,800);
		setLayout(null);
		setBackground(Color.DARK_GRAY);
			
		f0=new Font("TimesRoman",Font.PLAIN,30);
		f1=new Font("TimesRoman",Font.BOLD,40);
		f2=new Font("TimesRoman",Font.BOLD,15);
		
		top_menu = new JPanel();
		top_menu.setLayout(null);
		top_menu.setBackground(Color.black);
		top_menu.setBounds(0,0,1200,150);
		top_menu.setVisible(false);//#ff00a9
		top_menu.setBorder(BorderFactory.createMatteBorder(4, 0,3, 0, Color.decode("#ff00a9")));
		
		menu = new JButton();
		menu.setLayout(null);
		menu.setBounds(1100,50,50,50);
		menu.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/menu1.png"));
		menu.setBorder(null);
		menu.setFocusable(false);
		menu.setContentAreaFilled(false);
		menu.setOpaque(false);
		menu.setToolTipText("More Options");
		
		darkmode = new JLabel("Dark Mode");
		darkmode.setLayout(null);
		darkmode.setBounds(850,50,150,50);
		darkmode.setBorder(null);
		darkmode.setForeground(Color.white);
		darkmode.setFont(new Font("Arial",Font.PLAIN,20));
		
		dark = new JButton();
		dark.setLayout(null);
		dark.setBounds(1000,50,50,50);
		dark.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/dark2.png"));
		dark.setBorder(null);
		dark.setFocusable(false);
		dark.setContentAreaFilled(false);
		dark.setOpaque(false);
		dark.setToolTipText("Dark Mode Option");
		
		dark.addActionListener(this);
		dark.addMouseListener(this);
		dark.setActionCommand("dark");
		
		pre = new JButton();
		pre.setLayout(null);
		pre.setBounds(10,50,70,70);
		pre.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/leftarrow12.png"));
		pre.setBorder(null);
		pre.setFocusable(false);
		pre.setContentAreaFilled(false);
		pre.setOpaque(false);
		pre.setToolTipText("Back");
		
		JLabel lname=new JLabel("AdEx");
		lname.setLayout(null);
		lname.setBounds(560,0,300,150);
		lname.setForeground(Color.white);
		lname.setFont(f1);
		
		top_menu.add(menu);
		top_menu.add(pre);
		top_menu.add(lname);
		top_menu.add(dark);
		top_menu.add(darkmode);
		
		logo=new JButton();
		logo.setLayout(null);
		logo.setBounds(450,0,150,150);
		logo.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/logo4.png"));
		logo.setContentAreaFilled(false);
		logo.setOpaque(false);
		logo.setBorder(null);
		
		logo.setActionCommand("back");
		logo.addActionListener(this);
		logo.addMouseListener(this);
		
		logoname=new JLabel("AdEx");
		logoname.setLayout(null);
		logoname.setBounds(560,0,300,150);
		logoname.setForeground(Color.white);
		logoname.setFont(f1);
		
		main_menu = new JButton();
		main_menu.setLayout(null);
		main_menu.setBounds(1100,50,50,50);
		main_menu.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/menu2.png"));
		main_menu.setBorder(null);
		main_menu.setFocusable(false);
		main_menu.setContentAreaFilled(false);
		main_menu.setOpaque(false);
		
		updationpanel = new JPanel();
		updationpanel.setLayout(null);
		updationpanel.setBackground(Color.black);
		updationpanel.setBounds(0,160,1200,500);
		//Border b2 = BorderFactory.createLineBorder(Color.cyan, 4);
		updationpanel.setBorder(BorderFactory.createMatteBorder(4, 0,4, 0, Color.cyan));
		
		updation = new JLabel("Weekly Updation");
		updation.setLayout(null);
		updation.setBounds(480,10,240,40);
		updation.setFont(new Font("TimesRoman",Font.BOLD,25));
		updation.setForeground(Color.white);
		updation.setBackground(Color.black);
		updation.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.cyan));
		
		pic = new JButton();
		pic.setBounds(210,70,780,400);
		//pic.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/ex/Image/6.jpg"));
		pic.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 5, Color.cyan));
		
		setPic();
		
		left=new JButton();
		left.setBounds(10,70,200,400);
		left.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/arrow0022.png"));
		left.setLayout(null);
		left.setOpaque(false);
		left.setBorder(null);
		left.setFocusable(false);
		left.setContentAreaFilled(false);
		
		right=new JButton();
		right.setBounds(990,70,200,400);
		right.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/arrow0042.png"));
		right.setLayout(null);
		right.setOpaque(false);
		right.setBorder(null);
		right.setFocusable(false);
		right.setContentAreaFilled(false);
		//pic.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/arrow2.png"));
		/*logonameX=new JLabel("X");
		logonameX.setLayout(null);
		logonameX.setBounds(640,0,400,150);
		logonameX.setForeground(Color.green);
		logonameX.setFont(f2);
		
		
		logoname=new JLabel("dE");
		logoname.setLayout(null);
		logoname.setBounds(570,40,400,100);
		logoname.setForeground(Color.green);
		logoname.setFont(f1);
		
		logonamemsu=new JLabel("MSU");
		logonamemsu.setLayout(null);
		logonamemsu.setBounds(555,32,200,50);
		logonamemsu.setForeground(Color.white);
		logonamemsu.setFont(f0);*/
		
		jt = new JTextArea();
		jt.setLayout(null);
		jt.setEditable(false);
		jt.setBackground(Color.DARK_GRAY);
		jt.setForeground(Color.white);
		jt.setFont(f2);
		
		jsc = new JScrollPane(jt);
		jsc.setBounds(50,30,680,340);
		jsc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    jsc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    jsc.setBackground(Color.gray);
	    Border border1 = BorderFactory.createLineBorder(Color.black, 2);
	    jsc.setBorder(border1);
	    jsc.setVisible(false);
		
	    pic.add(jsc);
	    
	    updationpanel.add(pic);
	    updationpanel.add(updation);
	    updationpanel.add(left);
	    updationpanel.add(right);
		add(logo);
		add(top_menu);
		add(logoname);
		add(updationpanel);
		add(main_menu);
//		add(pic);
//		add(left);
//		add(right);
		menu.setActionCommand("menu");
		menu.addActionListener(this);
		menu.addMouseListener(this);
		main_menu.setActionCommand("main_menu");
		main_menu.addActionListener(this);
		main_menu.addMouseListener(this);
		pre.setActionCommand("previous");
		pre.addActionListener(this);
		pre.addMouseListener(this);
		
		left.setActionCommand("left");
		left.addActionListener(this);
		left.addMouseListener(this);
		right.setActionCommand("right");
		right.addActionListener(this);
		right.addMouseListener(this);
		pic.setActionCommand("pic");
		pic.addActionListener(this);
		
	}
	void setPic()
	{
		try
		{
			String path="/home/kirtan/eclipse-workspace/MSU_AD_Sense/Faculty/";
			File mainfile = new File("/home/kirtan/eclipse-workspace/MSU_AD_Sense/Faculty");
			String mainfilelist[] = mainfile.list();
			LocalDate currentDate = LocalDate.now(); // 2016-06-17 
	        int doy = currentDate.getDayOfYear(); // 169 
	        int y = currentDate.getYear(); // 2016
	
			for(int i=0;i<mainfilelist.length;i++)
			{
				File subfile = new File(path+mainfilelist[i]);
				String subfilelist[] = subfile.list();
				for(int j=0;j<subfilelist.length;j++)
				{				
					File subsubfile = new File(path+mainfilelist[i]+"/"+subfilelist[j]);
					String subsubfilelist[] = subsubfile.list();
					for(int k=0;k<subsubfilelist.length;k++)
					{
						File corefile = new File(path+mainfilelist[i]+"/"+subfilelist[j]+"/"+subsubfilelist[k]);
						String corefilelist[] = corefile.list();
						for(int l=0;l<corefilelist.length;l++)
						{
							if(corefilelist[l].equals("days.txt"))
							{
								try {
								String totdays=readLineByLineJava8(path+mainfilelist[i]+"/"+subfilelist[j]+"/"+subsubfilelist[k]+"/days.txt");
								System.out.println(totdays);
								System.out.println(totdays.length());
								String parsedstring = totdays.substring(0, totdays.length()-1);
								System.out.println("-->"+parsedstring);
								int daysint=Integer.parseInt(parsedstring);
								System.out.println(""+daysint);
								if((doy-daysint)<=7)
								{
									String image_path="";
									for(int ite=0;ite<corefilelist.length;ite++)
									{
										if(corefilelist[ite].substring(0,5).equals("Image"))
										{
											System.out.println(corefilelist[ite].substring(0,5));
											image_path=path+mainfilelist[i]+"/"+subfilelist[j]+"/"+subsubfilelist[k]+"/"+corefilelist[ite];
										}
									} 
									File f=new File(image_path);
									table.put(path+mainfilelist[i]+"/"+subfilelist[j]+"/"+subsubfilelist[k]+"/Image."+getFileExtension(f),"\t\t"+subfilelist[j]+"\n\n"+readLineByLineJava8(path+mainfilelist[i]+"/"+subfilelist[j]+"/"+subsubfilelist[k]+"/Description.txt"));
//									System.out.println("\n\n-->"+mainfilelist[i]);
//									System.out.println("-->"+subfilelist[j]);
//									System.out.println("-->"+subsubfilelist[k]);
//									System.out.println("-->"+corefilelist[l]);
//									System.out.println("String-->"+readLineByLineJava8(path+mainfilelist[i]+"/"+subfilelist[j]+"/"+subsubfilelist[k]+"/Description.txt"));				
								
								}
								
								}
								catch(Exception e)
								{
									System.out.print(e.getMessage());
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		
			Enumeration<String> enumeration = table.keys();
		    
	        // iterate using enumeration object
			picpath = new String[table.size()];
			picdesc = new String[table.size()];
			int i=0;
	        while(enumeration.hasMoreElements()) {
	        	
	            String key = enumeration.nextElement();
	            picpath[i]=key;
	            picdesc[i]=table.get(key);
	            i++;
	        }
	        pic.setIcon(new ImageIcon(picpath[counter]));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	private static String readLineByLineJava8(String filePath) 
	{
		StringBuilder contentBuilder = new StringBuilder();
		try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) 
		{
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return contentBuilder.toString();
	}

	public void actionPerformed(ActionEvent ae)
	{	
		lab=ae.getActionCommand();
		if(lab.equals("left"))
		{
			if(counter==0)
			{
				counter=picpath.length-1;
				jsc.setVisible(false);
				//pic.setIcon(new ImageIcon(new GetRound().getImg(picpath[counter])));	
				pic.setIcon(new ImageIcon(picpath[counter]));

				
			}
			else
			{
				counter--;
				jsc.setVisible(false);
				pic.setIcon(new ImageIcon(picpath[counter]));
				//pic.setIcon(new ImageIcon(new GetRound().getImg(picpath[counter])));	
				
			}
		}
		else if(lab.equals("right"))
		{
			if(counter==(picpath.length-1))
			{
				counter=0;
				jsc.setVisible(false);
				pic.setIcon(new ImageIcon(picpath[counter]));
				
			}
			else
			{
				counter++;
				jsc.setVisible(false);
				pic.setIcon(new ImageIcon(picpath[counter]));
				
			}
		}
		else if(lab.equals("pic"))
		{
			jt.setText(picdesc[counter]);
			jsc.setVisible(true);
		}
		else if(lab.equals("menu"))
		{
			top_menu.setVisible(false);
		}
		else if(lab.equals("main_menu"))
		{
			top_menu.setVisible(true);
		}
		else if(lab.equals("dark"))
		{
			darkflag++;
			if(darkflag%2==0)
			{
				dark.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/dark1.png"));
			}
			else
			{
				dark.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/dark2.png"));
			}
		}
	}
	public void mouseClicked(MouseEvent e) 
	{  
		AbstractButton ESource = (AbstractButton)e.getSource();
		if(ESource.equals(left))
		{
			left.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/arrow002.png"));
		}
		else if(ESource.equals(right))
		{
			right.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/arrow005.png"));
		}
    }  
    public void mouseEntered(MouseEvent e) 
    {  
    	AbstractButton ESource = (AbstractButton)e.getSource();
    	if(ESource.equals(left))
		{
			left.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/arrow0021.png"));
		}
		else if(ESource.equals(right))
		{
			right.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/arrow0041.png"));
		}
		else if(ESource.equals(menu))
		{
			menu.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/menu2.png"));
		}
		else if(ESource.equals(main_menu))
		{
			main_menu.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/menu1.png"));
		}
		else if(ESource.equals(pre))
		{
			pre.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/leftarrow1.png"));
		}
    }  
    public void mouseExited(MouseEvent e) 
    {  
    	AbstractButton ESource = (AbstractButton)e.getSource();
    	if(ESource.equals(left))
		{
			left.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/arrow0022.png"));
		}
		else if(ESource.equals(right))
		{
			right.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/arrow0042.png"));
		}
		else if(ESource.equals(menu))
		{
			menu.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/menu1.png"));
		}
		else if(ESource.equals(main_menu))
		{
			main_menu.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/menu2.png"));
		}
		else if(ESource.equals(pre))
		{
			pre.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/leftarrow12.png"));
		}
    }  
    public void mousePressed(MouseEvent e) 
    {
    	AbstractButton ESource = (AbstractButton)e.getSource();
    	
    }  
    public void mouseReleased(MouseEvent e) 
    {
    	
    }  
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
