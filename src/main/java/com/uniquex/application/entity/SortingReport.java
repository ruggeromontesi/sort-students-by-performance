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

    public SortingReport() {
    }

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

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public int getNumberOfRecords() {
        return numberOfRecords;
    }

    public void setNumberOfRecords(int numberOfRecords) {
        this.numberOfRecords = numberOfRecords;
    }

    public String getSortingAlgorithm() {
        return sortingAlgorithm;
    }

    public void setSortingAlgorithm(String sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }
}
