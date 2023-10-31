package org.vaasistas.basil.introspection.treeProcess;

import java.io.*;

public abstract class FileStructure extends File {

    protected int descentLevel;

    public FileStructure(String path, int descentLevel) {
        super(path);
        this.descentLevel = descentLevel;
    }

    /**
     * Get the package of the file
     * @return the package
     */
    public String getPackage() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("package")) {
                    return line.substring(8, line.length() - 1) + ".";
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found : " + this.getPath());
        } catch (IOException e) {
            System.out.println("Error reading file : " + this.getPath());
        }
        return null;
    }

    public int getDescentLevel() {
        return descentLevel;
    }
}
