package adventureGame;

import java.util.Scanner;

public abstract class NormalLoc extends Location {
   Scanner scan=new Scanner(System.in);
	public NormalLoc(Player player, String name) {
		super(player);
		this.name=name;
	}
	
	
}
