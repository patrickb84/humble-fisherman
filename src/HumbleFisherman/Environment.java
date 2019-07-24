package HumbleFisherman;

/******************************************
* Authors:   Patrick Bradshaw
*               Punamai Futialo
*                  Tenzin Rabjam
*
* Date:   4/23/2017
*
* Class Environment contains descriptions,
* ASCII images and endings for the game
* HumbleFisherman.
*******************************************/

import java.util.Scanner;

public class Environment {
   // FIELDS
   Scanner input = new Scanner(System.in);
   
   private boolean wish = false;
   private String userWish = "";
   
   private String[] turnDescriptors = {
      // The individual descriptors for each turn
      "              ><(((*>  16 TURNS LEFT  <*)))><\n\n" +
      "The morning has broken into a glorious new day. You find yourself \n" +
      "on a long wooden dock with your bamboo fishing pole and a cooler \n" +
      "you hope to fill with fish. May the ocean bring you great good \n" +
      "fortune! \n",
      
      "              ><(((*>  15 TURNS LEFT  <*)))><\n\n" +
      "The morning is in full motion, like the waves of the sea. The \n" +
      "quiet fishing village behind you stirs with life. The sun climbs \n" +
      "steadily over the vast ocean. \n",
      
      "              ><(((*>  14 TURNS LEFT  <*)))><\n\n" +
      "An ocean breeze catches a bird in mid-flight for a moment. \n" +
      "Seagulls call to one another, maybe they are looking for \n" +
      "breakfast. One swooshes by you, eyeing your cooler. \n",

      "              ><(((*>  13 TURNS LEFT  <*)))><\n\n" +
      "Ships seem to drift lazily by, dotting the horizon. You hear \n" +
      "their far-off horns and wonder where they come from. They float \n" +
      "lazily by as if caught in a sea-foam dream. \n",
      
      "              ><(((*>  12 TURNS LEFT  <*)))><\n\n" +
      "The sun reflects upon the seawater. The light it gives scatters, \n" +
      "resembling wishing stars caught in a fishing net. You try to make \n" +
      "a wish on each one. Maybe they will come true. \n",
      
      "              ><(((*>  11 TURNS LEFT  <*)))><\n\n" +
      "The day is bright and the sun smiles upon you, warming your very \n" +
      "soul! There are bubbles and flotsam on the surface of the water. \n" +
      "They look like treasure. You feel like a rich man! \n",
      
      "              ><(((*>  10 TURNS LEFT  <*)))><\n\n" +
      "Baby crabs emerge from holes in the cold wet sand. They scurry by \n" +
      "you on the dock and taunt you with tiny claws for a moment before \n" +
      "returning underground. They are kind of cute, you think. \n",
      
      "              ><(((*>  9 TURNS LEFT  <*)))><\n\n" +
      "You lose your shadow as the sun approaches its zenith. You are \n" +
      "reminded of a certain truth: even the sun at it's highest point \n" +
      "must descend. But it's lowest point must rise again. Likewise, \n" +
      "you hope that an empty cooler becomes full again. \n",
      
      "              ><(((*>  8 TURNS LEFT  <*)))><\n\n" +
      "Humble fisherman, you feel as if no day is the same by the \n" +
      "infinite ocean. Each moment like a grain of sand, beautiful as \n" +
      "each seashell you find. From your spot on the wooden dock you see \n" +
      "a horizon with no end. \n",
      
      "              ><(((*>  7 TURNS LEFT  <*)))><\n\n" +
      "Time seems to slow down by the ocean. You can’t tell whether the \n" +
      "tide is coming or going. The afternoon sun has warmed the air and \n" +
      "sweat has formed on your brow. You dream of a young coconut with \n" +
      "a straw through it... \n",
       
      "              ><(((*>  6 TURNS LEFT  <*)))><\n\n" +
      "Somebody seems to be playing a song on a ukulele somewhere, maybe \n" +
      "you are dreaming. It sounds like \"Beyond the Sea\"! My lover \n" +
      "stands on golden sands... and watches the ships... that go \n" +
      "sailing... \n",
      
      "              ><(((*>  5 TURNS LEFT  <*)))><\n\n" +
      "The sun is falling softly in the sky, and the ocean will catch it \n" +
      "and swallow it whole. Clouds roll overhead and turn into familiar \n" +
      "shapes. When you see their reflections on the surface of the \n" +
      "ocean, they all look like big fluffy white fish! \n",
      
      "              ><(((*>  4 TURNS LEFT  <*)))><\n\n" +
      "The silhouette of the moon has become visible, still misty in the \n" +
      "weakening light. The tide is beginning to recede. It carries with \n" +
      "it what it will: jetsam, driftwood, seaweed and memories... \n" +
      "apparently some guy’s sandal. \n",
      
      "              ><(((*>  3 TURNS LEFT  <*)))><\n\n" +
      "The sun is hanging low above the ocean. If you had a boat, you \n" +
      "could sail to the horizon and touch it with your fishing pole. \n" +
      "The first star has appeared. You give it a name and remember your \n" +
      "first love. The sound of the ocean is making you feel sleepy. \n",
      
      "              ><(((*>  2 TURNS LEFT  <*)))><\n\n" +
      "The last of the day holds on with all its might. The tide \n" +
      "continues to fade, there is only a little bit of ocean beneath \n" +
      "the dock. Far away, a lighthouse has been lit for struggling \n" +
      "sailors. \n",
      
      "              ><(((*>  FINAL TURN  <*)))><\n\n" +
      "The last of the sun has disappeared below the ocean. Evening has \n" +
      "settled. A stone tossed into the water reveals bioluminescence, \n" +
      "the gently glow of life within the water. The tide is just about \n" +
      "out. You have time to cast one more line. \n"
      };
      
