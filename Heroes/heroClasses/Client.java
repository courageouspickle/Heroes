package heroClasses;
import java.util.Scanner;
import heroClasses.*;
import java.util.ArrayList;
import java.awt.Point;
public class Client {
	
	static ArrayList<Item> inventory = new ArrayList<Item>(2); 
	static Point position = new Point(0,0);
	static int classId;
	static int time = 0;
	static boolean isNight = false;
	Hero User;
	

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Welcome to the great kingdom of Himblain!\nWhat is your name?");
		String temp = userInput.nextLine();
		if(temp.equals("Lex")){
			System.out.println("Hah! - what a doofus!");
			System.exit(0);
		}
		System.out.println("What type of Hero are you " + temp + "?\n1. Knight\n2. Berserker\n3. Cleric\n4. Wizard\n(Psst... only Knight works; new classes coming soon!)");
		Hero User;
		switch (userInput.nextLine()){
		case "1":
		case "Knight":
		case "knight":
		default:
			classId = 1;
			User = new Knight(temp, 10);
			break;
		}
			//default: System.out.println("Please make a selection hero! there isn't much time!");
			//break;
		
		System.out.println("There is no time for pleasantries " + temp + "!");
		delay(1500);
		System.out.println("The kingdom is in grave danger! Demonic forces have invaded and we need heroes like you now more than ever!");
		delay(2000);
		System.out.println("Take this sword and some bread, and go clear out a cave 10 miles east of here!");
		delay(2000);
		System.out.println("Be careful, because as you get farther from the castle, you'll see scarier monsters!");
		Item Bread = new Item ("Piece of bread", 0.5, 0.0, true, 20);
		System.out.println();
		addItem(Bread);
		Item OldSword = new Item ("Old sword", 12.5, 1.0);
		addItem(OldSword);
		User.weapon = OldSword;
		delay(1000);
		System.out.println("Type commands into the console to explore the world. Enter \"help\" if you get stuck.");
		home(User);
		
	}
	
	public static void addItem(Item x){
		inventory.add(x);
		System.out.println("You got: " + x.name);
	}
	public static void home(Hero User){
		if (classId == 1)
			User = (Knight) User;
		
		Scanner userInput = new Scanner(System.in);
		switch(userInput.nextLine()){
		case "help": System.out.println("Here are some things you can do:\ngo (north/east/south/west): walk in a certain direction\ninventory: check inventory\nstatus: check current status\nexamine: examine current surroundings\nsleep: stop for the night and try to rest\nwait: sit around for about an hour");
			
			User = (Hero) User; home(User); 
			break;
		case"Lex is a D00FUS":
			User.addXp(2000);
			User = (Hero) User; home(User);
			break;
		case"give me a REAL challenge":
			Enemy DemonKing = new Enemy("Demon King", "The King of Demons smites you with a bolt of deific power.", 50);
			System.out.println("Ha ha ha ha ha...");
			delay(1000);
			System.out.println("HA HA HA HA HA...");
			delay(3000);
			System.out.println("You are arrogant, mortal, and its time you were put down.");
			delay(1000);
			System.out.println("The King of Demons appears!");
			fight(User, DemonKing);
			break;
		case "n":
		case "north":
		case "go north":
			position.translate(0, 1); 
			System.out.println("You walk North for about a mile."); 
			time++;
			examine(position);
			User.useStamina(5);
			encounter(User, encId(position));
			User = (Hero) User; home(User); 
			break;
		case "e":
		case "east":
		case "go east": 
			position.translate(1, 0); 
			System.out.println("You walk East for about a mile.");
			time++;
			examine(position);
			User.useStamina(5);
			encounter(User, encId(position));
			User = (Hero) User; home(User); 
			break;
		case "s":
		case "south":
		case "go south":
			position.translate(0, -1); 
			System.out.println("You walk South for about a mile."); 
			time++;
			examine(position);
			User.useStamina(5);
			encounter(User, encId(position));
			User = (Hero) User; home(User); 
			break;
		case "w":
		case "west":
		case "go west":
			position.translate(-1, 0); 
			System.out.println("You walk West for about a mile."); 
			time++;
			examine(position);
			User.useStamina(5);
			encounter(User, encId(position));
			User = (Hero) User; home(User); 
			break;
			
		case "examine": 
			examine(position);
			User = (Hero) User; home(User);
			break;
		case "inv":
		case "check inventory":	
		case "inventory": 
			User = (Hero) User; 
			checkInventory(User);
			home(User);
			break;
		case "rest":
		case "sleep":
			if (time < 7)
				{System.out.println("It's too bright out to sleep now.");}
			else{System.out.println("You hunker down in the best hiding place you can find and try to sleep.");
			for (int i = 0; i < (int)((Math.random() + 1)*5); i++){
			System.out.print("Zzz... ");
			delay(1000);
		}
			System.out.println();
		if (Math.random() * Math.sqrt(position.x * position.x + position.y * position.y) > 5){
			System.out.println("You are startled awake by a sound in the night.");
			encounter(User, encId(position));
		} else {
			System.out.println("\nYou awake feeling rested.");
			User.heal(50);
			User.gainStamina(User.maxStamina);
			System.out.println("Your health is now: " + User.getHp());
			System.out.println("Your stamina is now " + User.getStamina());
			time = 0;
			examineTime();
		}
			
			
		}
		User = (Hero) User; home(User);
		break;
		
		case "wait": time++;
		examineTime();
		encounter(User, encId(position));
		User = (Hero) User; home(User);
		break;
		
		case "check status":
		case "status":
			System.out.println(User.getName() + ": Level " + User.level + " " + getClass(classId));
			System.out.println("HP: \t\t" + User.hp + "/" + User.maxHp);
			System.out.println("XP: \t\t" + User.xp + "/" + (User.level * 100));
			System.out.println("Stamina:\t" + User.stamina + "/" + User.maxStamina);
			System.out.println("Strength:\t" + User.strength);

			User = (Hero) User; home(User);
			break;
			
		default: System.out.println("Not a valid command. Enter \"help\" for options");
		User = (Hero) User; home(User);
		break;
		}
	}
