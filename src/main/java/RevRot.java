class RevRot {

    public static String revRot(String strng, int sz) {
        String result = "";
        if((sz <= 0) || (strng.length() == 0)) {
            return "";
        } else if(sz > strng.length()){
            return "";
        }else{
            int iterations = strng.length() / sz;
            for(int i=0; i < iterations; i++){
                result += checkChunk(strng.substring(i*sz,(i*sz)+sz));
            }
            return result;
        }
    }

    public static String checkChunk(String chunk){
        int sum = 0;
        for(int i=0; i<chunk.length(); i++){
            int digit = Integer.parseInt(chunk.charAt(i)+"");
            sum += Math.pow(digit,3);
        }
        if(sum % 2 == 0){
            return new StringBuilder(chunk).reverse().toString();
        }
        else{
            return chunk.substring(1) + chunk.charAt(0);
        }
    }
}