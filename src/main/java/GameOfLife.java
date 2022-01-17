
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

        for (int i = 1; i <= xValue; i++) {
            for (int j = 1; j <= yValue; j++) {
                for (Boolean isAlive : listOfStates) {
                    if (isAlive) {
                        cellsInGrid.add(new Cell(i, j));
                    }
                }
            }
        }
        return cellsInGrid;
    }

    public static String stringOutput(ArrayList<Cell> cellsGrid) {

        int maxX = 3;
        String grid = "";

        for (int i = 1; i <= cellsGrid.size(); i++) {
            if (i % maxX == 0) {
                grid += ("X\r\n");
            } else {
                grid += ("X");
            }
        }
        return grid;
    }

    public static ArrayList<Cell> calculateGenerations(ArrayList<Cell> cellGrid) {
        ArrayList<Cell> resultGrid = new ArrayList<>();

        int numberOfCells = cellGrid.size();
        if (numberOfCells <= 2) {
            return resultGrid;
        }

        for (Cell cell : cellGrid) {
            int numberOfNeighbours = neighbourCount(cell, cellGrid);

            if (numberOfNeighbours <= 3 && numberOfNeighbours >= 2) {
                resultGrid.add(cell);
            }
        }

        resultGrid.addAll(createLivingCell(resultGrid));

        return resultGrid;
    }

    public static List<Cell> createLivingCell(List<Cell> cellGrid) {

        List<Cell> newCells = new ArrayList<>();

        newCells.add(new Cell(5,5));

        return newCells;
    }

    private static int neighbourCount(Cell cell, List<Cell> cellList) {
        int x = cell.getX();
        int y = cell.getY();

        var count = cellList.stream().filter(c ->
                c.getX() >= x - 1 && c.getX() <= x + 1
                        && c.getY() >= y - 1 && c.getY() <= y + 1).count();

        return (int) (count - 1);

        // free space = if the count is 3 then return 1 as free space

        /*
            x-1, y-1
            x,   y-1
            x+1, y-1

            x-1, y
            x+1, y

            x-1, y+1
            x,   y+1
            x+1, y+1
        */
    }


}