    public static String getWeek(String dataStr) {
        try {
            return WEEK.format(MONTH_DAY_FORMAT.parse(dataStr));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

