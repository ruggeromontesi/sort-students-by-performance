package com.uniquex.application.service;

import com.uniquex.application.StorageException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class StudentFileStorageServiceImplementation implements StudentFileStorageService {

    private final Path rootLocation;

    public StudentFileStorageServiceImplementation(Path rootLocation) {
        this.rootLocation = rootLocation;
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }
    }
}
