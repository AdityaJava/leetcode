package leetcode.countanagram;

import java.util.*;

public class CountAnagram {
    public static void main(String[] args) {
        List<String> inputList = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        Map<String, List<String>> sortedStringToString = new HashMap<>();
        for (String string : inputList) {
            char[] characters = string.toCharArray();
            Arrays.sort(characters);
            String sortedString = new String(characters);
            List<String> stringList = sortedStringToString.getOrDefault(sortedString, new ArrayList<>());
            stringList.add(string);
            sortedStringToString.put(sortedString, stringList);
        }
        System.out.println("sda");
    }
}
