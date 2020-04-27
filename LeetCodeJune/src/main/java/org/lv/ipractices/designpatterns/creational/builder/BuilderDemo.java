package org.lv.ipractices.designpatterns.creational.builder;

public class BuilderDemo {


    public static void main(String[] args){

        Person person = new Person.PersonBuilder()
                .Name("Labin")
                .Age(32)
                .build();

        System.out.println(person);

    }
}
