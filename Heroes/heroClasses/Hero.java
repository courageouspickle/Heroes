package heroClasses;
import java.util.Scanner;

import heroClasses.Item;

public class Hero {
	public String name;
	public int maxHp = 100;
	public int hp = 100;
	public int xp = 0;
	public Item weapon;
	public int level = 1;
	public int maxStamina = 100;
	public int stamina = 100;
	public int strength = 10;
	
	public void useStamina(int amount){
		this.stamina -= amount;
		int counter = 3;
		if (this.stamina < 30){
			counter++;
			if (counter >= 3){
				System.out.println("You feel utterly exhausted. You need to rest soon.");
				counter = 0;
			}
		}
		if (this.stamina == 5){
			System.out.println("You are on the brink of death by exhaustion...");
		}
		if (this.stamina <= 0){
			System.out.println("You died of exhaustion");
			System.exit(0);
		}
	}
	public void gainStamina(int amount){
		if (this.stamina + amount > maxStamina)
			this.stamina = maxStamina;
		else this.stamina += amount;
	}
	public int getStamina(){
		return this.stamina;
	}
	public int getStrength(){
		return this.strength;
	}
	public void addXp(int amount) {
		this.xp += amount;
		while (this.xp > 100 * level){
			level++;
			System.out.println("You gained a level!\n You are now level " + level + ".");
			System.out.println("What would you like to increase?\n1. Health\n2. Strength\n3. Stamina");
			Scanner userInput = new Scanner(System.in);
			switch (userInput.nextLine()){
			case "1":
				this.maxHp += 50;
				this.hp = maxHp;
				System.out.println("Your health is now: " + maxHp);
				break;
			case "2":
				this.strength += 5;
				System.out.println("Your strength is now: " + strength);
				break;
			case "3":
				this.maxStamina += 50;
				this.stamina = maxStamina;
				System.out.println("Your stamina is now: " + maxStamina);
				break;
			}
		}
	}
	public String getName(){
		return name;
	}
	public void heal(int amount){
		if (this.hp + amount > maxHp)
			this.hp = maxHp;
			else this.hp += amount;
	}
	public void damage(int amount){
		this.hp -= amount;
		if (this.hp <= 0){
			System.out.println("You have died!\nGame Over");
			System.exit(0);
		}
	}
	public int getXp(){
		return this.xp;
	}
	public int getHp(){
		return this.hp;
	}
	public int attack(){
		return 0;
	}
	public Item getWeapon(){
		return weapon;
	}
	

}
