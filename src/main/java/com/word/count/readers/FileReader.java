package com.word.count.readers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.channels.FileChannel;

public class FileReader {

    private FileChannel ch;

    public FileReader(String fileName) throws FileNotFoundException {
        this.ch = new FileInputStream(fileName).getChannel();
    }

    public FileChannel getCh() {
        return this.ch;
    }
}
