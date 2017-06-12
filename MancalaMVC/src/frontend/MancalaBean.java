package frontend;

import java.util.ArrayList;
import backend.*;


public class MancalaBean {
	
	public MancalaBean() {
		
	}
	private int currentTurn = 0;
	
    private Mancala mancala = new Mancala(4);
    private String winningPlayer = mancala.getWinningPlayer();
    ArrayList<Integer> stones = mancala.getStones();
    private int numberOfWinningStones = mancala.getNumberOfWinningStones();
    
	public MancalaBean(ArrayList <Integer> stones, int currentTurn, String winningPlayer, int numberOfWinningStones) {
		this.stones = stones;
		this.currentTurn = currentTurn;
		this.winningPlayer = winningPlayer;
		this.numberOfWinningStones = numberOfWinningStones;
	}
	
	
    
    public ArrayList<Integer> getStones() {
        return this.stones;
    }
    
    public int getCurrentTurn() {
    	return currentTurn;
    }
    
    public String getWinningPlayer() {
    	return winningPlayer;
    }
    public int getNumberOfWinningStones() {
    	return numberOfWinningStones;
    }

    
    public Mancala getMancala() {
    	return this.mancala;
    }
    public MancalaBean(Mancala mancala) {
    	this.mancala = mancala;
    }

    
}