package Text_based_adventure_Game;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        //Game Variables
        String[] enemies = {"Skeleton","Zombie","Warrior","Assassin"};
        int maxEnemyHealth = 95;
        int enemyAttackDamage = 15;

        //Player Variables
        int health = 100;
        int attackDamage = 25;
        int numHealthPotions = 4;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 60;  //percentage

        boolean running = true;

        System.out.println("Welcome to the Dungeon");

        GAME:
        while(running){
            System.out.println("-----------------------------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy  = enemies[rand.nextInt(enemies.length)];

            System.out.println("\t# " + enemy + "has appeared! #\n");

            while(enemyHealth>0){
                System.out.println("\tYour HP: "+ health);
                System.out.println("\t"+enemy + "'s HP: "+ enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");
                
                String input = sc.nextLine();
                if(input.equals("1")){
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You strike the "+ enemy+ " for "+ damageDealt+ " damage");
                    System.out.println("\t> You recieve "+ damageTaken + " in retaliation");

                    if(health<1){
                        System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                        break;
                    }
                }else if(input.equals("2")){
                    if(numHealthPotions>0){
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You drink a health potion. Your health is increased by : " + healthPotionHealAmount);
                        System.out.println("\t> Your health is : " + health+ " HP");
                        System.out.println("\t> You have " + numHealthPotions + " health potions left.");

                    }else{
                        System.out.println("\t> You have no health potion left. Defeat an enemy for a chance to get health potion");
                    }
                }else if(input.equals("3")){
                    System.out.println("\t> You run away from the "+ enemy+ "!");
                    continue GAME;
                }else{
                    System.out.println("\t> Invalid command!");
                }
            }

            if(health<1){
                System.out.println("\t> You Died");
                break;
            }

            System.out.println("-----------------------------------------------------------------");

            System.out.println(" # " + enemy + " was defeated! # ");
            System.out.println("# You have "+ health + "HP left. #");

            if(rand.nextInt(100)< healthPotionDropChance){
                numHealthPotions++;
                System.out.println(" # The " + enemy + " dropped a health potion! #");
                System.out.println(" # You now have "+ numHealthPotions + " health potion. # ");
            }
            System.out.println("-----------------------------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit dungeon");

            String input = sc.nextLine();

            while(!input.equals("1")&&!input.equals("2")){
                System.out.println("Invalid command! ");
                input = sc.nextLine();

            }

            if(input.equals("1")){
                System.out.println("You continue on your adventure! ");
            }else if(input.equals("2")){
                System.out.println("You exit the dungeon!!! ");
                break;
            }

        }

        System.out.println("#############################");
        System.out.println("#    Thanks for playing     #");
        System.out.println("#############################");

        
    }
}
