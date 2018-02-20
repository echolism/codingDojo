package codingdojo.gameoflife;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

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
        for (int x = 1; x <= width; x++) {
            grid.put(x, new HashMap<>());
            for (int y = 1; y <= height; y++) {
                grid.get(x).put(y, null);
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

    public String getGridMap() {
        final StringBuilder result = new StringBuilder();
        IntStream.rangeClosed(1, height).forEach(y -> {
            IntStream.rangeClosed(1, width).forEach(x ->
                    result.append(getGridStatus(x, y))
            );
            result.append("\n");
        });
        return result.toString().substring(0, result.length() - 1);
    }

    private String getGridStatus(int x, int y) {
        final Cell cell = getCell(x, y);
        return cell == null ? "-" : cell.isLive() ? "O" : "X";
    }

    private Cell getCell(int x, int y) {
        return grid.get(x).get(y);
    }
}
