    public static URL getWeatherForecastUrl(Context context,
                                            String endpoint,
                                            double lat,
                                            double lon,
                                            String units,
                                            String lang) throws MalformedURLException {
        String url = Uri.parse(endpoint)
                        .buildUpon()
                        .appendQueryParameter("appid", ApiKeys.getOpenweathermapApiKey(context))
                        .appendQueryParameter("lat", String.valueOf(lat).replace(",", "."))
                        .appendQueryParameter("lon", String.valueOf(lon).replace(",", "."))
                        .appendQueryParameter("units", units)
                        .appendQueryParameter("lang", OWMLanguages.getOwmLanguage(lang))
                        .build()
                        .toString();
        return new URL(url);
    }

