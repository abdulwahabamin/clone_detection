    /**
     * 输入一个日期，返回该日期以�?�接下�?�6天的星期数。
     * @param date 一个日期
     * @return 返回星期数
     */
    public static String[] getNextWeek(Date date) {
        String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        String[] myWeek = new String[7];
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int weekIndex = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (weekIndex < 0) {
            weekIndex = 0;
        }
        for(int i = 0 ;i < 7;i++) {
            if (i == 0) {
                myWeek[i] = new SimpleDateFormat("MM/dd").format(date);
            }else{
                myWeek[i] = weeks[(weekIndex + i) % 7];

            }
        }
        return myWeek;
    }

