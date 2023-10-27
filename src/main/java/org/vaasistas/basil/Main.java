package org.vaasistas.basil;

import org.vaasistas.basil.introspection.BasilClass;

public class Main {

    public static void main(String[] args) {
        BasilClass basilClass = new BasilClass("org.vaasistas.basil.sample.Eating", true);
        System.out.println(basilClass);
    }
}
