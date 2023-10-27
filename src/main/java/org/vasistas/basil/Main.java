package org.vasistas.basil;

import org.vasistas.basil.introspection.BasilClass;

public class Main {

    public static void main(String[] args) {
        BasilClass basilClass = new BasilClass("org.vasistas.basil.sample.Eating", true);
        System.out.println(basilClass);
    }
}
