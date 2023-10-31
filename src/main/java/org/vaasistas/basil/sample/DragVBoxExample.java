package org.vaasistas.basil.sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DragVBoxExample extends Application {
    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage primaryStage) {
        VBox vbox = new VBox(new Label("Drag me!"));

        vbox.setOnMousePressed(event -> {
            // Lorsque la souris est pressée, enregistrez la position actuelle de la souris
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        vbox.setOnMouseDragged(event -> {
            // Calculez la différence de position de la souris par rapport à la position enregistrée
            double deltaX = event.getSceneX() - xOffset;
            double deltaY = event.getSceneY() - yOffset;

            // Mettez à jour la position du VBox en fonction de la différence de position
            vbox.setLayoutX(vbox.getLayoutX() + deltaX);
            vbox.setLayoutY(vbox.getLayoutY() + deltaY);

            // Enregistrez la nouvelle position de la souris pour la prochaine itération
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        // Créez une scène et ajoutez le VBox
        Pane root = new Pane(vbox);
        Scene scene = new Scene(root, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
