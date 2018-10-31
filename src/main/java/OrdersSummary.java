public class OrdersSummary {

    public static String balanceStatements(String lst) {
        String count = "Buy: %d Sell: %d";
        String result;
        String badlyFormed = "; Badly formed %d: ";
        int failed = 0;
        String[] orders = lst.split(",");
        int[] data = {0, 0};

        for (int i = 0; i < orders.length; i++) {
            String[] comp = orders[i].trim().split(" ");
            if(isCorrectOrder(comp)) {
                if (comp[3].equals("B")) {
                    data[0] += Double.parseDouble(comp[1]) * Double.parseDouble(comp[2]);
                } else if (comp[3].equals("S")) {
                    data[1] += Double.parseDouble(comp[1]) * Double.parseDouble(comp[2]);
                }
            } else {
                failed++;
                badlyFormed += orders[i].trim() + " ;";
            }
        }

        result = String.format(count,data[0],data[1]);

        if(failed > 0 && ((data[0]>0) || (data[1]>0))) {
            result += String.format(badlyFormed,failed);
        }

        return result;
    }

    public static boolean isCorrectOrder(String[] comp){
        if((comp.length == 4) && (Double.parseDouble(comp[1]) > 0)
                && (Double.parseDouble(comp[2]) > 0) && (comp[2].contains("."))
                && ((comp[3].equals("B"))||(comp[3].equals("S")))){
            return true;
        }
        else{
            return false;
        }
    }
}