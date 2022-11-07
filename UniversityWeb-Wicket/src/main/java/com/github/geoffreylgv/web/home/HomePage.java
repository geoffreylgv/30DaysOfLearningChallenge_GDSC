/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.geoffreylgv.web.home;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import com.github.geoffreylgv.model.University;
import com.github.geoffreylgv.web.base.BasePage;
import com.github.geoffreylgv.web.service.UniversityClient;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

/**
 *
 * @author geoffreylgv
 */
@WicketHomePage
@MountPath("/home")
public class HomePage extends BasePage {

    @SpringBean
    private UniversityClient univClient;
    private University univ;
    private String search;
    private List<University> listUniv = new LinkedList<>();
    private ListView<University> listView;
    private LoadableDetachableModel ldm;

    public HomePage() throws IOException {
        univ = new University();
        initComponents();
    }

    private void initComponents() throws IOException {

        FeedbackPanel feedback = new FeedbackPanel("feedback");
        WebMarkupContainer container = new WebMarkupContainer("container");
        Form form = new Form("form", new CompoundPropertyModel<>(this));
        container.add(form);
        listUniv = univClient.getAll();
        listView = new ListView<University>("lines", listUniv) {
            @Override
            protected void populateItem(ListItem<University> item) {
                item.add(new Label("nameFR", item.getModelObject().getName()));
                item.add(new Label("director", item.getModelObject().getDirector()));
                item.add(new Label("foundedDate", frontDateFormat(null, localDateToDate(item.getModelObject().getFoundedDate()))));
                item.add(new Label("language", item.getModelObject().getLanguage()));
                item.add(new Label("type", item.getModelObject().getType()));
                item.add(new Label("countryCity", item.getModelObject().getCountry().getNameEN()));
                item.add(new Label("addressUrl", item.getModelObject().getAddress().getUrl()));
                item.add(new Label("addressStreet", item.getModelObject().getAddress().getStreet()));
                item.add(new Label("addressPhone", item.getModelObject().getAddress().getPhone()));
                item.add(new Label("addressMail", item.getModelObject().getAddress().getMail()));
            }
        };

        TextField searchTXT = new TextField("search");
        form.add(searchTXT);

        AjaxButton sendBTN = new AjaxButton("send") {
            @Override
            public void onSubmit(AjaxRequestTarget target) {
                super.onSubmit(target);
            }
        };
        form.add(sendBTN);
        form.add(feedback.setOutputMarkupId(true));
        container.add(listView.setOutputMarkupId(true));
        container.add(form);
        add(container.setOutputMarkupId(true));
    }

}
