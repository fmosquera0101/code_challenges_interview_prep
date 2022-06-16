package co.com.fredymosquera;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {

    public static void main(String[] args) {

        String s = "egegxx";// 010122
        String t = "adadbb";// 010122
        boolean isIsomorphic = isIsomorphic(s, t);
        System.out.println(isIsomorphic);
    }

    private static boolean isIsomorphic(String s, String t) {
        s = getStringTransformed(s);
        t = getStringTransformed(t);
        return s.equals(t);
    }

    private static String getStringTransformed(String s) {
        Map<Character, Integer> mapTransformer = new HashMap<>();
        StringBuilder converted = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if(!mapTransformer.containsKey(character)){
                mapTransformer.put(character, i);
            }
            converted.append(mapTransformer.get(character));
        }
        return converted.toString();
    }
}
