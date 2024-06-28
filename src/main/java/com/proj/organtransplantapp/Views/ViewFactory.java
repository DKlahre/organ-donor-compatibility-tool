package com.proj.organtransplantapp.Views;

import com.proj.organtransplantapp.Controllers.InitialController;
import com.proj.organtransplantapp.Controllers.SearchCandidateController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class ViewFactory {

    private AnchorPane searchCandidateView;
//    private AnchorPane showInitialView;
//    public Button initial_entry_btn;

    public ViewFactory(){

    }

    public void showInitialWindow()  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Initial.fxml"));
//        InitialController controller = new InitialController();
//        loader.setController(controller);
         createStage(loader);
    }


    public void showSearchCandidateWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/SearchCandidate.fxml"));
//        SearchCandidateController controller = new SearchCandidateController();
//        loader.setController(controller);
        createStage(loader);
    }

    public void showSearchDonorController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/SearchDonor.fxml"));
        createStage(loader);
    }


    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
//            System.out.println("Inside createStage try");

        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
       // stage.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> mouseEvent.consume());

        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/snakeRod2.png"))));
        stage.show();
    }

    public AnchorPane getSearchCandidateView(){
        if (searchCandidateView == null) {
            try {
                searchCandidateView = new FXMLLoader(getClass().getResource("/Fxml/SearchCandidate.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return searchCandidateView;
    }

    public void closeStage (Stage stage) {
        stage.close();
    }

}
