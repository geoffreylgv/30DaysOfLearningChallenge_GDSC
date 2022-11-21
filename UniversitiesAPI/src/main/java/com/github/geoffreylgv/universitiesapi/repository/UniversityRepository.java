/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.geoffreylgv.universitiesapi.repository;

import com.github.geoffreylgv.universitiesapi.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 * @author geoffreylgv
 */
public interface UniversityRepository extends JpaRepository<University, Long> {
    
    //find university search like name
    @Query(value = "select u from University u where u.name like %:name% ")
    public List<University> findLikeName(@Param("name") String name);
    
    //find university search like name, director & founded date
    public List<University> findByNameLikeOrDirectorLikeOrFoundedDateLike(String search);
}
