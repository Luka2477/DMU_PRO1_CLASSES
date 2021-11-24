package opgave4;

class Circle extends Figure {

    Circle (int x, int y, int size) {
        super(x, y, size);
    }

    @Override
    public double calculateArea () {
        return Math.PI * this.getSize() * this.getSize();
    }

}
