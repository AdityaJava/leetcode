package leetcode;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * SecondNonRepeatingChar
 */
public class SecondNonRepeatingChar {
  private static String secondNonRepeatingChar(String s, int nthNonRepeatingChar) {
    LinkedHashMap<String, Long> hashMap = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
    //    return hashMap.values().stream().filter(value -> value==1).collect(Collectors.toList()).get(2);
    if(nthNonRepeatingChar>hashMap.size()){
      System.out.println("Yeday ka re...hashmap chi size bagh....");
      return "";
    }
    return hashMap.entrySet().stream().filter(entry -> {
      return entry.getValue().equals(1l);
    }).collect(Collectors.toList()).get(nthNonRepeatingChar).getKey();

  }

  public static void main(String[] args) {
    String s = "stress";
    System.out.println(SecondNonRepeatingChar.secondNonRepeatingChar(s,100));
  }
}
