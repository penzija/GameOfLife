public class Cell {

    private final int x;
    private final int y;
    boolean isAlive;


    public Cell(int x, int y, boolean isAlive) {
        this.x = x;
        this.y = y;
        this.isAlive = isAlive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void isAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String toString() {
        return "Cell{" + "x=" + x + ", y=" + y + ", isAlive=" + isAlive + '}';
    }
}
