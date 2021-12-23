import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeTest {

    @Test
    void test() {
        int expectedResult = 9;
        var actualResult = GameOfLife.createGrid(3, 3).size();

        assertEquals(expectedResult, actualResult);
    }
}
