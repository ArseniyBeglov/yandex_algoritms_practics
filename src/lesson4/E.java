package lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class E {
    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
            HashMap<Integer, Integer> map = new HashMap<>();
            int n = Integer.parseInt(in.readLine());
            for(int i=0; i< n; i++){
                String line = in.readLine();
                String[] arr = line.split(" ");
                int k= Integer.parseInt(arr[0]);
                int v= Integer.parseInt(arr[1]);
                map.putIfAbsent(k, v);
                if(map.get(k)!=null && map.get(k)<v){
                    map.put(k,v);
                }
            }
            long H=0;
            for(int i: map.values()){
                H+=i;
            }
            System.out.println(H);
        } catch (IOException exception){

        }
    }
}
