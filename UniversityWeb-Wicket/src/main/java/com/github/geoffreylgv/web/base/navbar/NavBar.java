/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.geoffreylgv.web.base.navbar;

import com.github.geoffreylgv.web.home.HomePage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

/**
 *
 * @author geoffreylgv
 */
public class NavBar extends Panel {

    public NavBar(String id) {
        super(id);
        BookmarkablePageLink homePage = new BookmarkablePageLink("home", HomePage.class);
        this.add(homePage);
    }

}
