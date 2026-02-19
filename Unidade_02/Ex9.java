package Unidade_02;

import java.util.HashMap;
import java.util.Map;

public class Ex9 {

    public static Map<String, Integer> mergeMaps(
            Map<String, Integer> map1,
            Map<String, Integer> map2) {
        Map<String, Integer> map = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            map.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        return map;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        // Registro da Ilíada
        map1.put("Aquiles", 12);
        map1.put("Odisseu", 9);

        Map<String, Integer> map2 = new HashMap<>();
        // Registro da Odisseia
        map2.put("Odisseu", 15);
        map2.put("Agamemnon", 4);

        Map<String, Integer> merged = mergeMaps(map1, map2);

        System.out.println(merged);
    }
}
