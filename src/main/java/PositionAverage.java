public class PositionAverage {
    public static double posAverage(String s) {
        double acum = 0.0;
        int sets = 0;
        String[] array = s.split(",");
        for(int i=0;i<array.length; i++){
            for(int j=i+1; j<array.length; j++){
                sets++;
                acum += compare(array[i].trim(),array[j].trim());
            }
        }
        return (acum / (sets * array[0].length())) * 100;
    }

    public static int compare(String a, String b){
        int matches = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) == b.charAt(i)) matches++;
        }
        return matches;
    }
}