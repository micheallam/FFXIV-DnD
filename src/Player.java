import javax.swing.*;


public class Player {
	static JPanel playerStatPanel;
	static JLabel hpText, hpStatus, weaponText, weaponStatus;
	static int playerHP;
	static int playerDamage = 0;
	static String weaponName;
	static boolean fistWeapon = false;
	static boolean longSwordWeapon = false;
	static boolean daggerWeapon = false;
	static boolean poisonDaggerWeapon = false;
	
	public static void playerStatus() {
		// Creates the initial player status when game begins
		playerHP = 40;
		weaponName = "";
		weaponStatus.setText(weaponName);
		hpStatus.setText("" + playerHP); //turning the player hp int into a string
		longSwordWeapon = false;
		fistWeapon = false;
		daggerWeapon = false;
		poisonDaggerWeapon = false;
	}

}
