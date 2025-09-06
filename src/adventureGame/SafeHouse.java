package adventureGame;


public class SafeHouse extends NormalLoc {
	public SafeHouse(Player player) {
		// TODO Auto-generated constructor stub
		super(player, "Safe House");
	}
	public boolean getLocation() {
		player.setHealth(player.getrHealth());
		System.out.println("You have recovered");
		System.out.println("You are in a safe house right now.");
		System.out.println("Money: " + player.getMoney());
		return true;
	}
 
}
