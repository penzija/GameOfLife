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

        outputGrid = findMinMaxValue(listOfCells, outputGrid, minXValue, maxXValue, minYValue, maxYValue);
        return outputGrid;
    }

    public static List<Cell> calculateGenerations(List<Cell> cellGrid) {
        List<Cell> resultGrid = new ArrayList<>();

        int numberOfCells = cellGrid.size();

        if (numberOfCells <= 2) {
            return resultGrid;
        }

        storeSurvivingCells(cellGrid, resultGrid);

        resultGrid.addAll(createLivingCell(resultGrid));
        return resultGrid;
    }

    public static List<Cell> createLivingCell(List<Cell> cellGrid) {

        Set<Cell> deadSet = new HashSet<>();

        //For each living cell in grid
        createNeighbourCells(cellGrid, deadSet);

        //Remove all cells that are alive from deadSet,
        cellGrid.forEach(deadSet::remove);

        //For each cell in deadSet check number of neighbours
        //If neighbourCount == 3 add Cell to newCells;

        List<Cell> newCells = CheckNumberOfNeighboursInDeadset(cellGrid, deadSet);

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

    private static String findMinMaxValue(List<Cell> listOfCells, String outputGrid, int minXValue, int maxXValue, int minYValue, int maxYValue) {
        for (int y = minYValue; y <= maxYValue; y++) {
            for (int x = minXValue; x <= maxXValue; x++) {
                outputGrid = containNewCell(listOfCells, outputGrid, y, x);
            }
            outputGrid += "\n";
        }

        return outputGrid;
    }

    private static String containNewCell(List<Cell> listOfCells, String outputGrid, int y, int x) {
        if (listOfCells.contains(new Cell(x, y))) {
            outputGrid += "*";

        } else {
            outputGrid += "O";
        }
        return outputGrid;
    }

    private static void storeSurvivingCells(List<Cell> cellGrid, List<Cell> resultGrid) {

        for (Cell cell : cellGrid) {
            int removeItself=1;
            
            int numberOfNeighbours = neighbourCount(cell, cellGrid)-removeItself;

            if (isEnoughNeighbours(numberOfNeighbours)) {
                resultGrid.add(cell);
            }
        }

    }

    private static boolean isEnoughNeighbours(int numberOfNeighbours) {
        return numberOfNeighbours <= 3 && numberOfNeighbours >= 2;
    }

    private static void createNeighbourCells(List<Cell> cellGrid, Set<Cell> deadSet) {
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
    }

    private static List<Cell> CheckNumberOfNeighboursInDeadset(List<Cell> cellGrid, Set<Cell> deadSet) {
        List<Cell> newCells = new ArrayList<>();

        for (Cell cell : deadSet) {

            checkNeighbourCount(cellGrid, newCells, cell);
        }
        return newCells;
    }

    private static void checkNeighbourCount(List<Cell> cellGrid, List<Cell> newCells, Cell cell) {
        if (neighbourCount(cell, cellGrid) == 3)
            newCells.add(cell);
    }
}