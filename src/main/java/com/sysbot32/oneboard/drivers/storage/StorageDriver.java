package com.sysbot32.oneboard.drivers.storage;

import java.io.IOException;
import java.util.List;

public interface StorageDriver {
    List<String> listDirectory(String path) throws IOException;

    void createFile(String path, String name, byte[] content) throws IOException;

    byte[] retrieveFile(String path, String name) throws IOException;

    void updateFile(String path, String name, byte[] content) throws IOException;

    default void delete(String path, String name) throws IOException {
        this.delete(path, name, false);
    }

    void delete(String path, String name, boolean r) throws IOException;

    boolean isDirectory(String path, String name);

    void createDirectory(String path, String name) throws IOException;
}
