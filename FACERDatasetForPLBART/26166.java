    private static String getTimeTips(long timeStamp) {
        long now = System.currentTimeMillis() / 1000;
        String tips;
        long diff = now - timeStamp / 1000;
        if (diff < 60) {
            tips = "åˆšåˆš";
        } else if ((diff /= 60) < 60) {
            tips = String.format("%dåˆ†é’Ÿå‰?", diff);
        } else if ((diff /= 60) < 24) {
            tips = String.format("%då°?æ—¶å‰?", diff);
        } else if ((diff /= 24) < 7) {
            tips = String.format("%då¤©å‰?", diff);
        } else if ((diff /= 7) < 4) {
            tips = String.format("%då‘¨å‰?", diff);
        } else {

            tips = DATE_FORMAT.format(new Date(timeStamp * 1000));

        }
        return tips;
    }

