    /**
     * æ—¥æœŸè½¬æ?¢
     *
     * @return 08.07
     */
    public static String convertDataToString(String dateString) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATA_FORMAT_PATTEN_YYYY_MM_DD, Locale.CHINA);
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date == null)
            return "";
        return (String.valueOf(date.getMonth()).length() == 1 ? "0" + date.getMonth() : String.valueOf(date.getMonth()))
                + "." + (String.valueOf(date.getDay()).length() == 1 ? "0" + date.getDay() : String.valueOf(date.getDay()));
    }

