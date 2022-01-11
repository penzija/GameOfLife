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

        for (int i = 1; i <= cellsGrid.size(); i++) {
            if (i%maxX == 0){
                grid += ("X\r\n");
            }
            else if (cellsGrid.get(i).isAlive) {
                grid += ("X");
        }
            else {
                grid += ("o");
            }
        }
        return grid;
    }

    public static ArrayList<Cell> calculateGenerations(ArrayList<Cell> cellGrid) {

        int Rows = 3;
        int Columns = 3;

        ArrayList<Cell> testGrid = new ArrayList<>();

        testGrid.add(new Cell(1, 1, true));
        testGrid.add(new Cell(1, 2, true));
        testGrid.add(new Cell(1, 3, true));
        testGrid.add(new Cell(2, 1, true));
        testGrid.add(new Cell(2, 2, true));
        testGrid.add(new Cell(2, 3, true));
        testGrid.add(new Cell(3, 1, true));
        testGrid.add(new Cell(3, 2, true));
        testGrid.add(new Cell(3, 3, true));

        for (int i = 0; i < Rows; i++)
        {
            for (int j = 0; j < Columns; j++)
            {
                if (testGrid. == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        nextGeneration(grid, M, N);



}

}