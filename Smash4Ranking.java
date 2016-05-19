import java.util.ArrayList;

public class Smash4Ranking
{
  protected static ArrayList <Smash4Player> rank = new ArrayList<Smash4Player>();
  
  
   //Adds new player
   public static void newPlayer (Smash4Player x)
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
   public static int compareTo(Smash4Player a, Smash4Player b)
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
   public static Smash4Player playerAt(int n)
   {
     return rank.get(n);
   }
   
   public static void changeScore(int loc, int p)
   {
     Smash4Player temp = rank.get(loc);
     temp.addScore(p);
     rank.set(loc, temp);
   }
   
   public static void adjustRanking()
   {
     Smash4Player temp;
     for(int k = 0; k < 32;k++){
       for(int i = 0; i < rank.size()-1;i++){
         if(Smash4Ranking.compareTo(rank.get(i), rank.get(i+1)) < 0){
           temp=rank.get(i);
           rank.set(i, rank.get(i+1));
           rank.set(i+1, temp);
         }
        }
      }
   }

   
}