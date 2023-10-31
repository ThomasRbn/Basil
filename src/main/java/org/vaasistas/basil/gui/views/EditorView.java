package org.vaasistas.basil.gui.views;

import javafx.scene.control.MenuBar;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.vaasistas.basil.introspection.treeProcess.BasilFolder;
import org.vaasistas.basil.introspection.treeProcess.FileStructure;

import java.util.HashMap;
import java.util.Map;

public class EditorView extends BorderPane {

    public static Map<BasilClassView, Boolean> DISPLAYED_CELLS = new HashMap<>();
    private final String directoryPath;

    public EditorView(String directoryPath) {
        this.directoryPath = directoryPath;

        MenuBar menuBar = new MenuBar();
        this.setTop(menuBar);

        TreeView<FileStructure> treeView = new NavigatorView(directoryPath);
        this.setLeft(treeView);

        Text text = new Text("Editor");
        this.setCenter(text);
    }
}
