package lesson5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class С {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine()); // Количество точек
            int[][] points = new int[n][2]; // Массив для хранения точек

            // Считываем координаты точек
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                points[i][0] = Integer.parseInt(tokenizer.nextToken()); // x-координата
                points[i][1] = Integer.parseInt(tokenizer.nextToken()); // y-координата
            }

            int m = Integer.parseInt(reader.readLine()); // Количество трасс
            int[][] tracks = new int[m][2]; // Массив для хранения трасс

            // Считываем начальные и конечные точки трасс
            for (int i = 0; i < m; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                tracks[i][0] = Integer.parseInt(tokenizer.nextToken()); // Начальная точка трассы
                tracks[i][1] = Integer.parseInt(tokenizer.nextToken()); // Конечная точка трассы
            }

            int[] results = tourism(points, tracks); // Вычисляем результаты для каждой трассы

            // Выводим результаты
            for (int result : results) {
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для вычисления суммарных подъемов на трассах
    private static int[] tourism(int[][] points, int[][] tracks) {
        // Суммарные подъёмы от начала до i слева направо
        int[] prefixesRisesLtr = new int[points.length];
        // Суммарные подъёмы от конца до i справа налево
        int[] prefixesRisesRtl = new int[points.length];

        for (int i = 1; i < points.length; i++) {
            prefixesRisesLtr[i] = prefixesRisesLtr[i - 1] + Math.max(points[i][1] - points[i - 1][1], 0);
            prefixesRisesRtl[points.length - i - 1] = prefixesRisesRtl[points.length - i] +
                    Math.max(points[points.length - i - 1][1] - points[points.length - i][1], 0);
        }

        int[] results = new int[tracks.length];
        for (int i = 0; i < tracks.length; i++) {
            int start = tracks[i][0];
            int end = tracks[i][1];
            if (start < end) {
                results[i] = prefixesRisesLtr[end - 1] - prefixesRisesLtr[start - 1];
            } else {
                results[i] = prefixesRisesRtl[end - 1] - prefixesRisesRtl[start - 1];
            }
        }
        return results;
    }
}

