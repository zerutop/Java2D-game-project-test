package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Gamepanel extends JPanel implements Runnable
{

	// Screen setting
	final int originalTitleSize = 16; // 16*16 title
	final int scale = 3;
	
	final int titleSize = originalTitleSize * scale; // 48*48 title
	final int maxScreenColum = 16; // Width ("You can adjust as you like")
	final int maxScreenRow = 12; // length ("You can adjust as you like")
	final int screenWidth = titleSize * maxScreenColum; //  867 Pixel
	final int screenHeight = titleSize * maxScreenRow; // 586 Pixel
	
	Thread GameThread;
	
	public Gamepanel() 
	{
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //sets the game-screen resolution.
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); //can make drawing smoother and reduce flickering.
		
		
	}
	
	public void StartGameThread() 
	{
		
		GameThread = new Thread(this);
		GameThread.start();
		
	}

	@Override
	public void run()
	{
		while(GameThread != null) // not equal to" comparison 
		{
			System.out.println("The game loop is running and show in output");
			
			//1.I Update: Update info of such as character Position
			update();
			//2. Draw: DRAW the screen with the updated info
			repaint();
			
		}
	}
	public void update() 
	{
		
	}
	public void paintComponent(Graphics gph)
	{
		super.paintComponent(gph);
		
		Graphics2D g2 = (Graphics2D)gph;
		
		g2.setColor(Color.white);
		
		g2.fillRect(100, 100, titleSize, titleSize);
		
		g2.dispose();
	}
	
}
