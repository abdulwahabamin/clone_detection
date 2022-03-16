    public static String friendlyTimeDuration(long millis) {
        if(millis<60000) {
            return (millis/1000)+"s";
        } else if(millis<(Cal.MINUTES_1_IN_MILLIS*5)) {
            long seconds=((millis/1000)%60);
            if(seconds==0)
                return Double.valueOf(millis / Cal.MINUTES_1_IN_MILLIS).intValue() +"mins";
            return Double.valueOf(millis / Cal.MINUTES_1_IN_MILLIS).intValue() +"min, "+seconds+"s";
        } else {
            return Double.valueOf(millis / Cal.MINUTES_1_IN_MILLIS).intValue() +"mins";
        }
    }

