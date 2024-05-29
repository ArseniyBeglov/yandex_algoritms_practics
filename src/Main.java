import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n>10000||n<1) throw new IllegalArgumentException();
        scanner.nextLine();
        char[][] forest = new char[n][3];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < 3; j++) {
                forest[i][j] = line.charAt(j);
            }
        }

        int[][] dp = new int[n][3];
        for (int j = 0; j < 3; j++) {
            if (forest[n - 1][j] == 'W') {
                dp[n - 1][j] = 0;
            } else if (forest[n - 1][j] == 'C') {
                dp[n - 1][j] = 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                if (forest[i][j] == 'W') {
                    dp[i][j] = 0;
                } else {
                    int maxMushrooms = 0;
                    if (j - 1 >= 0) {
                        maxMushrooms = Math.max(maxMushrooms, dp[i + 1][j - 1]);
                    }
                    maxMushrooms = Math.max(maxMushrooms, dp[i + 1][j]);
                    if (j + 1 < 3) {
                        maxMushrooms = Math.max(maxMushrooms, dp[i + 1][j + 1]);
                    }
                    dp[i][j] = maxMushrooms;
                    if (forest[i][j] == 'C') {
                        dp[i][j]++;
                    }
                }
            }
        }

        int result = Math.max(dp[0][0], dp[0][1]);
        result = Math.max(result, dp[0][2]);
        System.out.println(result);
    }
}
