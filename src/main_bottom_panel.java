import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class main_bottom_panel extends JPanel
{
	JLabel label;
	main_bottom_panel()
	{
		setBounds(0,1200,1200,300);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		label= new JLabel("BOTTOM PANEL");
		label.setBounds(100,50,200,100);
		label.setBackground(Color.green);

		add(label);
	}
}
