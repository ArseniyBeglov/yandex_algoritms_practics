package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class E {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = reader.readLine();
            List<Character> xyz = line.chars()
                    .mapToObj(c -> (char) c)
                    .collect(ArrayList::new, List::add, List::addAll);

            char[] chars = reader.readLine().toCharArray();
            Set<Character> line2 = new HashSet<>();
            for (char i : chars) {
                line2.add(i);
            }
            xyz.forEach(line2::remove);
            System.out.println(line2.size());
        } catch (IOException ignore) {

        }
    }
}
