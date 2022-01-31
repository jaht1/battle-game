import java.io.Serializable;
public class Weapon implements Serializable{
    String name;
    int damage;

    public Weapon(String name, int damage) {
        this.damage = damage;
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}
