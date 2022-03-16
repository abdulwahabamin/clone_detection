    /**
     * 判断时间是�?是今天
     *
     * @return 是返回true，�?是返回false
     */
    private static boolean isNow(Date date) {
        //当�?时间
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATA_FORMAT_PATTEN_YYYY_MM_DD, Locale.CHINA);
        //获�?�今天的日期
        String nowDay = simpleDateFormat.format(now);
        //对比的时间
        String day = simpleDateFormat.format(date);
        return day.equals(nowDay);
    }

