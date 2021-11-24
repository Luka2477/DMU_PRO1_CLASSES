package opgave4;

class Cube extends Figure {

    Cube (int x, int y, int size) {
        super(x, y, size);
    }

    @Override
    public double calculateArea () {
        return this.getSize() * this.getSize();
    }

}