public static void checkInventory(Hero User){
	Scanner userInput = new Scanner(System.in);
	for (int i = 0; i < inventory.size(); i++){
		System.out.println(i + 1 + ". " + inventory.get(i).name);
	}
	System.out.println((inventory.size()+1) + ". Nevermind");
	System.out.println("\nWhat would you like to use?");
	String num = userInput.nextLine();
	try {
		int temp = Integer.parseInt(num) - 1;
	} catch (NumberFormatException nfe) {
		System.out.println("Enter the number designation, not the whole word.");
		checkInventory(User);
		return;
		
	}
	int temp = Integer.parseInt(num) - 1;
	if (temp == inventory.size()){
		return;
	} 
	System.out.println("What would you like to do with it?");
	System.out.println("1. Consume\n2. Equip\n3. Drop");
	if (userInput.hasNextInt()){
	int temp2 = userInput.nextInt();
	switch (temp2){
		case 1: 
			if(inventory.get(temp).heals){
				User.heal(inventory.get(temp).amount);
				System.out.println("You gained: " + inventory.get(temp).amount + " health");
				inventory.remove(temp);
				}else{
					System.out.println("You can't eat that!");
				}
			return;
		case 2:
			User.weapon = inventory.get(temp);
			System.out.println("You brandish the " + inventory.get(temp).name + " menacingly in front of you.");
			return;

		case 3: 
			System.out.println("You dropped: " + inventory.get(temp).name);
			inventory.remove(temp);
			return;

		default: 
			System.out.println("Not a valid selection.");
		}
	}else{
		System.out.println("Make your selection with the number designations.");
		checkInventory(User);
	}
	}
	public static void examine(Point current){
		if (current.x == 10 && current.y == 0){
			System.out.println("A large, forboding cave dominates the landscape. This must be what that guy was talking about.");
			System.out.println("It seems pretty scary... Do you want to go in anyway?");
			Scanner userInput = new Scanner(System.in);
			switch (userInput.nextLine()){
			case "yes":
			case "yea":
			case "yeah":
			case "What could possibly go wrong?":
			case "sure": dungeon(); break;
			}
			
		}
		else switch(Math.abs(current.x) + Math.abs(current.y)){
		case 0: System.out.println("You're back at castle Himblain."); break;
		case 1: 
		case 2:
		case 3: System.out.println("There's just a bunch of grass, nothing interesting."); break;
		case 4: 
		case 5:
		case 6:
		case 7: System.out.println("Thickets of trees are spread across the landscape, and the grass grows tall and wild here."); break;
		case 8:
		case 9: 
		case 10:
		case 11:
		case 12:
		case 13: System.out.println("The forest is thick here, and shadows are more common than the occasional rays of light shining through the canopy."); break;
		default: System.out.println("Far from any semblance of civilization, the trees envelop you in darkness."); break;
		}
		examineTime();
	}
	public static void examineTime(){
		switch(time){
		case 0: System.out.println("The sunrise looks beautiful."); break;
		case 1:System.out.println("The sun is rising over the horizon."); break;
		case 2: System.out.println("It's midmorning."); break;
		case 3: System.out.println("The sun is high in the sky."); break;
		case 4: System.out.println("It's high noon."); break;
		case 5: System.out.println("The sun is burning bright."); break;
		case 6: System.out.println("It's midafternoon now."); break;
		case 7: System.out.println("The sun is starting to set. You should find a place to rest for the night."); break;
		case 8: System.out.println("It's twilight. I need to hide before the monsters come out."); break;
		case 9: isNight = true;
		case 10:
		case 11:
		case 12:
		case 13:
		case 14:
		case 15: System.out.println("It's pitch black out. You can hear the blood-curdling moan of a monster off in the distance."); break;
		default: time = 0; examineTime(); isNight = false; break;
		}
	}
	
	public static void dungeon(){
		System.out.println("Don't say I didn't warn you.\nYou walk into the cave and are immediately mauled to death by an angry bear.");
		System.out.println("Thanks for playing!");
		System.out.println("Did you slay the dragon? Play again! Himblain needs you!");
		System.exit(0);
	}
	public static int encId(Point place){
		double distance =  Math.sqrt(place.x * place.x + place.y * place.y)/2;
		if (isNight)
			distance *= 2;
		
		return (int)Math.floor((Math.random() + .5) * distance);
	}
	public static void encounter(Hero User, int encId){
		Item Bread = new Item ("Bread", 0.5, 0.0, true, 20);
		Item Potion = new Item("Healing Potion", .25, .1, true, 100);
		Enemy AdultDragon = new Enemy("Dragon", "The Dragon mauls you with a giant taloned claw.", 10);
		Enemy AncientDragon = new Enemy("Ancient Dragon", "The monster bathes the landscape in a maelstrom of fire.", 20);
		Enemy DemonKing = new Enemy("Demon King", "The King of Demons smites you with a bolt of deific power.", 40);
		Enemy Midget = new Enemy("midget", "The midget waddles up to you and gives you a sharp kick in the knee.", .25);
		Enemy Goblin = new Enemy("goblin", "The goblin quickly stabs you and scurries away.",  .5);
		Enemy Zombie = new Enemy("zombie", "The zombie bites you and tears at your flesh.", 1);
		Enemy Ogre = new Enemy ("big, fat ogre", "The ogre smashes you with its club, knockng you off of your feet.", 3);
		Enemy Dragonling = new Enemy("dragonling", "The dragonling bathes you in a torrent of fire breath.", 6);
		switch(encId){
		case 0:
			break;
		case 1: 
			break;
		case 2: System.out.println("You spot an angry hunchbacked goblin prancing toward you.");
			fight(User, Goblin);
			break;
		case 3:
			System.out.println("A zombie hobbles toward you menacingly.");
			fight(User, Zombie);
			break;
		case 4:
			System.out.println("It's eerily quiet.");
			break;
		case 5:
			System.out.println("You found some bread on the ground! (5 second rule right?)");
			addItem(Bread);
			break;
		case 6: 
		case 12:
			System.out.println("Ahh! A zombie!");
			fight(User, Zombie);
			break;
		case 7: 
		case 11:
		case 14:
			System.out.println("A massive ogre roars at you! Prepare yourself!");
			fight(User, Ogre);
			break;
		case 8: 
			System.out.println("You find a healing potion on the ground! What luck!");
			addItem(Potion);
			break;
		case 9:
		case 10:
		case 16:
		case 17:
			System.out.println("A dragonling plummets down from above and lands in front of you with an earth-shattering smash.");
			fight(User, Dragonling);
			break;
		case 15: 
			System.out.println("What is that? A midget?!?");
			fight(User, Midget);
			break;
		case 25:
		case 24:
		case 23:
		case 21:
			System.out.println("A massive dragon crashes down in front of you!");
			fight(User, AdultDragon);
			break;
		case 26:
		case 27:
		case 28:
			System.out.println("A dragon three times the size of castle Himblain appears in front of you out of thin air.");
			fight(User, AncientDragon);
			break;
		case 29:
		case 30:
			System.out.println("Ha ha ha ha ha...");
			delay(1000);
			System.out.println("HA HA HA HA HA...");
			delay(3000);
			System.out.println("You are arrogant, mortal, and its time you were put down.");
			delay(1000);
			System.out.println("The King of Demons appears!");
			fight(User, DemonKing);
		default: break;
		
		}
		
	}
	public static void fight(Hero User, Enemy noob){
		delay(1000);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("1. fight\n2. inventory\n3. status\n4. run");
		Scanner userInput = new Scanner(System.in);
		switch(userInput.nextLine()){
		case "fight":
		case "Fight":
		case "1":{
			System.out.println("You smack the " + noob.name + " with your " + User.getWeapon().getName() + "!");
			int temp1 = User.attack();
			noob.damage(temp1);
			System.out.println("It takes " + temp1 + " damage");
			delay(500);
			User.useStamina(5);
			delay(500);
			if (noob.hp <= 0){
				System.out.println("Hooray! You killed the " + noob.name + "!");
				System.out.println("You gained " + noob.xp + " XP!");
				User.addXp(noob.xp);
				Item temp = noob.drop();
				if (temp.name != "nothing"){
					System.out.println("Theres a " + temp.name + " on the " + noob.name + "'s corpse. Take it?");
					switch (userInput.nextLine()){
					case "yes":
					case "take":
					case "take it":
					case "yea":
					case "yeah": 
						addItem(temp);
						break;
					case "no":
					case "No":
					case "naw":
					case "leave": 
						System.out.println("You leave it on the corpse.");
						break;
					default:
						System.out.println("I'm not sure what you said, so let's just take it.");
						addItem(temp);
						break;
					}
				}
				return;
				
			}
			break;
		}
		case "2":
		case "inventory":
			checkInventory(User);
			fight(User, noob);
			return;
		case "3":
		case "status":
			System.out.println(User.getName() + ": Level " + User.level + " " + getClass(classId));
			System.out.println("HP: \t\t" + User.hp + "/" + User.maxHp);
			System.out.println("XP: \t\t" + User.xp + "/" + (User.level * 100));
			System.out.println("Stamina:\t" + User.stamina + "/" + User.maxStamina);
			System.out.println("Strength:\t" + User.strength);
			fight(User,noob);
			return;
		case "run":
		case "bail":
		case "RUN":
		case "4":
			if (Math.random() < .5){
				System.out.println("Got away safely!");
				return;
			}else{
				System.out.println("You trip and fall as you try to escape!");
			}
			break;
		default: 
				System.out.println("Invalid entry");
				fight(User, noob);
				return;
		}
			System.out.println(noob.attack);
			User.damage(noob.attackPlayer());
			fight(User, noob);
		
		
	}
	public static String getClass(int id){
		if (id == 1)
			return ("Knight");
		else return null;
	}
	public static void delay(int ms){

		try {
	    Thread.sleep(ms);                 
		} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
		}
	}

}
/*inputLoop: while(true){
			switch(classId){
			case 1: Hero User = new Knight(temp, 5);
			break inputLoop;
	
			//default: System.out.println("Please make a selection hero! there isn't much time!");
			//break;
			}
		}
		trying to figure out how to declare Hero so that it can be passed into home(Hero)
*/