package task1;

import java.lang.reflect.Field;

public class Task1 {
    public static void main(String[] args) throws Exception{

        Cat c = new Cat();

        Class cl = c.getClass();
        Field field = cl.getSuperclass().getDeclaredField("age");
        field.setAccessible(true);
        field.setInt(c, 10);

        Field field2 = cl.getSuperclass().getDeclaredField("color");
        field2.setAccessible(true);
        field2.set(c, "Red");

        Field field3 = cl.getSuperclass().getDeclaredField("name");
        field3.setAccessible(true);
        field3.set(c, "Pushok");

        System.out.println("" + field.getInt(c) + field2.get(c) + field3.get(c));
    }
}
class Animal{
    int age = 3;
    String color = "Black";
    String name = "Murzik";
}

class Cat extends Animal{

}

