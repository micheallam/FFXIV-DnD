import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameJFrame extends JFrame implements ActionListener{
	//Game variables====================
	Container con = getContentPane();
	
	//Constructor ================================================================================
	//============================================================================================
	public GameJFrame() {
		super("Ishgardian Tales"); //Title of window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Settings.WIDTH, Settings.HEIGHT);
		setResizable(false); //disable resizing
		setLayout(null); 
		getContentPane().setBackground(Color.DARK_GRAY); // Sets the background color
		
		//Menu Bar ===============================================================================
		setJMenuBar(Menu.mainbar); //adds the mainbar to the window
		Menu.mainbar.add(Menu.file);
		Menu.file.add(Menu.home); // Will take the user back to the main menu screen
		Menu.file.add(Menu.exit); // Exits the program when clicked on
		
		//Home Page ==============================================================================
		createTitleScreen();
		
		// Set Action Listeners ==================================================================
		// =======================================================================================
		// Menu listeners
		Menu.home.addActionListener(this);
		Menu.exit.addActionListener(this);
		
	}
	
	// Creating the title screen ------------------------------
	public void createTitleScreen() {
		TitleScreen.makeTitleScreen();
		TitleScreen.startButton.addActionListener(this); //Adds to action listener
		TitleScreen.infoButton.addActionListener(this);
		TitleScreen.exitButton.addActionListener(this);
		
		add(TitleScreen.titleScreenBackground);
	}
	
	// Creating the game screens -----------------------------
	public void startAdventure() {
		// Set title screen visibility to false
		TitleScreen.titleScreenPanel.setVisible(false);
		TitleScreen.startButtonPanel.setVisible(false);
		
		GameScreen.makeAdventure();
		
		add(Player.playerStatPanel);
		add(GameScreen.gameTextPanel);
		add(GameScreen.gameButtonPanel);
		add(GameScreen.imagePanel);
	}
	
	// Create the info screen ------------------------------
	public void createInfo() {
		Information.makeInfo();
		Information.back.addActionListener(this);
		add(Information.infoPanel);
		add(Information.infoButtonPanel);
	}

	
	//Action Listener Events ======================================================================
	//=============================================================================================
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		// Controls the main menu bar
		if(source == Menu.home) {
			// Send the user back to the main menu
			GameScreen.gameTextPanel.setVisible(false);
			GameScreen.gameButtonPanel.setVisible(false);
			Player.playerStatPanel.setVisible(false);
			GameScreen.imagePanel.setVisible(false);
			createTitleScreen();
			
		}else if(source == Menu.exit || source == TitleScreen.exitButton) {
			// Exits the program through menu bar
			super.dispose();
			
		}else if(source == TitleScreen.infoButton) {
			//Starts the game
			TitleScreen.titleScreenBackground.setVisible(false);
			createInfo();
			
		}else if(source == TitleScreen.startButton) {
			//Starts the game
			TitleScreen.titleScreenBackground.setVisible(false);
			startAdventure();
			
		}else if(source == Information.back) {
			//Go back to the menu
			Information.infoPanel.setVisible(false);
			Information.infoButtonPanel.setVisible(false);
			TitleScreen.titleScreenBackground.setVisible(true);
			
		}
	}

}
