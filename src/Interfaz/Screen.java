package Interfaz;
import javax.swing.*;

import Datos.Value;
import Logica.KeyHandel;
import Logica.Mob;
import Logica.Save;
import Logica.Store;

import java.awt.*;
import java.awt.image.*;
import java.io.*;


public class Screen extends JPanel implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Thread thread = new Thread(this);
	
	public static Image[] tileset_ground = new Image[100];	
	public static Image[] tileset_air = new Image[100];	
	public static Image[] tileset_res = new Image[100];	
	public static Image[] tileset_mob = new Image[100];
	
	public static boolean isFirst = true;
	public static boolean isDead = false;
	public static boolean isDebug = false;
	public static boolean isWin = false;
	
	public static int myWidth, myHeight;	
	public static int coinage = 10, health = 100;
	public static int killed = 0, killsToWin = 0, level = 1, maxLevel = 3;
	public static int winTime = 4000, winFrame = 0;
	public static int totalPoints = 0;
	public static int healthMultiplier = 0;
	
	public static Room room;	
	public static Save save;	
	public static Store store;
	public static boolean simon;
	public ImageIcon imgGround ;

	private ImageIcon imgAir;

	private ImageIcon imgRes0;

	private ImageIcon imgRes1;

	private ImageIcon imgRes2;

	private ImageIcon mob;

	private ImageIcon mob1;

	
	
	public static Point mse = new Point(0,0);
	
	public static Mob[] mobs  = new Mob[100];
	
	//Constructor
	public Screen(Frame frame) {
		frame.addMouseListener(new KeyHandel());
		frame.addMouseMotionListener(new KeyHandel());
		thread.start();
	}
	
	public static   void hasWon() {
		if(killed == killsToWin) {
			isWin = true;
			killed = 0;
			healthMultiplier += health;
			totalPoints += coinage;
			coinage = 10;
		}
	}
	
	public void define() {
		room = new Room();
		save = new Save();
		store = new Store();
		coinage = 10;
		
		for (int i=0; i<tileset_ground.length; i++) {
			imgGround = new ImageIcon(Screen.class.getResource("/Datos/res/tileset_ground1.png"));
			//tileset_ground[i] = new ImageIcon("src/Datos/res/tileset_ground1.png").getImage();
			tileset_ground[i] = imgGround.getImage();
			tileset_ground[i] = createImage(new FilteredImageSource(tileset_ground[i].getSource(), new CropImageFilter(0, 26 * i, 26, 26)));
		}
		
		for (int i=0; i<tileset_air.length; i++) {
			imgAir = new ImageIcon(Screen.class.getResource("/Datos/res/tileset_ground1.png"));
			tileset_air[i] = imgAir.getImage();
			tileset_air[i] = createImage(new FilteredImageSource(tileset_air[i].getSource(), new CropImageFilter(0,26 + 26 * i, 26, 26)));
		}
		
		imgRes0 = new ImageIcon(Screen.class.getResource("/Datos/res/cell.png"));
		imgRes1 = new ImageIcon(Screen.class.getResource("/Datos/res/heart.png"));
		imgRes2 = new ImageIcon(Screen.class.getResource("/Datos/res/coin.png"));
		tileset_res[0] = imgRes0.getImage();
		tileset_res[1] = imgRes1.getImage();
		tileset_res[2] = imgRes2.getImage();
		
		mob = new ImageIcon("/Datos/res/melet.png");
		//mob1 = new ImageIcon("/Datos/res/bee.png");
		tileset_mob[0] = mob.getImage();
		//tileset_mob[1] = mob1.getImage();

		//save.loadSave(new File("src/Datos/save/mission" + level + ".fer"));
		save.loadSave(Screen.class.getResourceAsStream("/Datos/save/mission" + level + ".fer"));
		
		for(int i = 0; i < mobs.length; i++) {
			mobs[i] = new Mob();
		}
	}
	
	//
	public void paintComponent(Graphics g) {
		if(isFirst) {
			myWidth = getWidth();
			myHeight = getHeight();
			define();
			
			isFirst = false;
		}
		
		g.setColor(new Color( 70, 70, 70));
		g.fillRect(0, 0, getWidth(), getHeight());

		g.setColor(new Color( 0, 0, 0));
		g.drawLine(room.block[0][0].x - 1, 0, room.block[0][0].x - 1, room.block[room.worldHeight -1][0].y + room.blockSize); //Drawing the left line
		g.drawLine(room.block[0][room.worldWidth-1].x + room.blockSize, 0, room.block[0][room.worldWidth-1].x + room.blockSize, room.block[room.worldHeight -1][0].y + room.blockSize); //Drawing the right line		
		g.drawLine(room.block[0][0].x , room.block[room.worldHeight-1][0].y + room.blockSize, room.block[0][room.worldWidth-1].x + room.blockSize , room.block[room.worldHeight-1][0].y + room.blockSize); //Drawing the bottom line
		
		room.draw(g); //Drawing the room.
		
		for(int i = 0; i < mobs.length; i++) {
			if(mobs[i].inGame) {
				mobs[i].draw(g);
			}
		}
		
		store.draw(g);//Drawing the store.
		
		if(health < 1) {
			g.setColor(new Color(240, 20, 20));
			g.fillRect(0, 0, myWidth, myHeight);
			g.setColor(new Color(255,255,255));
			g.setFont(new Font("Courier New",Font.BOLD, 14));
			g.drawString("GAME OVER, unlucky...", 10, 10);
		}
		
		if(isWin) {
			g.setColor(new Color(255,255,255));
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(new Color(0,0,0));
			g.setFont(new Font("Courier New",Font.BOLD, 14));
			if(level > maxLevel) {
				g.drawString("You won the whole game! Your total points are: " + totalPoints * healthMultiplier +  " Please wait and the window will close", 10, 20);
			} else {
				g.drawString("You won! Congratulations! Please wait for the next level...", 10, 10);
			}
		}
	}
	
	public int spawnTime = 1400, spawnFrame = 0;
	public void mobSpawner() {
		if(spawnFrame >= spawnTime) {
			for(int i = 0; i < mobs.length; i++) {
				if(!mobs[i].inGame) {
					mobs[i].spawnMob(Value.mobHuman);
					break;
				}
			}
			
			spawnFrame = 0;
		} else {
			spawnFrame += 1;
		}
	}
	
	public void run() {
		while(true) {
			if(!isFirst && health > 0 && !isWin) {
				room.physic();
				mobSpawner();
				for(int i = 0; i < mobs.length; i++) {
					if(mobs[i].inGame) {
						mobs[i].physic();
					}
				}
			} else {
				if(isWin) {
					if(winFrame >= winTime) {
						if(level > maxLevel) {
							System.exit(0);
							simon = true;
						} else {
							level += 1;
							define();
							isWin = false;
							simon = false;
						}
						winFrame = 0;
					} else {
						winFrame += 1;
					}
				}
			}
			
			repaint();
			
			try {
				Thread.sleep(1);
			}catch(Exception e) {}	
		}
	}
}
