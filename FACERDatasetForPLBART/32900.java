    private static Calendar getLocalTimeWithoutDate(long timeInMilis) {
        Calendar calendar = GregorianCalendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(timeInMilis);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.YEAR, 1970);
        return calendar;
    }

