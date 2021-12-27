package heroClasses;

public class Item {
	public String name;
	public double damageMod;
	double scale;
	boolean heals;
	public int amount;
	
	public Item (String name, double damageM, double scale){
		this.name = name;
		this.damageMod = damageM;
		this.scale = scale;
	}
	public Item (String name, double damageM, double scale, boolean heal, int amount){
		this.name = name;
		this.damageMod = damageM;
		this.scale = scale;
		this.heals = heal;
		this.amount = amount;
	
	}
	public String getName(){
		return name;
	}
}
