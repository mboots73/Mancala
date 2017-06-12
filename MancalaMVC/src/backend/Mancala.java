package backend;

import java.util.ArrayList;

public class Mancala {
	public Field field;

	public Mancala() {
		this(4);
	}

	public Mancala(int numberOfStones) {
		this.field = new Field(numberOfStones);
	}

	public void doMove(int fieldnumber) {

		Location toPlay = this.field.getXLocation((fieldnumber - 1) + (this.getCurrentTurn() * 7));

		if (toPlay instanceof Field) {
			((Field) toPlay).doMove();
		} else if (toPlay instanceof Kalaha) {
			System.out.println("You cannot play a Kalaha");
		} else {
			getWinningPlayer();
		}

	}

	public ArrayList<Integer> getStones() {
		ArrayList<Integer> stones = new ArrayList<Integer>();
		stones.add(this.field.getStones());
		Location next = this.field.getNextLocation();
		while (next != this.field) {
			stones.add(next.getStones());
			next = next.getNextLocation();
		}

		return stones;
	}

	public int getCurrentTurn() {
		if (this.field.getPlayer().getIsTurn() == true) {
			return 0;
		}
		return 1;
	}

	public String getWinningPlayer() {
		if (this.field.getNumberOfWinningStones() > ((Field) this.field.getKalaha().getNextLocation()).getNumberOfWinningStones()) {
			if (this.field.getPlayer().getIsTurn()) {
				return Winner.Self.toString();
				
			} else {
				return Winner.Other.toString();
			}
		} 
		else if (this.field.getNumberOfWinningStones() < ((Field) this.field.getKalaha().getNextLocation()).getNumberOfWinningStones()) {
			if (this.field.getPlayer().getIsTurn()) {
				return Winner.Self.toString();

			} 
			else {
				return Winner.Other.toString();

			}
		}

		else
			
			return Winner.Draw.toString();

	}

	public int getNumberOfWinningStones() {
		return this.field.getNumberOfWinningStones();
	}

}
