/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.geoffreylgv.base;

import com.github.geoffreylgv.base.footer.Footer;
import com.github.geoffreylgv.base.navbar.NavBar;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.wicket.markup.html.WebPage;

/**
 *
 * @author geoffreylgv
 */
public class BasePage extends WebPage {

    public BasePage() {
        this.add(new NavBar("navBar"));
        this.add(new Footer("footer"));
    }

    public static String frontDateFormat(String format, Date date) {
        format = format == null ? "dd/MM/yyyy" : format;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public String fullName(String name, String lname) {
        return name + " " + lname;
    }

}
