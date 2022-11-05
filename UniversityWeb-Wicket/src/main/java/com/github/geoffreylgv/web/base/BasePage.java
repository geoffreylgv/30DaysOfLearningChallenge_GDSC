/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.geoffreylgv.web.base;

import com.github.geoffreylgv.web.base.footer.Footer;
import com.github.geoffreylgv.web.base.navbar.NavBar;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
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

    public Date localDateToDate(LocalDate ld) {
        return Date.from(ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public String frontDateFormat(String format, Date date) {
        format = format == null ? "dd/MM/yyyy" : format;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

}
