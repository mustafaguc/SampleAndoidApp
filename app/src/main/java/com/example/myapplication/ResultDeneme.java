package com.example.myapplication;


import android.util.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ResultDeneme {


    public List<Integer> compare(List<Integer> a,List<Integer> b) {
        IntStream.range(0, a.size() - 1)
                .mapToObj(i -> new Pair<Integer,Integer>(a.get(i) > b.get(i) ? 1 : 0,b.get(i) > a.get(i) ? 1 : 0))
                .forEach(System.out::println);

        return Collections.EMPTY_LIST;
    }

    public static void main(String[] args) {
        new ResultDeneme().compare(Arrays.asList(4,5), Arrays.asList(3,1));
    }
}
