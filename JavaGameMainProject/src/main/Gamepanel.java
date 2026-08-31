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
	
	// This is FPS section
	
	int Fps = 60;
	
	KeyHandle KeyH = new KeyHandle();
	Thread GameThread;
	
	//Player default position
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4; // 4 means 4 Pixels
	
	public Gamepanel() 
	{
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //sets the game-screen resolution.
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); //can make drawing smoother and reduce flickering.
		this.addKeyListener(KeyH);
		this.setFocusable(true);
		
	}
	
	public void StartGameThread() 
	{
		
		GameThread = new Thread(this);
		GameThread.start();
		
	}

//	@Override
//	public void run()
//	{
//		
//		double drawInterval = 1000000000/Fps; // 0.0166666 seconds
//		double nextDrawTime = System.nanoTime() + drawInterval;
//		while(GameThread != null) // not equal to" comparison 
//		{
//			//System.out.println("The game loop is running and show in output");
//			
//			/*long currentTime = System.nanoTime();
//			System.out.println("Current Time:"+currentTime);returns the current value of the running
//															Java Virtual Machine's high resolution time source, in nanoseconds.
//													
//													
//															Also, 1Millions nanoseconds equal to 1 seconds!
//															*/
//			
//			
//			//1.I Update: Update info of such as character Position
//			update();
//			//2. Draw: DRAW the screen with the updated info
//			repaint();
//			
//			try {
//				double remainingTime = nextDrawTime - System.nanoTime();
//				remainingTime = remainingTime/1000000;
//				
//				if(remainingTime < 0) {
//					remainingTime = 0;
//				}
//				
//				Thread.sleep((long) remainingTime);
//				
//				nextDrawTime += drawInterval;
//			} catch(InterruptedException e)
//			{
//				e.printStackTrace();
//			}
//			
//		}
//	}
	
	public void run()
	{
		
		double drawInterval = 1000000000/Fps; // 0.0166666 seconds
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(GameThread != null) 
		{
			currentTime = System.nanoTime();
			timer += (currentTime - lastTime);
			delta += (currentTime - lastTime) / drawInterval;
			
//			//1.I Update: Update info of such as character Position
//			update();
//			//2. Draw: DRAW the screen with the updated info
//			repaint();
			
			lastTime = currentTime;
			
			if(delta >= 1) 
			{
				update();
				repaint();
				delta--;
				drawCount++;
			}
			if(timer >= 1000000000) 
			{
				System.out.println("Fps:"+" "+drawCount);
				drawCount = 0;
				timer = 0;
			}
			
		}
		
	}
	public void update()
	{
		
		/*
		 * in java the upper left corner is X:0 Y:0
		 * 
		 * X value increase to the right
		 * Y value increase as they go down
		 * */
		
		
		if(KeyH.upPressed == true)
		{
			playerY -= playerSpeed;
		}
		else if(KeyH.downPressed == true) {
			playerY += playerSpeed;
		}
		else if(KeyH.leftPressed == true) {
			playerX -= playerSpeed;
		}
		else if(KeyH.rightPressed == true) {
			playerX += playerSpeed;
		}
		
		
	}
	public void paintComponent(Graphics gph) 
	{
		super.paintComponent(gph);
		
		Graphics2D g2 = (Graphics2D)gph;
		
		g2.setColor(Color.white);
		
		g2.fillRect(playerX, playerY, titleSize, titleSize);
		
		g2.dispose();
	}
	
}
