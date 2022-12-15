/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.geoffreylgv.universitiesapi.controller;

import com.github.geoffreylgv.universitiesapi.entity.Address;
import com.github.geoffreylgv.universitiesapi.entity.Country;
import com.github.geoffreylgv.universitiesapi.entity.University;
import com.github.geoffreylgv.universitiesapi.repository.UniversityRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.github.geoffreylgv.universitiesapi.utils.enumation.TypeUniv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author geoffreylgv
 */
@RestController
@RequestMapping(value = "/api/university/v1")
public class UniversityController {

    @Autowired
    UniversityRepository univRepo;

    //install
    @PostMapping(path = "/install")
    public ResponseEntity install() {
        Address address = new Address(null, "Bld Eyadema", "univ-lome.tg",
                "+228 22 25 25", "communication_ul@univ-lome.tg");
        Country country = new Country(null,"768","Togo",
                "Togo","TG","TGO");
        University univ = new University(null, "Université de Lomé",
                "Komlan D. Kokoroko", "Français", LocalDate.ofYearDay(1975, 1), country, address, TypeUniv.PB);
        univRepo.save(univ);
            return new ResponseEntity("Installation done !", HttpStatus.OK);
    }

    //get all universities
    @GetMapping(path = "/universities")
    public ResponseEntity getAll() {
        List<University> listUniv = univRepo.findAll();
        if (!listUniv.isEmpty()) {
            return new ResponseEntity(listUniv, HttpStatus.OK);
        } else {
            return new ResponseEntity("There is no record !", HttpStatus.OK);
        }
    }

    //get university by id
    @GetMapping(path = "/{id}")
    public ResponseEntity getUniversityById(@PathVariable("id") Long id) {
        Optional<University> univ = univRepo.findById(id);
        return univ.map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElse(new ResponseEntity("University Not Found !", HttpStatus.NOT_FOUND));
    }

    //get university by id
    @GetMapping()
    public ResponseEntity getOccurenceSearched(@RequestParam(value = "search") String search) {
        return new ResponseEntity<>(univRepo.findLikeNameDirectorFoundedDateCountryType(search), HttpStatus.OK);
    }

    //update university
    @PutMapping(path = "/{id}")
    public ResponseEntity updateUniv(@PathVariable("id") Long id, @RequestBody University univ) {
        Optional<University> existUniversity = univRepo.findById(id);
        if(!existUniversity.isPresent()){
            return new ResponseEntity("University not exist, Retry !", HttpStatus.CONFLICT);
        }
        //else
        univ.setId(id);
        univRepo.save(univ);
        return new ResponseEntity(univ.getName()+" updated successfuly !", HttpStatus.OK);
    }

}
