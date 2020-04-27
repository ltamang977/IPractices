package org.lv.ipractices.java8.function;

import org.lv.ipractices.java8.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PredicateDemo {

    public static void demo1(){

        Person labin = new Person("Labin", 33);

        Stream<Person> stream = Stream.of(
                labin,
                new Person("Dipen", 28),
                new Person("Palden", 24)
        );

        Predicate<Person> predicate = Predicate.isEqual(labin);

        stream.filter(predicate)
                .forEach(s->System.out.println(s));

    }

    public static void demo2(){

        Person labin = new Person("Labin", 33);
        Person dipen = new Person("Dipen", 28);
        Person palden = new Person("Palden", 24);

        List<Person> list = Arrays.asList(labin, dipen, palden);

        Predicate<Person> namePredicate1 = e -> e.getName().equals("Labin");
        Predicate<Person> namePredicate2 = e -> e.getName().equals("Dipen");
        Predicate<Person> namePredicate3 = e -> e.getName().equals("Dipen");

        list.stream()
                .filter(namePredicate1)
                .forEach(s->System.out.println(s));

    }


    public static void demo3(){

        Person labin = new Person("Labin", 33);
        Person dipen = new Person("Dipen", 28);
        Person palden = new Person("Palden", 24);

        List<Person> list = Arrays.asList(labin, dipen, palden);

        Predicate<Person> namePredicate1 = e -> e.getName().equals("Labin");
        Predicate<Person> namePredicate2 = e -> e.getName().equals("Dipen");
        Predicate<Person> namePredicate3 = e -> e.getName().equals("Dipen");

        List<Person> filterList =
                list.stream()
                .filter(namePredicate1)
                .collect(toList());

        System.out.println(filterList);

    }



    public static void main(String[] args){

        //demo1();
       // demo2();
        demo3();

    }
}