   private String menu = "[1] CAST LINE  [2] CHECK COOLER  [3] STORE  [0] EXIT\n"
      + ">>  What would you like to do? ";
      
   private String firstImg = "\n\n\n\n" +
      "                                          |                                        \n" + 
      "                                        \\ _ /                                     \n" +
      "                                      -= (_) =-                                    \n" +
      "     .\\/.                               /   \\                                    \n" +
      "  .\\\\//o\\\\                      ,\\/.      |              ,~                   \n" +
      "  //o\\\\|,\\/.   ,.,.,   ,\\/.  ,\\//o\\\\                     |\\                \n" +
      "    |  |//o\\  /###/#\\  //o\\  /o\\\\|                      /| \\                 \n" +
      "  ^^|^^|^~|^^^|' '|:|^^^|^^^^^|^^|^^^\"\"\"\"\"\"\"\"(\"~~~~~~~~/_|__\\~~~~~~~~~~  \n" +
      "   .|'' . |  '''\"\"'\"''. |`===`|''  '\"\" \"\" \" (\" ~~~~ ~ ~======~~  ~~ ~     \n" +
      "   jgs^^   ^^^ ^ ^^^ ^^^^ ^^^ ^^ ^^ \"\" \"\"\"( \" ~~~~~~ ~~~~~  ~~~ ~            \n" ;
      //  from  http://www.chris.com/ascii/joan/www.geocities.com/SoHo/7373/nature.html
            
   private String lastImg1 = "\n\n" +
      "                              |                               \n" +
      "                          \\       /                          \n" +
      "                            .-'-.                             \n" +
      "                       --  /     \\  --                       \n" +
      "      `~~^~^~^~^~^~^~^~^~^-=======-~^~^~^~~^~^~^~^~^~^~^~`    \n" +
      "      `~^_~^~^~-~^_~^~^_~-=========- -~^~^~^-~^~^_~^~^~^~`    \n" +
      "      `~^~-~~^~^~-^~^_~^~~ -=====- ~^~^~-~^~_~^~^~~^~-~^~`    \n" +
      "      `jgs^~-~^~~^~-~^~~-~^~^~-~^~~^-~^~^~^-~^~^~^~^~~^~-`    \n" ;
      //  from  http://www.chris.com/ascii/joan/www.geocities.com/SoHo/7373/nature.html
   
