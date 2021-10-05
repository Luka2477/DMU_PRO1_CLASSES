package opgave3;

public class Name {
    private String firstName, middleName, lastName;

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() { return this.firstName; }
    public String getMiddleName() { return this.middleName; }
    public String getLastName() { return this.lastName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getInit() { return (this.firstName.charAt(0) + this.middleName.substring(0, 1) + this.lastName.charAt(0)).toUpperCase(); }

    public String getUsername() { return this.firstName.substring(0, 2).toUpperCase() + this.middleName.length() + this.lastName.substring(this.lastName.length() - 2).toLowerCase(); }
}
