import java.util.ArrayList;
import java.util.List;

public class GameOfLife {
    public static ArrayList<Cell> createGrid(int xSize, int ySize) {

        ArrayList<Cell> grid = new ArrayList<>();

        for (int i = 1; i <= xSize; i++) {
            for (int j = 1; j <= ySize; j++) {
                grid.add(new Cell(i, j, false));

            }
        }
        return grid;
    }

    public static ArrayList<Cell> defineCells(ArrayList<Cell> grid, List<Boolean> input) {
        return grid;

    }
}
