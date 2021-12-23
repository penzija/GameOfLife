import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeTest {

    @Test
    void cell_creation() {
        Cell expectedResult = new Cell(1, 1, true);
        Cell actualResult = GameOfLife.createCell(1, 1, true);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void create_grid() {
        int gridX = 3;
        int gridY = 3;

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

        List<Cell> actualResult = GameOfLife.inputValues(gridX, gridY);
        assertEquals(expectedResult, actualResult);
    }
}
