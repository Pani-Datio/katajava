import java.util.*;

public class Order {
    public static String order(String words) {
        if(words.isEmpty()){
            return "";
        }else {
            String result = "";
            String[] array = words.split(" ");
            Map<Integer,String> mapResult = new HashMap<Integer,String>();
            for (String word : array) {
                for(char c : word.toCharArray()){
                    if(Character.isDigit(c)){
                        mapResult.put(new Integer(c),word);
                    }
                }
            }
            Map<Integer,String> orderedMap = new TreeMap<Integer, String>(mapResult);
            for (String str : orderedMap.values()){
                result += str + " ";
            }
            return result.substring(0, result.length() -1);
        }
    }
}