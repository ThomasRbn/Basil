package org.vaasistas.basil.gui.views;

import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Window;

public class HomeView extends VBox {

    public HomeView(){
        this.setPrefSize(Screen.getPrimary().getBounds().getWidth(), Screen.getPrimary().getBounds().getHeight());
    }
}
