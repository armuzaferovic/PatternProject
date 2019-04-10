package model;

import java.util.ArrayList;
import java.util.Random;

public class Spiel{
    private States state;
    private ArrayList<Observer> obser = new ArrayList<Observer>();
	private Random r;
	private int winPer = setWinper(r);
	private int losesToGetFired = losses(r);
	private double randomChance = setRandom(r);
	private int dubs;
	private int lossStreak ;
	private int gamesplayed;

    public int getGamesplayed() {
        return gamesplayed;
    }

    public void setGamesplayed(int gamesplayed) {
        this.gamesplayed = gamesplayed;
    }

    public int getDubs() {
		return dubs;
	}

    public int getLossStreak() {
        return lossStreak;
    }

    public void setLossStreak(int lossStreak) {
        this.lossStreak = lossStreak;
    }

    public void setDubs(int dubs) {
		this.dubs = dubs;
	}

	public Random getR() {
		return r;
	}

	public void setR(Random r) {
		this.r = r;
	}

	public int getWinPer() {
		return winPer;
	}

	public int getLosesToGetFired() {
		return losesToGetFired;
	}

	public double getRandomChance() {
		return randomChance;
	}

	private static Spiel instance;
    
    /** Don't let anyone else instantiate this class */
    private Spiel() {}

    /** Lazily create the instance when it is accessed for the first time */
    public static synchronized Spiel getInstance() {
        if(instance == null) {
            instance = new Spiel();
        }
        return instance;
    }
    private int setWinper(Random x) {
    	
        int max = 50; 
        int min = 20; 
        int range = max - min + 1; 
  
        // generate random numbers within 1 to 10 
       
            int rand = (int)(Math.random() * range) + min; 
  
            // Output is different everytime this code is executed 
            return rand;
    
    }
    public int getWin(){
       return this.winPer;
    }
    public void setWin1(int x){
        this.winPer=x;
    }
    private int losses(Random x) {
	
    int max = 9; 
    int min = 5; 
    int range = max - min + 1; 

    // generate random numbers within 1 to 10 
   
        int rand = (int)(Math.random() * range) + min; 

        // Output is different everytime this code is executed 
        return rand;

}
    
    private int setRandom(Random x) {
    	
        int max = 5; 
        int min = 1; 
        int range = max - min + 1; 
  
        // generate random numbers within 1 to 10 
       
            int rand = (int)(Math.random() * range) + min; 
  
            // Output is different everytime this code is executed 
            return rand;
    
    }
    public void attach(Observer o){
        obser.add(o);
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    public void notifyAllObservers(){
        for(Observer o : obser){
            o.update();
        }
    }
}
