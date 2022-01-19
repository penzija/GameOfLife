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

        int xValue = gridParameters.getGridX();
        int yValue = gridParameters.getGridY();
        List<Boolean> listOfStates = new ArrayList<>(gridParameters.cellState);

        List<Cell> cellsInGrid = new ArrayList<>();

        for (int i = 1; i <= xValue; i++) {
            for (int j = 1; j <= yValue; j++) {
                cellsInGrid.add(new Cell(i, j));
            }
        }

        for (Boolean el : listOfStates) {
            int index = cellsInGrid.size()-1;
            if (el.equals(true)) {
                index--;
            }
            if (el.equals(false)){
                cellsInGrid.remove(index);
            }

        }

        return cellsInGrid;
    }

    public static String stringOutput(List<Cell> cellsGrid, int maxX) {

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

    public static List<Cell> calculateGenerations(List<Cell> cellGrid) {
        List<Cell> resultGrid = new ArrayList<>();

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

        Set<Cell> deadSet = new HashSet<>();
        //For each living cell in grid
        for (Cell cell : cellGrid) {
            //Create all neighbour Cells and add to deadSet
            deadSet.add(new Cell(cell.getX() - 1, cell.getY()));
            deadSet.add(new Cell(cell.getX() + 1, cell.getY()));
            deadSet.add(new Cell(cell.getX() - 1, cell.getY() - 1));
            deadSet.add(new Cell(cell.getX() - 1, cell.getY() + 1));
            deadSet.add(new Cell(cell.getX() + 1, cell.getY() - 1));
            deadSet.add(new Cell(cell.getX() + 1, cell.getY() + 1));
            deadSet.add(new Cell(cell.getX(), cell.getY() - 1));
            deadSet.add(new Cell(cell.getX(), cell.getY() + 1));
        }

        //Remove all cells that are alive from deadSet,
        cellGrid.forEach(deadSet::remove);

        //For each cell in deadSet check number of neighbours
        //If neighbourCount == 3 add Cell to newCells;
        List<Cell> newCells = new ArrayList<>();

        for (Cell cell : deadSet) {
            if (neighbourCount(cell, cellGrid) == 3)
                newCells.add(cell);
        }
        //return deadSet.stream().filter(cell -> neighbourCount(cell,cellGrid) == 3).toList();


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