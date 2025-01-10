package de.lubowiecki.gui.plaintodo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        TextField input = new TextField();

        Separator separator = new Separator();

        Button allBtn = new Button("Alle");
        Button undoneBtn = new Button("Offen");
        Button doneBtn = new Button("Erleding");

        // Buttens in eine horizontale Box ablegen
        HBox btnBox = new HBox(allBtn, undoneBtn, doneBtn);
        btnBox.setAlignment(Pos.CENTER);

        // Hier werden die Todos abgelegt
        ObservableList<Todo> data = FXCollections.observableArrayList();

        // Hier werden die Todos angezeigt
        ListView<Todo> todoList = new ListView<>(data);

        VBox mainBox = new VBox(input,separator,btnBox,todoList);

        // Alle Bedienelemente werden in einer Box in die Szene eingefügt
        Scene scene = new Scene(mainBox);

        final String CSS_FILE = "style.css";
        // CSS-Style-Datei der Szene zuweisen
        // getClass() liefert ein Reflection-Object für diese Klasse (App)
        // Reflection-Object: ist eine Beschreibung des Inventers einer Klasse
        // getResource(CSS_FILE) liefert den Pfad als URL
        // toExternalForm() wandelt die URL in einen passenden String um
        scene.getStylesheets().add(getClass().getResource(CSS_FILE).toExternalForm());

        stage.setTitle("Todos!");
        stage.setScene(scene);
        stage.show();

        /*
        // Reflection liefert die Details für eine Klasse
        // Todo.class liefert ein Reflection-Object für die Todo-Klasse
        Field[] fields = Todo.class.getDeclaredFields(); // liest nicht private Eigenschaften aus
        System.out.println(Arrays.toString(fields));
        Method[] methods = Todo.class.getMethods();
        System.out.println(Arrays.toString(methods));
        */
    }

    public static void main(String[] args) {
        launch();
    }
}