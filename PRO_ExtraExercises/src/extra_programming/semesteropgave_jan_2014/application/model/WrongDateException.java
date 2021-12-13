package extra_programming.semesteropgave_jan_2014.application.model;

public class WrongDateException extends RuntimeException {

    public WrongDateException (String errorMessage) {
        super("Start dato skal komme før slut dato: " + errorMessage);
    }

}
