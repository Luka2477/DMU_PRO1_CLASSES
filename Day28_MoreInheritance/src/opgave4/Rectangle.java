package opgave4;

class Rectangle extends Figure {

    private int size2;

    Rectangle (int x, int y, int size, int size2) {
        super(x, y, size);

        this.size2 = size2;
    }

    @Override
    public double calculateArea () {
        return this.getSize() * this.size2;
    }

}