   private String lastImg2 = "\n\n" + 
      "              *      .         .                   .                            \n" +
      "      .                                      *         .         *              \n" +
      "                        *            *           .-.                            \n" +
      "          *        *         .                  ( (       *                     \n" +
      "                      .                   *      '-'                            \n" +
      "    ,\\//,.\\//\\/.         ,\\/,   ,\\/.//,                       .            \n" +
      "    //o\\\\/o//o\\\\ ,.,.,   //o\\   /o\\\\o\\\\         *     .                \n" +
      "      |   |  |  /###/#\\    |     |  |      .                 *                 \n" +
      "      |   |  |  |' '|:|    |`=.='|  |                                           \n" +
      "  jgs^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\"\"\"\"\"\"\"\"\"\"~~~~~~~~~~~~~~~~~~  \n" ;
      //  from  http://www.chris.com/ascii/joan/www.geocities.com/SoHo/7373/nature.html

   private String lastImg3 = "\n\n" +
      "                      .--.-.                                        \n" +
      "                     ( (    )__                                     \n" +
      "      ^^            (_,  \\ ) ,_)                                   \n" +
      "          ^^          '-'--`--'             |                       \n" +
      "                                        \\       /                  \n" +
      "                 ~,                       .-'-.                     \n" +
      "                 /|                  --  /     \\  --               \n" +
      "     ~^~`^~^`^~ / |\\ ~^~~^~``~~^~~^^~^~^-=======-~^~^~^~~^~~^~^~   \n" +
      "    ~^~ ~^~ ^~ /__|_\\~^~ ~^~^~^~_~^~^_~-=========- -~^~^~^^~^_~    \n" +
      "   ~^~ ~^~^ ~ '======' `~^-~~^~-^~^_~^~~ -=====- ~^~^~-~^~^~^~~^~   \n" +
      "   jgs  ~^~ ~^ ~^~ ~^~^ ~^~-~^~~^~-~^~~-~^~^~-~^~~^-~^~^~^-~^~^~^~  \n" +
      "  ~^~ ~^~ ~^~ ~^ ~^~ ~^~^ ~^~-~^~~^~-~^~~-~^~^~-~^~~^-~^~^~^-~^~^~^~\n";
      //  from  http://www.chris.com/ascii/joan/www.geocities.com/SoHo/7373/nature.html
      
   private String magicFishAscii = "\n\n" +
         "                               __,                \n" +
         "                        .-'_-'`                   \n" +
         "                      .' {`                       \n" +
         "                  .-'````'-.    .-'``'.           \n" +
         "                .'(0)       '._/ _.-.  `\\        \n" +
         "               }     '. ))    _<`    )`  |        \n" +
         "                `-.,\\'.\\_,.-\\` \\`---; .' /    \n" +
         "                     )  )       '-.  '--:         \n" +
         "                    ( ' (          ) '.  \\       \n" +
         "                     '.  )      .'(   /   )       \n" +
         "                       )/      (   '.    /        \n" +
         "                                '._( ) .'         \n" +
         "                             jgs    ( (           \n" +
         "                                     `-.          \n" ;
         //  from  http://www.ascii-art.de/ascii/def/fish.txt

   public void introduction(int thread) throws InterruptedException {
      System.out.print(firstImg);
      String[] introStrings = {
         "       -= most humble fisherman who lives by the sea =-  \n",
         "                by tenzin, punamai, and patrick  \n\n",
         "   (The object of the game is to catch enough fish to buy a boat.)\n\n",
         "                    peaceful, tranquil fish\n",
         "                     flying in my garden sky\n",
         "                      I find myself here...\n\n"
      };
      for (String el : introStrings) {
         Thread.sleep(thread);
         System.out.print(el);
      }
      return;
   }
   
   public void getTurnString(int turnCounter) {
      System.out.print(turnDescriptors[turnCounter]);
      return;
   }
   
   public void showMenu() {
      System.out.print(menu);
      return;
   }
   
   // NO LUCK ENDING (not enough money to buy a boat)
   public void ending1(int thread) throws InterruptedException {
      String[] noLuckEnding = {
         "Humble fisherman,"," the day is now over.\n",
         "The night sky twinkles with the stars of many wishes.\n",
         "Some wishes are granted,",
         " some are saved for another time.\n",
         "This day belonged to the fish of the ocean it seems.\n", "\n"
      };
      for (String el : noLuckEnding) {
         Thread.sleep(thread);
         System.out.print(el);
      }
      System.out.println(lastImg2);
      Thread.sleep(thread * 2);
      System.out.println("  -= Perhaps tomorrow will bring a different kind "
         + "of fortune? =-"); 
      return;
   }
   
