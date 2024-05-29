package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class F {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String genome1 =reader.readLine();
            String genome2 = reader.readLine();

            ArrayList<String> pairs1 = new ArrayList<>();
            for (int i = 0; i < genome1.length() - 1; i++) {
                pairs1.add(genome1.substring(i, i + 2));
            }

            Set<String> pairs2 = new HashSet<>();
            for (int i = 0; i < genome2.length() - 1; i++) {
                pairs2.add(genome2.substring(i, i + 2));
            }

            int count = 0;
            for (String pair : pairs1) {
                if (pairs2.contains(pair)) {
                    count++;
                }
            }

            System.out.println(count);
        } catch (IOException ignore) {

        }
    }
}
