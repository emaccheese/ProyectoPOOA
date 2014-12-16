package Interfaz;
import java.awt.*;

import Datos.Value;


public class Block extends Rectangle{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Rectangle towerSquare;
	public int towerSquareSize = 130;
	public int groundID;
	public int airID;
	public int loseTime = 100, loseFrame = 0;
	
	public int scareMob = -1;
	public boolean scaring = false;
	
	//Constructor
	public Block(int x, int y, int width, int height, int groundID, int airID) {
		setBounds(x, y, width, height);
		towerSquare = new Rectangle(x - (towerSquareSize/2), y - (towerSquareSize/2), width + (towerSquareSize), height + (towerSquareSize));
		this.groundID = groundID;
		this.airID = airID;
	}
	
	public void draw(Graphics g) {
		g.drawImage(Screen.tileset_ground[groundID], x, y, width, height, null);
		
		if(airID != Value.airAir) {
			g.drawImage(Screen.tileset_air[airID], x, y, width, height, null);
			
			
			
		}
		
	}
	
	public void physic() {
		if(scareMob != -1 && towerSquare.intersects(Screen.mobs[scareMob])) {
			scaring = true;
		} else {
			scaring = false;
		}
		if(!scaring) {
			if(airID == Value.airTower1) { //TODO: if there are more types of tower just add them here with an ||
				for(int i =0; i < Screen.mobs.length; i++) {
					if(Screen.mobs[i].inGame) {
						if(towerSquare.intersects(Screen.mobs[i])) {
							scaring = true;
							scareMob = i;
							
						}
					}
				}			
			}
		}
		
		if(scaring) {
			if(loseFrame >= loseTime) {
				Screen.mobs[scareMob].loseHealthEnemy(1);
				loseFrame = 0;
			} else {
				loseFrame += 1;
			}
			if(Screen.mobs[scareMob].isDead()) {
				
				scaring = false;
				scareMob = -1;
				
				Screen.killed +=  1;
				
				Screen.hasWon();
			}
		}

	}
	
	public void getMoney(int mobID) {
		Screen.coinage += Value.mobReward[mobID];
	}
	
	public void scare(Graphics g) {
		if(Screen.isDebug) {
			if(airID == Value.airTower1) {
				g.drawRect(towerSquare.x, towerSquare.y, towerSquare.width, towerSquare.height);
			}
			
		}

		if(scaring) {
			g.setColor(new Color(255, 255, 0));
			g.drawLine(x + (width/2), y + (height/2), Screen.mobs[scareMob].x + (Screen.mobs[scareMob].width/2), Screen.mobs[scareMob].y + (Screen.mobs[scareMob].height/2));
		}
	}
}
