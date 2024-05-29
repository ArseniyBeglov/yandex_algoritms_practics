package lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int num=Integer.parseInt(reader.readLine());
            HashMap<String,String> map=new HashMap<>(num);
            for (int i = 0; i < num; i++) {
                String[] str= reader.readLine().split(" ");
                String k = str[0];
                String v= str[1];
                map.put(k,v);
                map.put(v,k);
            }
            String string = reader.readLine();
            System.out.println(map.get(string));

        } catch (IOException ignore) {

        }
    }
}
