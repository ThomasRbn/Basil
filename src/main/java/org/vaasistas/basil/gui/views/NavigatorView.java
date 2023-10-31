package org.vaasistas.basil.gui.views;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import org.vaasistas.basil.introspection.BasilClass;
import org.vaasistas.basil.introspection.treeProcess.BasilFolder;
import org.vaasistas.basil.introspection.treeProcess.FileStructure;

public class NavigatorView extends TreeView<FileStructure> {

    private BasilFolder root;
    private DiagramView diagramView;

    public NavigatorView(String directoryPath, DiagramView diagramView) {
        this.diagramView = diagramView;
        this.root = new BasilFolder(directoryPath);
        root.buildFolderContent();
        TreeItem<FileStructure> rootItem = new TreeItem<>(root);
        rootItem.setExpanded(true);
        this.setRoot(rootItem);

        for (FileStructure fichier : this.root.getTree()) {
            createTreeItems(fichier, rootItem);
        }

        this.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                TreeItem<FileStructure> selectedItem = getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    FileStructure file = selectedItem.getValue();
                    BasilClass basilClass = new BasilClass(file.getPackage() + file.getName().substring(0, file.getName().length() - 5));
                    new BasilClassView(basilClass, this.diagramView);
                }
            }
        });
    }


    /**
     * Create tree items
     *
     * @param file   current file
     * @param parent parent tree item
     */
    public void createTreeItems(FileStructure file, TreeItem<FileStructure> parent) {
        TreeItem<FileStructure> item = new TreeItem<>(file);
        if (file.getDescentLevel() == parent.getValue().getDescentLevel() + 1) {
            parent.getChildren().add(item);
        }
        if (file instanceof BasilFolder) {
            for (FileStructure f : ((BasilFolder) file).getTree()) {
                createTreeItems(f, item);
            }
        } else {
            item.setGraphic(new ImageView(("file:assets/java.png")));
        }
    }
}
