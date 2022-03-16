    private void coordinates(String... params) {
        String UNITS_VALUE = sharedPreferences.getString(Constants.PREF_TEMPERATURE_UNITS , Constants.METRIC);
        builtDay = Uri.parse(Constants.OPEN_WEATHER_MAP_DAILY_API).buildUpon()
                .appendQueryParameter(Constants.LATITUDE , params[0])
                .appendQueryParameter(Constants.LONGITUDE , params[1])
                .appendQueryParameter(Constants.FORMAT_PARAM , Constants.FORMAT_VALUE)
                .appendQueryParameter(Constants.UNITS_PARAM , UNITS_VALUE)
                .appendQueryParameter(Constants.DAYS_PARAM , Integer.toString(10))
                .build();
        builtFort = Uri.parse(Constants.OPEN_WEATHER_MAP_FORECAST_API).buildUpon()
                .appendQueryParameter(Constants.LATITUDE , params[0])
                .appendQueryParameter(Constants.LONGITUDE , params[1])
                .appendQueryParameter(Constants.FORMAT_PARAM , Constants.FORMAT_VALUE)
                .appendQueryParameter(Constants.UNITS_PARAM , UNITS_VALUE)
                .appendQueryParameter(Constants.DAYS_PARAM , Integer.toString(10))
                .build();
    }

