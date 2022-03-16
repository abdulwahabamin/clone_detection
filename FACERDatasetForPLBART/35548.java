    public static boolean isNeedUpdate(Date oldTime,Date newTime){
        long oT = oldTime.getTime();
        long nT = newTime.getTime();

        if (nT - oT >= UPDATE_TIME) {
            return true;
        }else{
            return false;
        }
    }

