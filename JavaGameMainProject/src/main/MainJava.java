package main;

import javax.swing.JFrame;


public class MainJava{

	public static void main(String[] args) 
	{
		
		JFrame window = new JFrame(); // JFrame name for window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("My indie Adventure");
		
		Gamepanel gamePanel = new Gamepanel();// This is call function module of GamePanel
		window.add(gamePanel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.StartGameThread(); 
	}

}
