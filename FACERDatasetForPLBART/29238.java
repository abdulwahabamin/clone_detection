    /**
     *将农历数字日期转�?�为汉字表示
     * @param day
     * @return
     */
    public static String getChinaDayString(int day)
    {
        String chineseTen[] =
                { "�?", "�??", "廿", "�?�" };
        String chineseNumber[] =
                { "一", "二", "三", "四", "五", "六", "七", "八", "�?", "�??"};
        int n = day % 10 == 0 ? 9 : day % 10 - 1;
        if (day > 30)
            return "";
        if (day == 10)
            return "�?�??";
        else
            return chineseTen[day / 10] + chineseNumber[n];
    }

