package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class G {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            List<Pair> birds = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] line = reader.readLine().split(" ");
                int x = Integer.parseInt(line[0]);
                int y = Integer.parseInt(line[1]);
                birds.add(new Pair(x, y));
            }
            System.out.println(angryPigs(birds));
        } catch (IOException ignore) {

        }

    }
    static int angryPigs(List<Pair> birds) {
        Set<Integer> xSet = new HashSet<>();
        for (Pair bird : birds) {
            xSet.add(bird.x);
        }
        return xSet.size();
    }
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
