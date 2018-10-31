public class FindOutlier{
    static int find(int[] integers){
        int outlier = 0;
        boolean evenArray = (isEven(integers[0]) && isEven(integers[1])) ||
                (isEven(integers[0]) && isEven(integers[2])) ||
                (isEven(integers[1]) && isEven(integers[2]));

        for(int number : integers){
            if(evenArray){
                if(!(isEven(number))){
                    outlier = number;
                }
            }else{
                if((isEven(number))){
                    outlier = number;
                }
            }
        }
        return outlier;
    }

    static boolean isEven(int number){
        return number % 2 == 0;
    }
}