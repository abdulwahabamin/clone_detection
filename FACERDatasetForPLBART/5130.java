    public static String friendlyTimeDuration(int seconds) {
        //BLog.e("DURATION",""+seconds);
        if(seconds<minute) {
            return seconds+"s";
        } else if(seconds<(minute*5)) {
            if((seconds%60)==0)
                return Double.valueOf(seconds / minute).intValue() +"mins";
            return Double.valueOf(seconds / minute).intValue() +"min, "+(seconds%60)+"s";
        } else {
            return Double.valueOf(seconds / minute).intValue() +"mins";
        }
    }

