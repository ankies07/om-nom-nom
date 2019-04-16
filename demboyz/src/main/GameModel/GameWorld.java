package GameModel;

import java.util.Random;

public class GameWorld {
    private int[][] maze;
    private int size;

    public GameWorld(int size) {
        this.size = size - 1;
        this.generateMap();
    }

    private void generateMap() {
        this.initializeMaze();
        this.buildOuterWalls();
        this.carvePaths(new Vertex(2, 2), new Vertex(this.size - 2, this.size - 2));
        this.spawnPlayers();
        this.spawnFood();
    }

    private void initializeMaze() {
        this.maze = new int[this.size + 1][this.size + 1];
    }

    private void buildOuterWalls() {
        for (int i = 0; i <= this.size; i++) {
            this.maze[0][i] = 1;
            this.maze[i][0] = 1;
            this.maze[i][this.size] = 1;
            this.maze[this.size][i] = 1;
        }
    }

    private void carvePaths(Vertex topLeft, Vertex botRight) {
        if (botRight.getX() - topLeft.getX() >= 3 && botRight.getY() - topLeft.getY() >= 3) {
            int verticalWallIndex = getRandomNumberInRange(topLeft.getX(), botRight.getX());
            int horizontalWallIndex = getRandomNumberInRange(topLeft.getY(), botRight.getY());

            this.buildVerticalWall(verticalWallIndex, topLeft.getY(), botRight.getY());
            this.buildHorizontalWall(horizontalWallIndex, topLeft.getX(), botRight.getX());

            this.carvePaths(topLeft, new Vertex(verticalWallIndex, horizontalWallIndex));
            this.carvePaths(
                    new Vertex(verticalWallIndex + 2, topLeft.getY()),
                    new Vertex(botRight.getX(), horizontalWallIndex - 2)
            );
            this.carvePaths(
                    new Vertex(topLeft.getX(), horizontalWallIndex + 2),
                    new Vertex(verticalWallIndex - 2, botRight.getY())
            );
            this.carvePaths(new Vertex(verticalWallIndex + 2, horizontalWallIndex + 2), botRight);
        }
    }

    private int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private void buildVerticalWall(int column, int start, int end) {
        for (int i = start; i <= end; i++) {
            this.maze[i][column] = 1;
        }
        int hole = this.makeOpeningInWall(start, end);
        this.maze[hole][column] = 0;
    }

    private void buildHorizontalWall(int row, int start, int end) {
        for (int i = start; i <= end; i++) {
            this.maze[row][i] = 1;
        }
        int hole = this.makeOpeningInWall(start, end);
        this.maze[row][hole] = 0;
    }

    private int makeOpeningInWall(int start, int end) {
        return this.getRandomNumberInRange(start, end);
    }

    public boolean checkMoveValid(Direction move, Vertex coords) {
        switch (move){
            case UP:
                return this.isNotWall(new Vertex(coords.getX() - 1, coords.getY()));
            case DOWN:
                return this.isNotWall(new Vertex(coords.getX() + 1, coords.getY()));
            case LEFT:
                return this.isNotWall(new Vertex(coords.getX(), coords.getY() - 1));
            case RIGHT:
                return this.isNotWall(new Vertex(coords.getX(), coords.getY() + 1 ));
            default:
                throw new IllegalStateException("Unexpected value: " + move);
        }
    }

    private void spawnPlayers() {
        for (int i = 0; i < 4; i++) {
            int playerType;
            if (i == 0)  playerType = 3;
            else playerType = 4;

            this.tryPlacingEntity(playerType);
        }
    }

    public void tryPlacingEntity(int entityType) {
        boolean succesful_placement = false;

        while (!succesful_placement) {
            int X = this.getRandomNumberInRange(1, this.size - 1);
            int Y = this.getRandomNumberInRange(1, this.size - 1);

            if (this.maze[X][Y] == 0) {
                succesful_placement = true;
                this.maze[X][Y] = entityType;
            }
        }
    }

    private void spawnFood() {
        for (int i = 0; i < 20; i++) {
            this.tryPlacingEntity(2);
        }
    }

    private boolean isNotWall(Vertex nextPosition) {
        try {
            return this.maze[nextPosition.getX()][nextPosition.getY()] == 0;
        }
        catch(ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }

    public int[][] getMap() {
        return this.maze;
    }
}