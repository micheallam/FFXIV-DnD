import java.awt.*;
import javax.swing.*;

public class Information {
	//Variables
	static JPanel infoPanel, infoButtonPanel;
	static JTextArea infoArea;
	static JButton back;
	
	//Makes the Information screen
	public static void makeInfo() {
		infoPanel = new JPanel();
		infoPanel.setBounds(100, 50, 600, 500);
		infoPanel.setBackground(Settings.backgroundColor);
		
		infoButtonPanel = new JPanel();
		infoButtonPanel.setLayout(new GridLayout(3, 1));
		infoButtonPanel.setBounds(300, 400, 200, 100);
		infoButtonPanel.setBackground(Settings.backgroundColor);
		
		infoArea = new JTextArea("This game is a final project for CPSC 223J.This is a DND-like "
				+ "game with a Final Fantasy XIV Heavensward based story.\nImages were screenshots "
				+ "from FFXIV by Michael Lam\n\nMade by Michael Lam\n"
				+ "Inspired by RyiSnow's Youtube Tutorials");
		infoArea.setBackground(Settings.backgroundColor);
		infoArea.setForeground(Settings.textColor);
		infoArea.setBounds(100, 100, 600, 250);
		infoArea.setFont(Settings.normalFont);
		infoArea.setLineWrap(true); //Used to wrap the line to the new line if it's too long
		infoArea.setWrapStyleWord(true); //Used to wrap the words around
		
		back = new JButton("Back");
		back.setBackground(Settings.backgroundColor);
		back.setForeground(Settings.buttonColor);
		back.setFont(Settings.buttonFont);
		back.setFocusPainted(false);
		
		//Add to each panel
		infoPanel.add(infoArea);
		infoButtonPanel.add(back);
	}

}
