package co.com.fredymosquera;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IsIsomorphic {

    public static void main(String[] args) {

        String s = "egegxx";// 010122; //e = 2, g = 2, x = 2
        String t = "adadbb";// 010122; //a = 2, d = 2, b = 2
        boolean isIsomorphic = isIsomorphic(s, t);
        boolean isIsomorphicv0 = isIsomorphicV0(s, t);
        System.out.println(isIsomorphic);
        System.out.println(isIsomorphicv0);
    }

    private static boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }

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

    private static boolean isIsomorphicV0(String s, String t) {
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> mapS = getCountCharacters(s);
        Map<Character, Integer> mapT = getCountCharacters(t);
        List<Integer> listS = mapS.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        List<Integer> listT = mapT.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        return listS.equals(listT);
    }

    private static  Map<Character, Integer> getCountCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character myChar = s.charAt(i);
            if(map.containsKey(myChar)){
                map.put(myChar, map.getOrDefault(myChar, 0)+1);
            }else{
                map.put(myChar, 1);
            }
        }

        return map;
    }
}
