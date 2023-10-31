package org.vaasistas.basil.introspection;

public class BasilField {

    private int modifiers;
    private Class<?> type;
    private String name;

    public int getModifiers() {
        return modifiers;
    }

    public BasilField setModifiers(int modifiers) {
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
