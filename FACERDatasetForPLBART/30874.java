    public static Date stringToDate(String pattern, String in) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat)SimpleDateFormat.getDateInstance();
        simpleDateFormat.applyPattern(pattern);

        Date retDate = null;
        try {
            retDate = simpleDateFormat.parse(in);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return retDate;
    }

