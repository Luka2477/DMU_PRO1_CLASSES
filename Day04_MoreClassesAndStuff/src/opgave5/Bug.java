package opgave5;

public class Bug {
    private int position;
    private int direction = 1;

    public Bug(int initialPosition) {
        this.position = initialPosition;
    }

    public void turn() { this.direction *= -1; }
    public void move() { this.position += this.direction; }
    public int getPosition() { return this.position; }
}