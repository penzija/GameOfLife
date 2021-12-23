import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameOfLife {
    public static ArrayList<Cell> createGrid(int xSize, int ySize) {

        int gridSize = xSize * ySize;

        ArrayList<Cell> grid = new ArrayList<>();

        for (int i = 1; i <= xSize; i++) {
            for (int j = 1; j <= ySize; j++) {
                grid.add(new Cell(i, j, false));

            }
        }
        System.out.println(grid);

        return grid;
    }
}
