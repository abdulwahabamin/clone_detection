    /**
     * 传回农历 year年闰哪个月 1-12 , 没闰传回 0
     *
     * @param year 将�?计算的年份
     * @return 传回农历 year年闰哪个月1-12, 没闰传回 0
     */
    private static int leapMonth(int year) {
        return (int) ((LUNAR_INFO[year - MIN_YEAR] & 0xF00000)) >> 20;
    }

