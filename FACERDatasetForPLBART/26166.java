    private static String getTimeTips(long timeStamp) {
        long now = System.currentTimeMillis() / 1000;
        String tips;
        long diff = now - timeStamp / 1000;
        if (diff < 60) {
            tips = "刚刚";
        } else if ((diff /= 60) < 60) {
            tips = String.format("%d分钟�?", diff);
        } else if ((diff /= 60) < 24) {
            tips = String.format("%d�?时�?", diff);
        } else if ((diff /= 24) < 7) {
            tips = String.format("%d天�?", diff);
        } else if ((diff /= 7) < 4) {
            tips = String.format("%d周�?", diff);
        } else {

            tips = DATE_FORMAT.format(new Date(timeStamp * 1000));

        }
        return tips;
    }

