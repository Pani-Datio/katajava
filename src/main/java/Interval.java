import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Interval {

    public static int sumIntervals(int[][] intervals) {
        if(intervals == null){
            return 0;
        }
        else if(intervals.length == 0){
            return 0;
        }
        else{
            List<int[]> resultList = checkOverlapping(intervals);
            int sum = 0;
            for(int[] interval : resultList){
                sum += (interval[1] - interval[0]);
            }
            return sum;
        }
    }

    public static List<int[]> checkOverlapping(int[][] intervals){

        List<int[]> intervalList = new ArrayList<int[]>();
        for(int[] interval : intervals){
            intervalList.add(interval);
        }

        for(int i=0; i< intervalList.size(); i++){
            List<Integer> indexToDelete = new ArrayList<Integer>();
            int[] base = intervalList.get(i);

            for(int j=i+1; j<intervalList.size(); j++){
                //if these two arrays overlap
                if((intervals[j][0] >= base[0]) && (intervals[j][0] < base[1])) {
                    indexToDelete.add(j);
                    intervalList.set(i, new int[]{base[0], intervals[j][1]});
                    base = intervalList.get(i);
                }
                else if ((base[0] >= intervals[j][0]) && (base[0] < intervals[j][1])){
                    indexToDelete.add(j);
                    intervalList.set(i, new int[]{ intervals[j][0], base[1]});
                    base = intervalList.get(i);
                }
            }

            Collections.sort(indexToDelete, Collections.reverseOrder());

            for(int index : indexToDelete){
                intervalList.remove(index);
            }
        }
        return intervalList;
    }
}