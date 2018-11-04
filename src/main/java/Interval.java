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

            List<int[]> intervalList = new ArrayList<int[]>();
            for(int[] interval : intervals){
                intervalList.add(interval);
            }

            boolean updated = checkOverlapping(intervalList);
            while(updated){
                updated = checkOverlapping(intervalList);
            }
            int sum = 0;
            for(int[] interval : intervalList){
                sum += (interval[1] - interval[0]);
            }
            return sum;
        }
    }

    public static boolean checkOverlapping( List<int[]> intervalList){

        boolean updated = false;
        for(int i=0; i< intervalList.size(); i++){
            List<Integer> indexToDelete = new ArrayList<Integer>();
            int[] base = intervalList.get(i);

            for(int j=0; j<intervalList.size(); j++){
                if(i != j) {
                    if ((intervalList.get(j)[0] >= base[0]) && (intervalList.get(j)[0] < base[1])) {
                        indexToDelete.add(j);
                        if (intervalList.get(j)[1] >= base[1])
                            intervalList.set(i, new int[]{base[0], intervalList.get(j)[1]});
                        else
                            intervalList.set(i, new int[]{base[0], base[1]});

                        base = intervalList.get(i);
                        updated = true;
                    } else if ((base[0] >= intervalList.get(j)[0]) && (base[0] < intervalList.get(j)[1])) {
                        indexToDelete.add(j);
                        if (base[1] >= intervalList.get(j)[1])
                            intervalList.set(i, new int[]{intervalList.get(j)[0], base[1]});
                        else
                            intervalList.set(i, new int[]{intervalList.get(j)[0], intervalList.get(j)[1]});

                        base = intervalList.get(i);
                        updated = true;
                    }
                }
            }

            Collections.sort(indexToDelete, Collections.reverseOrder());

            for(int index : indexToDelete){
                intervalList.remove(index);
            }
        }
        return updated;
    }
}