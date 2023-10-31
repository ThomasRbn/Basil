package org.vaasistas.basil.introspection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Introspection {

    /**
     * Returns the name of the class.
     *
     * @param clazz the class
     * @return the name of the class
     * @see Class#getSimpleName()
     */
    public static String getName(Class<?> clazz) {
        return clazz.getSimpleName();
    }

    /**
     * Returns the package of the class.
     *
     * @param clazz the class
     * @return the package of the class
     * @see Class#getPackageName()
     */
    public static String getPackage(Class<?> clazz) {
        return clazz.getPackageName();
    }

    /**
     * Returns the interfaces implemented by the class.
     *
     * @param clazz the class
     * @return the interfaces implemented by the class
     */
    public static List<Class<?>> getInterfaces(Class<?> clazz) {
        return List.of(clazz.getInterfaces());
    }

    /**
     * Returns the superclass of the class.
     *
     * @param clazz the class
     * @return the superclass of the class
     */
    public static Class<?> getSuperClazz(Class<?> clazz) {
        if (clazz.getSuperclass() == Object.class) {
            return null;
        } else {
            return clazz.getSuperclass();
        }
    }

    /**
     * Returns all the fields of the class.
     *
     * @param clazz             the class
     * @param includeSuperClass whether to include the fields of the superclass
     * @return all the fields of the class
     */
    public static List<BasilField> getFields(Class<?> clazz, boolean includeSuperClass) {
        List<Field> fields = List.of(clazz.getDeclaredFields());
        List<BasilField> basilFields = new ArrayList<>();

        if (includeSuperClass) {
            Class<?> superClass = getSuperClazz(clazz);
            if (superClass != null) {
                basilFields.addAll(getFields(superClass, false));
            }
        }

        for (Field currentField : fields) {
            BasilField basilField = new BasilField();
            basilField.setModifiers(currentField.getModifiers());
            basilField.setType(currentField.getType());
            basilField.setName(currentField.getName());
            basilFields.add(basilField);
        }

        return basilFields;
    }

    /**
     * Returns all the constructors of the class.
     *
     * @param clazz the class
     * @return all the constructors of the class
     */
    public static List<BasilMethod> getConstructors(Class<?> clazz) {
        List<Constructor<?>> constructors = List.of(clazz.getConstructors());
        List<BasilMethod> basilConstructors = new ArrayList<>();

        for (Constructor<?> currentConstructor : constructors) {
            BasilMethod basilConstructor = new BasilMethod();
            basilConstructor.setModifiers(currentConstructor.getModifiers());
            basilConstructor.setParameters(List.of(currentConstructor.getParameters()));
            basilConstructors.add(basilConstructor);
        }

        return basilConstructors;
    }

    /**
     * Returns all the methods of the class.
     *
     * @param clazz the class
     * @return all the methods of the class
     */
    public static List<BasilMethod> getMethods(Class<?> clazz) {
        List<Method> methods = List.of(clazz.getDeclaredMethods());
        List<BasilMethod> basilMethods = new ArrayList<>();

        for (Method currentMethod : methods) {
            BasilMethod basilMethod = new BasilMethod();
            basilMethod.setModifiers(currentMethod.getModifiers());
            basilMethod.setReturnType(currentMethod.getReturnType());
            basilMethod.setName(currentMethod.getName());
            basilMethod.setParameters(List.of(currentMethod.getParameters()));
            basilMethods.add(basilMethod);
        }

        return basilMethods;
    }
}
