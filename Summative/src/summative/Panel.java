package summative;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener, MouseListener {

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
	
	private boolean inGame = false;
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    
    private Image apple;
    
    
    
	public Panel() {
		setLayout(null);
		Font titleFont = new Font("Verdana", Font.ITALIC, 38);
		Font menuFont = new Font("Georgia", Font.PLAIN, 20);
		JTextArea txt = new JTextArea();
		txt.setFont(titleFont);
		txt.setForeground(Color.yellow);

		title = new JLabel("Snake", JLabel.CENTER);
		title.setBounds(((WIDTH - 250) / 2), 10, 250, 50);
		title.setFont(titleFont);
		title.setForeground(Color.RED);
		add(title);

		menuStart = new JButton("Start");
		menuStart.setBounds((WIDTH - BUTTONWIDTH) / 2,
				(HEIGHT - BUTTONHEIGHT) / 2, BUTTONWIDTH, BUTTONHEIGHT);
		menuStart.setFont(menuFont);
		add(menuStart);

		menuQUIT = new JButton("QUIT");
		menuQUIT.setBounds(((WIDTH - BUTTONWIDTH) / 2),
				((HEIGHT - BUTTONHEIGHT) / 2) + BUTTONHEIGHT, BUTTONWIDTH,
				BUTTONHEIGHT);
		menuQUIT.setFont(menuFont);
		add(menuQUIT);

		highScores = new JButton("High Scores");
		highScores.setBounds((WIDTH - BUTTONWIDTH) / 2,
				((HEIGHT - BUTTONHEIGHT) / 2) + 2 * BUTTONHEIGHT, BUTTONWIDTH,
				BUTTONHEIGHT);
		highScores.setFont(menuFont);
		add(highScores);
		
		instructions = new JButton("Instructions");
		instructions.setBounds((WIDTH - BUTTONWIDTH) / 2,
				((HEIGHT - BUTTONHEIGHT) / 2) + 3 * BUTTONHEIGHT, BUTTONWIDTH,
				BUTTONHEIGHT);
		instructions.setFont(menuFont);
		add(instructions);

		menuQUIT.addActionListener(this);
		menuStart.addActionListener(this);
		menuQUIT.addMouseListener(this);
		menuStart.addMouseListener(this);
		highScores.addActionListener(this);
		highScores.addMouseListener(this);
		validate();
		
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	public void removeMenuButtons() {
		remove(menuQUIT);
		remove(menuStart);
		remove(highScores);
		remove(title);
		remove(instructions);
		repaint();
	}
	
	public void addMenuButtons() {
		add(menuQUIT);
		add(menuStart);
		add(highScores);
		add(instructions);
		add(title);
		repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("QUIT")) {
			System.exit(0);
		}
		
		if (e.getActionCommand().equals("Start")) {
			play();
		}
		
	}
	

	
	public void loadAppleImage() {
		ImageIcon apple = new ImageIcon("apple.png");
	}
	
	public void createApple() {
		randomNum = (int)(Math.random() * map);
		appleX = randomNum;
		
		randomNum = (int)(Math.random() * map);
		appleY = randomNum;
		
	}
	
	public void checkIfAppleWasEaten() {
		if ((x[0] == appleX) && (y[0] == appleY)){
			bodySegments ++;
			createApple();
		}
	}
	
	public void play() {
		removeMenuButtons();
		bodySegments = 2;
		
		drawStartingSnake(null);

	    gameUpdate(null);
	}
	
	public void gameUpdate(Graphics g){
		while (inGame == true){
			drawHead(g);
			drawBody(g);
			move();
		try {
			Thread.sleep(DELAY);
		}
		catch (Exception alternate) {
		}
		}
	}
	
	public void drawStartingSnake(Graphics g) {
	    for (int counter = 0; counter < bodySegments; counter++) {
	        x[counter] = SHAPEWIDTH - counter * SHAPEWIDTH;
	        y[counter] = SHAPEHEIGHT;
	        inGame = true;
	    }
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics draw = g;
		
		if (inGame == true) {
			drawHead(g);
			drawBody(g);
		}
	}
	
	public void drawHead(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawRect(x[0],
				y[0], SHAPEWIDTH,
				SHAPEHEIGHT);
		g.fillRect(x[0],
				y[0], SHAPEWIDTH,
				SHAPEHEIGHT);	
		}
	
	public void drawBody(Graphics g) {
		if (inGame ==  true){
		for (int counter = 1; counter < bodySegments; counter ++) {
			g.setColor(Color.WHITE);
			g.drawRect(x[counter], y[counter], SHAPEWIDTH, SHAPEHEIGHT);
			g.fillRect(x[counter], y[counter], SHAPEWIDTH, SHAPEHEIGHT);
		}
		Toolkit.getDefaultToolkit().sync();
		}
		else {
			gameOver(g);
		}
	}
	
	public void move() {
		// This will allow the body segments of to move 
		for (int counter = bodySegments; counter > 0; counter --) {
			x[counter] = x[(counter - 1)];
			y[counter] = y[(counter - 1)];
		}
		
		
		if (leftDirection == true) {
			x[0] -= dotSize;
		}
		
		if (rightDirection == true) {
			x[0] += dotSize;
		}
		
		if (downDirection == true) {
			y[0] -= dotSize;
		}
		
		if (upDirection == true) {
			y[0] += dotSize;
		}
	}
	
	public void gameOver(Graphics g){
		
	}


	public void checkCollision(){
		
	}
	
	  private class TAdapter extends KeyAdapter {

	     
	        public void keyPressed(KeyEvent e) {

	            int key = e.getKeyCode();

	            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
	                leftDirection = true;
	                upDirection = false;
	                downDirection = false;
	            }

	            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
	                rightDirection = true;
	                upDirection = false;
	                downDirection = false;
	            }

	            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
	                upDirection = true;
	                rightDirection = false;
	                leftDirection = false;
	            }

	            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
	                downDirection = true;
	                rightDirection = false;
	                leftDirection = false;
	            }
	        }
	    }

}
