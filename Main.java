import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
  private static ArrayList <Tournament> tourneys = new ArrayList<Tournament>();
  private static Scanner scan = new Scanner(System.in);
  
  public static void main(String str[])
  {
    System.out.println("Welcome to TourneyRank v0.1");
    mainMenuInterface();
  }
  
  private static void mainMenuInterface()
  {
    viewMenu1();
    
    int numInput = scan.nextInt();
    while(!(numInput > 0 && numInput < 5))
    {
      System.out.println("ERROR:INVALID CHOICE");
      viewMenu1();
      numInput = scan.nextInt();
    }
    if(numInput == 1)
    {
      inputTournament();
    }else if(numInput == 2){
      viewResults();
    }else if(numInput == 3){
      viewPlayer();
    }else{
      fullRanking();
    }
    scan.nextLine();
  }
  
  private static void viewMenu1()
  {
    System.out.println("Enter the number for what you would like to do:");
    System.out.println("1: Input a Tournament");
    System.out.println("2: View a Tournament's Results");
    System.out.println("3: View a Player's Ranking");
    System.out.println("4: View Full Ranking for a Game");
  }
  
  private static void inputTournament()
  {
    //Input Tournament
    String name;
    String game;
    int numTop;
    ArrayList <String> placings = new ArrayList<String>();
    
    System.out.println("1: Melee Tournament");
    System.out.println("2: Smash 4 Tournament");
    int numInput = scan.nextInt();
    scan.nextLine();
    while(numInput < 1 || numInput > 2)
    {
      System.out.println("ERROR:INVALID CHOICE");
      System.out.println("1: Melee Tournament");
      System.out.println("2: Smash 4 Tournament");
      numInput = scan.nextInt();
    }
    if(numInput == 1)
      game = "melee";
    else
      game = "smash4";
    
    System.out.println("What's the tournament called?");
      name = scan.nextLine();
    System.out.println("How many of the game’s top 10 players entered the tournament?");
    numTop = scan.nextInt();
    System.out.println("Enter 8 to 32 players in order. Enter “stop” to stop.");
    String sInput;
    int count = 0;
    while(count < 32)
    {
      while(count < 8)
      {
        sInput = scan.nextLine();
        if(!sInput.toLowerCase().equals("stop"))
        {
          placings.add(sInput);
          count++;
        }else{
          System.out.println("You must enter at least 8 players.");
        }
      }
      sInput = scan.nextLine();
      if(!sInput.toLowerCase().equals("stop"))
      {
        placings.add(sInput);
        count++;
      }else
        break;
    }
    
    tourneys.add(new Tournament(name, game, numTop, placings));
    System.out.println("Tournament successfully added. Press enter to return to the main menu.");
    scan.nextLine();
    mainMenuInterface();
  }
  
  private static void viewResults()
  {
    //View Results
    System.out.println("What's the tournament called?");
    String sInput = scan.nextLine();
    findTourney(sInput).viewResults();
    System.out.println("\nPress enter to return to the main menu.");
    scan.nextLine();
    mainMenuInterface();
  }
  
  private static void viewPlayer()
  {
    //View Player Ranking
    System.out.println("What's the player's tag?");
    String sInput = scan.nextLine();
    for(MeleePlayer mplayer : MeleeRanking.rank)
    {
      if(mplayer.getName().equals(sInput))
      {
        System.out.println("Name: " + mplayer.getName());
        System.out.println("Melee Rank: " + MeleeRanking.indexOf(mplayer.getName()));
      }else{
        System.out.println("No melee players found with the name '" + mplayer.getName() + "'");
      }
    }
    System.out.println();
    for(Smash4Player s4player : Smash4Ranking.rank)
    {
      if(s4player.getName().equals(sInput))
      {
        System.out.println("Name: " + s4player.getName());
        System.out.println("Smash 4 Rank: " + Smash4Ranking.indexOf(s4player.getName()));
      }else{
        System.out.println("No smash 4 players found with the name '" + s4player.getName() + "'");
      }
    }
    System.out.println("\nPress enter to return to the main menu.");
    scan.nextLine();
    mainMenuInterface();
  }
  
  private static void fullRanking()
  {
    //View Full Ranking
    System.out.println("1: Melee Ranking");
    System.out.println("2: Smash 4 Ranking");
    int numInput = scan.nextInt();
    while(numInput < 1 || numInput > 2)
    {
      System.out.println("ERROR:INVALID CHOICE");
      System.out.println("1: Melee Ranking");
      System.out.println("2: Smash 4 Ranking");
      numInput = scan.nextInt();
    }
    if(numInput == 1)
      MeleeRanking.viewRanking();
    else
      Smash4Ranking.viewRanking();
    System.out.println("\nPress enter to return to the main menu.");
    scan.nextLine();
    mainMenuInterface();
  }
  
  private static Tournament findTourney(String inputName)
  {
    for(Tournament tourney : tourneys)
    {
      if(tourney.getName().equals(inputName))
        return tourney;
    }
    return null;
  }
}