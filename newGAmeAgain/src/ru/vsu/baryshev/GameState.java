package ru.vsu.baryshev;

public class GameState {

    private final Cell[][] gameField;

    public GameState(Cell[][] board) {
        this.gameField = board;
    }

    public Cell[][] getGameField() {
        return gameField;
    }


    public enum Directions {
        UP,
        LEFT,
        RIGHT,
        DOWN
    }
    public static class IllegalBoardException extends Exception {
        public IllegalBoardException(String errorMessage) {
            super(errorMessage);
        }
    }

    public static class IllegalPointPosException extends Exception {
        public IllegalPointPosException(String errorMessage) {
            super(errorMessage);
        }
    }
    private Cell getCell(Point Point) throws IllegalPointPosException {
        if (Point.x > 0 && Point.x < gameField[0].length && Point.y > 0 && Point.y < gameField.length)
            return gameField[Point.y][Point.x];
        else throw new IllegalPointPosException("point out of board");
    }

    private Point getBallPoint(Cell.Color color) throws IllegalBoardException {

        for (int y = 0; y < gameField.length; y++) {
            for (int x = 0; x < gameField[0].length; x++) {
                switch (color){
                    case GREEN:{
                        if (gameField[y][x].isballhere() && gameField[y][x].isBallGreen()) return new Point(x,y);
                    }
                    case RED:{
                        if (gameField[y][x].isballhere() && gameField[y][x].isBallRed()) return new Point(x,y);
                    }case BLUE:{
                        if (gameField[y][x].isballhere() && gameField[y][x].isBallBlue()) return new Point(x,y);
                    }case YELLOW:{
                        if (gameField[y][x].isballhere() && gameField[y][x].isBallYellow()) return new Point(x,y);
                    }
                }
            }
        }
        throw new IllegalBoardException("There aren't required ball");
    }
    private void movePointInDir(Point Point, Directions dir) {
        switch (dir) {
            case UP : Point.y -= 1;
            case DOWN : Point.y += 1;
            case LEFT : Point.x -= 1;
            case RIGHT : Point.x += 1;
        }
    }
    public boolean checkForWin() {
        for (Cell[] row : gameField) {
            for (Cell cell : row) {
                if (!cell.checkForGateWithBall()) return false;
            }
        }
        return true;
    }
    public void moveBall(Directions direction, int x, int y) throws IllegalPointPosException, Cell.IllegalCellException {
        Point firstBallPoint = null;
        Cell.Color color = gameField[x][y].getColor();
        try {
            firstBallPoint = getBallPoint(color);
        } catch (IllegalBoardException e) {
            System.exit(-1);
        }
        Point secondBallPoint = new Point(firstBallPoint);
        movePointInDir(secondBallPoint, direction);
        if ((!getCell(secondBallPoint).isBarrierHere() || ! getCell(secondBallPoint).isballhere())){
            getCell(secondBallPoint).setBall();
            getCell(firstBallPoint).resetBall();
    }else if (getCell(secondBallPoint).isGate()){
            getCell(firstBallPoint).resetBall();
            getCell(secondBallPoint).setState(Cell.CellStates.GATE_WITH_BALL);
        }

    }


}
