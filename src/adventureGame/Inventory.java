package adventureGame;

public class Inventory {
	private boolean water,food,firewood;
	private String gunName, armourName;
	private int damage, armour;
	
	public Inventory() {
		// TODO Auto-generated constructor stub
	this.water=false;
	this.food=false;
	this.firewood=false;
	this.damage=0;
	this.armour=0;
	this.armourName=null;
	this.gunName=null;
	}

	public boolean isWater() {
		return water;
	}

	public void setWater(boolean water) {
		this.water = water;
	}

	public boolean isFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public boolean isFirewood() {
		return firewood;
	}

	public void setFirewood(boolean firewood) {
		this.firewood = firewood;
	}

	public String getGunName() {
		return gunName;
	}

	public void setGunName(String gunName) {
		this.gunName = gunName;
	}

	public String getArmourName() {
		return armourName;
	}

	public void setArmourName(String armourName) {
		this.armourName = armourName;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getArmour() {
		return armour;
	}

	public void setArmour(int armour) {
		this.armour = armour;
	}

	
}
