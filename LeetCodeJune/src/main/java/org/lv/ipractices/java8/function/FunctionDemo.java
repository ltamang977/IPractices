package org.lv.ipractices.java8.function;

import org.lv.ipractices.java8.Person;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


import static java.util.stream.Collectors.toList;

import java.util.stream.Collectors;
public class FunctionDemo {


    public static void demo3(){


        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(11, 12, 13, 14, 15);
        List<Integer> list3 = Arrays.asList(21, 22, 23, 24, 25);


        List<List<Integer>> listOfList = Arrays.asList(list1, list2, list3);
        System.out.println(listOfList);

        Function<List<Integer>, Integer> sizeFunction = List::size;
        Function<List<Integer>, Stream<Integer>> flatMapper =l->l.stream();



        listOfList.stream()
               // .map(sizeFunction)
                .map(flatMapper)
                .forEach(System.out::println);//terminating condition


    }


    public static void reductionDemo(){

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);


        Integer sum = list.stream()
                .reduce(0, (e1, e2)->e1+e2);

        System.out.println("Sum is :"+ sum);

        long count = list.stream().count();
        System.out.println("Count is :"+ count);

        Optional<Integer> min = list.stream().min((a, b)->Integer.compare(a,b));
        System.out.println("Min is :"+ min);

        if(min.isPresent()){
            System.out.println("Min present is :"+min.get());

           // min.orElse()
           // min.orElseGet()
           // min.orElseThrow()
        }

        Optional<Integer> max = list.stream().max(Comparator.naturalOrder());
        System.out.println("Max is :"+ max);


    }


    public static void collectorDemo(){


        Person labin = new Person("Labin", 33);
        Person labin1 = new Person("Labin1", 33);
        Person dipen = new Person("Dipen", 28);
        Person dipen1 = new Person("Dipen1", 28);
        Person palden = new Person("Palden", 24);
        Person palden1 = new Person("Palden1", 24);


        List<Person> list = Arrays.asList(labin, labin1, dipen, dipen1, palden, palden1 );

        String str = list.stream()
                .filter(p->p.getAge()==33)
                .map(p->p.getName())
                .collect(Collectors.joining(","));

        System.out.println("Reduced string"+str);


        List<String> resultList = list.stream()
                .filter(p->p.getAge()==33)
                .map(p->p.getName())
                .collect(Collectors.toList());

        System.out.println("Reduced to list"+resultList);


        Map<Integer, List<Person>> groupedByAge =
               list.stream()
                .collect(Collectors.groupingBy(p->p.getAge()));

        System.out.println("Grouped by age"+groupedByAge);


    }



    public static void main(String[] args){

        //demo1();
        // demo2();
        //demo3();
        //reductionDemo();

        collectorDemo();

    }

}
