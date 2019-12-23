package pack;

import java.util.ArrayList;

public class MainTest {
    public static void main(String[] args) {

        Person p1 = new Person("Jan", "Kowalski", 35);
        Person p2 = new Person("Adam", "Nowak", 32);
        Person p3 = new Person("Jan", "Nowak", 33);
        Person p4 = new Person("Adam", "Kowalski", 34);
        Person p5 = new Person("Janina", "Kowalska", 36);

        ArrayList<Person> lista = new ArrayList<Person>(10);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);

        for (Person e: lista) {
            System.out.println(e.toString());
        }

    }
}
