package com.proj.organtransplantapp.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class ViewFactory {

    public ViewFactory(){

    }

    public void showInitialWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }

    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
