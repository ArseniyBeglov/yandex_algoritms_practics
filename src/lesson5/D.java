package lesson5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class D {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = reader.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int r = Integer.parseInt(line[1]);

            line = reader.readLine().split(" ");
            List<Integer> arr = new ArrayList<>(n);
            for (String strNum : line) {
                arr.add(Integer.parseInt(strNum));
            }
            System.out.println(cnt(arr,r));

        } catch (IOException ignore) {

        }
    }
    private static long cnt(List<Integer> arr, int r){
        long cntpair=0;
        int last=0;
        for(int i=0;i<arr.size();i++){
            while (last<arr.size() && arr.get(last)-arr.get(i)<=r){
                last++;
            }
            cntpair+= arr.size()-last;
        }
        return cntpair;
    }

}
