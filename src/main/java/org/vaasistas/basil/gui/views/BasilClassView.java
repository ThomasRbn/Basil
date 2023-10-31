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
    private SquarePosition squarePosition;
    private DiagramView diagramView;


    public BasilClassView(BasilClass basilClass, DiagramView diagramView) {
        this.diagramView = diagramView;
        System.out.println(basilClass.getName());
        this.className = new Text(basilClass.getName());
        this.classFields = new VBox();
        this.classConstructors = new VBox();
        this.classMethods = new VBox();
        this.squarePosition = new SquarePosition(0, 0, 100, 100);

        this.setLayoutX(squarePosition.getPosX());
        this.setLayoutY(squarePosition.getPosY());
        this.setMinWidth(squarePosition.getWidth());
        this.setMinHeight(squarePosition.getHeight());

        this.getChildren().add(className);

        for (BasilField basilField : basilClass.getFields()) {
            Label fieldLabel = getFieldLabel(basilField);
            this.classFields.getChildren().add(fieldLabel);
        }

        for (BasilMethod constructor : basilClass.getConstructors()) {
            Label fieldLabel = getMethodLabel(constructor, basilClass);
            this.classConstructors.getChildren().add(fieldLabel);
        }

        for (BasilMethod method : basilClass.getMethods()) {
            Label fieldLabel = getMethodLabel(method, basilClass);
            this.classMethods.getChildren().add(fieldLabel);
        }

        this.getChildren().add(classFields);
        this.getChildren().add(classConstructors);
        this.getChildren().add(classMethods);
        this.diagramView.addClass(this);
    }

    /**
     * Get field label
     *
     * @param basilField basil field
     * @return field label
     */
    private static Label getFieldLabel(BasilField basilField) {
        Label fieldLabel = new Label();
        if (Modifier.isPublic(basilField.getModifiers())) {
            Circle circle = new Circle(8, Color.GREEN);
            fieldLabel.setGraphic(circle);
        } else if (Modifier.isPrivate(basilField.getModifiers())) {
            Circle circle = new Circle(8, Color.RED);
            fieldLabel.setGraphic(circle);
        } else if (Modifier.isProtected(basilField.getModifiers())) {
            Circle circle = new Circle(8, Color.YELLOW);
            fieldLabel.setGraphic(circle);
        } else {
            Circle circle = new Circle(8, Color.GRAY);
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
     *
     * @param method basil method
     * @return method label
     */
    private static Label getMethodLabel(BasilMethod method, BasilClass basilClass) {
        Label methodLabel = new Label();
        if (Modifier.isPublic(method.getModifiers())) {
            Circle circle = new Circle(8, Color.GREEN);
            methodLabel.setGraphic(circle);
        } else if (Modifier.isPrivate(method.getModifiers())) {
            Circle circle = new Circle(8, Color.RED);
            methodLabel.setGraphic(circle);
        } else if (Modifier.isProtected(method.getModifiers())) {
            Circle circle = new Circle(8, Color.YELLOW);
            methodLabel.setGraphic(circle);
        } else {
            Circle circle = new Circle(8, Color.GRAY);
            methodLabel.setGraphic(circle);
        }

        if (Modifier.isStatic(method.getModifiers())) {
            methodLabel.setText("static");
        }
        if (Modifier.isFinal(method.getModifiers())) {
            methodLabel.setText("final");
        }
        if (Modifier.isAbstract(method.getModifiers())) {
            methodLabel.setText("abstract");
        }

        if (method.getName() == null) {
            methodLabel.setText(methodLabel.getText() + " " + basilClass.getName() + "(");
        } else {
            methodLabel.setText(methodLabel.getText() + " " + method.getName() + "(");
        }

        for (Parameter parameter : method.getParameters()) {
            if (method.getParameters().indexOf(parameter) == method.getParameters().size() - 1) {
                methodLabel.setText(methodLabel.getText() + parameter.getType().getSimpleName() + " " + parameter.getName());
            } else {
                methodLabel.setText(methodLabel.getText() + parameter.getType().getSimpleName() + " " + parameter.getName() + ", ");
            }
        }
        methodLabel.setText(methodLabel.getText() + ")");
        String returnType = method.getReturnType() == null ? basilClass.getName() : method.getReturnType().getSimpleName();
        methodLabel.setText(methodLabel.getText() + " : " + returnType);
        return methodLabel;
    }
}
