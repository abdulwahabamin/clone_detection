    private void city(String... params) {
        String UNITS_VALUE = sharedPreferences.getString(Constants.PREF_TEMPERATURE_UNITS , Constants.METRIC);
        System.out.println(UNITS_VALUE);
        builtDay = Uri.parse(Constants.OPEN_WEATHER_MAP_DAILY_API).buildUpon()
                .appendQueryParameter(Constants.QUERY_PARAM , params[0])
                .appendQueryParameter(Constants.FORMAT_PARAM , Constants.FORMAT_VALUE)
                .appendQueryParameter(Constants.UNITS_PARAM , UNITS_VALUE)
                .appendQueryParameter(Constants.DAYS_PARAM , Integer.toString(10))
                .build();
        builtFort = Uri.parse(Constants.OPEN_WEATHER_MAP_FORECAST_API).buildUpon()
                .appendQueryParameter(Constants.QUERY_PARAM , params[0])
                .appendQueryParameter(Constants.FORMAT_PARAM , Constants.FORMAT_VALUE)
                .appendQueryParameter(Constants.UNITS_PARAM , UNITS_VALUE)
                .appendQueryParameter(Constants.DAYS_PARAM , Integer.toString(10))
                .build();
    }

