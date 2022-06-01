package com.uniquex.application.service;

import com.uniquex.application.StorageException;
import com.uniquex.application.StorageFileNotFoundException;
import com.uniquex.application.StorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StudentFileStorageServiceImplementation implements StudentFileStorageService {

    private final Path rootLocation;

    @Autowired
    public StudentFileStorageServiceImplementation(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getSortedStudentFileLocation());
    }

    @Override
    public Stream<Path> loadAll() {
        Stream<Path> outputStream;
        Stream<Path> outputStreamCopy;
        try {
            outputStream = Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));
            outputStreamCopy = Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));
            List<Path> pathList = outputStreamCopy.collect(Collectors.toList());
            return outputStream;
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }
    }


    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException("Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }


    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }
}
