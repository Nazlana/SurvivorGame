package adventureGame;


public class ToolStore extends NormalLoc {
public ToolStore(Player player) {
	// TODO Auto-generated constructor stub
   super(player,"Store");

}
public boolean getLocation() {
	System.out.println("Money: "+player.getMoney());
	System.out.println("1-Guns");
	System.out.println("2-Armours");
	System.out.println("3-Exit");
	System.out.print("Your Select:  ");
	int selTool=scan.nextInt();
	int selItemID;
	switch (selTool){
	case 1: 
		selItemID= gunMenu();
		buyGun(selItemID);
		break;
	case 2: 
		selItemID=armourMenu();
		buyArmour(selItemID);
		break; 
		
	default:
		break;
		
	}
	return true; 
  }

public int gunMenu() {
	System.out.println("1- Pistol,\tMoney:25 - Damage:2 ");
	System.out.println("2- Sword,\tMoney:35 - Damage:3 ");
	System.out.println("3- Rifle,\tMoney:45 - Damage:7 ");
	System.out.println("4-Exit");
	System.out.print("Select Weapon: ");
	int selWeaponID=scan.nextInt();
     return selWeaponID;
}

public void buyGun(int itemID) {
	int damage=0, price=0 ;
	String gunName=null;
	switch (itemID){
	case 1: 
		damage=2;
		gunName="Pistol";
		price=25;
		break;
	case 2: 
		damage=3;
		gunName="Sword";
		price=35;
		break;
	case 3:
		damage=7;
		gunName="Rifle";
		price=45;
		break;
	case 4: 
		System.out.println("Exit!");
		break;
	default:
		System.out.println("Invalid operation.");
		break;
	}
	if(price>0) {
	  if(player.getMoney()>=price) {
	player.getInv().setDamage(damage);
	player.getInv().setGunName(gunName);
	player.setMoney(player.getMoney()-price);
	System.out.println("Weapon purchase was reliased.");
	System.out.println("Previous damage:"+player.getDamage()+ "New damage:"+ player.getTotalDamage());
    System.out.println("Remaining balance:" +player.getMoney());
    }else {
	System.out.println("Insufficient Balance!!");
}
	}
	}

public int armourMenu() {
	System.out.println("1- Light,\tBlocking=1  Money=15");
	System.out.println("2- Medium,\tBlocking=3  Money=25");
	System.out.println("3- Heavy,\tBlocking=5  Money=40");
	System.out.println("4-Exit!");
	System.out.print("Select armour:");
	int selArmourID=scan.nextInt();
	return selArmourID;
}

public void buyArmour(int ItemID) {
	int avoid=0, price=0;
	String armourName=null;
	switch (ItemID) {
	case 1: 
		avoid=1;
		armourName="Light";
		price=15;
		break;
	case 2: 
		avoid=3;
		armourName="Medium";
		price=25;
		break;
	case 3: 
		avoid=5;
		armourName="Heavy";
		price=40;
		break;
	case 4: 
		System.out.println("Exit!!");
		break;
	}
	if(price>0) {
		if(player.getMoney()>=price) {
			player.getInv().setArmour(avoid);
			player.getInv().setArmourName(armourName);
			player.setMoney(player.getMoney()-price);
			System.out.println("Avoid damage:"+player.getInv().getArmour());
			System.out.println("Remaining balance: "+player.getMoney());
		    }else {
			System.out.println("Insufficient Balance!!");
		}
			}
		
	
	}
}

