package org.vaasistas.basil.gui.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import org.vaasistas.basil.introspection.BasilClass;
import org.vaasistas.basil.introspection.BasilField;
import org.vaasistas.basil.introspection.BasilMethod;

import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Objects;

public class BasilClassView extends VBox {

    private String className;
    private VBox header;
    private VBox classFields;
    private VBox classConstructors;
    private VBox classMethods;
    private SquarePosition squarePosition;
    private DiagramView diagramView;


    public BasilClassView(BasilClass basilClass, DiagramView diagramView) {
        this.diagramView = diagramView;
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));

        this.className = basilClass.getName();

        this.header = new VBox();
        this.header.getChildren().add(new Text(this.className));
        this.header.setAlignment(Pos.CENTER);
        this.header.setPadding(new Insets(10, 10, 10, 10));

        this.classFields = new VBox();
        classFields.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
                BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE,  BorderStrokeStyle.NONE, BorderStrokeStyle.NONE,
                null, null, null)));
        this.classFields.setPadding(new Insets(10, 10, 10, 10));
        this.classFields.setSpacing(3);


        this.classConstructors = new VBox();
        classConstructors.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
                BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE,  BorderStrokeStyle.NONE, BorderStrokeStyle.NONE,
                null, null, null)));
        this.classConstructors.setPadding(new Insets(10, 10, 10, 10));
        this.classConstructors.setSpacing(3);


        this.classMethods = new VBox();
        classMethods.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
                BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE,  BorderStrokeStyle.NONE, BorderStrokeStyle.NONE,
                null, null, null)));
        this.classMethods.setPadding(new Insets(10, 10, 10, 10));
        this.classMethods.setSpacing(3);


        this.squarePosition = new SquarePosition(20, 20, 100, 100);

        this.setLayoutX(squarePosition.getPosX());
        this.setLayoutY(squarePosition.getPosY());
        this.setMinWidth(squarePosition.getWidth());
        this.setMinHeight(squarePosition.getHeight());

        this.getChildren().add(header);

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
            circle.setStroke(Color.BLACK);
            fieldLabel.setGraphic(circle);
        } else if (Modifier.isPrivate(basilField.getModifiers())) {
            Circle circle = new Circle(8, Color.RED);
            circle.setStroke(Color.BLACK);
            fieldLabel.setGraphic(circle);
        } else if (Modifier.isProtected(basilField.getModifiers())) {
            Circle circle = new Circle(8, Color.YELLOW);
            circle.setStroke(Color.BLACK);
            fieldLabel.setGraphic(circle);
        } else {
            Circle circle = new Circle(8, Color.GRAY);
            circle.setStroke(Color.BLACK);
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
            circle.setStroke(Color.BLACK);
            methodLabel.setGraphic(circle);
        } else if (Modifier.isPrivate(method.getModifiers())) {
            Circle circle = new Circle(8, Color.RED);
            circle.setStroke(Color.BLACK);
            methodLabel.setGraphic(circle);
        } else if (Modifier.isProtected(method.getModifiers())) {
            Circle circle = new Circle(8, Color.YELLOW);
            circle.setStroke(Color.BLACK);
            methodLabel.setGraphic(circle);
        } else {
            Circle circle = new Circle(8, Color.GRAY);
            circle.setStroke(Color.BLACK);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasilClassView that = (BasilClassView) o;
        return Objects.equals(className, that.className) && Objects.equals(diagramView, that.diagramView);
    }

    @Override
    public int hashCode() {
        return Objects.hash(className, diagramView);
    }
}
