package HumbleFisherman;

import java.util.ArrayList;

public class Cooler {
   // fields
   private ArrayList<String> fishes = new ArrayList<>();
   private int fishCounter;
   
   // ctors
   
   // methods
   public void addWeight(int weight) {
      fishCounter += weight;
      return;
   }
   
   public void addFish(String fish) {
      fishes.add(fish);
   }
   
   public void showCooler(boolean nicePole, boolean specialLure) {
      System.out.println("Fishes: ");
         for (int i = 0; i < fishes.size(); i++) {
            if ((i) % 2 == 0)
               System.out.println();
               System.out.print("   ");
               System.out.printf("%-27s ", fishes.get(i));
               
               }
            System.out.println();
            System.out.println(">]]](*> Weight: " + fishCounter + " lbs.");
            System.out.println();
      return;
   }
   
   
}