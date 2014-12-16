package Logica;
import java.awt.*;

import Datos.Value;
import Interfaz.Screen;



public class Store {
	public static int shopWidth = 8;
	public static int buttonSize = 52;
	public static int cellSpace = 2;
	public static int awayFromGame = 29;
	public static int iconSize = 20;
	public static int iconSpace = 6;
	public static int iconTextY = 14;
	public static int itemIn = 4;
	public static int heldID = -1;
	public static int realID = -1;
	public static int[] buttonID = {Value.airTower1, Value.airAir, Value.airAir, Value.airAir, Value.airAir, Value.airAir, Value.airAir, Value.airTrashCan};
	public static int[] buttonPrice = {10, 0, 0, 0, 0, 0, 0, 0};
	
	
	public Rectangle[] button = new Rectangle[shopWidth];
	public Rectangle buttonHealth;
	public Rectangle buttonMoney;
	
	public boolean holdsItem = false;
	
	public Store() {
		define();
	}
	
	public void click(int mouseButton) {
		if(mouseButton == 1) {
			for(int i = 0; i < button.length; i++) {
				if(button[i].contains(Screen.mse)) {
					if(buttonID[i] != Value.airAir) {
						if(buttonID[i] == Value.airTrashCan) { //Delete item
							holdsItem = false;
						} else {
							heldID = buttonID[i];
							realID = i;
							holdsItem = true;
						}
					}
				}
			}
		}
		if(holdsItem) {
			if(Screen.coinage >= buttonPrice[realID]) {
				for(int y = 0; y <Screen.room.block.length; y++) {
					for(int x = 0; x< Screen.room.block[0].length; x++) {
						if(Screen.room.block[y][x].contains(Screen.mse)) {
							if(Screen.room.block[y][x].groundID != Value.groundRoad && Screen.room.block[y][x].airID == Value.airAir) {
								Screen.room.block[y][x].airID = heldID;
								Screen.coinage -= buttonPrice[realID];
							}
						}
					}
				}
			}
		}
	}
	
	public void define() {
		for(int i = 0; i < button.length; i++) {
			button[i] = new Rectangle((Screen.myWidth/2) - ((shopWidth * (buttonSize + cellSpace))/2) + ((buttonSize + cellSpace) * i), (Screen.room.block[Screen.room.worldHeight-1][0].y) + Screen.room.blockSize  + awayFromGame, buttonSize, buttonSize);
		}
		
		buttonHealth = new Rectangle(Screen.room.block[0][0].x - 1, button[0].y,iconSize, iconSize );
		buttonMoney = new Rectangle(Screen.room.block[0][0].x - 1, button[0].y + button[0].height - iconSize,iconSize, iconSize );
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < button.length; i++) {
			if(button[i].contains(Screen.mse)) {
				g.setColor(new Color(255,255,255,100));
				g.fillRect(button[i].x, button[i].y, button[i].width, button[i].height);
			}
			g.drawImage(Screen.tileset_res[0], button[i].x, button[i].y, button[i].width, button[i].height, null);
			if(buttonID[i] != Value.airAir) g.drawImage(Screen.tileset_air[buttonID[i]], button[i].x + itemIn, button[i].y + itemIn, button[i].width - (itemIn * 2), button[i].height - (itemIn * 2), null);
			if(buttonPrice[i] > 0) {
				g.setColor(new Color(255,255,255));
				g.setFont(new Font("Courier New", Font.BOLD, 14));
				g.drawString("$" + buttonPrice[i], button[i].x + itemIn, button[i].y + itemIn + 10);
			}
		}
		
		g.drawImage(Screen.tileset_res[1], buttonHealth.x, buttonHealth.y, buttonHealth.width, buttonHealth.height, null);
		g.drawImage(Screen.tileset_res[2], buttonMoney.x, buttonMoney.y, buttonMoney.width, buttonMoney.height, null);
		g.setFont(new Font("Courier New", Font.BOLD, 14));
		g.setColor(new Color(255,255,255));
		g.drawString("" + Screen.health, buttonHealth.x + buttonHealth.width + iconSpace, buttonHealth.y + iconTextY);
		g.drawString("" + Screen.coinage, buttonMoney.x + buttonMoney.width + iconSpace, buttonMoney.y + iconTextY);
		
		if(holdsItem) {
			g.drawImage(Screen.tileset_air[heldID], Screen.mse.x - ((button[0].width - (itemIn * 2))/2) + itemIn, Screen.mse.y - ((button[0].width - (itemIn * 2))/2) + itemIn, button[0].width - (itemIn * 2), button[0].height - (itemIn * 2), null);
		}
	}
}
