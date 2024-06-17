package com.proj.organtransplantapp;

import com.proj.organtransplantapp.Models.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Model.getInstance().getViewFactory().showInitialWindow();

    }
}
