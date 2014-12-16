package Interfaz;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Logica.PlaySong;
import Logica.PlaySound;
import Logica.Player;
import Logica.TileMap;

public class GamePanel /*<file1>*/ extends JPanel implements Runnable, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1150;
	public static final int HEIGHT = 650;
	private Thread thread;
	
	private boolean running;
	private boolean swimming;
	public boolean jungle;
	private boolean jungleDoor;
	private boolean desertDoor;
	private boolean waterDoor;
	private boolean forestDoor;
	
	//private PlaySong song;
	
	private BufferedImage image;
	private Graphics2D g;
	
	private int FPS = 30;
	private int targetTime = 1000/FPS;
	
	private TileMap tileMap;
	private Player player;
	
	private PlaySound swimmingSound;
	private PlaySound jumpingSound;
	private PlaySong music;
	
	//private File file1;
	//private File file2;
	
	static JFrame window;
	private Frame frame;
	
	public static void main(String[] args){
		window = new JFrame("Platformer");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new GamePanel());
		window.pack();
		window.setVisible(true);
		window.setSize(1150, 700);
		
		
		
	}
	
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		/*
		JMenuBar menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);
		
		JMenu mnJuego = new JMenu("Juego");
		menuBar.add(mnJuego);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnJuego.add(mntmExit);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mnAyuda.add(mntmAyuda);
		*/
	}
	
	public void addNotify(){
		super.addNotify();
		if(thread == null){
			thread = new Thread(this);
			thread.start();
		}
		addKeyListener( this);
	}
	@Override
	public void run() {
	
		init();
		
		long startTime;
		long urdTime;
		long waitTime;
		
		while(running){
			startTime = System.nanoTime();
			//song = new PlaySong();
			update();
			render();
			draw();
			
			//song.start();
			urdTime = (System.nanoTime()- startTime) / 1000000;
			waitTime = targetTime - urdTime;
			
			try{
				Thread.sleep(waitTime);
			}
			catch(Exception e){
				
			}
		}
		
	}
	private void init(){
		running = true;
		
		music = new PlaySong();
		
		music.start();
		
		image = new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		
		tileMap = new TileMap("/Datos/testmap.txt",32);
		tileMap.loadTiles("/Datos/images/tileset.gif");
		player = new Player(tileMap);
		player.setx(200);
		player.sety(300);
		//double dx = player.getX();
		//System.out.println("x:"+dx);
	}
	
	  //////////////////////////////////////////////////////////////////
	
	//La funcion update(); se actualiza continuamente
   //para indicar la posicion del jugador (player)
	private void update(){
		tileMap.update();
		player.update();
		//file2 = new File("src\\Audio\\bird.wav");
		//forestSound = new PlaySound();
		
		double x = player.getX();
		double y = player.getY();
		
		// ECOSISTEMA
		//detecta en cual ecosistema se encuentra
		//el jugador.
		
		if(x > 626 && y < 466){
			jungle = true;
		}else{
			jungle = false;
		}
		
		//agua
		if(x < 526 && y > 466){
			player.setGravity(0.60);
			player.setMaxFallingSpeed(3);
			player.setMoveSpeed(0.4);
			//player.setJumpStart(-9.00);
			swimming = true;
			
		}else{
			swimming = false;
			player.setGravity(0.64);
			player.setMaxFallingSpeed(12);
			player.setMoveSpeed(0.6);
			player.setJumpStart(-10.00);
		}
		
		//desert
		if(x > 712 && y > 466){
			player.setGravity(0.94);
			player.setMaxFallingSpeed(12);
			player.setMoveSpeed(0.4);
			player.setJumpStart(-9.00);
			player.setMaxSpeed(6.0);
			
		}
		//DOORS
				//detecta si el jugador esta sobre una puerta
				//usando su posicion (x,y) 
		if(x > 261 && x < 284 && y == 370){
			
			forestDoor = true;
			//System.out.println("x>261 && x<284");
		}
		else{
			forestDoor = false;
			
		}
		if(x >805 && x < 826 && y == 146){
			jungleDoor = true;
		}else{
			jungleDoor = false;
		}
		if(x > 39 && x < 57 && y == 498){
			waterDoor = true;
		}else{
			waterDoor = false;
		}
		if(x > 934 && x < 953 && y == 658){
			desertDoor = true;
		}else{
			desertDoor = false;
		}
		
		//System.out.println("x:"+x);
		//System.out.println("y:"+y);
	}
	
	private void render(){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		tileMap.draw(g);
		player.draw(g);
	}
	
	private void draw(){
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}
	
	
	//DETECSION DE BOTONES
		//Detecta el tequleado de botones
	public void keyTyped(KeyEvent key){}
	
	public void keyPressed(KeyEvent key){
		int code = key.getKeyCode();
		
		//IZQUIERDA
		if(code == KeyEvent.VK_LEFT){
			player.setLeft(true);
		}
		//DERECHO
		if (code == KeyEvent.VK_RIGHT){
			player.setRight(true);
		}
		
		//BRINCO
		if(code == KeyEvent.VK_SPACE){
			
			player.setJumping(true);
			//AGUA
			if(swimming){
				//file1= new File("src\\Audio\\bubbling1.wav");
				swimmingSound =  new PlaySound();
				//swimmingSound.setSoundFile(file1);
				//swimmingSound.setSoundFile(soundFile)
				swimmingSound.setFile("/Datos/Audio/bubbling1.wav");
				swimmingSound.start();
				player.setJumpStart(-6.00);
				player.setJumping2(true);
				
			}
			//JUNGLA
			if(jungle){
				
				//System.out.println("jungle!!");
				//file2 = new File("src\\Datos\\Audio\\boing2.wav");
				if(player.isJumping()){
				jumpingSound = new PlaySound();
				jumpingSound.setFile("/Datos/Audio/boing2.wav");
				jumpingSound.start();
				}
				player.setJumpStart(-15.00);
			}
		}
		
		if(code == KeyEvent.VK_ENTER){
			
			//double x = player.getX();
			//double y = player.getY();
			
			//System.out.println("x:"+x);
			//System.out.println("y:"+y);
			
			//MINIJUEGOS
				// TOWER DEFENSE
			if(forestDoor){
				System.out.println("forestDoor = true");
				window.setVisible(false);
				window.dispose();
				frame = new Frame();
				frame.setVisible(true);
				if(Screen.simon){
					frame.setVisible(false);
					frame.dispose();
					window.setVisible(true);
				}
			}
				//OTRO MINIJUEGO
			if(jungleDoor){
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JuegoBotones windowBotones = new JuegoBotones();
							windowBotones.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
				//OTRO MINIJUEGO
			if(waterDoor){
				
			}
				//OTRO MINIJUEGO
			if(desertDoor){
				
			}
		}
	}
	
	public void keyReleased(KeyEvent key){
		int code = key.getKeyCode();
		
		if(code == KeyEvent.VK_LEFT){
			player.setLeft(false);
		}
		if (code == KeyEvent.VK_RIGHT){
			player.setRight(false);
		}
	}
	
}
