package summative;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeInGame extends JPanel implements ActionListener {

	private JLabel title;
	private JButton menuStart, menuQUIT, highScores, instructions;
	private Timer timer;
	
	private int SHAPEHEIGHT = 20;
	private int SHAPEWIDTH = 20;
	private int BUTTONHEIGHT = 50;
	private int BUTTONWIDTH = 150;
	private int DELAY = 100;
	private int WIDTH = 650;
	private int HEIGHT = 650;
	private int map = (WIDTH * HEIGHT); // This variable accounts for all of the dots or pixels that are seeable in the game board
	private int bodySegments;
	private int appleX;
	private int appleY;
	private int randomNum;
	private int dotSize = 15;
	
	private int x[] = new int[map];// 
	private int y[] = new int[map];
	
	private boolean gameStart = false;
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    
    private Image apple;
    

    

    
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
