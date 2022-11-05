/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.geoffreylgv.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author geoffreylgv
 */
@Service
public class UniversityClient {

    private String getUri(String path) {
        return APIConstante.API_URL + path;
    }

}
