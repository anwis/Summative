package snakeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Snake extends JPanel implements ActionListener {

	private int SHAPEHEIGHT = 25;
	private int SHAPEWIDTH = 25;
	private int DELAY = 95;
	private int WIDTH = 650;
	private int HEIGHT = 650;
	private int map = (WIDTH * HEIGHT); // This variable accounts for all of the
	private Graphics draw;	// dots or pixels that are seeable in
										// the game board
	private int bodySegmentsTOTAL;
	private int appleX;
	private int appleY;
	private int randomNum;
	private int dotSize = 15;
	private int bodySegment;

	private int x[] = new int[map];//
	private int y[] = new int[map];

	private boolean inGame = true;
	private boolean leftDirection = false;
	private boolean rightDirection = true;
	private boolean upDirection = false;
	private boolean downDirection = false;


	public Snake() {
		addKeyListener(new Keyboard());
		setFocusable(true);
	}
	
	
	public void InitiateGame(){
		
	}
	
	public void gameUpdate(Graphics g) {
		
		
		//setFocusTraversalKeysEnabled(false);
		while (inGame == true) {

			move();
			drawHead(g);
			drawBody(g);
			repaint();
			try {
				Thread.sleep(DELAY);
			} catch (Exception alternate) {
			}
		}
	}

	public void drawStartingSnake(Graphics g) {
		for (bodySegment = 0; bodySegment < bodySegmentsTOTAL; bodySegment++) {
			x[bodySegment] = SHAPEWIDTH + bodySegment * SHAPEWIDTH;
			y[bodySegment] = SHAPEHEIGHT;
			inGame = true;
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (inGame == true) {
			drawHead(g);
			drawBody(g);
		}
	}

	public void drawHead(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawRect(x[0], y[0], SHAPEWIDTH, SHAPEHEIGHT);
		g.fillRect(x[0], y[0], SHAPEWIDTH, SHAPEHEIGHT);
	}

	public void drawBody(Graphics g) {
		if (inGame == true) {
			for (bodySegment = 1; bodySegment < bodySegmentsTOTAL; bodySegment++) {
				g.setColor(Color.BLACK);
				g.drawRect(x[bodySegment], y[bodySegment], SHAPEWIDTH,
						SHAPEHEIGHT);
				g.setColor(Color.WHITE);
				g.fillRect(x[bodySegment], y[bodySegment], SHAPEWIDTH,
						SHAPEHEIGHT);
				if (bodySegment == bodySegmentsTOTAL - 1) {
					g.setColor(Color.BLACK);
					g.drawRect(x[bodySegmentsTOTAL], y[bodySegmentsTOTAL],
							SHAPEWIDTH, SHAPEHEIGHT);
					g.fillRect(x[bodySegmentsTOTAL], y[bodySegmentsTOTAL],
							SHAPEWIDTH, SHAPEHEIGHT);
				}
			}
			Toolkit.getDefaultToolkit().sync();
		} else {
			gameOver(g);
		}
	}

	public void move() {
		// This will allow the body segments to move
		for (bodySegment = bodySegmentsTOTAL; bodySegment > 0; bodySegment--) {
			x[bodySegment] = x[(bodySegment - 1)];
			y[bodySegment] = y[(bodySegment - 1)];
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

	public void gameOver(Graphics g) {

	}

	public void checkCollision() {
		if (bodySegmentsTOTAL > 4) {
			for (bodySegment = 0; bodySegment < bodySegmentsTOTAL; bodySegment++) {

			}

		}
	}
	
	public class Keyboard extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			//System.out.println("key was pressed");
			int key = e.getKeyCode();

			if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) { // snake cant turn
																	// into itself
				leftDirection = true;
				upDirection = false;
				downDirection = false;
				System.out.println("key was pressed");
			}

			if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
				rightDirection = true;
				upDirection = false;
				downDirection = false;
				System.out.println("key was pressed");
			}

			if ((key == KeyEvent.VK_UP) && (!downDirection)) {
				upDirection = true;
				rightDirection = false;
				leftDirection = false;
				System.out.println("key was pressed");
			}

			if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
				downDirection = true;
				rightDirection = false;
				leftDirection = false;
				System.out.println("key was pressed");
			}

		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (inGame ==  true) {
			move();
			bodySegmentsTOTAL = 3;

			draw = this.getGraphics();
			drawStartingSnake(draw);

			gameUpdate(draw);
		}
		
	}
}
