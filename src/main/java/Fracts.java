public class Fracts {
    // your code
    public static String convertFrac(long[][] lst) {
        long result = lst[0][1];
        for(int i = 0; i < lst.length; i++){
            result = lcm(result,lst[i][1]);
        }
        String returnValue = "";
        for(int i = 0; i < lst.length; i++){
            returnValue += "(" + (result / lst[i][1]) + "," + result + ")";
        }
        return returnValue;
    }

    private static long gcd(long x, long y){
        while(y > 0){
            long aux = y;
            y = x % y;
            x = aux;
        }
        return x;
    }

    private static long lcm(long x, long y){
        return (x * y)/gcd(x,y);
    }

}