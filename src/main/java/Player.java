
public class Player extends GameCharacter {

    public Player(String name, int health) {
        super(name, health);
        setWeapon(new Weapon("Sword", 20));
        finesse = 0.8;
        inventory.add(getWeapon());
    }
   
}
