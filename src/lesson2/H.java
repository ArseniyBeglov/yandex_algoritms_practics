package lesson2;

import java.util.*;
import java.util.stream.Collectors;

public class H {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> arr = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> ans = func(arr);
        System.out.println(ans.get(0) + " " + ans.get(1) +" "+ ans.get(2));
    }

    private static List<Integer> func(List<Integer> arr) {
        Collections.sort(arr);
        final int N = arr.size();
        long first = (long) arr.get(0) * arr.get(1) * arr.get(2);
        long mid = (long) arr.get(0)*arr.get(1)*arr.get(N-1);
        long last = (long) arr.get(N - 1) * arr.get(N - 2) * arr.get(N-3);
        long max1= Math.max(first, mid);
        long max2 = Math.max(max1, last);
        if (max2 == first) {
            return arr.subList(0,3);
        } else if (max2==mid) {
            List<Integer> subList = new ArrayList<>(arr.subList(0, 2));
            subList.add(arr.get(N-1));
            return subList;
        } else {
            return arr.subList(N-3,N);
        }

    }
}
