package task3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Task3 {
    public static void main(String[] args) {
        A a = new A();
        Class cA = a.getClass();

        System.out.println("Fields:");
        Field[] fields = cA.getDeclaredFields();
        for (Field field : fields) {
            Class fieldType = field.getType();
            System.out.println("\tName: " + field.getName());
            System.out.println("\tType: " + fieldType.getName());
        }

        System.out.println("Methods:");
        Method[] methods = cA.getMethods();
        for (Method method : methods) {
            System.out.println("Name: " + method.getName());
            Class returnType = method.getReturnType();
            System.out.println("\tReturn type: " +returnType.getName());
            Class[] paramTypes = method.getParameterTypes();
            System.out.print("\tParam types:");
            for (Class paramType : paramTypes) {
                System.out.print(" " + paramType.getName());
            }
            System.out.println();
        }

        System.out.println("Constructors:");
        Constructor[] constructors = cA.getConstructors();
        for (Constructor ctr : constructors) {
            System.out.println("Parameters:");
            Class[] paramTypes = ctr.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.print(paramType.getName() + " ");
            }
            System.out.println();}

        System.out.print("Modifiers of class: ");
        int mods = cA.getModifiers();
        System.out.println(mods);
        if (Modifier.isPrivate(mods))
            System.out.print("private ");
        if (Modifier.isAbstract(mods))
            System.out.print("abstract ");
        if (Modifier.isFinal(mods))
            System.out.print("final ");
        if (Modifier.isStatic(mods)) {
            System.out.println("static");
        }
    }
}

class A{
    public int publicField;
    private int privateField;

    public A() {
    }

    public A(int publicField, int privateField) {
        this.publicField = publicField;
        this.privateField = privateField;
    }

    public A(int publicField) {
        this.publicField = publicField;
    }

    public int getPublicField() {
        return publicField;
    }

    public void setPublicField(int publicField) {
        this.publicField = publicField;
    }

    public int getPrivateField() {
        return privateField;
    }

    public void setPrivateField(int privateField) {
        this.privateField = privateField;
    }
}
