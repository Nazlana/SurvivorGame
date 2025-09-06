package adventureGame;

import java.util.Scanner;

public class Player {
private int damage, health,money, rHealth ;
private String name,charName;
Inventory inv;

Scanner scan= new Scanner(System.in);

public Player(String name) {
	super();
	this.name = name;
	this.inv= new Inventory();
	}
public void selectChar() {
	switch (charMenu()) {
	case 1: 
		initPlayer("Samurai", 5, 21, 15);
		
		break;
	case 2: 
		initPlayer("Archer", 7, 18, 20);
		//OR
		//setCharName("Archer");
		//setDamage(7);
		//setHealth(18);
		//setMoney(20);
		break;
	case 3: 
		initPlayer("Knight", 8, 24, 5);
		
		break;
		default:
			initPlayer("Samurai", 5, 21, 15);
	}
	System.out.println("Character is generated.");
	System.out.println("Character: "+getCharName()+"\tDamage:"+getDamage()+"\tHealth:"+getHealth()+"\tMoney:"+getMoney());
	
}
public int charMenu() {
	System.out.println("Please, select a character: ");
	System.out.println("1- Samurai,\t  Damage:5  Health:21  Money:15");
	System.out.println("2- Archer,\t  Damage:7  Health:18  Money:20");
	System.out.println("3- Knight,\t  Damage:8  Health:24  Money:5");
	System.out.print("Your select:");
	int charID= scan.nextInt();
	while(charID<1 || charID>3) { // geçerli ıd girilene kadar loop döner 
		System.out.print("Invalid character. Try Again!!");
		charID=scan.nextInt();	
		}
	return charID;
}

public void initPlayer(String charName, int dmg, int hlt, int mny ) {
	setCharName(charName);
	setDamage(dmg);
	setHealth(hlt);
	setMoney(mny);
    setrHealth(hlt);
    setInv(new Inventory());

}

public int getTotalDamage() {
	return (this.getDamage() + this.getInv().getDamage());
}
public int getDamage() {
	return damage;
}

public void setDamage(int damage) {
	this.damage = damage;
}

public int getHealth() {
	return health;
}

public void setHealth(int health) {
	this.health = health;
}

public int getMoney() {
	return money;
}

public void setMoney(int money) {
	this.money = money;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCharName() {
	return charName;
}

public void setCharName(String charName) {
	this.charName = charName;
}

public Inventory getInv() {
	return inv;
}

public void setInv(Inventory inv) {
	this.inv = inv;
}
public int getrHealth() {
	return rHealth;
}
public void setrHealth(int rHealth) {
	this.rHealth = rHealth;
}


}
