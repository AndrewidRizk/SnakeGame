package snake;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Frames extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Panel snake1;
	/**
	 * 
	 */


	
	Frames(Panel p)
	{
		
		this.add(p);
		System.out.print(snake1);
		snake1 = p;
		System.out.print(snake1);
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		setLayout(null);
	}
	
	Frames(Panel p, int a) 
	{
		this.remove(snake1);
		this.add(p);
		SwingUtilities.updateComponentTreeUI(snake1);
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		setLayout(null);
		
	}
	 
	
	
}
