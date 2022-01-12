import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeTest {

    @Test
    void storeAllValues_method() {
        List<Boolean> controlList = List.of(true, true, true, true, true, true, true, true, true);
        GridParameter expectedResult = new GridParameter(3, 3, controlList, 3);
        GridParameter actualResult = GameOfLife.storeGridParameter();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void defineGrid_method() {
        List<Cell> expectedResult = List.of(
                new Cell(1, 1),
                new Cell(1, 2),
                new Cell(1, 3),
                new Cell(2, 1),
                new Cell(2, 2),
                new Cell(2, 3),
                new Cell(3, 1),
                new Cell(3, 2),
                new Cell(3, 3)
        );

        List<Boolean> controlList = List.of(true, true, true, true, true, true, true, true, true);

        GridParameter gridParameters = new GridParameter(3, 3, controlList, 3);
        var actualResult = GameOfLife.buildGrid(gridParameters);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGridContent() {
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

        var expectedResult = "XXX\r\nXXX\r\nXXX\r\n";

        var actualResult = GameOfLife.stringOutput(testGrid);

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



}