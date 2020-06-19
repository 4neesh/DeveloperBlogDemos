import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class Main {


    public static void main(String[] args) {


        Map<String, Integer> presidentMap = new HashMap<>();
        presidentMap.put("Washington", 57);
        presidentMap.put("Adams", 61);
        presidentMap.put("Jefferson", 57);
        presidentMap.put("Madison", 57);
        presidentMap.put("Monroe", 58);
        presidentMap.put("Q. Adams", 57);
        presidentMap.put("Jackson", 61);
        presidentMap.put("Van Buren", 54);
        presidentMap.put("Harrison", 68);
        presidentMap.put("Tyler", 51);


        System.out.println("Print key-value pairs");
        System.out.println(presidentMap.entrySet());

        System.out.println("\nPrint the map key set:");
        System.out.println(presidentMap.keySet());

        System.out.println("\nPrint the map value set:");
        System.out.println(presidentMap.values());

        System.out.println("\nPerform different collect methods on the entry set:");

        Map<String, Integer> doubleValues = presidentMap
                .entrySet()
                .stream()
                .collect(Collectors.toMap(entryInstance -> entryInstance.getKey(),entryInstance -> doubler(entryInstance.getValue())));

        System.out.println("\ncollect and double value: " + doubleValues);

        Map<Integer,String> accumulateValues = presidentMap
                .entrySet()
                .stream()
                .collect(Collectors.toMap(entry -> entry.getValue(), entry -> entry.getKey(), (presidentOne, presidentTwo) -> presidentOne + ", " + presidentTwo));

        System.out.println("\ncollect and add all values: " + accumulateValues);


        Map<String,Integer> sortedByValue = presidentMap
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(presidentOne,presidentTwo) -> presidentOne,LinkedHashMap::new));

        System.out.println("\nSort by values and collect: " + sortedByValue);


    }

    private static int doubler(int i){
        return i*2;
    }

}
