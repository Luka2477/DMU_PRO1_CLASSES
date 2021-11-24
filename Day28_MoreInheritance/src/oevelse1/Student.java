package oevelse1;

import java.util.BitSet;

public class Student extends Person {

    private String subject;

    public Student (String name, int birthday, String subject) {
        super(name, birthday);

        this.subject = subject;
    }

    @Override
    public String toString () {
        return super.toString() + " | " + this.subject;
    }

}
