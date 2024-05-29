package lesson5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int num=Integer.parseInt(reader.readLine());
            int[] arr1 = new int[num];
            String[] inputLine = reader.readLine().split("\\s+");
            for (int i = 0; i < num; i++) {
                arr1[i] = Integer.parseInt(inputLine[i]);
            }
            int num2=Integer.parseInt(reader.readLine());
            int[] arr2 = new int[num2];
            String[] inputLine2 = reader.readLine().split("\\s+");
            for (int i = 0; i < num2; i++) {
                arr2[i] = Integer.parseInt(inputLine2[i]);
            }

            int[] result = stylishLook(arr1, arr2);
            System.out.println(result[0]+" "+result[1]);

        } catch (IOException ignore) {

        }
    }

    public static int[] stylishLook(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int bestI = 0;
        int bestJ = 0;
        int bestResult = Integer.MAX_VALUE;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                return new int[]{a[i], b[j]};
            }

            int newResult = Math.abs(b[j] - a[i]);
            if (newResult < bestResult) {
                bestI = i;
                bestJ = j;
                bestResult = newResult;
            }

            if (a[i] > b[j]) {
                j++;
            } else {
                i++;
            }
        }

        return new int[]{a[bestI], b[bestJ]};
    }
}