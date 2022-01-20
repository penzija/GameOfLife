import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameOfLife {

    public static Cell newCell(int numberInGrid, int maxX, int maxY) {

        int posX = (numberInGrid - 1) / maxX + 1;
        int posY = (numberInGrid - 1) % maxY + 1;

        return new Cell(posX, posY);
    }

    public static String stringOutput(List<Cell> listOfCells) {

        String outputGrid = "";

        int minXValue = listOfCells.stream().mapToInt(Cell::getX).min().orElse(0);
        int maxXValue = listOfCells.stream().mapToInt(Cell::getX).max().orElse(0);
        int minYValue = listOfCells.stream().mapToInt(Cell::getY).min().orElse(0);
        int maxYValue = listOfCells.stream().mapToInt(Cell::getY).max().orElse(0);


        for (int y = minYValue; y <= maxYValue; y++) {
            for (int x = minXValue; x <= maxXValue; x++) {
                if (listOfCells.contains(new Cell(x, y))) {
                    outputGrid += "*";

                } else {
                    outputGrid += "O";
                }
            }
            outputGrid += "\n";
        }
        return outputGrid;
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

        return (int) (count);
    }
}