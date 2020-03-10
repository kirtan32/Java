import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

final public class main_panel extends JPanel
{
	public JPanel main;
	public JLabel back;
	public main_top_panel main_top;
	public main_mid_panel main_mid;
	public main_bottom_panel main_bottom;
	public JScrollPane scrollPane;
	public JTextArea jta;
	main_panel()
	{
		
		setBounds(0,0,1200,800);
		setLayout(null);
		
		main = new JPanel();
		//main.setLayout(null);
		//main.setSize(1200,1500);
		main.setBounds(0,0,1200,1500);
		
		main_top=new main_top_panel();
		
		main_bottom=new main_bottom_panel();
		
		main_mid=new main_mid_panel();
		
		main.add(main_top);
		main.add(main_mid);
		main.add(main_bottom);
		
		jta = new JTextArea();
		//jta.setLayout(null);
		jta.setBounds(0,0,1200,800);
		jta.setLayout(null);
		scrollPane = new JScrollPane(jta);
		//scrollPane.getViewport().add(main);
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //scrollPane.setBounds(0,0,1200,800);
        //scrollPane.setBorder(null);
		//Start.add(maximize);
		//Start.add(minimize);
        jta.add(main);
        add(scrollPane);
        
	}
}
