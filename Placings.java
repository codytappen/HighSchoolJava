import java.util.ArrayList;

public class Placings
{
  private ArrayList <MeleePlayer> meleePlacings = new ArrayList<MeleePlayer>();
  private ArrayList <Smash4Player> smash4Placings = new ArrayList<Smash4Player>();
  
  //Translates list of strings into numbered placings based on game and assigns points to a player
  // 
  public Placings(ArrayList <String> n, String g, int ti)
  {
    if(g.equals("melee")){
      
    for(int i = 0; i < n.size();i++)
    {
      int temp = MeleeRanking.indexOf(n.get(i));
      if(temp>-1){
        meleePlacings.add(MeleeRanking.playerAt(temp));
        MeleeRanking.changeScore(temp, this.points(ti,i+1));
      }else{
        MeleePlayer t = new MeleePlayer(n.get(i), this.points(ti,i+1));
        MeleeRanking.newPlayer(t);
        meleePlacings.add(t);
      }
    }
    }else if(g.equals("smash4")){
      
          for(int i = 0; i < n.size();i++)
    {
      int temp = Smash4Ranking.rank.indexOf(n.get(i));
      if(temp>-1){
        smash4Placings.add(Smash4Ranking.playerAt(temp));
        Smash4Ranking.changeScore(temp, this.points(ti,i+1));
      }else{
        Smash4Player t = new Smash4Player(n.get(i), this.points(ti,i+1));
        Smash4Ranking.newPlayer(t);
        smash4Placings.add(t);
      }
    }
    }   
    
  }
  
  public int points(int ti, int i)
  {
    if(i == 1)
      return 10;
    else if(i == 2)
      return 9;
    else if(i == 3)
      return 8;
    else if(i == 4)
      return 7;
    else if(i > 4 && i < 7)//5
      return 6;
    else if(i > 6 && i < 9)//7
      return 5;
    else if(i > 8 && i < 13)//9
      return 4;
    else if(i > 12 && i < 17)//13
      return 3;
    else if(i > 16 && i < 25)//17
      return 2;
    else//25
      return 1;

  }
  //Returns strings for placing with numbers before them (also checks game)    
  public void printPlacings(String g)
  {
    if(g.equals("melee")){
    for(int i = 1; i <= meleePlacings.size(); i++){
      
    if(i == 1)
      System.out.println("1. " + meleePlacings.get(i-1));
    else if(i == 2)
      System.out.println("2. " + meleePlacings.get(i-1));
    else if(i == 3)
      System.out.println("3. " + meleePlacings.get(i-1));
    else if(i == 4)
      System.out.println("4. " + meleePlacings.get(i-1));
    else if(i > 4 && i < 7)//5
      System.out.println("5. " + meleePlacings.get(i-1));
    else if(i > 6 && i < 9)//7
      System.out.println("7. " + meleePlacings.get(i-1));
    else if(i > 8 && i < 13)//9
      System.out.println("9. " + meleePlacings.get(i-1));
    else if(i > 12 && i < 17)//13
      System.out.println("13. " + meleePlacings.get(i-1));
    else if(i > 16 && i < 25)//17
      System.out.println("17. " + meleePlacings.get(i-1));
    else//25
      System.out.println("25. " + meleePlacings.get(i-1));
     }
    
    }else if(g.equals("smash4")){
     for(int i = 1; i <= smash4Placings.size(); i++){
      
    if(i == 1)
      System.out.println("1. " + smash4Placings.get(i-1));
    else if(i == 2)
      System.out.println("2. " + smash4Placings.get(i-1));
    else if(i == 3)
      System.out.println("3. " + smash4Placings.get(i-1));
    else if(i == 4)
      System.out.println("4. " + smash4Placings.get(i-1));
    else if(i > 4 && i < 7)//5
      System.out.println("5. " + smash4Placings.get(i-1));
    else if(i > 6 && i < 9)//7
      System.out.println("7. " + smash4Placings.get(i-1));
    else if(i > 8 && i < 13)//9
      System.out.println("9. " + smash4Placings.get(i-1));
    else if(i > 12 && i < 17)//13
      System.out.println("13. " + smash4Placings.get(i-1));
    else if(i > 16 && i < 25)//17
      System.out.println("17. " + smash4Placings.get(i-1));
    else//25
      System.out.println("25. " + smash4Placings.get(i-1));
     }
    }
   }
  
  }
     