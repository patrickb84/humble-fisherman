package HumbleFisherman;

/******************************************
* Authors:   Patrick Bradshaw
*               Punamai Futialo
*                  Tenzin Rabjam
*
* Date:   4/23/2017
*
* Class Wallet represents a wallet to be 
* used in the game HumbleFisherman.
*******************************************/

public class Wallet {
   // FIELDS
   int wallet = 0;
   
   // METHODS
   public void wallet() {
      if (wallet == 0)
         System.out.println("You are penniless.");
      else {
         System.out.print("You have " + wallet + " dollar");
         if (wallet == 1)
            System.out.println(".");
         else
            System.out.println("s.");
      }
      return;
   }
   
   public int getWallet() {
      return wallet;
   }
   
   public void addMoney(int total) {
      wallet += total;
      return;
   }
   
   public void subtractMoney(int total) {
      wallet -= total;
      return;
   }
}