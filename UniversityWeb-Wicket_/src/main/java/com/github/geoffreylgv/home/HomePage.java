/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.geoffreylgv.home;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import com.github.geoffreylgv.base.BasePage;
import com.github.geoffreylgv.model.University;
import java.util.LinkedList;
import java.util.List;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

/**
 *
 * @author geoffreylgv
 */
@WicketHomePage
public class HomePage extends BasePage {

    private University univ;
    private String search;

    public HomePage() {
        univ = new University();
        initComponents();
    }

    private void initComponents() {

        Form form = new Form("form", new CompoundPropertyModel<>(this));

        TextField searchTXT = new TextField("search");
        form.add(searchTXT);

        List<University> listUniv = new LinkedList<>();
//        listUniv =
    }

}
