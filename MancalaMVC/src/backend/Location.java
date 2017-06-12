package backend;

public class Location {

	int numberOfStones;
	Location nextLocation;
	Player player;

	Location() {

	}

	Location(int numberOfStones, int leftOverFields, Location firstField, Player player) {
		this.player = player;
		if (leftOverFields < 13 && leftOverFields > 8) {
			this.nextLocation = new Field(numberOfStones, leftOverFields - 1, firstField, player);
		} else if (leftOverFields == 8) {
			this.nextLocation = new Kalaha(numberOfStones, leftOverFields - 1, firstField, player);
		} else if (leftOverFields == 7) {
			this.nextLocation = new Field(numberOfStones, leftOverFields - 1, firstField, player.getOpponent());
		} else if (leftOverFields > 1 && leftOverFields < 7) {
			this.nextLocation = new Field(numberOfStones, leftOverFields - 1, firstField, player);
		} else if (leftOverFields == 1) {
			this.nextLocation = new Kalaha(numberOfStones, leftOverFields - 1, firstField, player);
		} else {
			this.nextLocation = firstField;
		}
	}

	protected void increase() {
		numberOfStones = numberOfStones + 1;
	}

	public Location getNextLocation() {
		return this.nextLocation;
	}

	public void continueMove(int movesToGo) {
		if (movesToGo > 0) {
			this.increase();
			getNextLocation().continueMove(movesToGo - 1);
		} 
		
		else {
			this.player.startTurn();
			
		}

	}

	

	boolean isLastInMove(int movesToGo) {
		if (movesToGo == 1) {
			return true;
		} else
			return false;
	}

	
	boolean isPlayable() {
		if (this.getPlayer().getIsTurn() && this instanceof Field && getStones() > 0) {
			
					return true;
		}
		return false;

	}
	
	
	void addStones(int stealedStones) {
     numberOfStones = numberOfStones + stealedStones;
    }
	


	public Player getPlayer() {
		return this.player;
	}

	public int getStones() {
		return this.numberOfStones;
	}

	public Location getKalaha() {
		return nextLocation.getKalaha();

	}

	public Location getOpposite() {
		return this.getNextLocation().getOpposite().getNextLocation();

	}

	Location getXLocation(int n) {
		if (n == 0) {
			return this;
		}
		return this.getNextLocation().getXLocation(n - 1);
	}

}
