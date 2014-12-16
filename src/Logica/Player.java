package Logica;
 import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Interfaz.GamePanel;

public class Player {
	
	private double x;
	private double y;
	private double dx;
	private double dy;
	
	private int width;
	private int height;
	
	private boolean left;
	private boolean right;
	private boolean jumping;
	private boolean falling;
	
	private double moveSpeed = 0.6;
	private double maxSpeed = 8.2;
	private double maxFallingSpeed = 12;
	private double stopSpeed = 0.30;
	private double jumpStart = -10.0;
	private double gravity = 0.64;
	
	private TileMap tileMap;
	
	private boolean topLeft;
	private boolean topRight;
	private boolean bottomLeft;
	private boolean bottomRight;
	
	private Animation animation;
	private BufferedImage[] idleSprites;
	private BufferedImage[]	walkingSprites;
	
	private BufferedImage[] jumpingSprites;
	private BufferedImage[]	fallingSprites;
	private boolean facingRight; //puede ser facingLeft, dependiendo del sprite
	
	public double getJumpStart() {
		return jumpStart;
	}
	public void setJumpStart(double jumpStart) {
		this.jumpStart = jumpStart;
	}
	
	public double getStopSpeed() {
		return stopSpeed;
	}
	public void setStopSpeed(double stopSpeed) {
		this.stopSpeed = stopSpeed;
	}
	public double getMoveSpeed() {
		return moveSpeed;
	}
	public void setMoveSpeed(double moveSpeed) {
		this.moveSpeed = moveSpeed;
	}
	public double getGravity() {
		return gravity;
	}
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}

	public Player(TileMap tm) {
		
		tileMap = tm;
		
		//altura y ancho de el sprite del Jugador
		width = 17;
		height = 29;
		
		//moveSpeed = 0.6;
		//maxSpeed = 7.6;
		//maxFallingSpeed = 13;
		//stopSpeed = 0.30;
		//jumpStart = -11.0;
		//gravity = 0.84;
		
		System.out.println("x:"+x);
		System.out.println("y:"+y);
		//Animacion del jugador, sprites de movimiento.
		try{
			idleSprites = new BufferedImage[1];
			jumpingSprites = new BufferedImage[1];
			fallingSprites = new BufferedImage[1];
			walkingSprites = new BufferedImage[4];
			
			//se direcciona a el archivo con los sprites
			//Solo 1 frame para estas animaciones
			//idleSprites[0]= ImageIO.read(new File("src\\Datos\\images\\MarioIddle.gif"));
			idleSprites[0]= ImageIO.read(Player.class.getResourceAsStream("/Datos/images/MarioIddle.gif"));
			//jumpingSprites[0]=ImageIO.read(new File("src\\Datos\\images\\MarioJumping.gif"));
			jumpingSprites[0]=ImageIO.read(Player.class.getResourceAsStream("/Datos/images/MarioJumping.gif"));
			//fallingSprites[0]=ImageIO.read(new File("src\\Datos\\images\\MarioFalling.gif"));
			fallingSprites[0]=ImageIO.read(Player.class.getResourceAsStream("/Datos/images/MarioFalling.gif"));
			
			//mas de un frame para las animaciones
			//BufferedImage image = ImageIO.read(new File("src\\Datos\\images\\MarioWalking.gif")); // walking
			BufferedImage image = ImageIO.read(Player.class.getResourceAsStream("/Datos/images/MarioWalking.gif"));
			for(int i = 0; i < walkingSprites.length;i++){
				walkingSprites[i] = image.getSubimage(i * width + i, 0, width, height);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		animation = new Animation();
		facingRight = false;
	}
	public boolean isJumping() {
		return jumping;
	}
	public double getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public double getMaxFallingSpeed() {
		return maxFallingSpeed;
	}
	public void setMaxFallingSpeed(double maxFallingSpeed) {
		this.maxFallingSpeed = maxFallingSpeed;
	}
	public void setx(int i){ x = i;}
	public void sety (int i){ y = i;}
	
	public void setLeft(boolean b){
		left = b;
	}
	public void setRight (boolean b){
		right = b;
		
	}
	public void setJumping(boolean b){
		if(!falling){
			jumping = true;
		}
	}
	public void setJumping2(boolean c){
		jumping = c;
	}
	//DETECTA ESQUINAS
		//indica las esquinas del jugador
	private void calculateCorners(double x, double y){
		int leftTile = tileMap.getColTile((int)(x - width / 2));
		int rightTile = tileMap.getColTile((int) (x + width / 2) - 1);
		int topTile = tileMap.getRowTile((int) (y - height / 2));
		int bottomTile = tileMap.getColTile((int) (y + height / 2) - 1);
		
		topLeft = tileMap.isBlocked(topTile, leftTile);
		topRight = tileMap.isBlocked(topTile, rightTile);
		bottomLeft = tileMap.isBlocked(bottomTile, leftTile);
		bottomRight = tileMap.isBlocked(bottomTile, rightTile);
	}
	/////////////////////////////////
	
	public void update(){
		
		//Determina la siguiente posicion
		
		if(left){
			dx -= moveSpeed;
			if(dx < -maxSpeed){
				dx = -maxSpeed;
			}
		}
		else if(right){
			dx += moveSpeed;
			if(dx > maxSpeed){
				dx = maxSpeed;
			}
		}
		else{
			if(dx > 0){
				dx -= stopSpeed;
				if(dx < 0){
					dx = 0;
				}
			}
			else if(dx < 0){
				dx += stopSpeed;
				if(dx > 0){
					dx = 0;
				}
			}
			
		}
		//Brincando
		if(jumping){
			dy = jumpStart;
			falling = true;
			jumping = false;
		}
		if (falling){
			dy += gravity;
			if(dy > maxFallingSpeed){
				dy = maxFallingSpeed;
			}
		}
		else {
			dy = 0;
		}
		
		// Checa  Colisiones
		
		int currCol = tileMap.getColTile((int)x);
		int currRow = tileMap.getRowTile((int)y);
		
		double tox = x + dx;
		double toy = y + dy;
		
		double tempx = x;
		double tempy = y;
		
		calculateCorners(x, toy);
		if(dy < 0){
			if(topLeft || topRight){
				dy = 0;
				tempy = currRow * tileMap.getTileSize() + height / 2;
			}
			else {
				tempy += dy;
			}
		}
		if(dy > 0){
			if(bottomLeft || bottomRight){
				dy = 0;
				falling = false;
				tempy = (currRow + 1) * tileMap.getTileSize() - height / 2;
			}
			else{
				tempy += dy;
			}
		}
		
		calculateCorners(tox,y);
		if(dx < 0){
			if(topLeft || bottomLeft){
				dx = 0;
				tempx = currCol * tileMap.getTileSize() + width / 2;
			}
			else {
				tempx += dx;
			}
		}
		if(dx > 0){
			if(topRight || bottomRight){
				dx = 0;
				tempx = (currCol + 1) * tileMap.getTileSize() - width / 2;
			}
			else{
				tempx += dx;
			}
		}
		
		if(!falling){
			calculateCorners(x,y + 1);
			if(!bottomLeft && !bottomRight){
				falling = true;
			}
		}
		x = tempx;
		y = tempy;
		
		//mover el mapa
	
		
		tileMap.setX((int) (GamePanel.WIDTH / 4 - x));
		
		//if(y>400){
		tileMap.setY( (int) (GamePanel.HEIGHT / 2 - y));
		//}
		
		
		//animacion de Sprites 
		if(left || right){
			animation.setFrames(walkingSprites);
			animation.setDelay(100);
		}
		else{
			animation.setFrames(idleSprites);
			animation.setDelay(-1);
		}
		if(dy < 0){
			animation.setFrames(jumpingSprites);
			animation.setDelay(-1);
		}
		if(dy > 0){
			animation.setFrames(fallingSprites);
			animation.setDelay(-1);
		}
		animation.update();
		
		//aqui para saver si esta volteando a la derecho o izquierda
		if(dx < 0){
			facingRight = false; 
		}
		if(dx > 0){
			facingRight = true;
		}
		
	}
	
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void draw(Graphics2D g){
		
		int tx = tileMap.getX();
		int ty = tileMap.getY();
		
		if(facingRight){
			g.drawImage(animation.getImage(),
					(int)(tx + x - width / 2),
					(int) (ty + y - height / 2),
					null);
		}
		else{
			g.drawImage(
					animation.getImage(), 
					(int) (tx + x - width / 2 + width), 
					(int) (ty + y - height / 2),
					-width, height, null );
		}
		
		
		/*
		g.setColor(Color.RED);
		g.fillRect(
				(int)(tx + x - width / 2), 
				(int)(ty + y - height / 2), 
				width, 
				height);
				*/
	}


	
}
