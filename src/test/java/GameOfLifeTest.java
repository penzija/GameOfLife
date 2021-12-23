import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeTest {

    @Test
    void grid_creation_check() {
        int expectedResult = 9;
        int actualResult = GameOfLife.createGrid(3, 3).size();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void cells_alive_state() {

        ArrayList<Cell> initialCellsStatus = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                initialCellsStatus.add(new Cell(i, j, false));
            }
        }

        ArrayList<Cell> expectedResult = new ArrayList<>();
        expectedResult.add(new Cell(1, 1, false));
        expectedResult.add(new Cell(1, 2, false));
        expectedResult.add(new Cell(1, 3, false));
        expectedResult.add(new Cell(2, 1, false));
        expectedResult.add(new Cell(2, 2, false));
        expectedResult.add(new Cell(2, 3, true));
        expectedResult.add(new Cell(3, 1, true));
        expectedResult.add(new Cell(3, 2, true));
        expectedResult.add(new Cell(3, 3, true));

        List<Boolean> cellChangeStatus = List.of(false, false, false, false, false, true, true, true, true);
        var actualResult = GameOfLife.defineCells(initialCellsStatus, cellChangeStatus);

        assertEquals(expectedResult, actualResult);
    }
}
