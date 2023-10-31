package org.vaasistas.basil.gui.views;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import org.vaasistas.basil.introspection.BasilClass;
import org.vaasistas.basil.introspection.BasilField;
import org.vaasistas.basil.introspection.BasilMethod;

import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class BasilClassView extends VBox {

    private Text className;
    private VBox classFields;
    private VBox classConstructors;
    private VBox classMethods;


    public BasilClassView(BasilClass basilClass) {
        this.className = new Text(basilClass.getName());
        this.classFields = new VBox();
        this.classConstructors = new VBox();
        this.classMethods = new VBox();

        for (BasilField basilField : basilClass.getFields()) {
            Label fieldLabel = getFieldLabel(basilField);
            this.classFields.getChildren().add(fieldLabel);
        }

        for (BasilMethod constructor : basilClass.getConstructors()) {
            Label fieldLabel = getMethodLabel(constructor);
            this.classConstructors.getChildren().add(fieldLabel);
        }

        for (BasilMethod method : basilClass.getMethods()) {
            Label fieldLabel = getMethodLabel(method);
            this.classMethods.getChildren().add(fieldLabel);
        }
    }

    /**
     * Get field label
     * @param basilField basil field
     * @return field label
     */
    private static Label getFieldLabel(BasilField basilField) {
        Label fieldLabel = new Label();
        if (Modifier.isPublic(basilField.getModifiers())) {
            Circle circle = new Circle(16, Color.GREEN);
            fieldLabel.setGraphic(circle);
        } else if (Modifier.isPrivate(basilField.getModifiers())) {
            Circle circle = new Circle(16, Color.RED);
            fieldLabel.setGraphic(circle);
        } else if (Modifier.isProtected(basilField.getModifiers())) {
            Circle circle = new Circle(16, Color.YELLOW);
            fieldLabel.setGraphic(circle);
        } else {
            Circle circle = new Circle(16, Color.GRAY);
            fieldLabel.setGraphic(circle);
        }

        if (Modifier.isStatic(basilField.getModifiers())) {
            fieldLabel.setText("static");
        }
        if (Modifier.isFinal(basilField.getModifiers())) {
            fieldLabel.setText("final");
        }
        if (Modifier.isAbstract(basilField.getModifiers())) {
            fieldLabel.setText("abstract");
        }

        fieldLabel.setText(fieldLabel.getText() + " " + basilField.getName());
        fieldLabel.setText(fieldLabel.getText() + " : " + basilField.getType().getSimpleName());
        return fieldLabel;
    }

    /**
     * Get method label
     * @param method basil method
     * @return method label
     */
    private static Label getMethodLabel(BasilMethod method){
        Label fieldLabel = new Label();
        if (Modifier.isPublic(method.getModifiers())) {
            Circle circle = new Circle(16, Color.GREEN);
            fieldLabel.setGraphic(circle);
        } else if (Modifier.isPrivate(method.getModifiers())) {
            Circle circle = new Circle(16, Color.RED);
            fieldLabel.setGraphic(circle);
        } else if (Modifier.isProtected(method.getModifiers())) {
            Circle circle = new Circle(16, Color.YELLOW);
            fieldLabel.setGraphic(circle);
        } else {
            Circle circle = new Circle(16, Color.GRAY);
            fieldLabel.setGraphic(circle);
        }

        if (Modifier.isStatic(method.getModifiers())) {
            fieldLabel.setText("static");
        }
        if (Modifier.isFinal(method.getModifiers())) {
            fieldLabel.setText("final");
        }
        if (Modifier.isAbstract(method.getModifiers())) {
            fieldLabel.setText("abstract");
        }

        fieldLabel.setText(fieldLabel.getText() + " " + method.getName() + "(");
        for (Parameter parameter : method.getParameters()) {
            if (method.getParameters().indexOf(parameter) == method.getParameters().size() - 1) {
                fieldLabel.setText(fieldLabel.getText() + parameter.getType().getSimpleName() + " " + parameter.getName() + ")");
            } else {
                fieldLabel.setText(fieldLabel.getText() + parameter.getType().getSimpleName() + " " + parameter.getName() + ", ");
            }
        }
        fieldLabel.setText(fieldLabel.getText() + " : " + method.getReturnType().getSimpleName());
        return fieldLabel;
    }
}
