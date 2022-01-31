import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean chooseIn = false;
        boolean gameOn = true;
        boolean newGame = true;
        GameCharacter player = new Player(" ", 0);

        if (FileUtils.loadObject("game.save") != null) {
            newGame = false;
            player = (GameCharacter) FileUtils.loadObject("game.save");
            System.out.println("Welcome back " + player.getName() + "!\n");
            System.out.println("Do you want to load game (y) or start a new game? (n)");
            String g = scan.next();
            if (g.equals("y")) {
                ;
            } else {
                FileUtils.writeSaveFile("game.save", "");
                System.out.println("Starting new game...");
                newGame = true;

            }

        }

        if (FileUtils.readSaveFile("game.save") == null || newGame == true) {
            // System.out.println("Welcome new player!\n");
            System.out.print("Enter your name to play: ");
            String name = scan.next();
            player = new Player(name, 100);
            newGame = false;
        }

        GameCharacter npc = Npc.spawnNpc();

        npc.setWeapon(Npc.spawnNpc().getWeapon());

        System.out.println("A " + npc.getName() + " is walking towards you!");
        while (player.getHealth() >= 0 && npc.getHealth() >= 0 && gameOn == true) {

            System.out.println("Do you want to attack (y) or not (n)?");
            String userInput = scan.next();

            if (userInput.equals("n")) {
                System.out.println("You flee!");
                System.out.println("Play again (y) or quit game (n)?");
                String answer = scan.next();
                if (answer.equals("n")) {
                    System.out.println("Game over.");
                    gameOn = false;
                    break;
                } else if (answer.equals("y")) {
                    gameOn = true;
                    continue;
                }

            } else if (userInput.equals("y")) {
                gameOn = true;
                chooseIn = true;

                while (player.getHealth() >= 0 && npc.getHealth() >= 0) {

                    if (chooseIn == true) {
                        System.out.println("Inventory: ");
                        for (int i = 0; i < player.inventory.size(); i++) {
                            String we = player.inventory.get(i).name;
                            System.out.println((i + 1) + ". " + we);
                        }
                        int w = 0;
                        boolean ok = false;
                       
                        

                        while (!ok) {
                            try { 
                                System.out.println("\nChoose a weapon for attack: 1-" + (player.inventory.size())
                                + ". (Press '0' to remove a weapon from inventory.)");
                                w = scan.nextInt();
                                ok = true;
                            } catch (InputMismatchException e) {
                                //System.out.println("Please give a number between 1-"+ player.inventory.size());
                                scan.next();
                            }
                            
                       }
                        boolean checker = player.checkIndex(w);
                        if (checker == true) {
                            player.getInventory(w);
                        } else {
                            System.out.println(w + " is not a valid input. \nChoose another number between 1-"
                                    + player.inventory.size());
                            continue;
                        }
                        if (w == 0) {
                            System.out.println("Press the number of the weapon you want to remove:");
                            int num = scan.nextInt();
                            System.out.println(player.removeInventory(num));
                            continue;

                        } else {
                            player.setWeapon(player.getInventory(w));
                            chooseIn = false;
                        }
                    }

                    player.attack(npc);
                    System.out.println(player.getName() + " attacks " + npc.getName() + " with a "
                            + player.getWeaponName() + " for "
                            + player.getAttackStrength() + " HP");
                    System.out.println(npc.getName() + " has " + npc.getHealth() + " HP left.\n");

                    if (npc.getHealth() <= 0) {
                        System.out.println(player.getName() + " wins with " + player.getHealth() + " HP! \n");
                        System.out.println(npc.getName() + " dropped their " + npc.getWeaponName()
                                + ". Do you want to add (a) it to your inventory or continue (n)?");
                        String add = scan.next();

                        if (add.equals("a")) {
                            player.addInventory(npc.getWeapon());
                        } else if (add.equals("n")) {
                            System.out
                                    .println("\nYou chose to not add " + npc.getWeaponName() + " to your inventory\n");
                        }

                        int h = player.getHealth();
                        player.setHealth(player.heal(h));
                        System.out.println("You find a health potion and your HP is now " + player.getHealth());
                        System.out.println("Play again (y) or quit game (n)?");
                        String answer = scan.next();

                        if (answer.equals("n")) {
                            System.out.println("Game over.");
                            gameOn = false;
                            break;
                        } else if (answer.equals("y")) {
                            gameOn = true;
                            npc.setHealth(100);
                            npc = Npc.spawnNpc();
                            npc.setWeapon(Npc.spawnNpc().getWeapon());
                            chooseIn = true;
                            continue;
                        }

                    }

                    npc.attack(player);
                    System.out.println(
                            npc.getName() + " attacks " + player.getName() + " with a " + npc.getWeaponName() + " for "
                                    + npc.getAttackStrength() + " HP");
                    System.out.println(player.getName() + " has " + player.getHealth() + " HP left.\n");

                    if (player.getHealth() <= 0) {
                        System.out.println(npc.getName() + " wins with " + npc.getHealth() + " HP!\n");

                        System.out.println("Restart game (y) or quit (n)?");
                        String answer = scan.next();
                        if (answer.equals("n")) {
                            System.out.println("Game over.");
                            gameOn = false;
                            break;
                        } else if (answer.equals("y")) {
                            gameOn = true;
                            npc.setHealth(100);
                            player.setHealth(100);
                            chooseIn = true;
                            continue;
                        }

                    }

                }
            }
            npc.setHealth(100);
            player.setHealth(100);

        }

        FileUtils.saveObject("game.save", player);
        scan.close();
    }
}
