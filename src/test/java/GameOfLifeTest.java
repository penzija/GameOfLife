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
                new Cell(1, 1, true),
                new Cell(1, 2, true),
                new Cell(1, 3, true),
                new Cell(2, 1, true),
                new Cell(2, 2, true),
                new Cell(2, 3, true),
                new Cell(3, 1, true),
                new Cell(3, 2, true),
                new Cell(3, 3, true)
        );

        List<Boolean> controlList = List.of(true, true, true, true, true, true, true, true, true);

        GridParameter gridParameters = new GridParameter(3, 3, controlList, 3);
        var actualResult = GameOfLife.buildGrid(gridParameters);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGridContent() {
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

        var expectedResult = "XXX\r\nXXX\r\nXXX";

        var actualResult = GameOfLife.stringOutput(testGrid);

        assertEquals(expectedResult, actualResult);
    }
}