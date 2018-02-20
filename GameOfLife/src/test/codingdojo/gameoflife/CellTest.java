package codingdojo.gameoflife;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CellTest {
    /**
     * Given a living cell and a 1 x 1 grid
     * When living cell is injected to the grid
     * Then a living cell dies after next generation comes
     */
    @Test
    public void testGivenLivingCellAnd1x1GridWhenLivingCellOnGridThenLivingCellDies() {
        Cell cell = new Cell();
        Grid grid = new Grid(1, 1);

        grid.injectCell(cell, 1, 1);
        grid.goToNextGeneration();

        assertFalse(cell.isLive());
    }

    /**
     * Given a living cell and a 2 x 1 grid
     * When living cell is injected to grid (2, 1)
     * Then a living cell dies after next generation comes
     */
    @Test
    public void testGivenLivingCellAnd2x1GridWhenLivingCellOnGridx2y1ThenLivingCellDies() {
        Cell cell = new Cell();
        Grid grid = new Grid(2, 1);

        grid.injectCell(cell, 2, 1);
        grid.goToNextGeneration();

        assertFalse(cell.isLive());
    }

    /**
     * Given a living cell and a 2 x 2 grid
     * When living cell is injected to grid (2, 2)
     * Then a living cell dies after next generation comes
     */
    @Test
    public void testGivenLivingCellAnd2x2GridWhenLivingCellOnGridx2y2ThenLivingCellDies() {
        Cell cell = new Cell();
        Grid grid = new Grid(2, 2);

        grid.injectCell(cell, 2, 2);
        grid.goToNextGeneration();

        assertFalse(cell.isLive());
    }

    /**
     * Given a living cell and a 1 x 1 grid
     * When living cell is injected to the grid
     * Then I can see the grid with living cell
     */
    @Test
    public void testGivenLivingCellAnd1x1GridWhenInjectCellThenCanSeeGrid() {
        Cell cell = new Cell();
        Grid grid = new Grid(1, 1);

        grid.injectCell(cell, 1, 1);
        String expectedGrid = "O";

        assertEquals(expectedGrid, grid.getGridMap());
    }

    /**
     * Given a living cell and a 1 x 2 grid
     * When living cell is injected in (1, 2)
     * Then I can see the grid with living cell on (1, 2)
     */
    @Test
    public void testGivenLivingCellAnd1x2GridWhenInjectCellx1y2ThenCanCorrectGetGrid() {
        Cell cell = new Cell();
        Grid grid = new Grid(1, 2);

        grid.injectCell(cell, 1, 2);
        String expectedGrid = "-\nO";

        assertEquals(expectedGrid, grid.getGridMap());
    }

    /**
     * Given a living cell and a 1 x 2 grid
     * When living cell is injected in (1, 1)
     * Then I can see the grid with living cell on (1, 1)
     */
    @Test
    public void testGivenLivingCellAnd1x2GridWhenInjectCellx1y1ThenCanCorrectGetGrid() {
        Cell cell = new Cell();
        Grid grid = new Grid(1, 2);

        grid.injectCell(cell, 1, 1);
        String expectedGrid = "O\n-";

        assertEquals(expectedGrid, grid.getGridMap());
    }

    /**
     * Given a living cell and a 1 x 2 grid
     * When living cell is injected in (1, 1)
     * Then I can see the next generation grid with dead cell on (1, 1)
     */
    @Test
    public void testGivenLivingCellAnd1x2GridWhenInjectCellx1y1ThenCanGetNextGenGrid() {
        Cell cell = new Cell();
        Grid grid = new Grid(1, 2);

        grid.injectCell(cell, 1, 1);
        String expectedGrid = "X\n-";
        grid.goToNextGeneration();

        assertEquals(expectedGrid, grid.getGridMap());
    }
}
