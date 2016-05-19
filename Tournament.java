import java.util.ArrayList;

public class Tournament
{
  private int topPlayers;
  private String name;
  private int tier;
  private String game;
  private Placings place;

  
  //Creates and catagorizes a tournament
  //Creates a list of placings 
  //Adjust overall rankings based on results
  public Tournament(String n, String g, int numTop, ArrayList <String>placing)
  {
    name=n;
    topPlayers=numTop;
    game=g.toLowerCase();
    tier=Tier.calcTier(numTop, game);
    place= new Placings(placing, g, tier);
    
      
  }
  //Prints a tournament's placings
  public void viewResults()
  {
   place.printPlacings(game);
  }
  
  public void assignPoints()
  {
    
  }
   
  public String getName()
  {
   return name; 
  }
  
}
      
      
      
      
      
      
      
      
      
      