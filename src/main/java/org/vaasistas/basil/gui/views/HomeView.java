package org.vaasistas.basil.gui.views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Screen;

import java.io.File;

public class HomeView extends VBox {

    public HomeView() {
        this.setPrefSize(Screen.getPrimary().getBounds().getWidth(), Screen.getPrimary().getBounds().getHeight());
        this.setAlignment(Pos.CENTER);

        DirectoryChooser directoryChooser = new DirectoryChooser();

        Button openFinder = new Button("Open Finder");
        openFinder.setOnAction(e -> {
            File selectedDirectory = directoryChooser.showDialog(this.getScene().getWindow());
            if (selectedDirectory != null) {
                EditorView editorView = new EditorView(selectedDirectory.getAbsolutePath());
                this.getScene().setRoot(editorView);
            }
        });

        this.getChildren().add(openFinder);
    }
}
