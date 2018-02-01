package codingdojo.gameoflife;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

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
}
