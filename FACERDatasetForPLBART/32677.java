    public static String getLocalizedDateTime(Context context, Date inputTime, boolean showYear, Locale locale) {
        String dateStylePreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_DATE_STYLE, "system");
        switch (dateStylePreferences) {
            case "date_style_dots": return getSimpleDateFormatForDate("dd.MM.", "dd.MM.yy", showYear, locale).format(inputTime) +
                                        " " + getLocalizedTime(context, inputTime, locale);
            case "date_style_slash_month_first": return getSimpleDateFormatForDate("MM/dd", "yy/MM/dd", showYear, locale).format(inputTime) +
                                                    " " + getLocalizedTime(context, inputTime, locale);
            case "date_style_slash_day_first": return getSimpleDateFormatForDate("dd/MM", "dd/MM/yy", showYear, locale).format(inputTime) +
                                                    " " + getLocalizedTime(context, inputTime, locale);
            case "system":
            default: return DateFormat.getDateFormat(context).format(inputTime) + " " +
                    getLocalizedTime(context, inputTime, locale);
        }
    }

