package lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class B {
    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){

            HashMap<String, Integer> map = new HashMap<>();
            StringBuilder res= new StringBuilder();
            while(true){
                String line = in.readLine();
                if (line == null || line.isEmpty()) break;
                String[] arr = line.split(" ");
                for(String str: arr){
                    if(!map.containsKey(str)){
                        map.put(str,0);
                        res.append("0 ");
                    } else {
                        map.put(str, map.get(str)+1);
                        res.append(map.get(str)).append(" ");
                    }
                }

            }
            System.out.println(res);

        } catch (IOException exception){

        }
    }
}
