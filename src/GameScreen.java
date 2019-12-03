import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
 * Comment position mapping is on google draw.io file
 */

public class GameScreen {
	// Variables =================================================================================
	static JTextArea gameTextArea; // Main area where the text will be shown
	static JPanel gameTextPanel, gameButtonPanel, imagePanel;
	static JLabel imageLabel;
	static ImageIcon image;
	static JButton choice1, choice2, choice3, choice4;
	static String currentPosition; //Sets the current position of player, allows to change states
	static boolean ascianInfo = false;
	static boolean chestOpened = false;
	static int chance = 0;
	
	static ChoiceHandler choiceHandler = new ChoiceHandler(); //the switch case listener for choices
	
	// First screen of the main game / starts the game------------
	public static void makeAdventure() {
		ascianInfo = false;
		chestOpened = false;
		currentPosition = "Prologue1"; 
		
		//Creates the image panel
		imagePanel = new JPanel();
		imagePanel.setBounds(80, 350, Settings.IMAGE_WIDTH, Settings.IMAGE_HEIGHT);
		
		imageLabel = new JLabel();
		image = new ImageIcon(Images.tempPrologue);
		imageLabel.setIcon(image);
		
		imagePanel.add(imageLabel);

		
		gameTextPanel = new JPanel(); //Text area goes into the panel
		gameTextPanel.setBounds(100, 50, 600, 300);
		gameTextPanel.setBackground(Settings.backgroundColor);
		
		gameTextArea = new JTextArea("You're a famous mercenary who's saved an entire country from "
				+ "civil war, but you've been framed for the assassination of the queen at a formal"
				+ " party held for your party of adventurers. Your party members inform you of a "
				+ "shifty person with a black flame tattoo on their face they saw right before the "
				+ "celebration started. Your friends stay back one by one in order to give you "
				+ "enough time to escape, and tell you to find whoever the true culprit was."); //Prologue
		gameTextArea.setBounds(100, 100, 600, 250);
		gameTextArea.setBackground(Settings.backgroundColor);
		gameTextArea.setForeground(Settings.textColor);
		gameTextArea.setFont(Settings.italicFont);
		gameTextArea.setLineWrap(true); //Used to wrap the line to the new line if it's too long
		gameTextArea.setWrapStyleWord(true); //Used to wrap the words around
		
		// Player's Status up on the top of the screen ---------
		Player.playerStatPanel = new JPanel();
		Player.playerStatPanel.setBounds(20, 5, 800, 50);
		Player.playerStatPanel.setBackground(Settings.backgroundColor);
		Player.playerStatPanel.setLayout(new GridLayout(1, 4));
		
		Player.hpText = new JLabel("HP: ");
		Player.hpText.setForeground(Settings.textColor);
		Player.hpText.setFont(Settings.normalFont);
		
		Player.hpStatus = new JLabel();
		Player.hpStatus.setFont(Settings.normalFont);
		Player.hpStatus.setForeground(Settings.textColor);
		
		Player.weaponText = new JLabel("Weapon: ");
		Player.weaponText.setForeground(Settings.textColor);
		Player.weaponText.setFont(Settings.normalFont);
		
		Player.weaponStatus = new JLabel("");
		Player.weaponStatus.setForeground(Settings.textColor);
		Player.weaponStatus.setFont(Settings.normalFont);
		
		Player.playerStatPanel.add(Player.hpText);
		Player.playerStatPanel.add(Player.hpStatus);
		Player.playerStatPanel.add(Player.weaponText);
		Player.playerStatPanel.add(Player.weaponStatus);
		
		//Buttons -----------------------------------------------
		gameButtonPanel = new JPanel(new GridLayout(4, 1, 1, 1));
		gameButtonPanel.setBounds(480, 350, 300, 150);
		gameButtonPanel.setBackground(Settings.backgroundColor);
		
		choice1 = new JButton("next");
		choice1.setBackground(Settings.backgroundColor);
		choice1.setForeground(Settings.buttonColor);
		choice1.setFont(Settings.buttonFont);
		choice1.setActionCommand("C1");
		choice2 = new JButton("");
		choice2.setBackground(Settings.backgroundColor);
		choice2.setForeground(Settings.buttonColor);
		choice2.setFont(Settings.buttonFont);
		choice2.setActionCommand("C2");
		choice3 = new JButton("");
		choice3.setBackground(Settings.backgroundColor);
		choice3.setForeground(Settings.buttonColor);
		choice3.setFont(Settings.buttonFont);
		choice3.setActionCommand("C3");
		choice4 = new JButton("");
		choice4.setBackground(Settings.backgroundColor);
		choice4.setForeground(Settings.buttonColor);
		choice4.setFont(Settings.buttonFont);
		choice4.setActionCommand("C4");
		
		
		// Add to the window ------------------------------------
		gameTextPanel.add(gameTextArea);
		gameButtonPanel.add(choice1);
		gameButtonPanel.add(choice2);
		gameButtonPanel.add(choice3);
		gameButtonPanel.add(choice4);
		
		// Action Listener --------------------------------------
		choice1.addActionListener(choiceHandler);
		choice2.addActionListener(choiceHandler);
		choice3.addActionListener(choiceHandler);
		choice4.addActionListener(choiceHandler);
		
		//Sets the player status(new game status)
		Player.playerStatus();
	}
	
