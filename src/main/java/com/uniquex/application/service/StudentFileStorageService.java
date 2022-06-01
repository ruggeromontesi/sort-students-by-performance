package com.uniquex.application.service;

import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.stream.Stream;

@Service
public interface StudentFileStorageService {
    Stream<Path> loadAll();
}
