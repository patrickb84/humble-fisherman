
/******************************************
* Authors:   Patrick Bradshaw
*               Punamai Futialo
*                  Tenzin Rabjam
*
* Date:   4/23/2017
*
* HumbleFisherman is a game where the user
* plays a fisherman who is trying to catch
* and sell enough fish to buy a boat. It
* includes the Classes: Environment, Fish,
* Wallet, Store, and CastLineEvent.
*******************************************/

import java.util.Random;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) throws InterruptedException {
      @SuppressWarnings("resource")
      Scanner input = new Scanner(System.in);
      Random rand = new Random();

      CastLineEvent c = new CastLineEvent();
      Environment e = new Environment();
      Wallet w = new Wallet();
      Store s = new Store();

      boolean win = false;
      boolean noLuck = false; //
      boolean boatEnding = false; // win conditions
      boolean lureWin = false; //

      int thread = 1060;
      int storyThread = 1175;
      int turnCounter = 0;
      final int MAX_COUNTER = 16;
      boolean nicePole = false;
      boolean rareLure = false;
      int userInput = 0;
      int userStore;
      int diceRoll;
      boolean goodLuck;
      boolean stillTime;

      System.out.println(); //
      e.introduction(storyThread); // Introduction
      Thread.sleep(storyThread * 2); //
      System.out.println(); //

      // MAIN INTERFACE //
      do {
         stillTime = false;
         goodLuck = false;
         diceRoll = rand.nextInt(6);
         if (diceRoll == 5)
            goodLuck = true;
         else if (turnCounter >= 14)
            goodLuck = true;
         else
            goodLuck = false;

         System.out.println();
         e.getTurnString(turnCounter);
         w.wallet();
         boolean turnOver = false;

         do {
            boolean isNumeric = false;
            while(!isNumeric){
              try {
                  System.out.println();
                  e.showMenu();
                  userInput = input.nextInt(); 
                  isNumeric = true;
              } catch(Exception excpt) {
                System.out.println("Enter a valid number!");
                input.nextLine();//Advance the scanner
              }
            }

            switch (userInput) {
            case 1: // cast line event
               if (rareLure) {
                  System.out.print("Cast line with the rare lure (y/n)? ");
                  String lureInput = input.next();
                  ;
                  switch (lureInput) {
                  case "Y":
                  case "y":
                     turnCounter--; // use of the rare lure
                     stillTime = true; // does not spend a turn
                     c.castWithLure(thread); // unbeknownst to user
                     turnOver = true;
                     break;
                  case "N":
                  case "n":
                     c.castLine(thread, nicePole, goodLuck);
                     break;
                  default:
                     System.out.print("(y/n)? ");
                  }
               } else {
                  System.out.println();
                  c.castLine(thread, nicePole, goodLuck);
               }
               nicePole = c.getCheckPole();

               if (c.getLureWin()) {
                  turnOver = true;
                  win = true;
                  lureWin = true;
                  break;
               }
               System.out.println();
               Thread.sleep(thread * 2);
               turnOver = true;
               turnCounter++;
               break;

            case 2: // Cooler Display
               c.displayCooler(nicePole, rareLure);
               System.out.println();
               break;

            case 3: // Store Menu
               s.storeFront();
               do {
                  System.out.println("\nMONEY: $" + w.getWallet());
                  s.storeMenu();
                  userStore = input.nextInt();

                  switch (userStore) {
                  case 1: // Sell fish
                     System.out.println();
                     s.sellFish(c.getTotalCatchWeight());
                     w.addMoney(c.getTotalCatchWeight());
                     c.clearFish();
                     break;
                  case 2: // Buy pole
                     System.out.println();
                     s.buyPole(w.getWallet(), nicePole);
                     w.subtractMoney(s.getCost());
                     nicePole = s.checkPole();
                     break;
                  case 3: // Buy lure
                     System.out.println();
                     s.buyLure(w.getWallet(), rareLure);
                     w.subtractMoney(s.getCost());
                     rareLure = s.checkLure();
                     break;
                  case 4: // Buy boat
                     System.out.println();
                     s.buyBoat(w.getWallet());
                     if (s.getBoatWin()) {
                        win = true;
                        boatEnding = true;
                        userStore = 0;
                        break;
                     }
                     break;
                  case 0:
                     System.out.println("\n");
                     e.getTurnString(turnCounter);
                     break;
                  }
               } while (userStore != 0);
               break;
            case 2017: // Cheat code for convenience while presenting
               System.out.print("Set game speed (milliseconds): ");
               int gameSpeedZ = input.nextInt();
               thread = gameSpeedZ;
               System.out.print("Add money: ");
               int addMoneyZ = input.nextInt();
               w.addMoney(addMoneyZ);
               boolean turnSet = false;
               do {
                  System.out.print("Set turn (1 - 16, or 0 to skip): ");
                  int setTurnZ = input.nextInt();
                  if (setTurnZ > 0 && setTurnZ <= 16) {
                     turnCounter = setTurnZ - 1;
                     System.out.println();
                     e.getTurnString(turnCounter);
                     w.wallet();
                     turnSet = true;
                  } else if (setTurnZ == 0) {
                     turnSet = true;
                  } else {
                     System.out.println("Invalid entry. Try again.");
                     turnSet = false;
                  }
               } while (!turnSet);
               break;

            case 0:
               break;
            }

            // When the lure is used, this is a clue that it freezes the turns
            if (stillTime && !lureWin) {
               Thread.sleep(thread);
               System.out.println("Time is at a stand still (you did not lose a turn).");
            }

            if (turnCounter == MAX_COUNTER) {
               if (c.getTotalCatchWeight() > 0) {
                  Thread.sleep(thread * 2);
                  System.out.println("You sell the rest of your catch.");
                  w.addMoney(c.getTotalCatchWeight());
               }
               Thread.sleep(thread * 2);
               System.out.println("You ended with " + w.getWallet() + " dollars!\n");
               if (w.getWallet() < 200) {
                  noLuck = true;
                  boatEnding = false;
               } else {
                  boatEnding = true;
                  noLuck = false;
               }
               win = true;
            }
            if (win)
               break;
         } while (userInput != 0 && !turnOver);
      } while (userInput != 0 && !win);

      if (userInput == 0) {
         System.out.println("\n   `·.¸¸ ><(((º> .·´¯`· ><(((º>  See you later!");
         return;
      } else {
         if (lureWin) {
            e.ending3(storyThread);
            if (e.getWish())
               e.getUserWish();
         } else if (boatEnding)
            e.ending2(storyThread);
         else if (noLuck)
            e.ending1(storyThread);
      }
      Thread.sleep(storyThread * 2);
      c.getLargest();

      Thread.sleep(storyThread * 2);
      System.out.println("\n\n          -= THE END =- \n");
      System.out.println("       Thanks for playing!");
      System.out.println("     patrick, tenzin, punamai");
      Thread.sleep(storyThread * 2);

      boolean finalExit = false;
      do {
         System.out.print("\n\n  -= See different endings =-\n" + "  [1] You didn't catch enough fish.\n"
               + "  [2] You bought the boat.\n" + "  [3] Legendary ending.\n\n" + "  Your choice [0 to exit]: ");
         boolean endChoice = false;
         do {
            int endingChoice = input.nextInt();
            switch (endingChoice) {
            case 1:
               e.ending1(storyThread);
               endChoice = true;
               break;
            case 2:
               e.ending2(storyThread);
               endChoice = true;
               break;
            case 3:
               e.ending3(storyThread);
               endChoice = true;
               break;
            case 0:
               finalExit = true;
               endChoice = true;
               break;
            default:
               break;
            }
         } while (!endChoice);
      } while (!finalExit);
   }
}
