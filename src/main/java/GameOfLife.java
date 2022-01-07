import java.util.ArrayList;
import java.util.List;

public class GameOfLife {

    public static GridParameter storeGridParameter() {
        List<Boolean> deadOrAlive = new ArrayList<>();

        System.out.println("How big is the grid? (x) ");
        System.out.println("How big is the grid? (y) ");
        int gridXValue = 3;
        int gridYValue = 3;
        int gridMaxX = 3;

        for (int i = 0; i < gridXValue * gridYValue; i++) {
            System.out.println("Is the cell dead or alive? ");
            deadOrAlive.add(true);
        }
        return new GridParameter(gridXValue, gridYValue, deadOrAlive, gridMaxX);  // HERE WE CREATED THE PARAMETERS FOR THE NEXT METHOD
    }

    public static List<Cell> buildGrid(GridParameter gridParameters) {
        List<Cell> cellsInGrid = new ArrayList<>();

        int xValue = gridParameters.getGridX();
        int yValue = gridParameters.getGridY();
        List<Boolean> listOfStates = new ArrayList<>(gridParameters.getCellState());
        int indexOfList = 0;

        for (int i = 1; i <= xValue; i++) {
            for (int j = 1; j <= yValue; j++) {
                cellsInGrid.add(new Cell(i, j, listOfStates.get(indexOfList)));
            }
        }
        return cellsInGrid;
    }

    public static String stringOutput(ArrayList<Cell> cellsGrid) {

        int maxX = 3;
        String grid = "";

        for (Cell cell : cellsGrid) {
            if (cell.isAlive && cell.getX() == maxX) {
                grid += ("X\r\n");
            } else if (cell.isAlive) {
                grid = grid + ("X");
            } else {
                grid += ("o");
            }
        }
        return grid;
    }
}