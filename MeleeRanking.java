import java.util.ArrayList;

public class MeleeRanking
{
   protected static ArrayList <MeleePlayer> rank = new ArrayList<MeleePlayer>();
  
   //Adds new player
   public static void newPlayer (MeleePlayer x)
   {
    rank.add(x);
   }
   
   //Prints all of ranking 
   public static void viewRanking()
   {
     for(int i = 1; i <= rank.size(); i++){
       System.out.println(i+". "+ rank.get(i-1));
     }
   }
   
   //Compares the scores of two players and returns a value based on their placings
   //If a > b == 1
   //If a < b == -1
   //if a = b == 0
   public static int compareTo(MeleePlayer a, MeleePlayer b)
   {
     if(a.getScore() - b.getScore()>0){
       return 1;
     }else if (a.getScore() - b.getScore()<0){
       return -1;
     }else{
       return 0;
     }
       
   }
     
   //Finds player in ranking based on their tag
   public static int indexOf(String n)
   {
     for(int i = 0; i < rank.size(); i++){
       if(rank.get(i).getName().equals(n))
         return i;
     }
     return -1;
   }
   
   //Returns a player at a particular location
   public static MeleePlayer playerAt(int n)
   {
     return rank.get(n);
   }
   
   public static void changeScore(int loc, int p)
   {
     MeleePlayer temp = rank.get(loc);
     temp.addScore(p);
     rank.set(loc, temp);
   }
   
   public static void adjustRanking()
   {
     MeleePlayer temp;
     for(int k = 0; k < 32;k++){
       for(int i = 0; i < rank.size()-1;i++){
         if(MeleeRanking.compareTo(rank.get(i), rank.get(i+1)) < 0){
           temp=rank.get(i);
           rank.set(i, rank.get(i+1));
           rank.set(i+1, temp);
         }
        }
      }
   }
   
   
   
   
   
   
   
   

     
}