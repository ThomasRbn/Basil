package org.vaasistas.basil.gui.views;

import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;

public class EditorView extends BorderPane {

    public EditorView(String directoryPath) {

        MenuBar menuBar = new MenuBar();
        this.setTop(menuBar);

        DiagramView diagramView = new DiagramView();
        this.setCenter(diagramView);

        NavigatorView treeView = new NavigatorView(directoryPath, diagramView);
        this.setLeft(treeView);
    }
}
