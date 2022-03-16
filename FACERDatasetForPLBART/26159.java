    /**
     * 新时间戳显示
     * 0<X<1分钟     ：  刚刚
     * 1分钟<=X<60分钟    :    X分钟�?         EX:5分钟�?
     * 1�?时<=X<24�?时    ：  X�?时�?        EX：3�?时�?
     * 1天<=X<7天         ：   X天�?           Ex： 4天�?
     * 1周<=X<1个月     ：   X周�?           EX：3周�?
     * X>=1个月           :      YY/MM/DD   HH:MM       EX：15/05/15  15:34
     */


    public static long halfAnHourSeconds() {
        return MIN_OF_HOUR * SEC_OF_MIN / 2;
    }

