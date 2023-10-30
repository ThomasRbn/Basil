package org.vaasistas.basil.gui.views;

import javafx.scene.control.MenuBar;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.vaasistas.basil.introspection.TreeStructure;

import java.util.HashMap;
import java.util.Map;

public class EditorView extends BorderPane {

    public static Map<CellView, Boolean> DISPLAYED_CELLS = new HashMap<>();
    private final String directoryPath;

    public EditorView(String directoryPath) {
        this.directoryPath = directoryPath;

        MenuBar menuBar = new MenuBar();
        this.setTop(menuBar);

        TreeView<String> treeView = new TreeView<>();
        treeView.setRoot(TreeStructure.getTreeStructure(directoryPath));
        this.setLeft(treeView);

        Text text = new Text("Editor");
        this.setCenter(text);
    }
}
