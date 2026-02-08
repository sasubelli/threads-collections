package org.example.streams;

import java.util.*;
import java.util.stream.Collectors;


public class ListToMap {


    static void main(String[] args) {
        ArrayList<Integer> listToMap = new ArrayList<>();
        listToMap.add(1);
        listToMap.add(2);
        listToMap.add(3);
        listToMap.add(4);
        listToMap.add(5);
        listToMap.add(6);
        listToMap.add(7);
        //convert list o map  Stream
        Map<Integer, Integer> variable =
                //Creates a Stream from the collection listToMap
                listToMap.stream()
                        //Converts Stream<Integer> → IntStream
                        //Unboxes Integer to primitive int
                        .mapToInt(Integer::intValue)
                        //Converts IntStream back to Stream<Map.Entry<Integer, Integer>>
                        .mapToObj(x -> new AbstractMap.SimpleEntry<>(x, x * x))
                        //Collects the stream into a Map
                        //	•	Map.Entry::getKey → key mapper
                        //	•	Map.Entry::getValue → value mapper
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        System.out.println(variable);
        Map<Integer, Integer> mapvar = listToMap.stream().mapToInt(Integer::intValue)
                .mapToObj(x -> new AbstractMap.SimpleEntry<>(x, x * x))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(mapvar);

        ArrayList<String> listStrtoMap = new ArrayList<>();
        listStrtoMap.add("One");
        listStrtoMap.add("Two");
        listStrtoMap.add(null);
        listStrtoMap.add("Three");
        listStrtoMap.add("Four");
        Map<Integer,String> mapstring = new HashMap<>();
        for(String s: listStrtoMap){
            if(s==null){
                mapstring.put(0, null);
            }else
                mapstring.put(s.length(), s) ;

        }

        System.out.println(mapstring);
        Map<Object, List<String>> mapstring2 = listStrtoMap.stream()
                .collect(Collectors.groupingBy(String::valueOf));
        System.out.println(mapstring2);

    }
}
