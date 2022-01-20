import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeTest {

    @Test
    void newCell_from_user_input() {
        int numberOfCell = 9;
        int maxX = 3;
        int maxY = 3;

        var expectedResult = new Cell(3, 3);

        var actualResult = GameOfLife.newCell(numberOfCell, maxX, maxY);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void newCell_from_user_input_2() {
        int numberOfCell = 7;
        int maxX = 3;
        int maxY = 3;

        var expectedResult = new Cell(3, 1);

        var actualResult = GameOfLife.newCell(numberOfCell, maxX, maxY);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void newCell_from_user_input_3() {
        int numberOfCell = 58;
        int maxX = 8;
        int maxY = 8;

        var expectedResult = new Cell(8, 2);

        var actualResult = GameOfLife.newCell(numberOfCell, maxX, maxY);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGridOutput() {
        ArrayList<Cell> testGrid = new ArrayList<>();

        testGrid.add(new Cell(1, 1));
        testGrid.add(new Cell(1, 2));
        testGrid.add(new Cell(1, 3));
        testGrid.add(new Cell(2, 1));
        testGrid.add(new Cell(2, 2));
        testGrid.add(new Cell(2, 3));
        testGrid.add(new Cell(3, 1));
        testGrid.add(new Cell(3, 2));
        testGrid.add(new Cell(3, 3));

        var maxX = 3;

        var expectedResult = "XXX\r\nXXX\r\nXXX\r\n";

        var actualResult = GameOfLife.stringOutput(testGrid, maxX);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateGenerations() {
        ArrayList<Cell> testGrid = new ArrayList<>();

        testGrid.add(new Cell(1, 1));

        var expectedResult = new ArrayList<Cell>();

        var actualResult = GameOfLife.calculateGenerations(testGrid);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateGenerations2() {
        ArrayList<Cell> testGrid = new ArrayList<>();

        testGrid.add(new Cell(1, 1));
        testGrid.add(new Cell(2, 1));

        var expectedResult = new ArrayList<Cell>();

        var actualResult = GameOfLife.calculateGenerations(testGrid);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateGenerations3() {
        ArrayList<Cell> testGrid = new ArrayList<>();

        testGrid.add(new Cell(1, 1));
        testGrid.add(new Cell(2, 1));
        testGrid.add(new Cell(1, 2));
        testGrid.add(new Cell(2, 2));

        var expectedResult = new ArrayList<Cell>();
        expectedResult.add(new Cell(1, 1));
        expectedResult.add(new Cell(2, 1));
        expectedResult.add(new Cell(1, 2));
        expectedResult.add(new Cell(2, 2));

        var actualResult = GameOfLife.calculateGenerations(testGrid);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateGenerations4() {
        ArrayList<Cell> testGrid = new ArrayList<>();

        testGrid.add(new Cell(1, 1));
        testGrid.add(new Cell(2, 2));
        testGrid.add(new Cell(3, 3));

        var expectedResult = new ArrayList<Cell>();

        expectedResult.add(new Cell(2, 2));

        var actualResult = GameOfLife.calculateGenerations(testGrid);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateGenerations5() {
        ArrayList<Cell> testGrid = new ArrayList<>();

        testGrid.add(new Cell(1, 1));
        testGrid.add(new Cell(2, 1));
        testGrid.add(new Cell(1, 2));

        var expectedResult = new ArrayList<Cell>();

        expectedResult.add(new Cell(1, 1));
        expectedResult.add(new Cell(2, 1));
        expectedResult.add(new Cell(1, 2));
        expectedResult.add(new Cell(2, 2));

        var actualResult = GameOfLife.calculateGenerations(testGrid);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void createLivingCell() {
        List<Cell> testGrid = List.of(new Cell(1, 1));

        var expectedResult = List.of(new Cell(5, 5));
        var actualResult = GameOfLife.createLivingCell(testGrid);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void createLivingCell2() {
        List<Cell> testGrid = List.of(new Cell(1, 1), new Cell(2, 1), new Cell(1, 2));

        var expectedResult = List.of(new Cell(2, 2));

        var actualResult = GameOfLife.createLivingCell(testGrid);

        assertEquals(expectedResult, actualResult);
    }

}