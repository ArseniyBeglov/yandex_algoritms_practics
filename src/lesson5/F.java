package lesson5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class F {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Integer> schoolRooms = readList(reader);
            Collections.sort(schoolRooms);
            Map<Integer, Integer> map = readMap(reader);

            int i = 0;
            final int S_N = schoolRooms.size();
            int sum = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int price = entry.getKey();
                int power = entry.getValue();
                while (i < S_N && power >= schoolRooms.get(i)) {
                    i++;
                    sum += price;
                }
                if (i >= S_N) break;
            }
            System.out.println(sum);

        } catch (IOException ignore) {

        }
    }
    private static Map<Integer, Integer> readMap(BufferedReader reader) throws IOException {
        String[] line = reader.readLine().split(" ");
        int k = Integer.parseInt(line[0]);

        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            line = reader.readLine().split(" ");
            int power = Integer.parseInt(line[0]);
            int price = Integer.parseInt(line[1]);

            map.put(price, power);
        }
        return map;
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        String[] line = reader.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        List<Integer> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        return list;
    }
}
