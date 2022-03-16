    public static URL getWeatherForecastUrl(String endpoint, String city, String units) throws
            MalformedURLException {
        String builtDay = Uri.parse(endpoint).buildUpon()
                .appendQueryParameter(Constants.QUERY_PARAM , city)
                .appendQueryParameter(Constants.FORMAT_PARAM , Constants.FORMAT_VALUE)
                .appendQueryParameter(Constants.UNITS_PARAM , units)
                .appendQueryParameter(Constants.DAYS_PARAM , Integer.toString(10))
                .build()
                .toString();
        return new URL(builtDay);
    }

