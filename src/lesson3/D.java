package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class D {
    public static void main(String[] args) throws IOException {

        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){

            Set<String> listall = new HashSet<>();
            while(true){
                String line = in.readLine();
                if(line == null || line.isEmpty()) break;
                String[] arr = line.split("\s");
                listall.addAll(Arrays.asList(arr));
            }
            System.out.println(listall.size());

        } catch (IOException exception){

        }

    }
}
