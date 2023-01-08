package snake;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import snake.Panel.myKeyAdapter;

public class StartScreen extends JPanel implements ActionListener{


	private static final long serialVersionUID = 1L;
	
	static final int SCREEN_WIDTH =700;  // the Width of the panel
	static final int SCREEN_HEIGHT =450; // the Height of the panel
	 
	 
	  JTextField playerName = new JTextField();
	  
      JButton startBotton = new JButton("Start Game");
      JButton easy = new JButton("Easy");
      JButton medium = new JButton("Medium");
      JButton hard = new JButton("Hard");
      private Frames frame;
   
      boolean startButtonChecker  = false;
      private String Name  = playerName.getText();
      
     
    
      
	

	StartScreen()
	{
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT)); // Passing the Dimensions (Width and Height) to make it he preferred size of the component 
		this.setBackground(Color.blue);
		
		setFocusable(false);
		setLayout(null);
	    setBounds(2, 42, 146, 252);
	    startBotton.addActionListener(this);
	    
	    easy.addActionListener(this);
	    medium.addActionListener(this);
	    hard.addActionListener(this);
	    
	    add(startBotton);
        add(playerName);
        

	    
	   
	   
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)  {
		
		if(e.getSource() == startBotton)
		{
			this.Name = playerName.getText();
			startButtonChecker = true;
			if(playerName.getText().equals(""))
				this.Name = "User";
			
			repaint();
			remove(startBotton);
			remove(playerName);
			add(easy);
			add(medium);
			add(hard);
			
		}
		
		if(e.getSource() == easy)
		{   
			Panel panel = new Panel(85);
			this.frame = new Frames(panel);
			
		}
		
		
		if(e.getSource() == medium)
		{
			
			Panel panel = new Panel(65);
			this.frame = new Frames(panel);
		}
		
		if(e.getSource() == hard)
		{
			
			Panel panel = new Panel(40);
			this.frame = new Frames(panel);
		}
		
		
	
	
		
	}
	
	public Frames getFrame()
	{
		return this.frame;
	}
	
	
	public void draw(Graphics g)
	{
		if(startButtonChecker == false)
		{
			g.setColor(Color.green);
			g.setFont(new Font("Monospaced",Font.BOLD, 70));
			g.drawString("Snake",(SCREEN_WIDTH -580) /2, 160/2);
			g.setColor(Color.green);
			g.setFont(new Font("Monospaced",Font.BOLD, 40));
			g.drawString("Enter player name",50, 230);
			playerName.setBounds(50, 250, 360, 50);
			playerName.setFont(new Font("",Font.BOLD, 30));
		    startBotton.setMnemonic(KeyEvent.VK_ENTER);
		    startBotton.setBounds(260, 360, 150, 60);
		    startBotton.setFont(new Font("Monospaced",Font.BOLD, 17));
		   
		}
		else
		{
			
			g.setColor(Color.green);
			g.setFont(new Font("Monospaced",Font.BOLD, 70));
			g.drawString("Snake",(SCREEN_WIDTH -580) /2, 160/2);
			g.setColor(Color.green);
			g.setFont(new Font("Monospaced",Font.BOLD, 30));
			g.drawString("Hi "+ this.Name + ", Choose The Difficulty",(SCREEN_WIDTH -600) /2,180);
		
			
			easy.setBounds(50, 300, 150, 60);
			easy.setFont(new Font("Monospaced",Font.BOLD, 17));
			
			medium.setBounds(260, 300, 150, 60);
			medium.setFont(new Font("Monospaced",Font.BOLD, 17));
			
			hard.setBounds(470, 300, 150, 60);
			hard.setFont(new Font("Monospaced",Font.BOLD, 17));
			
			
		}
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		draw(g);
	}
	
	
	
	}
	
	
