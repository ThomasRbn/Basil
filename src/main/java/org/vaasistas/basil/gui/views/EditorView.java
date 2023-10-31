package org.vaasistas.basil.gui.views;

import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Map;

public class EditorView extends BorderPane {

    private final String directoryPath;

    public EditorView(String directoryPath) {
        this.directoryPath = directoryPath;

        MenuBar menuBar = new MenuBar();
        this.setTop(menuBar);

        DiagramView diagramView = new DiagramView();
        this.setCenter(diagramView);

        NavigatorView treeView = new NavigatorView(directoryPath, diagramView);
        this.setLeft(treeView);
    }
}
