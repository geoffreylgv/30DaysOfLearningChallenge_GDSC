/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.geoffreylgv.model;

/**
 *
 * @author geoffreylgv
 */
public enum TypeUniv {
    PB("Public"), PR("Private"), IS("Inter State");
    private String libelle;

    public String getLibelle() {
        return libelle;
    }

    private TypeUniv(String libelle) {
        this.libelle = libelle;
    }

    public static TypeUniv typeUnivByLibelle(String str) {
        for (TypeUniv c : TypeUniv.values()) {
            if (c.name().equals(str)) {
                return c;
            }
        }
        return null;
    }
}
