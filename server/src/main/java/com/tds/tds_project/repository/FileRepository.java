package com.tds.tds_project.repository;

import com.tds.tds_project.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
    // Jpa for basic CRUD with Files
    Optional<File> findById (Integer id);
    List<File> findAllByAuthorId(Integer id);
}