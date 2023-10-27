package org.vasistas.basil.introspection;

import java.util.List;

public class BasilField {

    private List<Integer> modifiers;
    private Class<?> type;
    private String name;

    public List<Integer> getModifiers() {
        return modifiers;
    }

    public BasilField setModifiers(List<Integer> modifiers) {
        this.modifiers = modifiers;
        return this;
    }

    public Class<?> getType() {
        return type;
    }

    public BasilField setType(Class<?> type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public BasilField setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "BasilField{" +
                "modifiers=" + modifiers +
                ", type=" + type +
                ", name='" + name + '\'' +
                '}';
    }
}
