package heroClasses;
import heroClasses.Item;
public class Enemy {
	public String name;
	public String attack;
	public int hp;
	public int xp;
	public double CR;
	public Enemy(String newName, String newAttack, double newCR){
		this.name = newName;
		this.attack = newAttack;
		this.CR = newCR;
		this.xp = (int) (CR * 20 * (.75 + Math.random()));
		this.hp = (int) (Math.sqrt(CR) * 50); 
		
		
	}
	public void damage(int amount){
		this.hp -= amount;
	}
	public int attackPlayer(){
		return (int)(Math.pow(CR, .5) * 50 * (Math.random() + .5));
	}
	public Item drop(){
		Item Nothing = new Item("nothing", 0, 2.0);
		Item OldSword = new Item ("Old sword", 15, 1.0);
		Item SharpKnife = new Item("Sharpened Knife", 30, 0.0);
		Item Bread = new Item("Piece of bread", .5, 0, true, 20);
		Item Potion = new Item("Healing Potion", .25, .1, true, 100);
		Item SteelSword = new Item("Steel Sword", 50, 1.5);
		Item WoodenClub = new Item("Wooden Club", 10, 2.0);
		Item SteelMace = new Item("Steel Mace", 10, 5.0);
		Item Greatsword = new Item("Greatsword", 100, 2.0);
		Item Greataxe = new Item("Greataxe", 20, 7.5);
		
		
		double index = CR * Math.random() * 5;
		if (index < 1){
			return Nothing;
		}else if (index < 2){
			return Bread;
		}else if (index < 2.5){
			return SharpKnife;
		}else if (index < 3){
			return OldSword;
		}else if (index < 4){
			return Potion;
		}else if (index < 5){
			return WoodenClub;
		}else if (index < 6){
			return SteelSword;
		}else if (index < 8){
			return SteelSword;
		}else if (index < 10){
			return SteelMace;
		}else if (index < 12){
			return Greatsword;
		}else if (index < 15){
			return Greataxe;
		}
			
		return Nothing;
		
	}

}