	public static void nextPrologue() {
		// The second screen after you start the game
		currentPosition = "Prologue2";
		gameTextArea.setText("You find yourself safely outside of the city-state after a long and "
				+ "tiring escape. While you escape you hear a suspicious pair of army guards "
				+ "mentioning their boss is heading towards the fabled city of dragons, "
				+ "Ishgard. With the parting information your friends left you, everything added "
				+ "up that this boss had had to be the true culprit.\nFilled with fury you quickly "
				+ "set off to Ishgard.");
		choice1.setText("next");
		choice2.setText("back");
		
	}
	
	public static void prevPrologue() {
		// Goes back to the first screen
		currentPosition = "Prologue1";
		gameTextArea.setText("You're a famous mercenary who's saved an entire country from "
				+ "civil war, but you've been framed for the assassination of the queen at a formal"
				+ " party held for your party of adventurers. Your party members inform you of a "
				+ "shifty person with a black flame tattoo on their face they saw right before the "
				+ "celebration started. Your friends stay back one by one in order to give you "
				+ "enough time to escape, and tell you to find whoever the true culprit was."); //Prologue
		choice1.setText("next");
		choice2.setText("");
	}
	
	// Lost in the snow and found shelter -----------------------
	public static void lostInSnow() {
		currentPosition = "Snow";
		image = new ImageIcon(Images.tempSnow);
		imageLabel.setIcon(image);
		gameTextArea.setText("You've been trudging through deep snow for the past few hours. "
				+ "You're running low on supplies and you havent seen any signs of civilization "
				+ "so far. You know Ishgard is somewhere north of your current position.\n\nWhat "
				+ "would you like to do?");
		choice1.setText("Continue North");
		choice2.setText("Look for shelter");
	}
	
	public static void findShelter() {
		// From lostInSnow
		currentPosition = "Searching";
		image = new ImageIcon(Images.tempCabin);
		imageLabel.setIcon(image);
		gameTextArea.setText("You wander around the snow for a few more minutes until you finally"
				+ " come across a shillouthe. You walk closer to the mysterious structure and find"
				+ " that it is a broken down shelter. Although it has some holes, it could provide"
				+ " warmth and safety until it's safer to head up north.\n\nWill you stay?");
		choice1.setText("Stay");
		choice2.setText("Continue North");
	}
	
	public static void stayShelter() {
		//From findShelter
		currentPosition = "Staying";
		gameTextArea.setText("You open the creaking door and find yourself in a rather homely place"
				+ " to stay compared to the blizzard outside. You see there's blankets lying on "
				+ "the ground, probably from a previous adventurer who used this same cabin.\n\n"
				+ "What would you like to do?");
		choice1.setText("Search");
		choice2.setText("Rest");
		choice3.setText("Leave"); //Continue up north
	}
	
