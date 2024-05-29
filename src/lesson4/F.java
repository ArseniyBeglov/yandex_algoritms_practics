package lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;


public class F {
    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(System.out))
        {
            Map<String, Map<String, Long>> dict = new TreeMap<>();
            String line;
            while ((line=in.readLine()) != null) {
                if (line == null || line.isEmpty()) break;
                String[] parts = line.split(" ");
                String name = parts[0];
                String thing = parts[1];
                Long quan = Long.parseLong(parts[2]);
                Map<String, Long> innerDict = dict.computeIfAbsent(name, k -> new TreeMap<>());
                innerDict.put(thing, innerDict.getOrDefault(thing, 0L) + quan);
            }
            for (String name : dict.keySet()) {
                writer.println(name + ":");
                for (String thing : dict.get(name).keySet()) {
                    writer.println(thing + " " + dict.get(name).get(thing));
                }
            }


        } catch (IOException ignored){

        }
    }
}
