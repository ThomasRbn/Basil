package org.vaasistas.basil.gui.views;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class DiagramView extends Pane {

    public List<BasilClassView> displayedClasses;

    public DiagramView() {
        this.setPrefSize(1000, 1000);
        this.displayedClasses = new ArrayList<>();
    }

    public void addClass(BasilClassView basilClassView) {
        this.getChildren().add(basilClassView);
    }

    public boolean editDisplay(BasilClassView bcv) {
        System.out.println(this.displayedClasses.contains(bcv));
        if (this.displayedClasses.contains(bcv)) {
            this.displayedClasses.remove(bcv);
            removeClass(bcv);
            System.out.println(this.displayedClasses.size());
            return false;
        } else {
            this.displayedClasses.add(bcv);
            addClass(bcv);
            System.out.println(this.displayedClasses.size());
            return true;
        }
    }

    public void removeClass(BasilClassView basilClassView) {
        this.getChildren().remove(basilClassView);
    }
}
