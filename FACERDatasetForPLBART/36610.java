    public static String getChinaDayString(int day) {
        String chineseTen[] = {"åˆ?", "å??", "å»¿", "ä¸‰"};
        int n = day % 10 == 0 ? 9 : day % 10 - 1;
        if (day > 30)
            return "";
        if (day == 10)
            return "åˆ?å??";
        else
            return chineseTen[day / 10] + chineseNumberDay[n];
    }

