package opgave1;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Array;
import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Person administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField textFieldName = new TextField();
    private final TextField textFieldTitle = new TextField();
    private final CheckBox checkBoxSenior = new CheckBox();
    private final ListView<String> listViewPersons = new ListView<>();

    private final ArrayList<Person> persons = new ArrayList<>();

    private void initContent(GridPane pane) {
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label labelName = new Label("Name:");
        pane.add(labelName, 0, 0);

        // add a text field to the pane (at col=1, row=0)
        pane.add(this.textFieldName, 1, 0);

        // add a label to the pane (at col=0, row=1)
        Label labelTitle = new Label("Title:");
        pane.add(labelTitle, 0, 1);

        pane.add(this.textFieldTitle, 1, 1);

        this.checkBoxSenior.setText("Senior");
        pane.add(this.checkBoxSenior, 1, 2);

        Button buttonAddPerson = new Button("Add person");
        buttonAddPerson.setOnAction(event -> this.addPersonAction());
        pane.add(buttonAddPerson, 2, 2);

        Label labelPersons = new Label("Persons:");
        pane.add(labelPersons, 0, 3);

        // add a listView to the pane(at col=1, row=1)
        pane.add(this.listViewPersons, 1, 3);
        this.listViewPersons.setPrefWidth(200);
        this.listViewPersons.setPrefHeight(200);
        this.listViewPersons.setFixedCellSize(25);
        this.listViewPersons.getItems().setAll(this.getNames());
    }

    // -------------------------------------------------------------------------

    private void addPersonAction() {
        String name = this.textFieldName.getText().trim();
        String title = this.textFieldTitle.getText().trim();
        if(!name.isEmpty() && !title.isEmpty()) {
            boolean senior = this.checkBoxSenior.isSelected();
            this.persons.add(new Person(name, title, senior));

            this.listViewPersons.getItems().setAll(this.getNames());

            this.textFieldName.clear();
            this.textFieldTitle.clear();
            this.checkBoxSenior.setSelected(false);
        }
    }

    private ArrayList<String> getNames() {
        ArrayList<String> temp = new ArrayList<>();
        for (Person person : this.persons)
            temp.add(person.toString());
        return temp;
    }
}
