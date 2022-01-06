package extra_programming.semesteropgave_jan_2018.gui;

import extra_programming.semesteropgave_jan_2018.application.controller.Controller;
import javafx.application.Application;

public class App {

    public static void main(String[] args) {
        Controller.initStorage();
        System.out.println(Controller.holdUdenTutorer());
        System.out.println();
        System.out.println(Controller.getUddannelser().get(0).tutorOversigt());
        Controller.tutorOversigtTilFil("PRO_ExtraExercises\\src\\extra_programming\\semesteropgave_jan_2018\\textfiler\\tutorer.txt");

        Application.launch(GUI.class);
    }

}
