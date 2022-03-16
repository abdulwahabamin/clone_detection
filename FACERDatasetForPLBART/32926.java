    public static SimpleDateFormat getDaysFormatter(Context context, Integer widgetId, Locale locale) {
        if (widgetId == null) {
            return new SimpleDateFormat("EEEE", locale);
        }
        WidgetSettingsDbHelper widgetSettingsDbHelper = WidgetSettingsDbHelper.getInstance(context);
        Boolean forecastDayAbbrev = widgetSettingsDbHelper.getParamBoolean(widgetId, "forecast_day_abbrev");
        if ((forecastDayAbbrev != null) && forecastDayAbbrev) {
            return new SimpleDateFormat("EEE", locale);
        } else {
            return new SimpleDateFormat("EEEE", locale);
        }
    }

