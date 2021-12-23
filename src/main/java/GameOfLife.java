import java.util.ArrayList;
import java.util.List;

public class GameOfLife {

    public static Cell createCell(int x, int y, boolean isAlive) {
        return new Cell(x, y, isAlive);
    }


    public static List<Cell> inputValues(int x, int y) {

        List<Cell> cellsGrid = new ArrayList<>();

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                System.out.println("is the cell " + i + " alive or death? (A/D)");
                var isAlive = true;
                Cell cell = createCell(i, j, isAlive);
                cellsGrid.add(cell);
            }
        }
        return cellsGrid;
    }
}