package lesson5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputLine = reader.readLine().split("\\s+");
            int N=Integer.parseInt(inputLine[0]);
            int K=Integer.parseInt(inputLine[1]);
            String[] inputLine1 = reader.readLine().split("\\s+");
            int[] arr1= new int[N];
//            int[] arr2= new int[N+1];
//            arr2[0]=0;
            for (int i = 0; i < N; i++) {
                arr1[i] = Integer.parseInt(inputLine1[i]);
            }
            int count = 0;
            int sum = 0;
            HashMap<Integer, Integer> prefixSumFreq = new HashMap<>();
            prefixSumFreq.put(0, 1); // Начальное значение для того случая, когда текущая сумма сразу равна K

            for (int i = 0; i < N; i++) {
                sum += arr1[i];
                int complement = sum - K; // Поиск дополнения текущей суммы до K
                if (prefixSumFreq.containsKey(complement)) {
                    count += prefixSumFreq.get(complement); // Увеличение счетчика на количество встреченных дополнений
                }
                prefixSumFreq.put(sum, prefixSumFreq.getOrDefault(sum, 0) + 1); // Обновление частоты текущей суммы
            }

            System.out.println(count);

        } catch (IOException ignore) {

        }
    }

}
