package p3_4;

public class Sheet {
    private int width;
    private int height;
    private int identifier;

    public Sheet() {
        this.width = 841;
        this.height = 1189;
        this.identifier = 0;
    }

    public void cutInHalf() {
        if(Math.max(this.width, this.height) == this.width) {
            this.width /= 2;
        } else {
            this.height /= 2;
        }

        int temp = this.width;
        this.width = this.height;
        this.height = temp;
        this.identifier++;
    }

    public int width() {
        return this.width;
    }

    public int height() {
        return this.height;
    }

    public String name() {
        return "A" + this.identifier;
    }
}
