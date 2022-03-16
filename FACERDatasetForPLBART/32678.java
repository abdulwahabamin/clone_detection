    private static SimpleDateFormat getSimpleDateFormatForDate(String datePattern, String yearPattern, boolean showYear, Locale locale) {
        if (showYear) {
            return new SimpleDateFormat(yearPattern, locale);
        } else {
            return new SimpleDateFormat(datePattern, locale);
        }
    }

