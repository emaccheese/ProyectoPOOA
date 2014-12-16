package Logica;

import java.io.*;
import java.awt.*;


import javax.imageio.ImageIO;

import Interfaz.GamePanel;

import java.awt.image.*;

public class TileMap {
	
	private int x;
	private int y;
	
	private int tileSize;
	private int [][] map;
	private int mapWidth;
	private int mapHeight;
	
	
	private BufferedImage tileset;
	private Tile [][] tiles;
	
	private int minx;
	private int miny;
	private int maxx = 0;
	private int maxy = 0;
	private BufferedReader br;
	
	
	public TileMap(String s, int tileSize) {
		this.tileSize = tileSize;
		try{
			//br = new BufferedReader(new FileReader(s));
			br = new BufferedReader(new InputStreamReader(TileMap.class.getResourceAsStream(s)));
			//br = new BufferedReader(reader);
			mapWidth = Integer.parseInt(br.readLine());
			mapHeight = Integer.parseInt(br.readLine());
			map = new int[mapHeight][mapWidth];
			
			minx = GamePanel.WIDTH - mapWidth * tileSize;
			miny = GamePanel.HEIGHT - mapHeight * tileSize;
			String delimiters = "\\s+";
			for(int row = 0; row < mapHeight; row++){
				String line = br.readLine();
				String[] tokens = line.split(delimiters);
				for(int col = 0; col < mapWidth; col++){
					map[row][col] = Integer.parseInt(tokens[col]);
				}
			}
		}catch(Exception e){
			
		}
	}
	
	public void loadTiles(String s){
		try{
			//tileset = ImageIO.read(new File(s));
			//tileset = ImageIO.read(ResourceLoader.loadInput(s));
			tileset = ImageIO.read(TileMap.class.getResourceAsStream(s));
			int numTilesAcross = (tileset.getWidth() + 1 ) / (tileSize + 1);
			//Declarar tamaño de matriz, 2 filas, 1 para los tiles que se pueden cruzar
			//y otra para los que no.
			tiles = new Tile[2][numTilesAcross];
			
			BufferedImage subimage;
			for(int col = 0; col < numTilesAcross; col++){
				//Bloques que si se puedn atravezar
				subimage = tileset.getSubimage(	
						col * tileSize + col , 
						0, 
						tileSize, tileSize);
				
				tiles [0][col] = new Tile(subimage,false);
				//Bloques que no se pueden atravezar
				subimage = tileset.getSubimage(
						col * tileSize + col,
						tileSize+1,
						tileSize,
						tileSize);
				tiles [1][col] = new Tile(subimage, true);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/////////GET Y SET///////////////
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public int getColTile(int x){
		return x / tileSize;
	}
	public int getRowTile(int y){
		return y / tileSize;
	}
	public int getTile(int row, int col){
		return map[row][col];
	}
	public int getTileSize(){
		return tileSize;
	}
	
	public void setX(int i) {
		x = i;
		if(x < minx){
			x = minx;
		}
		if(x > maxx){
			x = maxx;
		}
	}
	public void setY(int i) {
		y = i;
		if(y < miny){
			y = miny;
		}
		if(y > maxy){
			y = maxy;
		}
	}
	public boolean isBlocked(int row, int col){
		int rc = map[row][col];
		int r = rc / tiles[0].length;
		int c = rc % tiles[0].length;
		return tiles[r][c].isBlocked();
	}
	
	
	
	//////////////////////////////////////////////
		
		public void update(){
			
		}
		public void draw(Graphics2D g) {
			for(int row = 0; row < mapHeight; row++){
				for(int col = 0; col < mapWidth; col++){
					
					int rc = map[row][col];
					
					int r = rc / tiles[0].length;
					int c = rc % tiles[0].length;
					
					g.drawImage(
							tiles[r][c].getImage(), 
							x + col * tileSize, 
							y + row * tileSize,
							null
							);
					/*if(rc == 0){
						//g.drawImage(img, 0, 0,null );
						g.setColor(Color.BLACK);
						}
					if(rc == 1){
						Image img;
						img = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Erik\\Desktop\\Escuela\\POOA\\FFI_Background_Desert");
						//g.drawImage(img, 0, 0, null);
						g.setColor(Color.WHITE);
						}
					g.fillRect(x + col * tileSize, y + row * tileSize, tileSize, tileSize);
					*/
				}
			}
		}


	
	}



