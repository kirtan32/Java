import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

class sam extends JFrame
{
	Container cont;
	JPanel main;
	main_top_panel main_top;
	main_mid_panel main_mid;
	main_bottom_panel main_bottom;
	JScrollPane scrollPane;
	sam(String s)
	{
	
		super(s);
		cont=getContentPane();
		cont.setLayout(null);
		setLayout(null);
		//setUndecorated(true);
		setBounds(300,100,1200,800);
		//cont.setBounds(0,0,1200,1500);
		main = new JPanel();
		main.setLayout(null);
		main.setBounds(0,0,1200,800);
		
		main_top=new main_top_panel();
	
		/*main_bottom=new main_bottom_panel();
		
		main_mid=new main_mid_panel();
		
		JLabel x1=new JLabel("HELLO");
		//x1.setLayout(null);
		x1.setBounds(100,100,1000,500);
		x1.setBackground(Color.green);
		x1.setForeground(Color.white);
		
		JLabel x2=new JLabel("HI");
		//x2.setLayout(null);
		x2.setBounds(100,650,1000,500);
		x2.setBackground(Color.blue);
		x2.setForeground(Color.white);
		
		main.add(x1);
		main.add(x2);
		//main.add(main_top);
		//main.add(main_mid);
		//main.add(main_bottom);
		
	
		scrollPane = new JScrollPane(main);
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0,0,1200,500);
        scrollPane.setBackground(Color.black);
        scrollPane.setLayout(null);
		//Start.add(maximize);
        JPanel cPane = new JPanel();
        cPane.setLayout(new BoxLayout(cPane,BoxLayout.Y_AXIS));
        cPane.setPreferredSize(new Dimension(1200, 800));
        cPane.add(scrollPane);
		//Start.add(minimize);
       // cont.add();
        cont.add(cPane);
        */
		main.add(main_top);
		cont.add(main);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

public class sample {

    public static void main(String... args) {
        /* JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        for (int i = 0; i < 6; i++) {
            panel.add(new JButton("Hello-" + i));
        }
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(100, 30, 300, 50);
        //scrollPane.setVisible(false);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(700, 400));
        contentPane.add(scrollPane);
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);*/
    	
    	sam s1=new sam("aaa");
    	s1.setVisible(true);
    }
}