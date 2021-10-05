package modeldag07;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Write a description of class Person here.
 *
 * @author (Margrethe Dybdahl)
 * @version (16 / 09 / 2020)
 */
public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private final int dayOfBirth; // 1..31
    private final int monthOfBirth; // 1..12
    private final int yearOfBirth; // 1900..2010

    /**
     * Constructor for objects of class Person
     */

    public Person(String firstName, String lastName,
                  int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.middleName = "";
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public Person(String firstName, String middleName, String lastName,
                  int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }


    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void printPerson() {
        System.out.println(firstName + " " + middleName + " " + lastName + " "
                + dayOfBirth + "." + monthOfBirth + "." + yearOfBirth);
    }

    public String getInit() {
        if(this.middleName.isEmpty()) return this.firstName.substring(0, 2) + this.lastName.charAt(0);
        return "" + firstName.charAt(0) + middleName.charAt(0) + lastName.charAt(0);
    }

    public String getUserName() {
        if(this.middleName.isEmpty()) {
            String tekst1 = firstName.substring(0, 2).toUpperCase();
            String tekst2 = this.firstName.length() - this.lastName.length() + "";
            String tekst3 = lastName.substring(lastName.length() - 2);
            return tekst1 + tekst2 + tekst3;
        } else {
            String tekst1 = firstName.substring(0, 2).toUpperCase();
            String tekst2 = middleName.length() + "";
            String tekst3 = lastName.substring(lastName.length() - 2);
            return tekst1 + tekst2 + tekst3;
        }
    }

    public int age(int dayToDay, int monthToDay, int yearToDay) {
        int birthdayThisYear = (monthToDay < this.monthOfBirth || (monthToDay == this.monthOfBirth && dayToDay < this.dayOfBirth)) ? 1 : 0;
        return yearToDay - this.yearOfBirth - birthdayThisYear;
    }

    public boolean leapYear(int year) {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }

    public String weekdayHack(int year) {
        if(year <= this.yearOfBirth) return "...";

        LocalDate ld = LocalDate.of(year, this.monthOfBirth, this.dayOfBirth);
        return ld.getDayOfWeek().toString();
    }

    public String weekday(String dayOfBirthday, int year) {
        if (year <= this.yearOfBirth) return "...";

        String[] weekdays = {"Mandag", "Tirsdag", "Onsdag", "Torsdag", "Fredag", "Lørdag", "Søndag"};
        int dayOfTheWeek = Arrays.asList(weekdays).indexOf(dayOfBirthday);

        for (int i = this.yearOfBirth+1; i <= year; i++) {
            if(this.leapYear(i)) dayOfTheWeek += 2;
            else dayOfTheWeek++;
        }

        return weekdays[dayOfTheWeek % 7];
    }
}
