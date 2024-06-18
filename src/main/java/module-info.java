module com.example.organtransplantapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires java.desktop;
            
      //  requires org.controlsfx.controls;
        //    requires com.dlsc.formsfx;
            //        requires org.kordamp.bootstrapfx.core;

    opens com.proj.organtransplantapp to javafx.fxml;
    exports com.proj.organtransplantapp;
    exports com.proj.organtransplantapp.Controllers;
    exports com.proj.organtransplantapp.Models;
    exports com.proj.organtransplantapp.Views;
}