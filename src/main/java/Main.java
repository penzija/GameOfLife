import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Tools tools = new Tools();

        List<Cell> generation0 = new ArrayList<>();

        System.out.println("*** Game of life ***\n");
        System.out.print("Select the size of the grid (X): ");
        int gridSizeX = tools.readInt();

        System.out.print("Select the size of the grid (Y): ");
        int gridSizeY = tools.readInt();

        for (int cellNumber = 1; cellNumber <= gridSizeX * gridSizeY; cellNumber++) {
            System.out.println("Is cell " + cellNumber + " alive? (y/n): ");
            String input = tools.readText();
            if (input.equals("y")) {
                generation0.add(GameOfLife.newCell(cellNumber, gridSizeX, gridSizeY));
            } else if (input.equals("n")) {
                System.out.println("No cell added");
            } else {
                System.out.println("Error! Please type 'y' or 'n'");
            }
        }

        System.out.println("Choose the number of generations");
        int generationN = tools.readInt();

        List<Cell> nextGen = GameOfLife.calculateGenerations(generation0);

        System.out.println("Generation 0:");
        System.out.println(GameOfLife.calculateGenerations(generation0));

        for (int i = 1; i <= generationN; i++) {
            System.out.println("Generation " + i + ":\n");
            nextGen = GameOfLife.calculateGenerations(nextGen);
            System.out.println(GameOfLife.stringOutput(nextGen));
        }
    }
}
