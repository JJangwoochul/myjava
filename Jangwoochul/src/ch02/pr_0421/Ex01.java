package ch02.pr_0421;

//20260421 Ex1

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex01 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("david", "qwer123");
        map.put("cindy", "9abc9");
        map.put("alice", "abc000");
        map.put("paul", "asdf123");
        map.put("mary", "good!*?");
        Set<String> keySet = map.keySet();
        System.out.println(keySet);
        System.out.println("----------------------");

        for (Map.Entry<String, String> e : map.entrySet()) {
            String key = e.getKey();
            String value = e.getValue();
            System.out.println(key + " : " + value);
        }
        System.out.println("----------------------");
        String val = (String) map.get("alice");
        System.out.println("Value for key alice is : " + val);
    }
}
