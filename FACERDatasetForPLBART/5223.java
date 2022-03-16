    String getTimeDifference(Date start,Date end){

        long duration  = end.getTime() - start.getTime();
        long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration);
        if(diffInSeconds<60)
            return diffInSeconds+" seconds ago";
        long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        if(diffInMinutes<60)
            return diffInMinutes+" minutes ago";
        long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);

        if(diffInHours<24)
            return diffInHours+" hour(s) ago";
        return (diffInHours/24)+" day(s) ago";
    }

