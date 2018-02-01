package codingdojo.gameoflife;

import java.util.HashMap;
import java.util.Map;

public class Grid {
    private Map<Integer, Map<Integer, Cell>> grid;
    private final int width;
    private final int height;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;

        initializeGrid(width, height);
    }

    private void initializeGrid(int width, int height) {
        this.grid = new HashMap<>();
        for (int i = 1; i <= width; i++) {
            grid.put(i, new HashMap<>());
            for (int j = 1; j <= height; j++) {
                grid.get(i).put(j, null);
            }
        }
    }

    public void injectCell(Cell cell, int x, int y) {
        grid.put(x, new HashMap<>());
        grid.get(x).put(y, cell);
    }

    public void goToNextGeneration() {
        for (Map<Integer, Cell> row : grid.values()) {
            for (Cell cell : row.values()) {
                if (cell != null) {
                    killCell(cell);
                }
            }
        }
    }

    private void killCell(Cell cell) {
        cell.setLive(false);
    }
}
