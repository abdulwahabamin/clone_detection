    public static int countOccourences(String in, String subString) {
        int lastIndex = 0;
        int count =0;

        while(lastIndex != -1){

            lastIndex = in.indexOf(subString,lastIndex);

            if( lastIndex != -1){
                count ++;
                lastIndex+=subString.length();
            }
        }
        return count;
    }

