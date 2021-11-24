package opgave4;

abstract class Figure {

    private int x;
    private int y;
    private int size;

    Figure (int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void shiftX (int x) {
        this.x += x;
    }

    public void shiftY (int y) {
        this.y += y;
    }

    public abstract double calculateArea ();

}
