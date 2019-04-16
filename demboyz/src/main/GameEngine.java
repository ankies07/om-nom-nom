import GameModel.*;
import GameModel.entities.*;
//import GameModel.Direction;


public class GameEngine {
    private GameWorld world;
    private Pacman[] players;

    public GameEngine(GameWorld world, Pacman[] players) {
        this.world = world;
        this.players = players;
    }

    public void doGameLoop() {
        for (int i = 0; i < players.length; i++) {
            this.makePlayerMove(players[i]);
        }
    }

    public void makePlayerMove(Pacman player) {
        boolean succesfulMove = false;

        while (!succesfulMove) {
            Direction move = player.makeMove();
            Vertex newPosition = this.calculateNewPlayerPosition(move, player.getPosition());
            if (world.checkMoveValid(newPosition)) {
                world.updatePlayerPosition(player.getPosition(), newPosition);
                player.updatePosition(newPosition);
                succesfulMove = true;
            }
        }
    }

    private Vertex calculateNewPlayerPosition(Direction move, Vertex coords) {
        switch (move){
            case UP:
                return new Vertex(coords.getX() - 1, coords.getY());
            case DOWN:
                return new Vertex(coords.getX() + 1, coords.getY());
            case LEFT:
                return new Vertex(coords.getX(), coords.getY() - 1);
            case RIGHT:
                return new Vertex(coords.getX(), coords.getY() + 1 );
            default:
                throw new IllegalStateException("Unexpected value: " + move);
        }
    }
}
