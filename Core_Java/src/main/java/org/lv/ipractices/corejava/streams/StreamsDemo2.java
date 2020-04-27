package org.lv.ipractices.corejava.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsDemo2 {


    //1.transaction done in 2011 sorted by value
    public static void transactionsIn2011(List<Transaction> transactions){

        //1. all transactions in 2011 and sort by value(small to high)
        List<Transaction> transactionIn2011= transactions.stream()
                .filter(y->y.getYear()==2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        System.out.println(transactionIn2011);
    }

    //2.unique cities where the traders work
    public static void uniqueCitiesTradersWork(List<Transaction> transactions){

        //1. all transactions in 2011 and sort by value(small to high)
        List<String> cities= transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(cities);
    }

    //3.find all traders from cambridge and sort them by name
    public static void tradersFromCambridge(List<Transaction> transactions){

        //1. all transactions in 2011 and sort by value(small to high)
        List<Trader> tradersFromCambridge= transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        System.out.println(tradersFromCambridge);
    }

    //4. a string of all trader names sorted alphabetically
    public static void traderNameAppendedAlphabetically(List<Transaction> transactions){

        //1. all transactions in 2011 and sort by value(small to high)
        String tradersFromCambridge= transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (a,b)-> a +b);

        System.out.println(tradersFromCambridge);
    }



    //5 any trader based in Milan
    public static void checkIfTraderPresentFromMilan(List<Transaction> transactions){

        //1. all transactions in 2011 and sort by value(small to high)
        boolean hasTraderFromMilan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        System.out.println(hasTraderFromMilan);
    }


    //6 print transaction values from trader living in Cambridge
    public static void printTransactionValuesFromTraderInCambridge(List<Transaction> transactions){

        //1. all transactions in 2011 and sort by value(small to high)
       transactions.stream()
               .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
               .forEach(transaction ->{
                   System.out.println(transaction.getValue());
               });

       // System.out.println(hasTraderFromMilan);
    }

    //7 print highest value of all transactions
    public static void printHighestValueOfAllTransactions(List<Transaction> transactions){

        //1. all transactions in 2011 and sort by value(small to high)
        Optional<Integer> max =  transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::max);


         System.out.println("Max value is :"+max);
    }

    //7 print highest value of all transactions
    public static void transactionWithSmallestValue(List<Transaction> transactions){

        //1. all transactions in 2011 and sort by value(small to high)
        Optional<Transaction> smallestTransaction =  transactions.stream()
                .reduce((t1,t2)->t1.getValue()<t2.getValue()?t1:t2);


        System.out.println("Max value is :"+smallestTransaction);


        //second solution

        Optional<Transaction> smallest1 =  transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));



    }



    public static void main(String[] args){

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011,300),
                new Transaction(raoul, 2012,1000),
                new Transaction(raoul, 2011,400),
                new Transaction(mario, 2012,710),
                new Transaction(mario, 2012,700),
                new Transaction(alan, 2012,950)
        );

        //transactionsIn2011(transactions);
        //uniqueCitiesTradersWork(transactions);
        //tradersFromCambridge(transactions);
        //traderNameAppendedAlphabetically(transactions);
        //checkIfTraderPresentFromMilan(transactions);
       // printTransactionValuesFromTraderInCambridge(transactions);
        //printHighestValueOfAllTransactions(transactions);
        transactionWithSmallestValue(transactions);

    }
}
