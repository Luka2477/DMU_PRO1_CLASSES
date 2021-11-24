package opgave4;

class Eclipse extends Figure {

    private int size2;

    Eclipse (int x, int y, int size, int size2) {
        super(x, y, size);

        this.size2 = size2;
    }

    @Override
    public double calculateArea () {
        return Math.PI * this.getSize() * this.size2;
    }

}
