package backend;


public class Kalaha extends Location {


     Kalaha(int numberOfStones, int leftOverFields,Location firstField, Player player) {
        super( numberOfStones,  leftOverFields,  firstField,  player);
        this.numberOfStones = 0;
        }

        public void continueMove(int movesToGo) {

            if (this.player.isTurn ) {
                super.continueMove(movesToGo);
                if (isLastInMove(movesToGo)) {
                	this.player.startTurn();
                }
                else {
                	this.player.endTurn();
    				this.player.getOpponent().startTurn();
                }
            }
            else {
                getNextLocation().continueMove(movesToGo);

            }


        }

        public Location getKalaha() {
            return this;

        }

        public Location getOpposite() {
        return this;
         }

        
    }
