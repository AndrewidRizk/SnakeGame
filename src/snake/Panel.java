package snake;

import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Panel extends JPanel  implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	static final int SCREEN_WIDTH =600;  // the Width of the panel
	static final int SCREEN_HEIGHT =600; // the Height of the panel
	static final int UNIT_SIZE =25;  // Dimensions of 25 pixels 
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
	private int DELAY;  // how fast the game will go
	private int snakeX_Cord[] = new int[GAME_UNITS];
	private int snakeY_Cord[] = new int[GAME_UNITS];	
	int body = 5;
	int bodyApples = 0;
	int appleX = 0;
	int appleY = 0;
	char direc = 'R'; // R: right;   L: left; 	U: up; 	 D: down
	boolean running = false;
	boolean newApple = false;
	Timer timer;
	Random random;
	myKeyAdapter a = new myKeyAdapter();
	
	Color[] colors = new Color[6];
	int randomColor = 0;
	Color b = Color.green;
	JButton playAgain = new JButton("Play Again");
	JButton mainMenu = new JButton("Chose another Difficulty");
	
	
	
	Panel(){
		this.DELAY =75;
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT)); // Passing the Dimensions (Width and Height) to make it he preferred size of the component 
		this.setBackground(Color.darkGray); // setting the background color to black, will be applied later to in the paintComponent method 
		addKeyListener(a);
		setFocusable(true);
	    requestFocus();
		startGame();
		colors[0] = Color.red;
		colors[1] = Color.green;
		colors[2] = Color.yellow;
		colors[3] = Color.blue;
		colors[4] = Color.white;
		colors[5] = Color.gray;
		
		
	}
	
	Panel(int Delay){
		this.DELAY =Delay;
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT)); // Passing the Dimensions (Width and Height) to make it he preferred size of the component 
		this.setBackground(Color.darkGray); // setting the background color to black, will be applied later to in the paintComponent method 
		addKeyListener(a);
		setFocusable(true);
	    requestFocus();
		startGame();
		colors[0] = Color.red;
		colors[1] = Color.green;
		colors[2] = Color.yellow;
		colors[3] = Color.blue;
		colors[4] = Color.white;
		colors[5] = Color.gray;
		
	}
	public class myKeyAdapter extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e)
		{
			int key = e.getKeyCode();
			 if ((key == KeyEvent.VK_LEFT))
					 {
				if(direc != 'R')
				{
					direc = 'L';	
				}
			 }
			 if ((key == KeyEvent.VK_RIGHT))
			 {
					if(direc != 'L')
					{
						direc = 'R';	
						
					}
				 }
			    if ((key == KeyEvent.VK_UP)) {
					if(direc != 'D')
					{
						direc = 'U';	
					}
			    }
				
			    if ((key == KeyEvent.VK_DOWN)) {
					if(direc != 'U')
					{
						direc = 'D';	
					}
			    }	
			    
			    
		}
		}
	
	public void resetXandY()
	{
		this.snakeX_Cord = new int[GAME_UNITS];
		this.snakeY_Cord = new int[GAME_UNITS];
		this.body = 5;
		this.direc = 'R';
		snakeX_Cord[0] = 300;
		snakeY_Cord[0] = 300;
		
		
	}
	
	public void setDelay(int delay)
	{
		this.DELAY = delay;
	}
	
	public int getDelay()
	{
		return this.DELAY;
	}
	/**
	 * Start the Game
	 * construct a new Apple to start with
	 * Delay the timer of the game by DELAY
	 * The start the timer
	 * 
	 */
	public void startGame()
	{
		newApple();
		running = true;
		timer = new Timer(this.DELAY, this);
		timer.start();
	}
	
	
	
	/**
	 * Responsible for coloring the component as previously chosen in Line breakpoint:Panel [line: 29] 
	 *
	 * @param g
	 */
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		draw(g);
	}
	
	/**
	 * 
	 * @param g
	 */
	public void draw(Graphics g)
	{
		if(running)
		{
			for(int i = 0; i < SCREEN_HEIGHT/ UNIT_SIZE;i++)
			{
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT); // drawing lines on the x axes and the y axes the panel to visualize  
				g.drawLine(0, i*UNIT_SIZE,SCREEN_WIDTH, i*UNIT_SIZE);
			}
			
			
			
			g.setColor(colors[randomColor]);
			g.fillOval(appleX, appleY, UNIT_SIZE,UNIT_SIZE);
			
			
			for(int i = 0; i < body; i++)
			{
				if(i == 0)
				{
					g.setColor(b);
					g.fillOval(snakeX_Cord[i], snakeY_Cord[i], UNIT_SIZE, UNIT_SIZE);
				}
				else
				{
					g.setColor(b);
					g.fillRect(snakeX_Cord[i], snakeY_Cord[i], UNIT_SIZE, UNIT_SIZE);
				}
			}
			g.setColor(Color.red);
			g.setFont(new Font("Monospaced",Font.BOLD, 30));
			FontMetrics matrics = getFontMetrics(g.getFont()); 
			
			g.drawString("Score:" + bodyApples,(SCREEN_WIDTH - matrics.stringWidth("Score:" + bodyApples)) /20, g.getFont().getSize());
		}
		else
		{
			gameOver(g);
			add(playAgain);
			add(mainMenu);
		}
	}
	
	
	/**
	 * 
	 */
	public void newApple()
	{
		if(body > 7)
			b = colors[randomColor];
		
		randomColor = (int)(Math.random()*(4-0+1));
		newApple = true;
		appleX = random.nextInt((int)(SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
		appleY = random.nextInt((int)(SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
		
	}
	
	/**
	 * 
	 */
	public void move()
	{
		for(int i = body; i > 0 ; i--)
		{
			snakeX_Cord[i] = snakeX_Cord[i-1];
			snakeY_Cord[i] = snakeY_Cord[i-1];
			
		}
		
		if(direc == 'U')
		{
			snakeY_Cord[0] = snakeY_Cord[0] - UNIT_SIZE;
		}
		else if(direc == 'D')
		{
			snakeY_Cord[0] = snakeY_Cord[0] + UNIT_SIZE;
		}
		else if(direc == 'L')
		{
			snakeX_Cord[0] = snakeX_Cord[0] - UNIT_SIZE;
		}
		else if(direc == 'R')
		{
			snakeX_Cord[0] = snakeX_Cord[0] + UNIT_SIZE;
		}
	}
	
	/**
	 * 
	 */
	public void checkApple()
	{
		if((snakeX_Cord[0] == appleX) && ((snakeY_Cord[0] == appleY) ))
		{
			body = body + 1;
			bodyApples = bodyApples +1;
			newApple();
		}
		
	}
	
	/**
	 * 
	 */
	public void checkCollisions()
	{
		for(int i = body; i > 0; i--)     // checks if head hits body
		{
			if(snakeX_Cord[0] == snakeX_Cord[i] && snakeY_Cord[0] == snakeY_Cord[i])
			{
				running =false;
			}
		}
		if(snakeX_Cord[0] < 0)   // heads touches left border
		{
			running = false;
		}
		
		if(snakeX_Cord[0] > SCREEN_WIDTH)  // heads touches right border
		{
			running = false;
		}
		
		if(snakeY_Cord[0] < 0)  // heads touches top border
		{
			running = false;
		}
		
		if(snakeY_Cord[0] > SCREEN_HEIGHT)  // heads touches bot border
		{
			running = false;
		}
		
		if(running == false)
		{
			timer.stop();
		}
	}
	
	/**
	 * 
	 * @param g
	 */
	
	public void gameOver(Graphics g)
	{
		g.setColor(Color.red);
		g.setFont(new Font("Monospaced",Font.BOLD, 75));
		FontMetrics matrics = getFontMetrics(g.getFont()); 
		
		g.drawString("Game Over",(SCREEN_WIDTH - matrics.stringWidth("Game Over")) /2, SCREEN_HEIGHT/4);
		
		g.setColor(Color.green);
		g.setFont(new Font("Monospaced",Font.BOLD, 30));
		FontMetrics matrics1 = getFontMetrics(g.getFont()); 
		if(bodyApples <= 1)
		{
			g.drawString("Try Harder Next Time",(SCREEN_WIDTH - matrics1.stringWidth("Try Harder Next Time")) /2, 370);
		}
		else
			g.drawString("Well Done! Your Score is " + bodyApples,(SCREEN_WIDTH - matrics1.stringWidth("Well Done! Your Score is  ")) /2, 370);
		
		
		playAgain.setBounds(100, 480, 150, 60);
		playAgain.setFont(new Font("Monospaced",Font.BOLD, 17));
		playAgain.addActionListener(this);
		
		mainMenu.setBounds(250, 480, 280, 60);
		mainMenu.setFont(new Font("Monospaced",Font.BOLD, 17));
		mainMenu.addActionListener(this);
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(running)
		{
			move();
			checkApple();
			checkCollisions();
			
			
		}
		repaint();
		
		if(e.getSource()== playAgain)
	    {
			remove(this);
			setVisible(false);
			new Panel(this.DELAY);
			JComponent comp = (JComponent) e.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
			new Frames(new Panel(this.DELAY),1);
				
	    }
		if(e.getSource()== mainMenu)
	    {
			remove(this);
			setVisible(false);
			new Panel(this.DELAY);
			JComponent comp = (JComponent) e.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
			
				
	    }
		
	}
	

}
