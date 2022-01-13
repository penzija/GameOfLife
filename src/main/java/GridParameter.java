import java.util.List;
import java.util.Objects;

public class GridParameter {
    private final int gridX;
    private final int gridY;
    List<Boolean> cellState;
    private final int maxX;

    public GridParameter(int gridX, int gridY, List<Boolean> cellState, int maxX) {
        this.gridX = gridX;
        this.gridY = gridY;
        this.cellState = cellState;
        this.maxX = maxX;
    }

    public int getGridX() {
        return gridX;
    }

    public int getGridY() {
        return gridY;
    }

    public List<Boolean> getCellState() {
        return cellState;
    }

    public int getMaxX() {
        return maxX;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GridParameter parameter = (GridParameter) o;

        if (gridX != parameter.gridX) return false;
        if (gridY != parameter.gridY) return false;
        return Objects.equals(cellState, parameter.cellState);
    }

    @Override
    public int hashCode() {
        int result = gridX;
        result = 31 * result + gridY;
        result = 31 * result + (cellState != null ? cellState.hashCode() : 0);
        return result;
    }
}
