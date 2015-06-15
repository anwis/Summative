package summative;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Panel extends JPanel implements ActionListener, MouseListener {

	private JLabel title;
	private JButton menuStart, menuQUIT, highScores, instructions;
	private Timer timer;
	
	private int SHAPEHEIGHT = 10;
	private int SHAPEWIDTH = 10;
	private int BUTTONHEIGHT = 50;
	private int BUTTONWIDTH = 150;
	private int DELAY = 100;
	private int WIDTH = 650;
	private int HEIGHT = 650;
	private int map = (WIDTH * HEIGHT); // This variable accounts for all of the dots or pixels that are seeable in the game board
	private int bodySegments;
	
	private int x[] = new int[map];// 
	private int y[] = new int[map];
	
	private boolean gameStart = false;
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;

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
			gameStart = true;
			play(null);
		}
	}
	
	public void get
	

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (gameStart == true) {
			drawHead(g);
		}
	}
	
	public void drawHead(Graphics g) {

		g.setColor(Color.GREEN);
		g.drawRect((WIDTH - SHAPEWIDTH) / 2,
				((HEIGHT - SHAPEHEIGHT) / 2), SHAPEWIDTH,
				SHAPEHEIGHT);
		g.fillRect((WIDTH - SHAPEWIDTH) / 2,
				((HEIGHT - SHAPEHEIGHT) / 2), SHAPEWIDTH,
				SHAPEHEIGHT);
		}
	
	public void drawBody(Graphics g) {
		g.setColor(Color.WHITE);
		//g.drawRect(x, y, width, height);
	}


	public void play(Graphics g) {
		removeMenuButtons();
		bodySegments = 2;
		timer = new Timer(DELAY, this);
		//timer.start();
	}

}
