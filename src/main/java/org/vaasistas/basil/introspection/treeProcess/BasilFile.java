package org.vaasistas.basil.introspection.treeProcess;

public class BasilFile extends FileStructure {

    public BasilFile(String path, int descentLevel) {
        super(path, descentLevel);
    }

    public String toString() {
        return this.getName();
    }
}
