package org.vaasistas.basil.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.vaasistas.basil.gui.views.HomeView;

public class Index extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new HomeView());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
