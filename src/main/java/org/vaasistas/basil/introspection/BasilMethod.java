package org.vaasistas.basil.introspection;

import java.lang.reflect.Parameter;
import java.util.List;

public class BasilMethod {

    private List<Integer> modifiers;
    private Class<?> returnType;
    private String name;
    private List<Parameter> parameters;

    public List<Integer> getModifiers() {
        return modifiers;
    }

    public BasilMethod setModifiers(List<Integer> modifiers) {
        this.modifiers = modifiers;
        return this;
    }

    public Class<?> getReturnType() {
        return returnType;
    }

    public BasilMethod setReturnType(Class<?> returnType) {
        this.returnType = returnType;
        return this;
    }

    public String getName() {
        return name;
    }

    public BasilMethod setName(String name) {
        this.name = name;
        return this;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public BasilMethod setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
        return this;
    }

    @Override
    public String toString() {
        return "BasilMethod{" +
                "modifiers=" + modifiers +
                ", returnType=" + returnType +
                ", name='" + name + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
