    public static String friendlyComebackDate(Date lastActiveDate, Date now, long COME_BACK_TIME_IN_MILLIS) {
        if(lastActiveDate==null) {
            return "Whenever";
        } else {
            long t = (lastActiveDate.getTime()+COME_BACK_TIME_IN_MILLIS-now.getTime());
            if(t>3600000)
                return Double.valueOf(t / 3600000).intValue()+"h";
            else if(t<60000)
                return Double.valueOf(t / 1000).intValue()+"s";
            else
                return Double.valueOf(t / 60000).intValue()+"m";
        }
    }

