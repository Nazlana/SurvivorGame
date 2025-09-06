package adventureGame;

import java.util.Scanner;


public class Game {
Player player;
Location location;
Scanner scan=new Scanner(System.in);
public void login() {
	System.out.println("Welcome to Adventure Game!");
	System.out.print("Please, Enter your name:");
	String playerName=scan.nextLine(); 
	player= new Player(playerName);
	player.selectChar();
	start();
	
}
public void start() {
	while(true) {
	System.out.println();
	System.out.println("-------------------");
	System.out.println();
	System.out.println("Select a location: ");
	System.out.println("1-Safe House: A safe place that belongs to you, no enemies. ");
    System.out.println("2-Cave: You may encounter zombies.");
    System.out.println("3-Forest: You may encounter vampires.");
    System.out.println("4-River: You may encounter bears.");
    System.out.println("5-Store: You can get guns or armour.");
    System.out.print("Your select: ");
    int selLoc= scan.nextInt();
    
    while(selLoc<0 || selLoc>5) {
    	System.out.println("Incalid Location. Try Again!");
    	selLoc=scan.nextInt();
    	}
    switch (selLoc) {
	case 1: 
		location= new SafeHouse(player);
		break;
	case 2: 
		location=new Cave(player);
		break;
	case 3: 
		location= new Forest(player);
		break;
	case 4:
		location= new River(player);
		break;
	case 5:
		location= new ToolStore(player);
		break;
		
	default:
		location= new SafeHouse(player);
		}
    if (location.getClass().getName().equals("Safe House")) {
		if(player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()  ) {
			System.out.println("You WİN!");
			break;
		}
	}
    
    if(!location.getLocation()) {
    	System.out.println("The Game is Over!");
    	break;
    }
    }
  }
}
