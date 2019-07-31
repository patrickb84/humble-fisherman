
/******************************************
* Authors:   Patrick Bradshaw
*               Punamai Futialo
*                  Tenzin Rabjam
*
* Date:   4/23/2017
*
* Class Fish represents a fish with a name
* and a weight for use in the game
* HumbleFisherman.
*******************************************/

import java.util.Random;

public class Fish {
   // FIELDS
   Random rand = new Random();

   private String[] adjectives = { "cute", "happy", "chubby", "majestic", "beautiful", "sad" };
   private String[] species = { "tuna", "salmon", "halibut", "mackarel", "seabass", "carp" };
   private int weight = 0;
   private String fishName = "";

   // METHODS
   public String getName() {
      int dice1 = rand.nextInt(6);
      int dice2 = rand.nextInt(6);
      fishName = adjectives[dice1] + " " + species[dice2];
      return fishName;
   }

   public int getWeight(boolean nicePole) {
      weight = rand.nextInt(10) + 2;
      if (nicePole) {
         int dice3 = rand.nextInt(6);
         weight = weight + dice3 + 10;
      }
      return weight;
   }
}