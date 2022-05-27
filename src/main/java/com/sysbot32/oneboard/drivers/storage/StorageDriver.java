package com.sysbot32.oneboard.drivers.storage;

import java.util.List;

public interface StorageDriver {
    List<String> listDirectory(String path);

    void createFile(String path, String name, byte[] content);

    byte[] retrieveFile(String path, String name);

    void updateFile(String path, String name, byte[] content);

    void deleteFile(String path, String name);

    boolean isDirectory(String path, String name);

    void createDirectory(String path, String name);

    default void deleteDirectory(String path, String name) {
        this.deleteDirectory(path, name, false);
    }

    void deleteDirectory(String path, String name, boolean r);
}
