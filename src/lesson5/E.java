package lesson5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = reader.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);

            line = reader.readLine().split(" ");
            int[] colors = new int[n];
            for (int i = 0; i < n; i++) {
                colors[i] = Integer.parseInt(line[i]);
            }
            int left = 0;
            int[] segmentColors = new int[k + 1];
            int[] bestSegment = {0, colors.length};
            int distinctColorsCounter = 0;

            for (int right = 0; right < n; right++) {
                int color = colors[right];
                if (segmentColors[color] == 0) {
                    distinctColorsCounter++;
                }
                segmentColors[color]++;
                if (distinctColorsCounter == k) {
                    while (segmentColors[colors[left]] > 1) {
                        segmentColors[colors[left]]--;
                        left++;
                    }
                    if (right - left < bestSegment[1] - bestSegment[0]) {
                        bestSegment[0] = left;
                        bestSegment[1] = right;
                    }
                }
            }

            System.out.println((bestSegment[0] + 1) + " " + (bestSegment[1] + 1));

        } catch (IOException ignore) {

        }
    }

}