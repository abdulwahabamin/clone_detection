    @Override
    public String milliSecondsToTime(long milliseconds){
        String finalTime = "";
        String secondsString = "";

        int hours = (int)(milliseconds / (1000 * 60 * 60));
        int minutes = (int)(milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int)((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);

        if(hours > 0){
            finalTime = hours + ":";
        }

        if(seconds < 10){
            secondsString = "0" + seconds;
        }else{
            secondsString = "" + seconds;
        }

        finalTime = finalTime + minutes + ":" + secondsString;

        return finalTime;
    }

