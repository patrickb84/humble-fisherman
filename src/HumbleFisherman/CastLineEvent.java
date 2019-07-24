package HumbleFisherman;

/******************************************
* Authors:   Patrick Bradshaw
*               Punamai Futialo
*                  Tenzin Rabjam
*
* Date:   4/23/2017
*
* Class CastLineEvent represents the game
* event of catching and storing fish for 
* the game HumbleFisherman
*******************************************/

import java.util.Random;
import java.util.ArrayList;

public class CastLineEvent {
   // FIELDS
   Random rand = new Random();
   
   Fish fish = new Fish();
   String name;
   int weight;
   
   private boolean checkPole = false;
   private int poleCounter = 0;
   private boolean poleBroke = false;
   private int lureCounter = 0;
   private boolean lureWin = false;
   private boolean caughtFish;
   private String[] randomThoughts = {
      "Is that a mermaid in the distance? Nah...",
      "Gosh, the ocean is so beautiful...",
      "Here's hoping for a decent catch...",
      "The ocean makes you feel peaceful.",
      "You remember suddenly the legend of a magical fish...",
      "You think you see a ghost ship in the distant. Scary!"
   };
   private String[] exclamations = {
      "Well, I'll be a manatee's uncle!",
      "Holy carp!!!",
      "Oh my goblin shark!",
      "Son of a barnacle!",
      "Poseidon's trident!",
      "Leaping lobsters!"
   };
   private String[] noCatch = {
      "You caught a boot!",
      "You thought you felt something, but it was nothing.",
      "Nope, nothing. Must have scared it away.",
      "You caught a crab. It waves at you and jumps away.",
      "Nothing that time.",
      "Hmm... nothing. More bait next time."
   };
   private String[] castLineResults = new String[7];
   private int resultsArrayLength;
   // cooler
   private ArrayList<String> fishes = new ArrayList<>();
   private int totalCatchWeight = 0;
   private int gameTotal = 0;
   // largest fish caught
   int largestWeight = 0;
   String largestFish = "";

   // METHODS
   public void getLargest() {  //  Prints out the largest fish at the end
      String largest = "\n\n" +
         "                               Total catch " + gameTotal + " lbs!\n"    +
         "            /\"*._         _                                        \n" +
         "        .-*'`    `*-.._.-‘/    Largest fish caught:                 \n" +
         "      < * ))     ,       ( 	 " + largestFish + ", " + largestWeight    +
                                               " lbs." +                     "\n" +
         "        `*-._`._(__.--*\"`.\\                                       \n" ;
         // from  http://www.ascii-code.com/ascii-art/animals/fish.php
      System.out.println(largest);
      return;
   }
   
