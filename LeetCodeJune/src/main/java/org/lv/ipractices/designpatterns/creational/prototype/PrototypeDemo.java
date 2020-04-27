package org.lv.ipractices.designpatterns.creational.prototype;

class Person implements  Cloneable{

    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

/*    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }*/
}

public class PrototypeDemo {


  /*  public static void personDemo(){

        Person person = new Person("Labin", 33);
        System.out.println(person);

        Person clonedPerson = (Person)person.clone();
        System.out.println(clonedPerson);

        if(person.name==clonedPerson.name){
            System.out.println("Refers same");
        }

    }*/


    public static void main(String[] args) throws CloneNotSupportedException {


        Registry registry = new Registry();

        Movie movie1 = (Movie) registry.createItem("Movie");
        movie1.setTitle("Hello");
        System.out.println(movie1);


        Movie movie2 = (Movie) registry.createItem("Movie");
        movie2.setTitle("Hi");
        System.out.println(movie2);

    }
}
