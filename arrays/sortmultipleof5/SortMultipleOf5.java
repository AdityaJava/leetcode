package leetcode.arrays.sortmultipleof5;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortMultipleOf5 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new String("10 3 25 8 5 1 30").split(" ")).stream().map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> positionList = new ArrayList<>();
//        Map<Integer, List<Integer>> numberToPosition = IntStream.range(0, list.size()).filter(index -> {
//            if (list.get(index) % 5 == 0) {
//                positionList.add(index);
//                return true;
//            }
//            return false;
//        }).boxed().collect(Collectors.groupingBy(index -> list.get(index)))
//                .entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByKey())
//                        .collect(Collectors.toMap(
//                                Map.Entry::getKey,
//                                Map.Entry::getValue,
//                                (oldValue, newValue)->oldValue,
//                                LinkedHashMap::new
//                        ));
        List<Integer> divideBy5List = IntStream.range(0, list.size()).filter(index -> {
            System.out.println("Filtering");
            if (list.get(index) % 5 == 0) {
                positionList.add(index);
                return true;
            }
            return false;
        }).map(index -> {
            System.out.println("Mapping");
            return list.get(index);
        }).sorted().boxed().collect(Collectors.toList());
        for (int pos = 0; pos < positionList.size(); pos++) {
            list.set(positionList.get(pos), divideBy5List.get(pos));
        }
        System.out.println(list);
    }
}
