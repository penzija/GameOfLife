public class Cell {

    private final int x;
    private final int y;
    boolean isAlive;


    public Cell(int x, int y, boolean isAlive) {
        this.x = x;
        this.y = y;
        this.isAlive = isAlive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void isAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (x != cell.x) return false;
        if (y != cell.y) return false;
        return isAlive == cell.isAlive;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + (isAlive ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cell{" + "x=" + x + ", y=" + y + ", isAlive=" + isAlive + '}';
    }
}
