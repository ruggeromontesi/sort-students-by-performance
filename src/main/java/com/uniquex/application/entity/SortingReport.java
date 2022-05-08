package com.uniquex.application.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Duration;

@Entity
public class SortingReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private Duration duration;
    private int numberOfRecords;
    private String sortingAlgorithm;

    public SortingReport(Duration duration, int numberOfRecords, String sortingAlgorithm) {
        this.duration = duration;
        this.numberOfRecords = numberOfRecords;
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public int getId() {
        return Id;
    }

    public Duration getDuration() {
        return duration;
    }

    public int getNumberOfRecords() {
        return numberOfRecords;
    }

    public String getSortingAlgorithm() {
        return sortingAlgorithm;
    }
}
