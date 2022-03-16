    /**
     * 传回农历year年month月的总天数
     * @param year �?计算的年份
     * @param month        �?计算的月
     * @param leap 当月是�?�是闰月
     * @return 传回天数，如果闰月是错误的，返回0.
     */
    public static final int daysInMonth(int year, int month, boolean leap) {
        int leapMonth = leapMonth(year);
        int offset = 0;

        // 如果本年有闰月且month大于闰月时，需�?校正
        if (leapMonth != 0 && month > leapMonth) {
            offset = 1;
        }

        // �?考虑闰月
        if (!leap) {
            return daysInLunarMonth(year, month + offset);
        } else {
            // 传入的闰月是正确的月份
            if (leapMonth != 0 && leapMonth == month) {
                return daysInLunarMonth(year, month + 1);
            }
        }

        return 0;
    }

