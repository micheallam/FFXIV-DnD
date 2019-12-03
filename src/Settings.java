import java.awt.Color;
import java.awt.Font;

public class Settings {
	//Window game screen size
	final static int WIDTH = 800;
	final static int HEIGHT = 600;
	final static int IMAGE_WIDTH = 350;
	final static int IMAGE_HEIGHT = 190;
	
	//Color
	static Color backgroundColor = Color.DARK_GRAY;
	static Color buttonColor = Color.WHITE;
	static Color textColor = Color.WHITE;
	static Color transparent = new Color(0, 0, 0, 0); // makes it transparent
	
	//Game Fonts
	static Font titleFont = new Font("New Times Roman", Font.ITALIC, 70);
	static Font buttonFont = new Font("New Times Roman", Font.PLAIN, 20);
	static Font normalFont = new Font("New Times Roman", Font.PLAIN, 25);
	static Font italicFont = new Font("New Times Roman", Font.ITALIC, 25);
	

}
