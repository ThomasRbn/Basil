package org.vaasistas.basil.sample;

public abstract class Animal implements Eating {

    public static String CATEGORY = "domestic";
    private String name;
    String color;

    protected abstract String getSound();
}