package Interfaz;
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//String to see from other clases
	public static String title = "Ecosystem Tower Defense";
	public static Dimension size = new Dimension(700, 550);
	//Constructor
	public Frame() {
		setTitle(title);
		setSize(size);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init();
	}
	//Initializer
	public void init() {
		setLayout(new GridLayout(1,1,0,0));
		
		Screen screen = new Screen(this);
		add(screen);
		
		setVisible(true);
	}
	//Main
	/*public static void main(String []args) {
		Frame frame = new Frame();
	}
*/
}
