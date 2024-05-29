package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<Integer> arr = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());


        System.out.println(arr.size());
    }
}
