    public static String getChinaDayString(int day) {
        String chineseTen[] = {"�?", "�??", "廿", "三"};
        int n = day % 10 == 0 ? 9 : day % 10 - 1;
        if (day > 30)
            return "";
        if (day == 10)
            return "�?�??";
        else
            return chineseTen[day / 10] + chineseNumberDay[n];
    }

