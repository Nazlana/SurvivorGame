package adventureGame;

public abstract class BattleLoc extends Location{
	protected Obstacle obstacle;
	protected String award="";
	public BattleLoc(Player player, String name, Obstacle obstacle, String award ) {
		super(player);
		this.name=name;
		this.obstacle=obstacle; 
		this.award=award;
	}
	public boolean getLocation() {
		int obsCount= obstacle.obstacleCount();
		System.out.println("You are currently in the "+this.getName());
		System.out.println("Be careful!!  There are "+obsCount+" "+ obstacle.getName() +" here.");
		System.out.println("<W>ar or <E>scape");
		String selCase = scan.nextLine();
		selCase=selCase.toUpperCase();
		if (selCase.equals("W")) {
			if(combat(obsCount)) { // if true 
				System.out.println("You have cleared all the enemies in the "+ this.getName());
				if("Food".equals(this.award) && player.getInv().isFood()==false) {
					System.out.println("You earned "+ this.award);
					player.getInv().setFood(true);
				}else if("Water".equals(this.award) && player.getInv().isWater()==false) {
					System.out.println("You earned "+ this.award);
					player.getInv().setWater(true);
				}else if("Firewood".equals(this.award) && player.getInv().isFirewood()==false) {
					System.out.println("You earned "+ this.award);
					player.getInv().setFirewood(true);
				}
				return true;
			} 
			
			if(player.getHealth()<=0) {
					System.out.println("You died!!");
					return false;
			}
		}
		return true;
	}
	public void afterHit() {
		System.out.println("Player life: "+player.getHealth());
		System.out.println(obstacle.getName()+" life: "+obstacle.getHealth());
        System.out.println("-----------------");	
	}
	public boolean combat(int obsCount) {
		for(int i=0; i<obsCount;i++) {
			int defObsHealth= obstacle.getHealth();
			playerStats();
			enemyStats();
			while(player.getHealth()>0 && obstacle.getHealth()>0) {
				System.out.println("<H>it or <R>un");
				String hit= scan.nextLine();
				hit=hit.toUpperCase();
				if(hit.equals("H")) {
					System.out.println("You hit!");
					obstacle.setHealth(obstacle.getHealth()-player.getTotalDamage());
					afterHit();
					if(obstacle.getHealth()> 0 ) {
						System.out.println();
						System.out.println(obstacle.getName()+" hit you!");
						player.setHealth(player.getHealth()-(obstacle.getDamage()-player.getInv().getArmour())); //**
					    afterHit();	
					}
					
				}
				else {
					return false;
				}
			}
			if(obstacle.getHealth() < player.getHealth()) {
				System.out.println(obstacle.getName() + " died! YOU WIN!");
				player.setMoney(player.getMoney()+obstacle.getAward());
				System.out.println("Your current balance: "+player.getMoney());
				obstacle.setHealth(defObsHealth);
				
			}else {
				return false; // if you died
			}
			System.out.println("-----------------");
		}
		
		return true;
	}
	
	public void playerStats() {
		System.out.println("Player Stats\n-------------- ");
		System.out.println("Life: " + player.getHealth());
		System.out.println("Damage: "+ player.getTotalDamage());
		System.out.println("Money: "+player.getMoney());
		if (player.getInv().getDamage()>0) {
			System.out.println("Weapon: "+player.getInv().getGunName());
		}
		if (player.getInv().getArmour()>0) {
			System.out.println("Armour: "+player.getInv().getArmourName());
		}	
	}
	
	public void enemyStats() {
		System.out.println("\n"+obstacle.getName()+" Stats\n-------------");
		System.out.println("Life: " + obstacle.getHealth());
		System.out.println("Damage: "+ obstacle.getDamage());
		System.out.println("Money: "+obstacle.getAward());
	}

}
