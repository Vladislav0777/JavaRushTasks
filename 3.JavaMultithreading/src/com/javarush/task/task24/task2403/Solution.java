package com.javarush.task.task24.task2403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Scanner numbers = new Scanner(reader.readLine());

        List<Integer> list = new ArrayList<>();
        while(numbers.hasNextInt()) {
            list.add(numbers.nextInt());
        }

        long val = list.stream().collect(Collectors.reducing(0, (a, b)->a*a*b*b));
        System.out.println(val);
    }
}