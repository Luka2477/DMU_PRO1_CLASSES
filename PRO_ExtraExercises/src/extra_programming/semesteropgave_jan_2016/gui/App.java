package extra_programming.semesteropgave_jan_2016.gui;

import extra_programming.semesteropgave_jan_2016.application.controller.Service;
import javafx.application.Application;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
        Application.launch(GUI.class);

        Service.writeLedigeTider(LocalDate.now(), "ledigeTider.txt");
    }

}
