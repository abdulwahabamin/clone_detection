    /**
     * 将公历日期转�?�为农历日期，且标识是�?�是闰月
     * @param year
     * @param month
     * @param monthDay
     * @return 返回公历日期对应的农历日期，year0，month1，day2，leap3
     */
    public static  String solarToLunar(int year, int month, int monthDay) {
        int[] lunarDate = new int[4];
        Date baseDate = new GregorianCalendar(1900, 0, 31).getTime();
        Date objDate = new GregorianCalendar(year, month - 1, monthDay).getTime();
        int offset = (int) ((objDate.getTime() - baseDate.getTime()) / 86400000L);

        // 用offset�?去�?农历年的天数计算当天是农历第几天
        // iYear最终结果是农历的年份, offset是当年的第几天
        int iYear, daysOfYear = 0;
        for (iYear = MIN_YEAR; iYear <= MAX_YEAR && offset > 0; iYear++) {
            daysOfYear = daysInLunarYear(iYear);
            offset -= daysOfYear;
        }
        if (offset < 0) {
            offset += daysOfYear;
            iYear--;
        }

        // 农历年份
        lunarDate[0] = iYear;

        int leapMonth = leapMonth(iYear); // 闰哪个月,1-12
        boolean isLeap = false;
        // 用当年的天数offset,�?个�?去�?月（农历）的天数，求出当天是本月的第几天
        int iMonth, daysOfMonth = 0;
        for (iMonth = 1; iMonth <= 13 && offset > 0; iMonth++) {
            daysOfMonth = daysInLunarMonth(iYear, iMonth);
            offset -= daysOfMonth;
        }
        // 当�?月超过闰月，�?校正
        if (leapMonth != 0 && iMonth > leapMonth) {
            --iMonth;

            if (iMonth == leapMonth) {
                isLeap = true;
            }
        }
        // offset�?于0时，也�?校正
        if (offset < 0) {
            offset += daysOfMonth;
            --iMonth;
        }

        lunarDate[1] = iMonth;
        lunarDate[2] = offset + 1;
        lunarDate[3] = isLeap ? 1 : 0;
        String lunarMonthAndDay_inChinese=
                lunarMonthChinese[lunarDate[1]-1]+getChinaDayString(lunarDate[2]);
        if(lunarDate[3]==1){
            lunarMonthAndDay_inChinese="闰"+lunarMonthAndDay_inChinese;
        }
        return lunarMonthAndDay_inChinese;
    }

