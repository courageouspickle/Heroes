package heroClasses;

public class Knight extends Hero{

	public Knight(String tempN, int tempS) {
		this.name = tempN;
		this.strength = tempS;
	}
	public void damage(int amount){
		this.hp -= amount*2/3;
		System.out.println("Your knightly armor protects you a bit, but you take " + amount * 2/3 + " damage.");
		if (this.hp <= 0){
			System.out.println("You have died!\nGame Over");
			System.exit(0);
		}
	}
	public int attack(){
		return (int)((Math.random() + 0.5) * (this.weapon.damageMod + this.weapon.scale * Math.pow(this.strength, .9)));
	}

}
