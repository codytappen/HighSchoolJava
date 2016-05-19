public class Tier
{
  // For Tier
  // 3 = Super-Major
  // 2 = Major
  // 1 = Regional 
  
  
  //decides tier based on number of top players
  public static int calcTier(int t, String game)
    {
    
    int gametop=0;
    
    if(game.equals("melee")){
      gametop=10;
    }else if(game.equals("smash4")){
      gametop=15;
    }
    
    if(gametop == 10){
      if(t>=6)
        return 3;
      else if(t>=3)
        return 2;
      else if(t>=1)
        return 1;
    }else if(gametop == 15){
      if(t>=9)
        return 3;
      else if(t>=3)
        return 2;
      else if(t>=1)
        return 1;
    }
    
    return -1;
  }
  
  //names tier based on integer value of tier
  public static String tierName(int n)
  {
    if(n==3)
      return "Super-Major";
    if(n==2)
      return "Major";
    if(n==1)
      return "Regional";
    return "N/A";
  }
  
}
    