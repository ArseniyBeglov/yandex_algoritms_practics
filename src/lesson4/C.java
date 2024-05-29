package lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class C {
    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
            int maxcnt=0;
            HashMap<String, Integer> map = new HashMap<>();
            while(true){
                String line = in.readLine();
                if (line == null || line.isEmpty()) break;
                String[] arr = line.split(" ");
                for(String str: arr){
                    if(!map.containsKey(str)){
                        map.put(str,0);
                    } else {
                        map.put(str, map.get(str)+1);
                    }
                }

            }

            String res = "";
            for (String str : map.keySet()) {
                if (map.get(str) > maxcnt) {
                    maxcnt = map.get(str);
                    res = str;
                } else if (map.get(str) == maxcnt && (str.compareTo(res) < 0) || res.isEmpty()) {
                    res = str;
                }
            }
            System.out.println(res);
        } catch (IOException exception){

        }
    }
}
