import java.util.Random;

public class Npc extends GameCharacter {

    public Npc(String name, int health) {
        super(name, health);
        //setWeapon(new Weapon("club", 20));
        finesse = 0.5;
    }

    static GameCharacter spawnNpc(){

        String[] npcType = {"monster", "zombie", "giant", "troll", "orc"};
        String[] weaponType = {"club", "spear", "axe", "mace", "crossbow", "knife"};

        Random rand = new Random();
        int i = rand.nextInt(3);
        String npcName = npcType[i];
        String npcWeapon = weaponType[i];

        
        GameCharacter npc = new Npc(npcName, 100);
        npc.setWeapon(new Weapon(npcWeapon, 20));
        return npc;
    }
}
