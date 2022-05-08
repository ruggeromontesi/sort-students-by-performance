package com.uniquex.application.repository;

import com.uniquex.application.entity.SortingReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SortingReportRepository extends JpaRepository<SortingReport,Integer> {
}
