package org.lv.ipractices.designpatterns.creational.builder;

public final class Person {
    private String name;
    private int age;

    private Person(PersonBuilder builder){
        this.name = builder.name;
        this.age = builder.age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    static class PersonBuilder{

        private String name;
        private int age;

        public PersonBuilder Name(String name){
            this.name = name;
            return this;

        }

        public PersonBuilder Age(int age){
            this.age = age;
            return this;

        }

        public Person build(){
            return new Person(this);
        }

    }
}
