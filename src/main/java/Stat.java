import java.util.Arrays;

public class Stat {

    public static String stat(String strg) {

        String[] array = strg.split(",");
        int[] list = new int[array.length];
        int[] hourlist = new int[array.length];
        int[] minutelist = new int[array.length];
        int[] secondlist = new int[array.length];
        int secondsRange = 0;
        int secondsAverage = 0;
        int secondsMedian = 0;

        if(array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                int seconds = toSeconds(array[i].trim());
                String[] data = array[i].split("\\|");
                hourlist[i] = Integer.parseInt(data[0].trim());
                minutelist[i] = Integer.parseInt(data[1].trim());
                secondlist[i] = Integer.parseInt(data[2].trim());
                list[i] = seconds;
            }

            Arrays.sort(list);
            Arrays.sort(hourlist);
            Arrays.sort(minutelist);
            Arrays.sort(secondlist);

            secondsRange = list[list.length - 1] - list[0];

            for (int i = 0; i < list.length; i++) {
                secondsAverage += list[i];
            }
            secondsAverage = secondsAverage / list.length;

            //        int hoursMedian = ((hourlist.length % 2) == 0)?(hourlist[hourlist.length/2] + hourlist[hourlist.length/2 + 1]) / 2 : hourlist[hourlist.length/2];
            //        int minuteMedian = ((minutelist.length % 2) == 0)?(minutelist[minutelist.length/2] + minutelist[minutelist.length/2 + 1]) / 2 : minutelist[minutelist.length/2];
            //        int secondsMedian = ((secondlist.length % 2) == 0)?(secondlist[secondlist.length/2] + secondlist[secondlist.length/2 + 1]) / 2 : secondlist[secondlist.length/2];
            secondsMedian = ((list.length % 2) == 0) ?
                    (list[list.length / 2] + list[list.length / 2 + 1]) / 2 : list[list.length / 2];
        }
        return "Range: " + parseResult(secondsRange) + " Average: " + parseResult(secondsAverage)
                + " Median: " + parseResult(secondsMedian);
//                + " Median: " + String.format("%02d",hoursMedian) + "|"
//                + String.format("%02d",minuteMedian) + "|" + String.format("%02d",secondsMedian);
    }

    public static int toSeconds(String x){
        String[] data = x.split("\\|");
        return (((data[0]!= null)? Integer.parseInt(data[0])*3600 : 0) +
                ((data[1]!= null)? Integer.parseInt(data[1])*60 : 0) +
                ((data[2]!= null)? Integer.parseInt(data[2]) : 0));
    }

    public static String parseResult(int seconds){
        int hours = seconds / 3600;
        int remainder = seconds - hours*3600;
        int minutes = remainder / 60;
        remainder = remainder - minutes * 60;
        int sec = remainder;
        return String.format("%02d",hours) + "|" + String.format("%02d",minutes) + "|" + String.format("%02d",sec);
    }
}