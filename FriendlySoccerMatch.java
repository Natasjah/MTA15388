package Lecture01;

import java.util.Random;
import java.util.Scanner;

public class FriendlySoccerMatch {

	public String getResultText(Team team1, Team team2) { //This line will print the results
		return "The friendly game ends with		\n\n"+team1.getName()+" - "+ team2.getName() +" "+team1.getPoints()+":"+team2.getPoints()+".";
	}

	public void startGame(Team t1, Team t2){

		// now the game can begin; we have to create for the 
		// 90 minutes + extra time the different actions 
		Random r = new Random();
		boolean gameruns = true;
		int gameduration = 90 + r.nextInt(5);
		int time = 1;
		int nextAction = 0;
		
		// while the game runs, goals can be scored
		while (gameruns){
			nextAction = r.nextInt(15)+1;
			// Is the game over?
			if ((time + nextAction > gameduration) || (time > gameduration)){
				gameruns = false;
				break;
			}
			
			//*******************************************
			// A new action can take place ...
			time = time + nextAction;
		
			// randomly choose a player for next shot
			int shooter = r.nextInt(10);
			if (whichTeamShoots(t1, t2)){ //Choose which team they are from
				Player p = t1.getPlayers()[shooter];
				Keeper k = t2.getKeeper();
				int shot = p.shootsOnGoal();
				
				// check if shot is saved
				boolean goal = !k.saveShot(shot);
				
				PrintOutGameStatus(time, t1, t2, p, goal);
				
			} // IF 
			else{
				Player p = t2.getPlayers()[shooter];
				Keeper k = t1.getKeeper();
				int shot = p.shootsOnGoal();
				boolean goal = !k.saveShot(shot);
				
				PrintOutGameStatus(time, t2, t1, p, goal); //Prints what happens at a random minute in a time interval of 15 minutes
				
			} // else 
		} //WHILE
	}
	
	// influence of motivation on strength:
	private float getStrengthTeam(Team team) { 
		return (team.getStrength()/2.0f) + ((team.getStrength()/2.0f)*(team.getMotivation()/10.0f)); 
	}
	
	// influence of trainer on strength:
	private float getInfluenceOfTrainer(Team team) {
		Random r = new Random();
		int deviation = r.nextInt(2);
				
		if (getStrengthTeam(team) > team.getTrainer().getExperience())
			deviation = -deviation;
		return Math.max(1, Math.min(10, getStrengthTeam(team) + deviation));
	}
	
	//Which team is shooting
	private boolean whichTeamShoots(Team team1, Team team2) {
		Random r = new Random();
		return (r.nextInt(Math.round(getInfluenceOfTrainer(team1)+getInfluenceOfTrainer(team2)))-getInfluenceOfTrainer(team1))<=0;
	}
	
	private void PrintOutGameStatus(int time, Team team1, Team team2, Player player, boolean goal) { //The status of the game
	
		System.out.println();
		System.out.println(time+".Minute: ");
		System.out.println(" Chance for "+team1.getName()+" ...");
		System.out.println(" "+player.getName()+" shoots");
		if (goal) {
			team1.addPoints();
			player.addGoal();
			System.out.println(HomeTeamGoal() + " " + team1.getPoints()+":" + team2.getPoints() + " " + player.getName() + "("+player.getGoals()+")");
			changePlayer(team2);
		} 
		else {
			System.out.println(" " + team2.getKeeper().getName() + " " + KeeperSave());
		}
	
	}
	
	private static String HomeTeamGoal(){
		String[] goal = new String[7];
		
		goal[0] = "Goal!!!";
		goal[1] = "Gooooal";
		goal[2] = "He shoots!... He scores!!!";
		goal[3] = "Jubiii";
		goal[4] = "We are winning!";
		goal[5] = "We are the champions";
		goal[6] = "Yes!";
		
		Random r = new Random();
		int goalHomeTeam = r.nextInt(6);
		
		return goal[goalHomeTeam];
	}
	
	private static String KeeperSave() {
		String[] save = new String[5];
				
		save[0] = "He shoots!... and he saves.";
		save[1] = "Hej";
		save[2] = "Pipaluuuuuk!!! Is winning!";
		save[3] = "..";
		save[4] = "Saves briliantly!";
		
		Random r = new Random();
		int keeperSaves = r.nextInt(4);
		
		return save[keeperSaves];
	}
	
	private void changePlayer(Team team) {
		Scanner sc = new Scanner(System.in);
		String userAnswer;
		String swapIn;
		String swapOut;
		int in,out;
		System.out.println("Do you want to replace a player?");
		userAnswer = sc.nextLine();
		if(userAnswer.equals("yes")) {
			System.out.println("Which player do you want to replace?");
			swapOut = sc.nextLine();
			System.out.println("Which player do you want to swap in?");
			swapIn = sc.nextLine();
			in = Integer.parseInt(swapIn);
			out = Integer.parseInt(swapOut);
			team.changePlayer(in, out);
		}
			
		
	}
	
}

