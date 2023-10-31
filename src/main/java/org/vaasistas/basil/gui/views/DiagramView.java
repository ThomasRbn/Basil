package org.vaasistas.basil.gui.views;

import javafx.scene.layout.Pane;

public class DiagramView extends Pane {

        public DiagramView() {
            this.setPrefSize(1000, 1000);
        }

        public void addClass(BasilClassView basilClassView) {
            this.getChildren().add(basilClassView);
            System.out.println("Added class");
        }

        public void removeClass(BasilClassView basilClassView) {
            this.getChildren().remove(basilClassView);
        }
}
