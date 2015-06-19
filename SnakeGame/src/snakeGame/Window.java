package snakeGame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Panel;

import javax.swing.JFrame;

public class Window extends JFrame {

	private static final int WIDTH = 650;
	private static final int HEIGHT = 650;
	Snake snake =  new Snake();
	
	public Window() {
		super("Snake");
		
		Container container;
		
		snake = new Snake();
		container = getContentPane();
		snake.setBackground(Color.BLACK);
		setLocationByPlatform(true);
		container.add(snake);
		container.validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//add(snake);
	}
	
	public static void main(String[] args) {
		Window frame = new Window();
		frame.setResizable(false);
		frame.setLocation(0,0);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);

	    }
	}


