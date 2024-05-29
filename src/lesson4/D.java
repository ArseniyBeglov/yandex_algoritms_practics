package lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class D {
    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
            int[] arr1= read(in);
            int [] arr2 = read(in);
            HashMap<Integer, Integer> map1 = new HashMap<>();
            HashMap<Integer,Integer> map2 = new HashMap<>();
            for(int i=1; i<=arr2.length; i++){
                map2.putIfAbsent(arr2[i-1], 0);
                map2.put(arr2[i-1], map2.get(arr2[i-1])+1);
            }
            for(int i=1; i<=arr1.length; i++){
                if(arr1[i-1]>=map2.get(i)){
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        } catch (IOException exception){

        }
    }
    private static int[] read(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        String[] line =  reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i]= Integer.parseInt(line[i]);
        }
        return arr;
    }
}