   // The event of casting a line
   public void castLine(int thread, boolean nicePole, boolean goodLuck)
      throws InterruptedException {
      String luck = "";
      if (goodLuck)
         luck = "Feeling lucky, alright!!";
         
      castLineResults[0] = ">>  You cast your line. " + luck;
      castLineResults[1] = ">>  " + randomThoughts[rand.nextInt(6)];
      checkPole = nicePole;
      
      int nicePoleAdder = 0;
      if (nicePole) {
         nicePoleAdder = 2;  //  Nice pole makes it easier to catch fish
         poleCounter++;      //  But there is a chance that it will break
      }
      
      int dice1 = rand.nextInt(6);
      int dice2 = rand.nextInt(6);
      poleBroke = false;
      
      if (dice1 + dice2 + nicePoleAdder - rand.nextInt(3) > 3) {
         caughtFish = true;
         castLineResults[2] = ">>  There's something on the line!!";
      }
      if ((nicePole) && (poleCounter > 3)) {
         int dice3 = rand.nextInt(6);
         if (dice3 < 2)
            poleBroke = true;
      }
      
      if (caughtFish) {
         if (poleBroke) {
               castLineResults[3] = ">>  SNAP!!! Your pole broke!";
               castLineResults[4] = ">>  @#%$&!!!";
               resultsArrayLength = 5;
               checkPole = false;
               poleCounter = 0;
         }
         else {
            name = fish.getName();
            weight = fish.getWeight(checkPole);
            if (goodLuck) {
               weight = (weight + 2 + nicePoleAdder)  //  Good luck multiplies
               * (rand.nextInt(3) + 1);               //  the weight of the fish
            }
            String whopper = "";
            if (weight > 30) {
               whopper = "IT'S GI-NORMOUS!!! ";
               name = "MASSIVE " + name;
            }
            else if (weight > 20) {
               whopper = "It's YUUUGE! ";
               name = "HUGE " + name;
            }
            else if (weight > 15) {
               whopper = "It's a big one! ";
               name = "big " + name;
            }
            fishes.add(name);
            totalCatchWeight += weight;
            gameTotal += weight;
            if (weight > largestWeight) {  //  This tracks the
               largestWeight = weight;     //  largest fish that
               largestFish = name;         //  the player catches
            }
            castLineResults[3] = ">>  " + exclamations[rand.nextInt(6)];
            castLineResults[4] = ">>  " + "You caught a " + name + "!!!";
            castLineResults[5] = ">>  " + whopper + "It must weigh about " + 
               weight + " lbs!";
            castLineResults[6] = ">>  You are happy as a clam!";
            resultsArrayLength = 7;
         }
      }
      else if (!caughtFish) {
         castLineResults[2] = ">>  Still waiting...";
         castLineResults[3] = ">>  " + noCatch[rand.nextInt(6)];
         castLineResults[4] = ">>  Darn.";
         resultsArrayLength = 5;
      }
                
      for (int i = 0; i < resultsArrayLength; i++) {  //  This method ultimately
         Thread.sleep(thread);                        //  produces an appropriate 
         System.out.println(castLineResults[i]);      //  array from the results
      }
      return;
   }
   
   public boolean getCheckPole() {
      return checkPole;
   }
   
   public void castWithLure(int thread) throws InterruptedException {
      System.out.println("\n>>  You cast your line with a rare lure.");
      if (lureCounter == 3) {
         Thread.sleep(thread);
         System.out.println(">>  Something's caught on your line!!!");
         lureWin = true;
         return;
      }
      if (lureCounter <= 1) {
         Thread.sleep(thread);
         System.out.println(">>  Time seems to stand still.");
         Thread.sleep(thread);
         System.out.println(">>  Nothing happens.");
      }
      if (lureCounter == 2) {
         Thread.sleep(thread);
         System.out.print(">>  . ");
         Thread.sleep(thread);
         System.out.print(". ");
         Thread.sleep(thread);
         System.out.println(". ");
         Thread.sleep(thread);
         System.out.println(">>  Something shimmers in the water...");
         Thread.sleep(thread);
      }
      lureCounter++;
      return;
   }
   
   // Cooler display
   public void displayCooler(boolean nicePole, boolean rareLure) {
      if (totalCatchWeight == 0)
         System.out.println("\nYour cooler is empty.");
      else {
         System.out.println("\nFishes: ");
         for (int i = 0; i < fishes.size(); i++) {
            if ((i > 0) && (i % 2 == 0))
               System.out.println();
            System.out.print("   ><((> ");
            System.out.printf("%-20s ", fishes.get(i));
         }  
         System.out.println("\nWeight: " + totalCatchWeight + " lbs.");
      }
      System.out.print("You have a ");
      if (nicePole)
         System.out.print("nice high-end fishing pole");
      else
         System.out.print("sturdy bamboo fishing pole");
      if (rareLure)
         System.out.print(" and a rare lure");
      System.out.println(".");
      return;
   }
   
   public int getTotalCatchWeight() {
      return totalCatchWeight;
   }
   
   public void clearFish() {
      fishes.clear();
      totalCatchWeight = 0;
      return;
   }
   
   public boolean getLureWin() {
      return lureWin;
   }
}