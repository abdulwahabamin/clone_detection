    public static String getLocalizedHour(Context context, Date inputTime, Locale locale) {
        String timeStylePreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_TIME_STYLE, "system");
        if ("system".equals(timeStylePreferences)) {
            return DateFormat.getTimeFormat(context).format(inputTime);
        } else if ("12h".equals(timeStylePreferences)) {
            SimpleDateFormat sdf_12 = new SimpleDateFormat("hh", locale);
            return sdf_12.format(inputTime);
        } else {
            SimpleDateFormat sdf_24 = new SimpleDateFormat("HH", locale);
            return sdf_24.format(inputTime);
        }
    }

