/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.geoffreylgv.web.service;

import com.github.geoffreylgv.model.Address;
import com.github.geoffreylgv.model.TypeUniv;
import com.github.geoffreylgv.model.University;
import com.github.geoffreylgv.web.model.Country;
import com.github.openjson.JSONArray;
import com.github.openjson.JSONObject;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import lombok.SneakyThrows;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

/**
 *
 * @author geoffreylgv
 */
@Service
public class UniversityClient {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @SneakyThrows
    public List<University> getAll() throws IOException {
        List<University> universities = new LinkedList<>();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(new HttpGet(getUri("/universities")));

        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                JSONArray jsonArray = new JSONArray(EntityUtils.toString(entity));
                for (int i = 0; i < jsonArray.length(); i++) {
                   
                }
            }
        }
        return universities;
    }
    Address addressJson(JSONObject json) {
        Address add = new Address();
        add.setId(json.optLong("id"));
        add.setMail(json.optString("mail"));
        add.setUrl(json.optString("url"));
        add.setPhone(json.optString("phone"));
        add.setStreet(json.optString("street"));
        return add;
    }
    
    Country countryJson(JSONObject json) {
        Country country = new Country();
        country.setId(json.optLong("id"));
        country.setNameEN(json.optString("nameEN"));
        country.setCode(json.optString("code"));
        country.setNameFR(json.optString("nameFR"));
        return country;
    }
    University univJson(JSONObject json) {
        University univ = new University();
        univ.setId(json.optLong("id"));
        univ.setName(json.optString("name"));
        univ.setAddress(addressJson(json.getJSONObject("address")));
        univ.setType(TypeUniv.typeUnivByLibelle(json.optString("type")));
        univ.setLanguage(json.optString("language"));
        return univ;
    }

    
    private String getUri(String path) {
        return APIConstante.API_URL + path;
    }
}
