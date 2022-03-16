    /**
     * 将时间戳转�?�为日期
     *
     * @param time             待转�?�的时间戳
     * @param dataFormatPatten 转�?�出的日期格�?
     */
    public static String timeStampToDate(long time, String dataFormatPatten) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dataFormatPatten, Locale.CHINA);
        Date date = new Date(time);
        return simpleDateFormat.format(date);
    }

