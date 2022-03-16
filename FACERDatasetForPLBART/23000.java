    /**
     * Function to convert milliseconds time to
     * Timer Format
     * Hours:Minutes:Seconds
     */
    public String milliSecondsToTimer(long milliseconds) {
        try {
            String finalTimerString = "";
            int hours = (int) (milliseconds / (1000 * 60 * 60));
            int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
            int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);
            if (hours > 0) {
                finalTimerString = hours + ":";
            }

            String secondsString;
            if (seconds < 10) {
                secondsString = "0" + seconds;
            } else {
                secondsString = "" + seconds;
            }
            finalTimerString = finalTimerString + minutes + ":" + secondsString;
            return finalTimerString;
        } catch (Exception e) {
            return "";
        }
    }

