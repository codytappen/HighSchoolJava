public class Smash4Player
{

  private int score;
  private String name;
  private String main="unknown";

  
  public Smash4Player(String n, int s)
  {
    name=n;
    score=s;
  }

  public Smash4Player(String n, String m, int s)
  {
    name=n;
    score=s;
    main=m;
  }
  
  public int getScore()
  {
   return score; 
  }
  
  public String getName()
  {
   return name; 
  }
  
  public String getMain()
  {
   return main; 
  }
  
  public String toString()
  {
   return name; 
  }
  
  public void addScore(int n)
  {
    score+=n;
  }
}
  