package summative;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;


public class Window extends JFrame{

	private static final int WIDTH = 650;
	private static final int HEIGHT = 650;
	

	
	public Window(String Title){
		super("Snake");

		Panel basicPanel;
        Container container;
        	
        // Instantiate and add the SimplePanel to the frame 
        basicPanel = new Panel();
        container = getContentPane();
        basicPanel.setBackground(Color.BLACK);
        setLocationByPlatform(true);
        container.add(basicPanel);
        container.validate();
        
        

	}
	
	
	public static void main(String[] args) {
		Window frame = new Window("Snake");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocation(0,0);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		//frame.add(p);
	}
}
