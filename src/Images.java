import java.awt.Image;
import javax.swing.ImageIcon;

public class Images {
	//Prologue
	static ImageIcon prologue = new ImageIcon(".//images//Memories_of_a_Hero.jpg");
	static Image tempPrologue = prologue.getImage().
			getScaledInstance(Settings.IMAGE_WIDTH, Settings.IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	
	//Snow
		static ImageIcon snow = new ImageIcon(".//images//Snow.png");
		static Image tempSnow = snow.getImage().
				getScaledInstance(Settings.IMAGE_WIDTH, Settings.IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
		
	//Snow 2
	static ImageIcon snow2 = new ImageIcon(".//images//Snow.jpg");
	static Image tempSnow2 = snow2.getImage().
			getScaledInstance(Settings.IMAGE_WIDTH, Settings.IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	
	// Structures =================================================================================
	
	//Town gate
	static ImageIcon gateway = new ImageIcon(".//images//Gateway_Entrance.jpg");
	static Image tempGateway = gateway.getImage().
			getScaledInstance(Settings.IMAGE_WIDTH, Settings.IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	
	//Town
	static ImageIcon town = new ImageIcon(".//images//Town.png");
	static Image tempTown = town.getImage().
			getScaledInstance(Settings.IMAGE_WIDTH, Settings.IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	
	//Inn
	static ImageIcon inn = new ImageIcon(".//images//Inn.png");
	static Image tempInn = inn.getImage().
			getScaledInstance(Settings.IMAGE_WIDTH, Settings.IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	
	//City Square
	static ImageIcon citySquare = new ImageIcon(".//images//CitySquare.png");
	static Image tempCitySquare = citySquare.getImage().
			getScaledInstance(Settings.IMAGE_WIDTH, Settings.IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	
	//Snow Cabin
	static ImageIcon cabin = new ImageIcon(".//images//Cabin.png");
	static Image tempCabin = cabin.getImage().
			getScaledInstance(Settings.IMAGE_WIDTH, Settings.IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	
	//Cave
	static ImageIcon cave = new ImageIcon(".//images//Cave.png");
	static Image tempCave = cave.getImage().
			getScaledInstance(Settings.IMAGE_WIDTH, Settings.IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	
	//Corridor
	static ImageIcon corridor = new ImageIcon(".//images//Corridor.png");
	static Image tempCorridor = corridor.getImage().
			getScaledInstance(Settings.IMAGE_WIDTH, Settings.IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
		
	//Chest =======================================================================================
	//Closed
	static ImageIcon chest = new ImageIcon(".//images//Chest.png");
	static Image tempChest = chest.getImage().
			getScaledInstance(Settings.IMAGE_WIDTH, Settings.IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	
	//Opened
	static ImageIcon chestOpened = new ImageIcon(".//images//ChestOpened.png");
	static Image tempChestOpened = chestOpened.getImage().
			getScaledInstance(Settings.IMAGE_WIDTH, Settings.IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	
	//Weapons =====================================================================================
	static ImageIcon sword = new ImageIcon(".//images//LongSword.png");
	static Image tempSword = sword.getImage().
			getScaledInstance(Settings.IMAGE_WIDTH, Settings.IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	
	static ImageIcon daggers = new ImageIcon(".//images//Daggers.png");
	static Image tempDaggers = daggers.getImage().
			getScaledInstance(Settings.IMAGE_WIDTH, Settings.IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	
	static ImageIcon knuckles = new ImageIcon(".//images//Knuckles.png");
	static Image tempKnuckles = knuckles.getImage().
			getScaledInstance(Settings.IMAGE_WIDTH, Settings.IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	
	//Enemies =====================================================================================
	//guards
	static ImageIcon guards = new ImageIcon(".//images//Enemies.png");
	static Image tempGuards = guards.getImage().
			getScaledInstance(Settings.IMAGE_WIDTH, Settings.IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	
	//One guard
	static ImageIcon oneGuard = new ImageIcon(".//images//OneGuard.png");
	static Image tempOneGuard = oneGuard.getImage().
			getScaledInstance(Settings.IMAGE_WIDTH, Settings.IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	
	//Beast
	static ImageIcon beast = new ImageIcon(".//images//Beast.png");
	static Image tempBeast = beast.getImage().
			getScaledInstance(Settings.IMAGE_WIDTH, Settings.IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
	
	//Boss
	static ImageIcon boss = new ImageIcon(".//images//Boss.png");
	static Image tempBoss = boss.getImage().
			getScaledInstance(Settings.IMAGE_WIDTH, Settings.IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
}
