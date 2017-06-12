package backend;

public class Field extends Location {

	public Field(int numberOfStones) {
		super.numberOfStones = numberOfStones;
		this.player = new Player();
		this.nextLocation = new Field(numberOfStones, 12, this, player);

	}

	public Field(int numberOfStones, int leftOverFields, Location firstField, Player player) {
		super(numberOfStones, leftOverFields, firstField, player);
		this.numberOfStones = 4;
	}

	public void doMove() {
		Location firstField = this.getKalaha().getNextLocation().getKalaha().getNextLocation();
		checkIfPossibleMove(firstField);
			if (isPlayable()) {
				int movesToGo = getStones();
				empty();
				getNextLocation().continueMove(movesToGo);
			}
			else {
				this.player.endTurn();
				this.player.getOpponent().startTurn();
			}
		
		
	}

	public int getNumberOfWinningStones() {
		int numberOfWinningStones = 0;
		int kalahaStones = this.getKalaha().getStones();
		int totalStones = 0;
		totalStones = totalStones + this.getStones();
		Location next = this.getNextLocation();
		while (next instanceof Kalaha == false) {
			totalStones = totalStones + next.getStones();
			next = next.getNextLocation();
		}
		numberOfWinningStones = totalStones + kalahaStones;
		return numberOfWinningStones;

	}

	public void stealStones() {
		int stealedStones = this.getStones() + this.getOpposite().getStones();
		this.empty();
		getOpposite().numberOfStones = 0; 
		getKalaha().addStones(stealedStones);
	}

	public void continueMove(int movesToGo) {
		if (movesToGo > 1) {
			super.continueMove(movesToGo);
		}

		else if (movesToGo == 1) {
			if (wasZero() && this.getPlayer().getIsTurn() ) {
				this.increase();
				stealStones();
				this.player.endTurn();
				this.player.getOpponent().startTurn();
			} else {
				super.continueMove(movesToGo);
			}
			
		}
		else {
			super.continueMove(movesToGo);
		}
	}

	private void empty() {
		numberOfStones = 0;
	}

	public boolean checkIfPossibleMove(Location firstField) {

		if (firstField.getStones() != 0) {
			return true;

		} else if (firstField instanceof Kalaha) {
			return false;
		}

		else {
			return checkIfPossibleMove(firstField.getNextLocation());

		}

	}

	boolean wasZero() {
		if (numberOfStones > 0)
			return false;
		else
			return true;
	}

}
