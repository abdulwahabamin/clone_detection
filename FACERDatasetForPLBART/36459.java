    /**
     * 将时间转�?�为时间戳
     *
     * @param data             待转�?�的日期
     * @param dataFormatPatten 待转�?�日期格�?
     */
    public static long dateToTimeStamp(String data, String dataFormatPatten) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dataFormatPatten, Locale.CHINA);
        Date date = null;
        try {
            date = simpleDateFormat.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert date != null;
        return date.getTime();
    }

