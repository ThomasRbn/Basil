package org.vaasistas.basil.introspection;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;

public class TreeStructure {

    public static TreeItem<String> getTreeStructure(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            return null;
        }

        TreeView<String> treeView = new TreeView<>();
        treeView.setRoot(new TreeItem<>(directory.getName()));
        treeView.setShowRoot(false);
        FileFilter fileFilter = pathname -> (pathname.getName().endsWith(".java")
                || pathname.isDirectory())
                && !pathname.getName().equals("module-info.java");
        File[] files = directory.listFiles(fileFilter);

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    TreeItem<String> childTree = getTreeStructure(file.getAbsolutePath());
                    if (childTree != null) {
                        try {
                            FileInputStream fileInputStream = new FileInputStream("assets/folder.png");
                            childTree.setGraphic(new ImageView(new Image(fileInputStream)));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        treeView.getRoot().getChildren().add(childTree);
                    }
                } else {
                    TreeItem<String> childTree = new TreeItem<>(file.getName());
                    try {
                        FileInputStream fileInputStream = new FileInputStream("assets/java.png");
                        childTree.setGraphic(new ImageView(new Image(fileInputStream)));
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    treeView.getRoot().getChildren().add(childTree);
                }
            }
        }

        if (treeView.getRoot().getChildren().isEmpty()) {
            return null; // Don't add directories with no .java files.
        }

        return treeView.getRoot();
    }
}
