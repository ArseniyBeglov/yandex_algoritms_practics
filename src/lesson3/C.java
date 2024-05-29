package lesson3;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class C {
    public static void main(String[] args) throws IOException {

        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out =new PrintWriter(System.out);){
            String[] line = in.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            Set<Integer> listanya = new TreeSet<>();
            Set<Integer> listborya = new TreeSet<>();
            Set<Integer> listall = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                listanya.add(Integer.parseInt(in.readLine()));
            }

            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(in.readLine());
                if (listanya.remove(num)) {
                    listall.add(num);
                } else {
                    listborya.add(num);
                }
            }

            pr(listall, out);
            pr(listanya, out);
            pr(listborya, out);
        } catch (IOException exception){

        }

    }

    private static void pr(Set<Integer> list, PrintWriter out) {
        out.println(list.size());
        for (Integer i : list) {
            out.print(i + " ");
        }
        out.println();
    }
}