	public static void searchShelter() {
		//From stayShelter
		currentPosition = "ShelterSearching";
		image = new ImageIcon(Images.tempSword);
		imageLabel.setIcon(image);
		gameTextArea.setText("You look around the cabin to see if there's any other useful things."
				+ " In the corner of your eye, you see something that seemed to reflect your a "
				+ "faint image of yourself.\n\nYou find a rather new long sword.");
		Player.longSwordWeapon = true;
		Player.weaponName = "Long Sword";
		Player.weaponStatus.setText(Player.weaponName); //Equip the Long Sword
		choice1.setText("Rest");
		choice2.setText("Leave");
		choice3.setText("");
	}
	
	public static void restShelter() {
		//From stayShelter
		currentPosition = "Resting";
		image = new ImageIcon(Images.tempCabin);
		imageLabel.setIcon(image);
		gameTextArea.setText("Some of the bitter coldness flows through into the cabin because of "
				+ "the tiny holes. You quickly take the blanket and put it over yourself in "
				+ "response to that sharp sting. You feel yourself falling into a deep slumber as "
				+ "you put the blanket over yourself.\n\nYou gained 50 HP for resting.");
		Player.playerHP += 50;
		Player.hpStatus.setText("" + Player.playerHP); //Gain 5 hp
		choice1.setText("Head out in the morning");
		choice2.setText("");
		choice3.setText("");
	}
	
