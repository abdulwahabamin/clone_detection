    /**
     * 传回农历 year年month月的总天数，总共有13个月包括闰月
     *
     * @param year  将�?计算的年份
     * @param month 将�?计算的月份
     * @return 传回农历 year年month月的总天数
     */
    private static int daysInLunarMonth(int year, int month) {
        if ((LUNAR_INFO[year - MIN_YEAR] & (0x100000 >> month)) == 0)
            return 29;
        else
            return 30;
    }

