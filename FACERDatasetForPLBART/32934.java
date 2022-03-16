    public WindWithUnit(Context context, double windSpeed, String windUnit, double windDirection, Locale locale) {
        this.windSpeed = windSpeed;
        this.windUnit = windUnit;
        this.windDirection = windDirection;
        this.context = context;
        this.pressureLocale = locale;
        directionTypeFromPreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_WIND_DIRECTION, "abbreviation");
    }