	// Moving onwards -------------------------------------
	public static void continueNorth() {
		// From lostInSnow
		// From findShelter
		currentPosition = "North";
		image = new ImageIcon(Images.tempSnow2);
		imageLabel.setIcon(image);
		Player.playerHP = Player.playerHP - 30;
		Player.hpStatus.setText("" + Player.playerHP); //take 3 damage from cold
		gameTextArea.setText("You continue off to the north in hopes of finding Ishgard. You take "
				+ "3 damage from the bitter cold winds stinging you across your face and open "
				+ "parts of your armor.\nYou look into the distance and see a large gate like "
				+ "structure. Without much of a choice, you trudge towards that mysterious building.");
		choice1.setText("Continue forward");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void townGate() {
		currentPosition = "Gate";
		image = new ImageIcon(Images.tempGateway);
		imageLabel.setIcon(image);
		gameTextArea.setText("The snow stops and you find yourself in front of a large gate "
				+ "entrance. Behind you, it looks like snow is beginning to pick back up. Given "
				+ "no other option, you're left with entering the city-state.");
		choice1.setText("Enter city");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	// In the town -----------------------------------------
	public static void inCity() {
		currentPosition = "City";
		image = new ImageIcon(Images.tempTown);
		imageLabel.setIcon(image);
		gameTextArea.setText("You enter the city and find yourself in the middle of a run down and "
				+ "near empty city. You need to gather more information on the suspect you've been "
				+ "following and decide to ask around if there's been any signs of a person with a "
				+ "black flame tattoo near the right part of their face.\n\nWhere would you like "
				+ "to go?");
		choice1.setText("City Square");
		choice2.setText("Training Grounds");
		choice3.setText("Alley Way");
		if(ascianInfo) {
			choice4.setText("Rest at an inn");
		}else {
			choice4.setText("");
		}
	}
	
	public static void restInn() {
		currentPosition = "Inn";
		image = new ImageIcon(Images.tempInn);
		imageLabel.setIcon(image);
		gameTextArea.setText("You feel relieved that you finally found information of the person "
				+ "you're looking for. You find an inn to rest for the night before you head out "
				+ "in the morning.\n Rested for max HP");
		Player.playerHP = 100;
		Player.hpStatus.setText("" + Player.playerHP);
		choice1.setText("Head out in morning"); //exit
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void citySquare() {
		currentPosition = "CitySquare";
		image = new ImageIcon(Images.tempCitySquare);
		imageLabel.setIcon(image);
		gameTextArea.setText("You walk to the city square and ask the people around the broken "
				+ "fountain. As all hope seemed lost, the last person happened to give you good "
				+ "information about the person you're looking for. He's the leader of a group "
				+ "called the Ascians, and they're located in a cave outside of Ishgard.");
		ascianInfo = true; //Gained info
		choice1.setText("Go back");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void trainingGrounds() {
		//find yourself a pair of fist weapons
		currentPosition = "Training";
		image = new ImageIcon(Images.tempKnuckles);
		imageLabel.setIcon(image);
		gameTextArea.setText("You head towards a group of people training to get information. A "
				+ "fighter called Alexis comes and spares with you while exchanging words. "
				+ "She finds potential in you and decides to give you a pair of metal knuckles.");
		Player.fistWeapon = true; //Gained fists
		Player.weaponName = "Metal Knuckles";
		Player.weaponStatus.setText(Player.weaponName); //Equip the Fists
		choice1.setText("Go back");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void alleyWay() {
		//find the dagger
		currentPosition = "Alley";
		image = new ImageIcon(Images.tempDaggers);
		imageLabel.setIcon(image);
		gameTextArea.setText("You believe you would find some information from the people hanging "
				+ "out in an alleyway, but they just shrug you off. You see something shiny on the "
				+ "top of a trash can.\n\nYou got a dagger!");
		Player.daggerWeapon = true;
		Player.weaponName = "Dagger";
		Player.weaponStatus.setText(Player.weaponName); //Equip the Dagger
		choice1.setText("Go back");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	// Go outside of city -----------------------------
	public static void exit() {
		//decide which weapon to take
		currentPosition = "Exit";
		image = new ImageIcon(Images.tempInn);
		imageLabel.setIcon(image);
		gameTextArea.setText("Before you head outside and search for the cave, you stop at the "
				+ "exit and decide on which weapon you want to bring.\n\nThey have default attack "
				+ "values\nWhich weapon are you bringing?");
		if(Player.longSwordWeapon) {
			choice1.setText("Long Sword"); //if you found long sword
		}else {
			choice1.setText("");
		}
		if(Player.fistWeapon) {
			choice2.setText("Metal Knuckles"); //if you found fists
		}else {
			choice2.setText("");
		}
		if(Player.daggerWeapon) {
			choice3.setText("Dagger"); //if you found dagger
		}else {
			choice3.setText("");
		}
		choice4.setText("Explore outside"); //head out
	}
	
	// In the cave ------------------------------------
	public static void exploreOutside() {
		//looking for cave
		currentPosition = "Outside";
		image = new ImageIcon(Images.tempCave);
		imageLabel.setIcon(image);
		gameTextArea.setText("You find yourself outside of the cave that matched the description of "
				+ "what the people told you. Without doubt, you venture into the cave and find "
				+ "yourself already lost at a forked road. You see a path with lit torches, one "
				+ "that had voices, and another where a shady figure vanished quickly.\nWhich path "
				+ "do you follow?");
		choice1.setText("Shadowy Figure"); //movement()
		if(chestOpened) {
			choice2.setText(""); //already got dagger
		}else {
			choice2.setText("Lit Torches"); //torches()
		}
		choice3.setText("Voices"); //voices()
		choice4.setText("");
	}
	
	public static void movement() {
		//You follow the mysterious figure
		currentPosition = "ShadowArea";
		image = new ImageIcon(Images.tempCorridor);
		imageLabel.setIcon(image);
		gameTextArea.setText("You started chasing the shadow down the corridor it escaped in. You "
				+ "get to a corner and you hear it's footsteps loud and clear.");
		choice1.setText("Next");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void wildBeast() {
		currentPosition = "WildBeast";
		image = new ImageIcon(Images.tempBeast);
		imageLabel.setIcon(image);
		gameTextArea.setText("You arrive in a lit room and you find yourself in front of a wild "
				+ "beast! The creature growls at you and looks like it's about to attack you."
				+ " You have no choice but to fight it!");
		Enemy.enemyHP = 30;
		choice1.setText("Attack"); //attack enemy
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void torches() {
		//You follow the lit path
		currentPosition = "TorchPath";
		image = new ImageIcon(Images.tempCorridor);
		imageLabel.setIcon(image);
		gameTextArea.setText("You Follow the well lit path with multiple torches along the walls."
				+ " You keep walking down the long corridor which seemed to go on forever.");
		choice1.setText("Proceed"); //chest
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void chest() {
		//You find a chest at the end of the pathway
		currentPosition = "ChestArea";
		image = new ImageIcon(Images.tempChest);
		imageLabel.setIcon(image);
		gameTextArea.setText("You reach the end of the pathway and you find a big chest. \n\nWhat do you do?");
		choice1.setText("Open chest"); //you find a poison dagger
		choice2.setText("Go back"); //go back to the fork path
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void openChest() {
		//You chose to open the chest
		currentPosition = "OpenChestArea";
		image = new ImageIcon(Images.tempChestOpened);
		imageLabel.setIcon(image);
		gameTextArea.setText("You open the chest cautiously, and find yourself a dagger that seems "
				+ "to be dipped in poison.");
		chestOpened = true;
		choice1.setText("Go back"); //go back to the fork, exploreOutside()
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void voices() {
		//Following the voices
		currentPosition = "Voices";
		image = new ImageIcon(Images.tempCorridor);
		imageLabel.setIcon(image);
		gameTextArea.setText("You follow the path that you heard voices come from. You keep "
				+ "walking a rather long dim lit corridor. As you walk deeper in, the voices "
				+ "you hear get louder.");
		choice1.setText("Proceed"); //proceed to two enemies
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void twoEnemies() {
		//You find two enemies
		currentPosition = "TwoEnemies";
		image = new ImageIcon(Images.tempGuards);
		imageLabel.setIcon(image);
		gameTextArea.setText("At the end of the corrider, you stop at the entrance to the lit room."
				+ " You hear two people in robes with hoods over their head talking to each other."
				+ " You don't want them to warn others so you have to get rid of them as fast as "
				+ "possible.");
		choice1.setText("Attack"); //attack both
		choice2.setText("Sneak by"); //sneak by % chance
		if(chestOpened) {
			choice3.setText("Sneak Attack"); //if you have dagger
		}else {
			choice3.setText("");
		}
		choice4.setText("");
	}
	
	public static void attackEnemies() {
		//You attack the enemies
		currentPosition = "Attacking";
		gameTextArea.setText("You're engaging the enemy.\nEnemy HP:" + Enemy.enemyHP +"\n\nWhat "
				+ "are you going to do.");
		choice1.setText("Attack"); //attack the enemy
		if(Enemy.boss) {
			choice2.setText("");
		}else {
			choice2.setText("Run"); //try to sneak away
		}
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void sneakByFailed() {
		//failed escape
		currentPosition = "EscapeFailed";
		gameTextArea.setText("You failed to escape and the enemies found you!");
		choice1.setText("Attack"); //attackenemies
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void sneakBySuccess() {
		//escape succeeded
		currentPosition = "EscapeSuccess";
		image = new ImageIcon(Images.tempCorridor);
		imageLabel.setIcon(image);
		gameTextArea.setText("You managed to get away safely!");
		choice1.setText("Continue onwards");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void sneakAttack() {
		//tries to sneak attack
		currentPosition = "SneakAttack";
		gameTextArea.setText("You attempt to sneak attack one of the guards with the poison dagger"
				+ " you just found.");
		choice1.setText("Proceed");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void sneakAttackFailed() {
		//failed sneak attack
		currentPosition = "FailedSneakAttack";
		image = new ImageIcon(Images.tempGuards);
		imageLabel.setIcon(image);
		gameTextArea.setText("You tried to sneak up on one of them, but you accidently kicked a "
				+ "rock and it made sound. They both turn around and find you, get ready for a "
				+ "battle.");
		choice1.setText("Attack"); //attack enemies
		choice2.setText("Run"); //sneak by
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void sneakAttackSuccess() {
		//escape succeeded
		currentPosition = "SneakAttackSuccess";
		image = new ImageIcon(Images.tempOneGuard);
		imageLabel.setIcon(image);
		gameTextArea.setText("You manage to get one of them by surprise and stabbed one of them "
				+ "with the poison dagger! You're left with one enemy left, get ready to engage");
		Enemy.enemyHP = 20; //one enemy left, half the hp
		choice1.setText("Attack"); //half the enemy HP
		choice2.setText("Run"); //sneakby
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void playerAttack() { //the player attacks
		currentPosition = "PlayerAttack";
		//damage calculations
		if(Player.weaponName == "Dagger" || Player.weaponName == "Long Sword" || Player.weaponName == "Metal Knuckles") {
			Player.playerDamage = new java.util.Random().nextInt(10); //random dmg from 1-10 
		}else {
			Player.playerDamage = new java.util.Random().nextInt(5); //random dmg from 1-5
		}
		Enemy.enemyHP -= Player.playerDamage;
		gameTextArea.setText("You attacked the enemy and dealt " + Player.playerDamage + " damage!\n\nEnemy HP: " + Enemy.enemyHP);
		choice1.setText(">"); //enemy attack
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void enemyAttack() { //enemy attacks
		currentPosition = "EnemyAttack";
		//dmg calculations
		Enemy.enemyDamage = new java.util.Random().nextInt(6); //random dmg from 1-6
		Player.playerHP -= Enemy.enemyDamage;
		Player.hpStatus.setText("" + Player.playerHP);
		gameTextArea.setText("The enemy attacked you for " + Enemy.enemyDamage + " damage!");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void win() { //when you beat the enemy
		currentPosition = "EnemyDefeated";
		gameTextArea.setText("You managed to defeat the enemy!");
		choice1.setText("Next");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	//Towards boss ------------------------------------------
	public static void finalTunnel() {
		// the tunnel before boss
		currentPosition = "FinalTunnel";
		image = new ImageIcon(Images.tempCorridor);
		imageLabel.setIcon(image);
		gameTextArea.setText("You're now in a corridor that linked up with the past paths you "
				+ "could had taken. There's only one pathway to move.");
		choice1.setText("Onwards"); //bossRoom
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void bossRoom() {
		// player is in boss room
		currentPosition = "BossRoom";
		image = new ImageIcon(Images.tempBoss);
		imageLabel.setIcon(image);
		gameTextArea.setText("You reach the end of the tunnel and you're now in an even bigger "
				+ "room. You see the person in the hood at the end of the room get into a battle "
				+ "stance.You've finally found the person you're looking for, there's no turning "
				+ "back now.");
		Enemy.enemyHP = 50; //boss HP
		Enemy.boss = true;
		choice1.setText("Attack"); //attackEnemies
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void bossDefeated() {
		currentPosition = "BossDefeated";
		gameTextArea.setText("You managed to defeat the culprit you've been after this entire "
				+ "time. You have him tied up and are prepared to bring him back to your "
				+ "city-state for him to confess his crimes and to clear your friends names.");
		choice1.setText("Game Over");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	// End of game
	public static void credits() {
		currentPosition = "Credits";
		imagePanel.setVisible(false);
		gameTextArea.setText("Thank you for playing!\n\nGame made by Michael Lam\nImages were "
				+ "taken from FFXIV ingame");
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public static void gameOver() {
		currentPosition = "GameOver";
		imagePanel.setVisible(false);
		gameTextArea.setText("You've died.\n\n\nGame Over!");
		choice1.setText("Title");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	// Handler ------------------------------------------------
	public static class ChoiceHandler implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			String playerChoice = ae.getActionCommand();
			
			switch(currentPosition) {
			case "Prologue1": //for Prologue 1
				switch(playerChoice) {
				case "C1": nextPrologue(); break; //shows the next set of prologue text
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "Prologue2": // for Prologue 2
				switch(playerChoice) {
				case "C1": lostInSnow(); break;
				case "C2": prevPrologue(); break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "Snow": // lost in the snow
				switch(playerChoice) {
				case "C1": continueNorth(); break;
				case "C2": findShelter(); break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "Searching": // Looking for a place to stay
				switch(playerChoice) {
				case "C1": stayShelter(); break;//stay
				case "C2": continueNorth(); break;//continue north
				case "C3": break;
				case "C4": break;
				} break;
				
			case "Staying": //Decided to stay in the cabin
				switch(playerChoice) {
				case "C1": searchShelter(); break; //find sword
				case "C2": restShelter(); break; //gain hp
				case "C3": continueNorth(); break; //go north
				case "C4": break;
				} break;
				
			case "ShelterSearching": //Search the shelter and find sword
				switch(playerChoice) {
				case "C1": restShelter(); break; //gain hp
				case "C2": continueNorth(); break; //go north
				case "C3": break;
				case "C4": break;
				} break;
				
			case "Resting":
				switch(playerChoice) {
				case "C1": continueNorth(); break; //go north
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "North": // player finds the shadow of main entrance
				switch(playerChoice) {
				case "C1": townGate(); break; // go into town
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "Gate": // Player is at main entrance
				switch(playerChoice) {
				case "C1": inCity(); break;
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "City": //while in the town
				switch(playerChoice) {
				case "C1": citySquare(); break;
				case "C2": trainingGrounds(); break;
				case "C3": alleyWay(); break;
				case "C4": if(ascianInfo) {
					restInn(); break;
					}else {
						break;
					}
				} break;
				
			case "Training": //finding the fist weapons in training ground
				switch(playerChoice) {
				case "C1": inCity(); break;
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "Alley": // finding the dagger in the alley
				switch(playerChoice) {
				case "C1": inCity(); break;
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "CitySquare": //in the city square
				switch(playerChoice) {
				case "C1": inCity(); break;
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "Inn": //resting in the inn
				switch(playerChoice) {
				case "C1": exit(); break;
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "Exit": //Picking the weapon
				switch(playerChoice) {
				case "C1": if(Player.longSwordWeapon) {
					Player.weaponName = "Long Sword";
					Player.weaponStatus.setText(Player.weaponName); //Equip the Long Sword
					exploreOutside();
					break;
				}else {
					break;
				}
				case "C2": if(Player.fistWeapon) {
					Player.weaponName = "Metal Knuckles";
					Player.weaponStatus.setText(Player.weaponName); //Equip the Fists
					exploreOutside();
					break;
				}else {
					break;
				}
				case "C3": if(Player.daggerWeapon) {
					Player.weaponName = "Dagger";
					Player.weaponStatus.setText(Player.weaponName); //Equip the Long Sword
					exploreOutside();
					break;
				}else {
					break;
				}
				case "C4": exploreOutside(); break;
				} break;
				
			case "Outside": //Looking for the cave
				switch(playerChoice) {
				case "C1": movement(); break;
				case "C2": if(chestOpened) {
					break;
				}else {
					torches(); break;
				}
				case "C3": voices(); break;
				case "C4": break;
				} break;
				
			case "ShadowArea": //you follow the shadow
				switch(playerChoice) {
				case "C1": wildBeast(); break;
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "WildBeast": //you're in front of the wild beast
				switch(playerChoice) {
				case "C1": attackEnemies(); break;
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "TorchPath": //While in the torch path
				switch(playerChoice) {
				case "C1": chest(); break;
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "ChestArea": //while you found the chest
				switch(playerChoice) {
				case "C1": openChest(); break;
				case "C2": exploreOutside(); break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "OpenChestArea": //You open the chest
				switch(playerChoice) {
				case "C1": exploreOutside(); break;
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "Voices": //follow the voices in corridor
				switch(playerChoice) {
				case "C1": twoEnemies(); break;
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "TwoEnemies": //When you see the enemies
				switch(playerChoice) {
				case "C1": attackEnemies(); break;
				case "C2": chance = (int)(Math.random() * 2) + 1; //50% chance to escape
				if(chance == 1) {
					sneakByFailed(); break;
				}else {
					sneakBySuccess(); break;
				}
				case "C3": if(chestOpened) {
					sneakAttack(); break;
				}else {
					break;
				}
				case "C4": break;
				} break;
				
			case "SneakAttack": //Player chose to sneak attack
				switch(playerChoice) {
				case "C1": chance = (int)(Math.random() * 3) + 1; //33% chance to fail
				if(chance == 1) {
					sneakAttackFailed(); break;
				}else {
					sneakAttackSuccess(); break;
				}
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "FailedSneakAttack": //When the attack fails two enemies still alive
				switch(playerChoice) {
				case "C1": attackEnemies(); break;
				case "C2": chance = (int)(Math.random() * 4) + 1; //25% chance to escape
				if(chance == 1) {
					sneakBySuccess(); break;
				}else {
					sneakByFailed(); break;
				}
				case "C3": break;
				case "C4": break;
				} break;
				
			case "SneakAttackSuccess": //When you succeed in ambushing
				switch(playerChoice) {
				case "C1": attackEnemies(); break;
				case "C2": chance = (int)(Math.random() * 4) + 1; //25% chance to escape
				if(chance == 1) {
					sneakBySuccess(); break;
				}else {
					sneakByFailed(); break;
				}
				case "C3": break;
				case "C4": break;
				} break;
				
			case "EscapeFailed": //when you fail to escape
				switch(playerChoice) {
				case "C1": attackEnemies(); break;
				case "C2": chance = (int)(Math.random() * 4) + 1; //25% chance to escape
				if(chance == 1) {
					sneakBySuccess(); break;
				}else {
					sneakByFailed(); break;
				}
				case "C3": break;
				case "C4": break;
				} break;
				
			case "Attacking": //battle sequence
				switch(playerChoice) {
				case "C1": playerAttack(); break;
				case "C2": if(!Enemy.boss) {
					chance = (int)(Math.random() * 4) + 1; //25% chance to escape
					if(chance == 1) {
						sneakBySuccess(); break;
					}else {
						sneakByFailed(); break;
					}
				}else {
					break;
					}
				case "C3": break;
				case "C4": break;
				} break;
				
			case "PlayerAttack": //player's attack
				switch(playerChoice) {
				case "C1": if(Enemy.enemyHP <1) {
					if(Enemy.boss) {
						bossDefeated(); break; //defeat boss
					}else {
						win(); break; //defeated guards/beast
					}
				}else{
					enemyAttack(); break; //goes to the enemy's turn
				}
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "EnemyAttack": //enemy's turn
				switch(playerChoice) {
				case "C1": if(Player.playerHP < 1) {
					gameOver(); break;
				}else {
					attackEnemies(); break; //goes to the enemy's turn
				}
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "EscapeSuccess":
				switch(playerChoice) {
				case "C1": finalTunnel(); break; //proceed
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "EnemyDefeated": //when you beat the enmy
				switch(playerChoice) {
				case "C1": finalTunnel(); break;
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "FinalTunnel": //at the tunnel beforeboss
				switch(playerChoice) {
				case "C1": bossRoom(); break; //onwards to the final boss
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "BossRoom": //at boss room
				switch(playerChoice) {
				case "C1": attackEnemies(); break;
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "BossDefeated": //player defeats boss
				switch(playerChoice) {
				case "C1": credits(); break;
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "Credits": //when you die
				switch(playerChoice) {
				case "C1": break;
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
				
			case "GameOver": //when you die
				switch(playerChoice) {
				case "C1": break;
				case "C2": break;
				case "C3": break;
				case "C4": break;
				} break;
			} //end of handler
			
		}
		
	}

}