public class Cell {

    private int x;
    private int y;
    boolean isAlive;


    public Cell(int x, int y, boolean isAlive) {
        this.x = x;
        this.y = y;
        this.isAlive = isAlive;
    }

    @Override
    public String toString() {
        return "Cell{" + "x=" + x + ", y=" + y + ", isAlive=" + isAlive +
                '}';
    }
}
