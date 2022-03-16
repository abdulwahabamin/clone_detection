    /**
     * 格�?化时间
     *
     * @param duration 时长
     * @return 00:00
     */
    public static String formatTime(long duration) {
        if (duration / 1000 % 60 < 10) {
            return duration / 1000 / 60 + ":0" + duration / 1000 % 60;
        }
        return duration / 1000 / 60 + ":" + duration / 1000 % 60;
    }

