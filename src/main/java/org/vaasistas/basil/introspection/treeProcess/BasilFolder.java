package org.vaasistas.basil.introspection.treeProcess;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class BasilFolder extends FileStructure {

    private List<FileStructure> content;

    public BasilFolder(String path, int descentLevel) {
        super(path, descentLevel);
        content = new ArrayList<>();
    }

    public BasilFolder(String path) {
        this(path, 0);
    }

    /**
     * Add a file or a folder to the folder content
     * @param fileStructure file or folder to add
     */
    public void addContent(FileStructure fileStructure) {
        content.add(fileStructure);
    }

    /**
     * Build the folder content
     */
    public void buildFolderContent() {
        FileFilter fileFilter = pathname -> (pathname.getName().endsWith(".java")
                || pathname.isDirectory())
                && !pathname.getName().equals("module-info.java");
        File[] folderContent = this.listFiles(fileFilter);
        if (folderContent != null) {
            for (File currentFile : folderContent) {
                if (currentFile.isDirectory()) {
                    BasilFolder folder = new BasilFolder(currentFile.getPath(), this.descentLevel + 1);
                    System.out.println(folder.getName());
                    this.addContent(folder);
                    folder.buildFolderContent();
                } else {
                    BasilFile file = new BasilFile(currentFile.getPath(), this.descentLevel + 1);
                    System.out.println(file.getPackage() + file.getName().substring(0, file.getName().length() - 5));
                    this.addContent(file);
                }
            }
        }
    }

    /**
     * Get the tree of the root folder
     * @return the tree
     */
    public List<FileStructure> getTree() {
        List<FileStructure> clazzs = new ArrayList<>();
        for (FileStructure fileStructure : content) {
            if (fileStructure instanceof BasilFolder) {
                clazzs.add(fileStructure);
                clazzs.addAll(((BasilFolder) fileStructure).getTree());
            } else {
                clazzs.add(fileStructure);
            }
        }
        return clazzs;
    }

    public String toString() {
        return this.getName();
    }
}
