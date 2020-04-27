package org.lv.ipractices.corejava.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsDemo {


    public static void lowCalorieDemo( List<Dish> dishList){

        List<String> lowCalorieDishNames = dishList.stream()
                .filter(d->d.getCalories()<400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());

        System.out.println(lowCalorieDishNames);

    }


    public static void lowCalorieCountDemo(List<Dish> dishList){

        long count = dishList.stream()
                .filter(d->d.getCalories()>300)
                .distinct()
                .limit(3)
                .count();

        System.out.println("Count is :"+count);

    }

    public static void vegeterianMenuDemo(List<Dish> dishList){

        List<String> vegMenu = dishList.stream()
                .filter(Dish::isVegetarian)
                .map(Dish::getName)
                .collect(Collectors.toList());


        System.out.println("Veg Menu is :"+vegMenu);

    }


    public static void flatteningMaps(List<Dish> dishList){

        List<String> words = Arrays.asList("Hello", "World");

        List<String> list = words.stream()
                .map(word->word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(list);



    }

    public static void predicateDemo(List<Dish> dishList){

        boolean isVeg = dishList.stream().anyMatch(Dish::isVegetarian);
        System.out.println("isVeg check : "+isVeg);

        boolean isHealthy = dishList.stream().allMatch(d->d.getCalories()<1000);
        System.out.println("isHealthy check : "+isHealthy);

        boolean isNotHealthy = dishList.stream().noneMatch(d->d.getCalories()<1000);
        System.out.println("isNotHealthy check : "+isNotHealthy);


        Optional<Dish> dish = dishList.stream().filter(Dish::isVegetarian).findAny();
        System.out.println("any vegeterian dish : "+dish);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = numbers.stream()
                .map(x->x*x)
                .filter(x->x%3==0)
                .findFirst();
        System.out.println("First number divisible by three is :"+firstSquareDivisibleByThree);

    }



    public static void main(String[] args){

        List<Dish> dishList = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.MEAT),
                new Dish("salmon", false, 450, Dish.Type.MEAT));

        //lowCalorieDemo(dishList);
        //lowCalorieCountDemo(dishList);
        //vegeterianMenuDemo(dishList);
        //flatteningMaps(dishList);

        predicateDemo(dishList);
    }
}
