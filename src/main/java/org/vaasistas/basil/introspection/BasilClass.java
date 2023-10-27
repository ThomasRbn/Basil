package org.vaasistas.basil.introspection;

import java.util.List;

public class BasilClass {

    private String name;
    private String pkg;
    private List<Class<?>> interfaces;
    private Class<?> superClass;

    private List<BasilField> fields;
    private List<BasilMethod> constructors;
    private List<BasilMethod> methods;

    public BasilClass(String name, boolean includeSuperClassFields) {
        try {
            Class<?> currentClass = Class.forName(name);
            this.name = Introspection.getName(currentClass);
            this.pkg = Introspection.getPackage(currentClass);
            this.interfaces = Introspection.getInterfaces(currentClass);
            this.superClass = Introspection.getSuperClass(currentClass);
            this.fields = Introspection.getFields(currentClass, includeSuperClassFields);
            this.constructors = Introspection.getConstructors(currentClass);
            this.methods = Introspection.getMethods(currentClass);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + name);
        }
    }

    public String getName() {
        return name;
    }

    public BasilClass setName(String name) {
        this.name = name;
        return this;
    }

    public String getPkg() {
        return pkg;
    }

    public BasilClass setPkg(String pkg) {
        this.pkg = pkg;
        return this;
    }

    public List<Class<?>> getInterfaces() {
        return interfaces;
    }

    public BasilClass setInterfaces(List<Class<?>> interfaces) {
        this.interfaces = interfaces;
        return this;
    }

    public Class<?> getSuperClass() {
        return superClass;
    }

    public BasilClass setSuperClass(Class<?> superClass) {
        this.superClass = superClass;
        return this;
    }

    public List<BasilField> getFields() {
        return fields;
    }

    public BasilClass setFields(List<BasilField> fields) {
        this.fields = fields;
        return this;
    }

    public List<BasilMethod> getConstructors() {
        return constructors;
    }

    public BasilClass setConstructors(List<BasilMethod> constructors) {
        this.constructors = constructors;
        return this;
    }

    public List<BasilMethod> getMethods() {
        return methods;
    }

    public BasilClass setMethods(List<BasilMethod> methods) {
        this.methods = methods;
        return this;
    }

    @Override
    public String toString() {
        return "BasilClass{" +
                "name='" + name + '\'' +
                ", pkg='" + pkg + '\'' +
                ", interfaces=" + interfaces +
                ", superClass=" + superClass +
                ", fields=" + fields +
                ", constructors=" + constructors +
                ", methods=" + methods +
                '}';
    }
}
