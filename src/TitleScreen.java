import java.awt.*;
import javax.swing.*;

public class TitleScreen{
	// Title Screen Variables ----------------------------------
	static JPanel titleScreenPanel, startButtonPanel;
	static JLabel titleScreenLabel, titleScreenBackground;
	static JButton startButton, infoButton, exitButton;
	static ImageIcon titleScreenImage = new ImageIcon(".//images//Titlescreen.jpg");
	static Image temp_img = titleScreenImage.getImage().
			getScaledInstance(Settings.WIDTH, Settings.HEIGHT, java.awt.Image.SCALE_SMOOTH);
	static ImageIcon backgroundImage = new ImageIcon(temp_img);
	
	// Creating the title screen ------------------------------
	public static void makeTitleScreen() {
		titleScreenBackground = new JLabel("", backgroundImage, JLabel.CENTER);
		titleScreenBackground.setBounds(0, 0, Settings.WIDTH, Settings.HEIGHT);
		
		titleScreenPanel = new JPanel();
		titleScreenPanel.setBounds(100, 100, 600, 150);
		titleScreenPanel.setBackground(Settings.transparent);
		
		titleScreenLabel = new JLabel("Ishgardian Tales");
		titleScreenLabel.setForeground(Settings.textColor);
		titleScreenLabel.setFont(Settings.titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setLayout(new GridLayout(3, 1));
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Settings.transparent);
	
		startButton = new JButton("START");
		startButton.setBackground(Settings.backgroundColor);
		startButton.setForeground(Settings.buttonColor);
		startButton.setFont(Settings.buttonFont);
		startButton.setFocusPainted(false); // disables the box around the start button
		
		infoButton = new JButton("INFO");
		infoButton.setBackground(Settings.backgroundColor);
		infoButton.setForeground(Settings.buttonColor);
		infoButton.setFont(Settings.buttonFont);
		infoButton.setFocusPainted(false);
		
		exitButton = new JButton("EXIT"); // Exit button, closes the program
		exitButton.setBackground(Settings.backgroundColor);
		exitButton.setForeground(Settings.buttonColor);
		exitButton.setFont(Settings.buttonFont);
		exitButton.setFocusPainted(false);
		
		titleScreenPanel.add(titleScreenLabel); //Adding to the panels
		startButtonPanel.add(startButton);
		startButtonPanel.add(infoButton);
		startButtonPanel.add(exitButton);
		titleScreenBackground.add(titleScreenPanel);
		titleScreenBackground.add(startButtonPanel);
	}

}
