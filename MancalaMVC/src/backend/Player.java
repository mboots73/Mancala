package backend;

 class Player {
    Player opponent;
    boolean isTurn = false;

     Player() {
        this.opponent = new Player(this);
        this.isTurn = true;
    }
    private Player(Player player) {
        this.opponent = player;
    }

     boolean getIsTurn(){
        return isTurn;
    }

     void startTurn() {
        isTurn = true;
    }
     void endTurn() {
        isTurn = false;

    }
     Player getOpponent(){
        return this.opponent;
    }



  





}