   // BOAT ENDING
   public void ending2(int thread) throws InterruptedException {
      String[] boatEnding = {
         "\nCongratulations!\n",
         "You were able to buy the beautiful boat of your dreams!\n",
         "You spend the rest of your days sailing off in big adventures,\n",
         "with gratitude for your great food fortune!",
         "\n",
         "\n",
         "Still...",
         " you often find yourself wondering about the mysteries of ocean.\n",
         "Perhaps there was something you overlooked?\n", 
         "\n"
      };
      
      Thread.sleep(thread * 2);
      System.out.println(lastImg3);
      for (String el : boatEnding) {
         Thread.sleep(thread);
         System.out.print(el);
      }
      return;
   }   
   
   // LURE ENDING
   public void ending3(int thread) throws InterruptedException {         
      String[] lureEnding1 = {
         "\nYou caught a MAGICAL TALKING FISH!\n",
         "It must be worth a fortune!\n",
         "\"Noble fisherman,\" the fish says in a deep voice.\n",
         "\"Only the chosen few may catch me.\"\n",
         "Tell me, \n", 
         "\n        what of this fish \n",
         "        would you wish? \n\n"
      };
      System.out.print(magicFishAscii);
      for (String el : lureEnding1) {
         Thread.sleep(thread);
         System.out.print(el);
      }
      Thread.sleep(thread * 3);
      System.out.print("You: I wish ... ");
      userWish = input.nextLine();
      wish = true;
      
      System.out.println();
      Thread.sleep(thread * 2);
      System.out.println("Hmm...");
      Thread.sleep(thread * 2);
      String[] lureEnding2 = {
         "We shall see...\n",         
         "But for now what I will grant you is this: \n",
         "You will grow to be very old,",
         " and very wise \n",
         "You will neither be rich",
         " nor poor. \n",
         "You will continue to work hard",
         " and be humble \n",
         "but you will be happy",
         " knowing the secret things", " of the deep. \n",
         "The ocean gives what it will.\n",
         "If you release me,",
         " it will be done.\n", "\n"
      };
      for (String el : lureEnding2) {
         Thread.sleep(thread);
         System.out.print(el);
      }
      System.out.print("Release this magical fish into the ocean (y/n)? ");
      String releaseFish = input.nextLine();
      boolean release = true;
      switch (releaseFish) {
         case "Y":
         case "y":
            break;
         case "N":
         case "n":
            release = false;
            break;
         default:
            System.out.print("y/n? ");
      }
      if (release) {
         System.out.println();
         System.out.println(lastImg1);
         String[] releasedStrings = {
            "\nYou release the magical fish into the ocean.\n",
            "You sit on the dock in awe, wondering at fish’s words.\n",
            "You look out at the ocean, take in it’s infinite majesty, pack " +
            "your\n" + "things and walk back to the village.\n",
            "Who knows what the ocean may bring?\n","\n",
            "\"Eternity begins and ends with the ocean tides.\"\n -Unknown\n\n"
         };
         for (String el : releasedStrings) {
            Thread.sleep(thread);
            System.out.print(el);
         }
         return;
      }
      else {
         String[] keptStrings = {
            "\n\"So be it.\"\n\n",
            "Suddenly a massive wave erupts from the ocean and envelopes you,\n",
            "the dock,"," the whole village,"," and everything with it.\n",
            "The whole world seems vanish as the ocean washes away everything \n" +
            "you ever knew.\n", "\n", 
            "The sea, once it casts its spell, holds one in its net of wonder\n", 
            "                                                   forever.\n",
            " -Jacques Cousteau\n\n"
         };
         for (String el : keptStrings) {
            Thread.sleep(thread);
            System.out.print(el);
         }
         System.out.print(lastImg1 + "\n\n");
         return;
      }
   }
   
   public boolean getWish() {
      return wish;
   }
   
   public void getUserWish() {
      System.out.print("Your wish: I wish " + userWish +
         "\nHope it comes true!");
      return;
   }
}