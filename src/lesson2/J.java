package lesson2;

import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double prevFreq = scanner.nextDouble();
        double left = 30;
        double right = 4000;

        for (int i = 0; i < n - 1; i++) {
            double freq = scanner.nextDouble();
            String word = scanner.next();

            if (word.equals("closer")) {
                if(freq>prevFreq){
                    left = Math.max(left, (prevFreq+freq)/2);
                } else {
                    right=Math.min(right, (prevFreq+freq)/2);
                }
            } else if (word.equals("further")) {
                if(freq<prevFreq){
                    left = Math.max(left, (prevFreq+freq)/2);
                } else {
                    right=Math.min(right, (prevFreq+freq)/2);
                }
            }

            prevFreq = freq;
        }

        System.out.printf("%.6f %.6f%n", left, right);
    }
}
