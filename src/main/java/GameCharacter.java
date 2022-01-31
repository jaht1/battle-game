import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.io.Serializable;

abstract class GameCharacter implements Serializable {
    private String name;
    String wName;
    private int health;
    private Weapon weapon;
    double finesse;
    Random rand = new Random();
    private int attackStrength;
    double randomStrength;
    ArrayList<Weapon> inventory = new ArrayList<Weapon>();

    public void addInventory(Weapon w) {
        inventory.add(w);
    }

    public Weapon getInventory(int num) {
        if (num == 0){
            return inventory.get(num);
        }
        return inventory.get(num - 1);

    }

    public ArrayList getInventoryContent() {
        return inventory;
    }

    public void setInventory() {
        inventory = ((ArrayList) FileUtils.loadObject("game.save"));
    }

    public String removeInventory(int index) {

        if (checkIndex(index) == true) {
            try {
                Weapon removed = inventory.get(index - 1);
                inventory.remove(index - 1);
                return "Removed " + removed.name;
            } catch (IndexOutOfBoundsException e) {
                return "You don't have a " + index + "th weapon. \nChoose another number between 1-" + inventory.size();
            } catch (NumberFormatException e) {
                return "You don't have a " + index + "th weapon. \nChoose another number between 1-" + inventory.size();
            } catch (InputMismatchException e) {
                return "Please give a number input.";
            } catch (Exception e) {

                return "Please give a number input.";
            }

        } else

        {
            return "You don't have a " + index + "th weapon. \nChoose another number between 1-" + inventory.size();
        }
    }

    public boolean checkIndex(int index) {
        try {
            if ((index) >= 0 && (index-1) < inventory.size()) {
                return true;
            }
           else {
                return false;
            }
        } catch (InputMismatchException e) {
            return false;
        }
        catch (IndexOutOfBoundsException e) {
            return false;
        } catch (NumberFormatException e) {
            return false;
        }  catch (Exception e) {

            return false;
        }
        
    }

    public GameCharacter(String name, int health) {
        this.name = name;
        this.health = health;

    }

    public int takeDamage(int damage) {
        health = health - damage;
        if (health <= 0) {
            this.health = 0;
        }
        return health;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;

    }

    public String getWeaponName() {
        wName = weapon.name;
        return wName;
    }

    public Weapon getWeapon() {
        this.weapon = weapon;
        return weapon;
    }

    public String getName() {
        this.name = name;
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public int attack(GameCharacter defender) {
        double minAttack = weapon.getDamage() * finesse;
        double maxAttack = weapon.getDamage();
        randomStrength = minAttack + (maxAttack - minAttack) * rand.nextDouble();
        // attackStrength = (int) randomStrength;
        getAttackStrength();
        return defender.takeDamage(attackStrength);

    }

    public int getAttackStrength() {
        return attackStrength = (int) randomStrength;
    }

    public int heal(int currentHealth) {
        Random rand = new Random();
        int randomHeal = currentHealth + rand.nextInt((100 - currentHealth) + 1);
        return randomHeal;
    }

}
