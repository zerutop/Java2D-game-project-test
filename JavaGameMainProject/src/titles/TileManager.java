package titles;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.Gamepanel;

public class TileManager 
{
	Gamepanel gp;
	tile[] tile;
	int mapTileNum[][];
	
	public TileManager(Gamepanel gp) 
	{
		this.gp = gp;
		tile = new tile[10];
		mapTileNum = new int[gp.maxScreenColum][gp.maxScreenRow];
		
		
		getTileImage();
		loadMap();
		
	}
	
	public void getTileImage() 
	{
		try {
			
			tile[0] = new tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/titles/grass_16x16.png"));
			
			tile[1] = new tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/titles/wall_16x16.png"));
			
			tile[2] = new tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/titles/water_16x16.png"));
			
			
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}	
	}
	public void loadMap() 
	{
		
		try 
		{
			InputStream is = getClass().getResourceAsStream("/maps/map01.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxScreenColum && row < gp.maxScreenRow) 
			{
				String line = br.readLine(); //ready the single line of text and put into string
				
				while(col < gp.maxScreenColum) {
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
					
				}
				if(col == gp.maxScreenColum) 
				{
					col = 0;
					row++;
				}		
			}
			br.close();	
		}catch(Exception e){
			
		}
	}
	public void draw(Graphics2D g2) 
	{
		
		// you can adjust this as you like!
//		g2.drawImage(tile[1].image, 0,0, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[1].image, 48,0, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[1].image, 96,0, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[1].image, 144,0, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[1].image, 192,0, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[1].image, 240,0, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[1].image, 288,0, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[1].image, 336,0, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[1].image, 384,0, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[1].image, 432,0, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[1].image, 480,0, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[1].image, 528,0, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[1].image, 624,0, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[1].image, 672,0, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[1].image, 720,0, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[1].image, 768,0, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[1].image, 816,0, gp.titleSize, gp.titleSize, null);
//		
//		g2.drawImage(tile[0].image, 0,48, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[0].image, 48,48, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[0].image, 96,48, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[0].image, 144,48, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[0].image, 192,48, gp.titleSize, gp.titleSize, null);
//		
//		g2.drawImage(tile[0].image, 0,96, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[0].image, 48,96, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[0].image, 96,96, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[0].image, 144,96, gp.titleSize, gp.titleSize, null);
//		g2.drawImage(tile[0].image, 192,96, gp.titleSize, gp.titleSize, null);
		
		
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(col < gp.maxScreenColum && row < gp.maxScreenRow) 
		{
			
			int tileNum = mapTileNum[col][row];
			
			
			g2.drawImage(tile[tileNum].image, x, y, gp.titleSize, gp.titleSize, null);
			col ++;
			x += gp.titleSize;
			
			if(col == gp.maxScreenColum ) 
			{
				col = 0;
				x = 0;
				row++;
				y += gp.titleSize;
				
			}
		}
	}
}
























