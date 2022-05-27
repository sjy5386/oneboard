package com.sysbot32.oneboard.drivers.storage;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BlockStorageDriver implements StorageDriver {
    private final String root;

    @Override
    public List<String> listDirectory(String path) throws IOException {
        return Files.list(Paths.get(root, path)).map(Path::getFileName).map(Path::toString).collect(Collectors.toList());
    }

    @Override
    public void createFile(String path, String name, byte[] content) throws IOException {
        Files.newOutputStream(Files.createFile(getPath(path, name))).write(content);
    }

    @Override
    public byte[] retrieveFile(String path, String name) throws IOException {
        return Files.newInputStream(getPath(path, name)).readAllBytes();
    }

    @Override
    public void updateFile(String path, String name, byte[] content) throws IOException {
        Files.newOutputStream(getPath(path, name)).write(content);
    }

    @Override
    public void delete(String path, String name, boolean r) throws IOException {
        Path p = getPath(path, name);
        if (!isDirectory(path, name) || !r) {
            Files.delete(p);
        } else {
            Files.walkFileTree(p, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return super.visitFile(file, attrs);
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    return super.postVisitDirectory(dir, exc);
                }
            });
        }
    }

    @Override
    public boolean isDirectory(String path, String name) {
        return Files.isDirectory(getPath(path, name));
    }

    @Override
    public void createDirectory(String path, String name) throws IOException {
        Files.createDirectories(getPath(path, name));
    }

    private Path getPath(String path, String name) {
        return Paths.get(root, path, name);
    }
}
