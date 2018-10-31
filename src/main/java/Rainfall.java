import java.util.HashMap;
import java.util.Map;

public class Rainfall {

    public static double mean(String town, String strng) {

         double result = -1.0;
         Map data = getDataMap(strng);

         if(data.containsKey(town)){
            double[] values = (double[]) data.get(town);
            result = 0;
            for(double value : values){
                result += value;
            }
            result = result / values.length;
         }
         return result;
    }

    public static double variance(String town, String strng) {

        double result = -1.0;
         Map data = getDataMap(strng);

         if(data.containsKey(town)){
             double mean = mean(town,strng);
             double[] values = (double[]) data.get(town);
             double[] variances = new double[values.length];
             result = 0;
             for(int i = 0; i < values.length; i++){
                 variances[i] = Math.pow(values[i] - mean,2);
             }

             for(double variance : variances){
                result += variance;
             }
             result = result / values.length;

         }
         return result;
    }

    public static Map getDataMap(String strng){
        String[] lines = strng.split("\n");
        Map<String, double[]> myMap = new HashMap<String, double[]>();
        for(String line : lines){
          String[] partials = line.split(":");
          String[] months = partials[1].split(",");
          double[] values = new double[months.length];
          for(int i = 0; i < months.length; i++){
            values[i] = Double.parseDouble(months[i].split(" ")[1]);
          }
          myMap.put(partials[0],values);
        }
        return myMap;
    }
}