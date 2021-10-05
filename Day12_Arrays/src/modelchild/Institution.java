package modelchild;

public class Institution {
    private String name;
    private String address;

    private final int MAX_ATTENDANTS = 15;
    private final Child[] attendants = new Child[this.MAX_ATTENDANTS];
    private int numberOfAttendants = 0;

    public Institution(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public void addChild(Child child) {
        this.attendants[this.numberOfAttendants] = child;
        this.numberOfAttendants++;
    }

    public int averageAge() {
        int sum = 0;
        for(int i=0; i<this.numberOfAttendants; i++)
            sum += this.attendants[i].getAge();

        return sum / this.numberOfAttendants;
    }

    public int numberOfGirls() {
        int girls = 0;
        for(int i=0; i<this.numberOfAttendants; i++)
            if(!this.attendants[i].isBoy())
                girls++;

        return girls;
    }

    public int numberOfBoys() {
        return this.numberOfAttendants - this.numberOfGirls();
    }
}
