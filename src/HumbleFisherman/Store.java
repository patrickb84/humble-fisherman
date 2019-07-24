package HumbleFisherman;

/******************************************
* Authors:   Patrick Bradshaw
*               Punamai Futialo
*                  Tenzin Rabjam
*
* Date:   4/23/2017
*
* Class Store represents a store that buys
* fish, sells a fishing pole, a fishing
* lure, and a boat for the game
* HumbleFisherman.
*******************************************/

public class Store {
   // FIELDS
   private boolean pole = false;
   private boolean lure = false;
   private String[] storeDescriptors = {
      "\n\n    ><(*>  WELCOME TO THE FISHING STORE!!!  <*)><\n",
      "!!! Let us give you $$$ for your catch !!!",
      "!!! Catch heaviest fish with a NICE FISHING POLE for $25 !!!",
      "!!! Today only: buy the boat of your dreams for $200 !!!",
      "(You also notice a most peculiar lure for $60. Expensive!)"
   };
   private boolean boatWin = false;
   private int cost = 0;
   
   // METHODS
   public void storeFront() {
      for (String el : storeDescriptors) {
         System.out.println(el);
      }
      return;
   }
   
   public void storeMenu() {
      System.out.println("[1] SELL [2] NICE POLE $25 [3] RARE LURE $60 [4] BOAT $200 [0] LEAVE");
      System.out.print("What would you like to do? ");
      return;
   }
   
   public void sellFish(int total) {
      if (total > 0)
         System.out.println("Alright, you sold your fish for " + total + " dollars!");
      else
         System.out.println("You have nothing to sell.");
      return;
   }
   
   public void buyPole(int wallet, boolean nicePole) {
      cost = 0;
      if (wallet < 25) {
         System.out.println("You don't have enough money.");
         pole = nicePole;
      }
      else if (nicePole) {
         System.out.println("You can only carry one.");
         pole = nicePole;
      }
      else {
         System.out.println("You bought a nice pole!\nIt seems really high-tech!\n"
            + "It comes with a limited warranty.");
         cost = 25;
         pole = true;
      }
      return;
   }
   
   public void buyLure(int wallet, boolean rareLure) {
      cost = 0;
      if (wallet < 60) {
         System.out.println("You don't have enough money.");
         lure = rareLure;
      }
      else if (rareLure) {
         System.out.println("You can only carry one.");
         lure = rareLure;
      }
      else {
         System.out.println("You bought a rare lure!\nIt seems very " +
            "strange...");
         cost = 60;   
         lure = true;
      }
      return;
   }
   
   public void buyBoat(int wallet) {
      if (wallet < 200)
         System.out.println("You need to catch more fish!");
      else
         boatWin = true;
      return;
   }     
   
   public int getCost() {
      return cost;
   }
   
   public boolean checkPole() {
      return pole;
   }
   
   public boolean checkLure() {
      return lure;
   }
   
   public boolean getBoatWin() {
      return boatWin;
   }
}