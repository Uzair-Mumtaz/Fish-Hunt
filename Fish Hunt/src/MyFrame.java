import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;

public class MyFrame extends JFrame implements KeyListener, Runnable{//KeyListener is an interface. Then we add unimplemented methods
	
	private JLabel label;
	private JLabel food1;
	private JLabel food2;
	private JLabel food3;
	private JLabel food4;
	
	private int x;
	private int direction1;
	private int direction2;
	private int direction3;
	private int direction4;
	private Thread z;
	private ImageIcon icon; 
	private ImageIcon shark;
	private JLabel string1;
	private JLabel string2;
	
	public MyFrame() {
		super();
		
		this.setLayout(null);
		
		shark = new ImageIcon("src/shark2.png");

		
		label = new JLabel();
		label.setBounds(375, 375, 64, 64);

		label.setIcon(shark);
		
		icon = new ImageIcon("src/fish-24.png");
		
		food1 = new JLabel();
		food1.setBounds((int) (Math.random()*500), (int) (Math.random()*500), 24, 24);

		food1.setIcon(icon);
		
		food2 = new JLabel();
		food2.setBounds((int) (Math.random()*500), (int) (Math.random()*500), 24, 24);
		food2.setIcon(icon);

		food3 = new JLabel();
		food3.setBounds((int) (Math.random()*500), (int) (Math.random()*500), 24, 24);
		food3.setIcon(icon);

		
		food4 = new JLabel();
		food4.setBounds((int) (Math.random()*500), (int) (Math.random()*500), 24, 24);
		food4.setIcon(icon);

		string1 = new JLabel();
		string1.setText("Press any arrow key to begin. Eat all 4 fish to win the game");
		string1.setFont(new Font("Calibri", Font.BOLD, 20));
		string1.setForeground(Color.green);
		string1.setBackground(Color.DARK_GRAY);
		string1.setBounds(100,50,700,100);
		string1.setOpaque(true);
		
		string2 = new JLabel();
		string2.setText("Congratulations! You Win!");
		string2.setFont(new Font("Calibri", Font.BOLD, 20));
		string2.setForeground(Color.green);
		string2.setBackground(Color.DARK_GRAY);
		string2.setBounds(300,50,700,100);
		string2.setOpaque(true);
		string2.setVisible(false);
		
		
		
		this.getContentPane().setBackground(Color.DARK_GRAY);
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				//using anonymous class to override the run method. 
				while(true) {
					if (x != 0) {
						string1.setVisible(false);
						
					}
					
					if (!(food1.isVisible()))
						if (!(food2.isVisible()))
							if (!(food3.isVisible()))
								if (!(food4.isVisible())) {
									string2.setVisible(true);
									label.setVisible(false);
								}
									
					
					if (x == 37) {
						label.setLocation(label.getX()-5, label.getY());
						if (label.getX() == 10) { //relocates the snake if it hits wall
							x = 39;
						}
					}
					else if (x == 38) {
						label.setLocation(label.getX(), label.getY()-5);
						if (label.getY() == 10) { //relocates the snake if it hits wall
							x = 40;
						}
					}
					else if (x == 39) {
						label.setLocation(label.getX()+5, label.getY());
						if (label.getX() ==700) {
							x = 37;
						}
					}
					else if (x == 40) {
						label.setLocation(label.getX(), label.getY()+5);
						if (label.getY() == 700) { //relocates the snake if it hits wall
							x = 38;
						}
					}
					
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}	
		});
		Thread s1 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					direction1 = (int) (37 + Math.random() * 4);
					direction2 = (int) (37 + Math.random() * 4);
					direction3 = (int) (37 + Math.random() * 4);
					direction4 = (int) (37 + Math.random() * 4);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() { //fish1

			@Override
			public void run() {
				while(true) {
					
					
					
					if (direction1 == 37) {
						food1.setLocation(food1.getX()-2, food1.getY());
						if (food1.getX() == 100) { //relocates the snake if it hits wall
							direction1 = 39;
						}
					}
					else if (direction1 == 38) {
						food1.setLocation(food1.getX(), food1.getY()-2);
						if (food1.getY() == 100) { //relocates the snake if it hits wall
							direction1 = 40;
						}
					}
					else if (direction1 == 39) {
						food1.setLocation(food1.getX()+2, food1.getY());
						if (food1.getX() ==710) {
							direction1 = 37;
						}
					}
					else if (direction1 == 40) {
						food1.setLocation(food1.getX(), food1.getY()+2);
						if (food1.getY() == 710) { //relocates the snake if it hits wall
							direction1 = 38;
						}
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					foodEaten(food1);
					
					
				}
				
			}
			
		});
		
		Thread t3 = new Thread(new Runnable() { //fish2

			@Override
			public void run() {
				while(true) {
					
					
					
					if (direction2 == 37) {
						food2.setLocation(food2.getX()-2, food2.getY());
						if (food2.getX() == 100) { //relocates the snake if it hits wall
							direction2 = 39;
						}
					}
					else if (direction2 == 38) {
						food2.setLocation(food2.getX(), food2.getY()-2);
						if (food2.getY() == 100) { //relocates the snake if it hits wall
							direction2 = 40;
						}
					}
					else if (direction2 == 39) {
						food2.setLocation(food2.getX()+2, food2.getY());
						if (food2.getX() ==710) {
							direction2 = 37;
						}
					}
					else if (direction2 == 40) {
						food2.setLocation(food2.getX(), food2.getY()+2);
						if (food2.getY() == 710) { //relocates the snake if it hits wall
							direction2 = 38;
						}
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					foodEaten(food2);

				}
				
			}
			
		});
		
		Thread t4 = new Thread(new Runnable() { //fish3

			@Override
			public void run() {
				while(true) {
					
					
					
					if (direction3 == 37) {
						food3.setLocation(food3.getX()-2, food3.getY());
						if (food3.getX() == 100) { //relocates the snake if it hits wall
							direction3 = 39;
						}
					}
					else if (direction3 == 38) {
						food3.setLocation(food3.getX(), food3.getY()-2);
						if (food3.getY() == 100) { //relocates the snake if it hits wall
							direction3 = 40;
						}
					}
					else if (direction3 == 39) {
						food3.setLocation(food3.getX()+2, food3.getY());
						if (food3.getX() ==710) {
							direction3 = 37;
						}
					}
					else if (direction3 == 40) {
						food3.setLocation(food3.getX(), food3.getY()+2);
						if (food3.getY() == 710) { //relocates the snake if it hits wall
							direction3 = 38;
						}
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					foodEaten(food3);

					
				}
				
			}
			
		});
		
		Thread t5 = new Thread(new Runnable() { //fish4

			@Override
			public void run() {
				while(true) {
					
					
					
					if (direction4 == 37) {
						food4.setLocation(food4.getX()-2, food4.getY());
						if (food4.getX() == 100) { //relocates the snake if it hits wall
							direction4 = 39;
						}
					}
					else if (direction4 == 38) {
						food4.setLocation(food4.getX(), food4.getY()-2);
						if (food4.getY() == 100) { //relocates the snake if it hits wall
							direction4 = 40;
						}
					}
					else if (direction4 == 39) {
						food4.setLocation(food4.getX()+2, food4.getY());
						if (food4.getX() ==710) {
							direction4 = 37;
						}
					}
					else if (direction4 == 40) {
						food4.setLocation(food4.getX(), food4.getY()+2);
						if (food4.getY() == 710) { //relocates the snake if it hits wall
							direction4 = 38;
						}
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					foodEaten(food4);

				}
				
			}
			
		});				
		this.setTitle("Snake Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(750,750);
		this.setLocationRelativeTo(null);
		this.add(label);
		this.add(food1);
		this.add(food2);
		this.add(food3);
		this.add(food4);
		this.add(string1);
		this.add(string2);
		this.addKeyListener(this);
		this.setVisible(true);
		t1.start();
		s1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

	@Override
	public void keyTyped(KeyEvent e) { //reads keyChar
		
	}

	@Override
	public void keyPressed(KeyEvent e) { //reads keyCode
		if (e.getKeyCode() == 37) {
			x = 37;
			
		}
		else if (e.getKeyCode() == 38) {
			x = 38;
			
		}
		else if (e.getKeyCode() == 39) {
			x = 39;
			
		}
		else if (e.getKeyCode() == 40) {
			x = 40;
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) { //reads keyChar
	}

	@Override
	public void run() {
		while(true) {
				
		}
		
	}
	public void foodEaten(JLabel food) {
		int lowerX = food.getX() - 20;
		int upperX = food.getX() + 20;
		int lowerY = food.getY() - 20;
		int upperY = food.getY() + 20;
		if (label.getX() >= lowerX && label.getX() <= upperX) {
			if (label.getY() >= lowerY && label.getY() <= upperY) {
				food.setVisible(false);
			}			
		}						
	}
}
