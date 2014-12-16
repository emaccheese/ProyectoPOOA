package Interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import Logica.loadImagenes;


public class JuegoBotones {
	

	JFrame frame;
	private Random r = new Random(); //Crea la funcion Random
	int x = 1;
	loadImagenes load;
  	public ImageIcon  icon[] = new ImageIcon[8];
  	
	

	/**
	 * Launch the application.
	 */
  	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegoBotones window = new JuegoBotones();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 */
	public JuegoBotones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		load = new loadImagenes(x);
		icon =load.returnImage() ;
		
		
		
	  	//icon =load.returnImage() ;
	  	
	  	
	  	
		frame = new JFrame();
		frame.setBounds(100, 100, 319, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);

		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);

		JButton btnIniciar = new JButton("INICIAR");

		JButton btnNewButton = new JButton("RESET");

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		final JButton btnBoton1 = new JButton("1",icon[0]);
		final JButton btnBoton2 = new JButton("2",icon[1]);
		final JButton btnBoton3 = new JButton("3",icon[2]);
		final JButton btnBoton4 = new JButton("4",icon[3]);
		final JButton btnBoton5 = new JButton("5",icon[4]);
		final JButton btnBoton6 = new JButton("6",icon[5]);
		final JButton btnBoton7 = new JButton("7",icon[6]);
		final JButton btnBoton8 = new JButton("8",icon[7]);
		final JButton btnBoton9 = new JButton("",icon[8]);
		btnBoton9.setVisible(false);


		btnBoton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnBoton4.getText().equals("")){
					btnBoton4.setText(btnBoton1.getText());
					btnBoton4.setIcon(btnBoton1.getIcon());
					btnBoton1.setText("");
					btnBoton1.setIcon(null);
					btnBoton4.setVisible(true);
					btnBoton1.setVisible(false);
				}
				else if(btnBoton2.getText().equals("")){
					btnBoton2.setText(btnBoton1.getText());
					btnBoton2.setIcon(btnBoton1.getIcon());
					btnBoton1.setText("");
					btnBoton1.setIcon(null);
					btnBoton2.setVisible(true);
					btnBoton1.setVisible(false);
				}
			}
		});
		btnBoton1.setBounds(0, 0, 100, 100);
		panel.add(btnBoton1);


		btnBoton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnBoton5.getText().equals("")){
					btnBoton5.setText(btnBoton2.getText());
					btnBoton5.setIcon(btnBoton2.getIcon());
					btnBoton2.setText("");
					btnBoton2.setIcon(null);
					btnBoton5.setVisible(true);
					btnBoton2.setVisible(false);
				}
				else if(btnBoton3.getText().equals("")){
					btnBoton3.setText(btnBoton2.getText());
					btnBoton3.setIcon(btnBoton2.getIcon());
					btnBoton2.setText("");
					btnBoton2.setIcon(null);
					btnBoton3.setVisible(true);
					btnBoton2.setVisible(false);
				}
				else if(btnBoton1.getText().equals("")){
					btnBoton1.setText(btnBoton2.getText());
					btnBoton1.setIcon(btnBoton2.getIcon());
					btnBoton2.setText("");
					btnBoton2.setIcon(null);
					btnBoton1.setVisible(true);
					btnBoton2.setVisible(false);
				}
			}
		});
		btnBoton2.setBounds(100, 0, 100, 100);
		panel.add(btnBoton2);


		btnBoton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnBoton6.getText().equals("")){
					btnBoton6.setText(btnBoton3.getText());
					btnBoton6.setIcon(btnBoton3.getIcon());
					btnBoton3.setText("");
					btnBoton3.setIcon(null);
					btnBoton6.setVisible(true);
					btnBoton3.setVisible(false);
				}
				else if(btnBoton2.getText().equals("")){
					btnBoton2.setText(btnBoton3.getText());
					btnBoton2.setIcon(btnBoton3.getIcon());
					btnBoton3.setText("");
					btnBoton3.setIcon(null);
					btnBoton2.setVisible(true);
					btnBoton3.setVisible(false);
				}
			}
		});
		btnBoton3.setBounds(200, 0, 100, 100);
		panel.add(btnBoton3);


		btnBoton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnBoton7.getText().equals("")){
					btnBoton7.setText(btnBoton4.getText());
					btnBoton7.setIcon(btnBoton4.getIcon());
					btnBoton4.setText("");
					btnBoton4.setIcon(null);
					btnBoton7.setVisible(true);
					btnBoton4.setVisible(false);
				}
				else if(btnBoton1.getText().equals("")){
					btnBoton1.setText(btnBoton4.getText());
					btnBoton1.setIcon(btnBoton4.getIcon());
					btnBoton4.setText("");
					btnBoton4.setIcon(null);
					btnBoton1.setVisible(true);
					btnBoton4.setVisible(false);
				}
				else if(btnBoton5.getText().equals("")){
					btnBoton5.setText(btnBoton4.getText());
					btnBoton5.setIcon(btnBoton4.getIcon());
					btnBoton4.setText("");
					btnBoton4.setIcon(null);
					btnBoton5.setVisible(true);
					btnBoton4.setVisible(false);
				}
			}
		});
		btnBoton4.setBounds(0, 100, 100, 100);
		panel.add(btnBoton4);


		btnBoton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnBoton8.getText().equals("")){
					btnBoton8.setText(btnBoton5.getText());
					btnBoton8.setIcon(btnBoton5.getIcon());
					btnBoton5.setText("");
					btnBoton5.setIcon(null);
					btnBoton8.setVisible(true);
					btnBoton5.setVisible(false);
				}
				else if(btnBoton6.getText().equals("")){
					btnBoton6.setText(btnBoton5.getText());
					btnBoton6.setIcon(btnBoton5.getIcon());
					btnBoton5.setText("");
					btnBoton5.setIcon(null);
					btnBoton6.setVisible(true);
					btnBoton5.setVisible(false);
				}
				else if(btnBoton4.getText().equals("")){
					btnBoton4.setText(btnBoton5.getText());
					btnBoton4.setIcon(btnBoton5.getIcon());
					btnBoton5.setText("");
					btnBoton5.setIcon(null);
					btnBoton4.setVisible(true);
					btnBoton5.setVisible(false);
				}
				else if(btnBoton2.getText().equals("")){
					btnBoton2.setText(btnBoton5.getText());
					btnBoton2.setIcon(btnBoton5.getIcon());
					btnBoton5.setText("");
					btnBoton5.setIcon(null);
					btnBoton2.setVisible(true);
					btnBoton5.setVisible(false);
				}
			}
		});
		btnBoton5.setBounds(100, 100, 100, 100);
		panel.add(btnBoton5);


		btnBoton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnBoton9.getText().equals("")){
					btnBoton9.setText(btnBoton6.getText());
					btnBoton9.setIcon(btnBoton6.getIcon());
					btnBoton6.setText("");
					btnBoton6.setIcon(null);
					btnBoton9.setVisible(true);
					btnBoton6.setVisible(false);
				}
				else if(btnBoton5.getText().equals("")){
					btnBoton5.setText(btnBoton6.getText());
					btnBoton5.setIcon(btnBoton6.getIcon());
					btnBoton6.setText("");
					btnBoton6.setIcon(null);
					btnBoton5.setVisible(true);
					btnBoton6.setVisible(false);
				}
				else if(btnBoton3.getText().equals("")){
					btnBoton3.setText(btnBoton6.getText());
					btnBoton3.setIcon(btnBoton6.getIcon());
					btnBoton6.setText("");
					btnBoton6.setIcon(null);
					btnBoton3.setVisible(true);
					btnBoton6.setVisible(false);
				}
			}
		});
		btnBoton6.setBounds(200, 100, 100, 100);
		panel.add(btnBoton6);





		btnBoton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnBoton4.getText().equals("")){
					btnBoton4.setText(btnBoton7.getText());
					btnBoton4.setIcon(btnBoton7.getIcon());
					btnBoton7.setText("");
					btnBoton7.setIcon(null);
					btnBoton4.setVisible(true);
					btnBoton7.setVisible(false);
				}
				else if(btnBoton8.getText().equals("")){
					btnBoton8.setText(btnBoton7.getText());
					btnBoton8.setIcon(btnBoton7.getIcon());
					btnBoton7.setText("");
					btnBoton7.setIcon(null);
					btnBoton8.setVisible(true);
					btnBoton7.setVisible(false);
				}
			}
		});

		btnBoton7.setBounds(0, 200, 100, 100);
		panel.add(btnBoton7);


		btnBoton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnBoton9.getText().equals("")){
					btnBoton9.setText(btnBoton8.getText());
					btnBoton9.setIcon(btnBoton8.getIcon());
					btnBoton8.setText("");
					btnBoton8.setIcon(null);
					btnBoton9.setVisible(true);
					btnBoton8.setVisible(false);
				}
				else if(btnBoton7.getText().equals("")){
					btnBoton7.setText(btnBoton8.getText());
					btnBoton7.setIcon(btnBoton8.getIcon());
					btnBoton8.setText("");
					btnBoton8.setIcon(null);
					btnBoton7.setVisible(true);
					btnBoton8.setVisible(false);
				}
				else if(btnBoton5.getText().equals("")){
					btnBoton5.setText(btnBoton8.getText());
					btnBoton5.setIcon(btnBoton8.getIcon());
					btnBoton8.setText("");
					btnBoton8.setIcon(null);
					btnBoton5.setVisible(true);
					btnBoton8.setVisible(false);
				}

			}
		});
		btnBoton8.setBounds(100, 200, 100, 100);
		panel.add(btnBoton8);


		btnBoton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnBoton6.getText().equals("")){
					btnBoton6.setText(btnBoton9.getText());
					btnBoton6.setIcon(btnBoton9.getIcon());
					btnBoton9.setText("");
					btnBoton9.setIcon(null);
					btnBoton6.setVisible(true);
					btnBoton9.setVisible(false);
				}
				else if(btnBoton8.getText().equals("")){
					btnBoton8.setText(btnBoton9.getText());
					btnBoton8.setIcon(btnBoton9.getIcon());
					btnBoton9.setText("");
					btnBoton9.setIcon(null);
					btnBoton8.setVisible(true);
					btnBoton9.setVisible(false);
				}
				 ganar( btnBoton1, btnBoton2, btnBoton3, btnBoton4, btnBoton5, btnBoton6,btnBoton7, btnBoton8, btnBoton9);
			}

		});
		btnBoton9.setBounds(200, 200, 100, 100);
		panel.add(btnBoton9);
		//Hacerlo en funciones //
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i;
				for(int c = 0; c < 50; c++){
					if(btnBoton9.getText().equals("")){
						i = r.nextInt(2);
						if(i == 0){
							btnBoton9.setText(btnBoton8.getText());
							btnBoton9.setIcon(btnBoton8.getIcon());
							btnBoton8.setText("");
							btnBoton8.setIcon(null);
							btnBoton9.setVisible(true);
							btnBoton8.setVisible(false);
						}
						else{
							btnBoton9.setText(btnBoton6.getText());
							btnBoton9.setIcon(btnBoton6.getIcon());
							btnBoton6.setText("");
							btnBoton6.setIcon(null);
							btnBoton9.setVisible(true);
							btnBoton6.setVisible(false);
						}
					}
					else if(btnBoton8.getText().equals("")){
						i = r.nextInt(3);
						if(i == 0){
							btnBoton8.setText(btnBoton7.getText());
							btnBoton8.setIcon(btnBoton7.getIcon());
							btnBoton7.setText("");
							btnBoton8.setVisible(true);
							btnBoton7.setVisible(false);
						}
						else if(i == 1){
							btnBoton8.setText(btnBoton5.getText());
							btnBoton8.setIcon(btnBoton5.getIcon());
							btnBoton5.setText("");
							btnBoton5.setIcon(null);
							btnBoton8.setVisible(true);
							btnBoton5.setVisible(false);
						}
						else{
								btnBoton8.setText(btnBoton9.getText());
								btnBoton8.setIcon(btnBoton9.getIcon());
								btnBoton9.setText("");
								btnBoton9.setIcon(null);
								btnBoton8.setVisible(true);
								btnBoton9.setVisible(false);
						}
					}
					else if(btnBoton7.getText().equals("")){
						i = r.nextInt(2);
						if(i == 0){
							btnBoton7.setText(btnBoton8.getText());
							btnBoton7.setIcon(btnBoton8.getIcon());
							btnBoton8.setText("");
							btnBoton8.setIcon(null);
							btnBoton7.setVisible(true);
							btnBoton8.setVisible(false);
						}
						else{
							btnBoton7.setText(btnBoton4.getText());
							btnBoton7.setIcon(btnBoton4.getIcon());
							btnBoton4.setText("");
							btnBoton4.setIcon(null);
							btnBoton7.setVisible(true);
							btnBoton4.setVisible(false);
						}
					}
					else if(btnBoton6.getText().equals("")){
						i = r.nextInt(3);
						if(i == 0){
							btnBoton6.setText(btnBoton3.getText());
							btnBoton6.setIcon(btnBoton3.getIcon());
							btnBoton3.setText("");
							btnBoton3.setIcon(null);
							btnBoton6.setVisible(true);
							btnBoton3.setVisible(false);
						}
						else if(i == 1){
							btnBoton6.setText(btnBoton5.getText());
							btnBoton6.setIcon(btnBoton5.getIcon());
							btnBoton5.setText("");
							btnBoton5.setIcon(null);
							btnBoton6.setVisible(true);
							btnBoton5.setVisible(false);
						}
						else{
								btnBoton6.setText(btnBoton9.getText());
								btnBoton6.setIcon(btnBoton9.getIcon());
								btnBoton9.setText("");
								btnBoton9.setIcon(null);
								btnBoton6.setVisible(true);
								btnBoton9.setVisible(false);
						}
					}
					else if(btnBoton5.getText().equals("")){
						i = r.nextInt(4);
						if(i == 0){
							btnBoton5.setText(btnBoton2.getText());
							btnBoton5.setIcon(btnBoton2.getIcon());
							btnBoton2.setText("");
							btnBoton2.setIcon(null);
							btnBoton5.setVisible(true);
							btnBoton2.setVisible(false);
						}
						else if(i == 1){
							btnBoton5.setText(btnBoton4.getText());
							btnBoton5.setIcon(btnBoton4.getIcon());
							btnBoton4.setText("");
							btnBoton4.setIcon(null);
							btnBoton5.setVisible(true);
							btnBoton4.setVisible(false);
						}
						else if(i == 2){
							btnBoton5.setText(btnBoton6.getText());
							btnBoton5.setIcon(btnBoton6.getIcon());
							btnBoton6.setText("");
							btnBoton6.setIcon(null);
							btnBoton5.setVisible(true);
							btnBoton6.setVisible(false);
						}
						else{
							btnBoton5.setText(btnBoton8.getText());
							btnBoton5.setIcon(btnBoton8.getIcon());
							btnBoton8.setText("");
							btnBoton8.setIcon(null);
							btnBoton5.setVisible(true);
							btnBoton8.setVisible(false);
						}
					}
					else if(btnBoton4.getText().equals("")){
						i = r.nextInt(3);
						if(i == 0){
							btnBoton4.setText(btnBoton7.getText());
							btnBoton4.setIcon(btnBoton7.getIcon());
							btnBoton7.setText("");
							btnBoton7.setIcon(null);
							btnBoton4.setVisible(true);
							btnBoton7.setVisible(false);
						}
						else if(i == 1){
							btnBoton4.setText(btnBoton5.getText());
							btnBoton4.setIcon(btnBoton5.getIcon());
							btnBoton5.setText("");
							btnBoton5.setIcon(null);
							btnBoton4.setVisible(true);
							btnBoton5.setVisible(false);
						}
						else{
								btnBoton4.setText(btnBoton1.getText());
								btnBoton4.setIcon(btnBoton1.getIcon());
								btnBoton1.setText("");
								btnBoton1.setIcon(null);
								btnBoton4.setVisible(true);
								btnBoton1.setVisible(false);
						}
					}
					else if(btnBoton3.getText().equals("")){
						i = r.nextInt(2);
						if(i == 0){
							btnBoton3.setText(btnBoton2.getText());
							btnBoton3.setIcon(btnBoton2.getIcon());
							btnBoton2.setText("");
							btnBoton2.setIcon(null);
							btnBoton3.setVisible(true);
							btnBoton2.setVisible(false);
						}
						else{
							btnBoton3.setText(btnBoton6.getText());
							btnBoton3.setIcon(btnBoton6.getIcon());
							btnBoton6.setText("");
							btnBoton6.setIcon(null);
							btnBoton3.setVisible(true);
							btnBoton6.setVisible(false);
						}
					}
					else if(btnBoton2.getText().equals("")){
						i = r.nextInt(3);
						if(i == 0){
							btnBoton2.setText(btnBoton1.getText());
							btnBoton2.setIcon(btnBoton1.getIcon());
							btnBoton1.setText("");
							btnBoton1.setIcon(null);
							btnBoton2.setVisible(true);
							btnBoton1.setVisible(false);
						}
						else if(i == 1){
							btnBoton2.setText(btnBoton3.getText());
							btnBoton2.setIcon(btnBoton3.getIcon());
							btnBoton3.setText("");
							btnBoton3.setIcon(null);
							btnBoton2.setVisible(true);
							btnBoton3.setVisible(false);
						}
						else{
								btnBoton2.setText(btnBoton5.getText());
								btnBoton2.setIcon(btnBoton5.getIcon());
								btnBoton5.setText("");
								btnBoton5.setIcon(null);
								btnBoton2.setVisible(true);
								btnBoton5.setVisible(false);
						}
					}
					else if(btnBoton1.getText().equals("")){
						i = r.nextInt(2);
						if(i == 0){
							btnBoton1.setText(btnBoton2.getText());
							btnBoton1.setIcon(btnBoton2.getIcon());
							btnBoton2.setText("");
							btnBoton2.setIcon(null);
							btnBoton1.setVisible(true);
							btnBoton2.setVisible(false);
						}
						else{
							btnBoton1.setText(btnBoton4.getText());
							btnBoton1.setIcon(btnBoton4.getIcon());
							btnBoton4.setText("");
							btnBoton4.setIcon(null);
							btnBoton1.setVisible(true);
							btnBoton4.setVisible(false);
						}
					}
				}
			}
		});
		toolBar.add(btnIniciar);


		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBoton1.setText("1");
				btnBoton1.setVisible(true);
				btnBoton1.setIcon(icon[0]);
				btnBoton2.setText("2");
				btnBoton2.setVisible(true);
				btnBoton2.setIcon(icon[1]);
				btnBoton3.setText("3");
				btnBoton3.setVisible(true);
				btnBoton3.setIcon(icon[2]);
				btnBoton4.setText("4");
				btnBoton4.setVisible(true);
				btnBoton4.setIcon(icon[3]);
				btnBoton5.setText("5");
				btnBoton5.setVisible(true);
				btnBoton5.setIcon(icon[4]);
				btnBoton6.setText("6");
				btnBoton6.setVisible(true);
				btnBoton6.setIcon(icon[5]);
				btnBoton7.setText("7");
				btnBoton7.setVisible(true);
				btnBoton7.setIcon(icon[6]);
				btnBoton8.setText("8");
				btnBoton8.setVisible(true);
				btnBoton8.setIcon(icon[7]);
				btnBoton9.setText("");
				btnBoton9.setVisible(false);
				//btnBoton8.setIcon(imagen1[8]);

			}
		});
		toolBar.add(btnNewButton);
		
		JButton btnNewAnimal = new JButton("Nuevo Animal");
		btnNewAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(x<11){
					x+=1;
					System.out.println("x: "+x);
				}
				else{
					x=1;
				}
				initialize();
			}
		});
		toolBar.add(btnNewAnimal);
	}
		private void ganar(JButton btnBoton1,JButton btnBoton2,
                           JButton btnBoton3,JButton btnBoton4,
                           JButton btnBoton5,JButton btnBoton6,
                           JButton btnBoton7,JButton btnBoton8,
                           JButton btnBoton9){

			if(btnBoton1.getText().equals("1") &&
					btnBoton2.getText().equals("2") &&
					btnBoton3.getText().equals("3") &&
					btnBoton4.getText().equals("4") &&
					btnBoton5.getText().equals("5") &&
					btnBoton6.getText().equals("6") &&
					btnBoton7.getText().equals("7") &&
					btnBoton8.getText().equals("8") &&
					btnBoton9.getText().equals("")){
				JOptionPane.showMessageDialog(null,"GANASTE");
				// System.out.println("Ganaste");
		}
	/*else {
			//JOptionPane.showMessageDialog(null,"SIGUE ASI");
			// System.out.println("SIGUE ASI");
		}*/
	}
}
