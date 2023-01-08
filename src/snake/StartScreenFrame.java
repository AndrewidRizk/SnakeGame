package snake;

import javax.swing.JFrame;

public class StartScreenFrame extends JFrame{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	StartScreenFrame()
	{
		 
		StartScreen screen = new StartScreen();
		this.add(screen);
		this.add(screen);
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		
		
	}

}
