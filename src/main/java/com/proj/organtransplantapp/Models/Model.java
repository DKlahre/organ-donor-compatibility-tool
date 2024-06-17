package com.proj.organtransplantapp.Models;

import com.proj.organtransplantapp.Views.ViewFactory;

public class Model {

    private static Model model;
    private final DatabaseDriver databaseDriver;
    private final ViewFactory viewFactory;

    public Model() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
    }

    public static synchronized Model getInstance() {
        if(model == null){
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

}
