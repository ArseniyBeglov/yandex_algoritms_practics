package lesson4;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lenW = scanner.nextInt();
        int lens = scanner.nextInt();
        scanner.nextLine(); // consume newline
        String W = scanner.nextLine();
        String S = scanner.nextLine();

        Map<Character, Integer> wDict = makeDict(W);
        Map<Character, Integer> sDict = makeDict(S.substring(0, lenW));
        int matchingLetters = matchDicts(wDict, sDict);
        int occurrences = 0;

        if (matchingLetters == wDict.size()) {
            occurrences++;
        }

        for (int i = lenW; i < lens; i++) {
            matchingLetters += modifyDict(sDict, wDict, S.charAt(i - lenW), -1);
            matchingLetters += modifyDict(sDict, wDict, S.charAt(i), +1);
            if (matchingLetters == wDict.size()) {
                occurrences++;
            }
        }

        System.out.println(occurrences);
    }

    public static Map<Character, Integer> makeDict(String s) {
        Map<Character, Integer> sDict = new HashMap<>();
        for (char c : s.toCharArray()) {
            sDict.put(c, sDict.getOrDefault(c, 0) + 1);
        }
        return sDict;
    }

    public static int matchDicts(Map<Character, Integer> dict1, Map<Character, Integer> dict2) {
        int matches = 0;
        for (Map.Entry<Character, Integer> entry : dict1.entrySet()) {
            if (dict2.containsKey(entry.getKey()) && Objects.equals(dict2.get(entry.getKey()), entry.getValue())) {
                matches++;
            }
        }
        return matches;
    }

    public static int modifyDict(Map<Character, Integer> sDict, Map<Character, Integer> wDict, char symbol, int countModifier) {
        int ans = 0;
        if (!sDict.containsKey(symbol)) {
            sDict.put(symbol, 0);
        }
        if (wDict.containsKey(symbol) && Objects.equals(sDict.get(symbol), wDict.get(symbol))) {
            ans = -1;
        }
        sDict.put(symbol, sDict.get(symbol) + countModifier);
        if (wDict.containsKey(symbol) && Objects.equals(sDict.get(symbol), wDict.get(symbol))) {
            ans = 1;
        }
        return ans;
    }


}

