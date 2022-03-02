package com.revature.nbaplayers;

import java.io.File;
import java.io.InputStream;

public class FileManipulator {
    private InputStream file;

    public FileManipulator(String file) {
        this.file = getClass().getClassLoader().getResourceAsStream(file);
    }

    public InputStream getFile() {
        return file;
    }
}
