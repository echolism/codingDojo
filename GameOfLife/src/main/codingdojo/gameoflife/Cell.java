package codingdojo.gameoflife;

public class Cell {
    private boolean isLive;

    public Cell() {
        this.isLive = true;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean isLive) {
        this.isLive = isLive;
    }
}
