    @Override
    protected void onHandleIntent(Intent intent) {
        ConnectionDetector connectionDetector = new ConnectionDetector(this);
        if (!connectionDetector.isNetworkAvailableAndConnected()) {
            return;
        }

        SharedPreferences preferences = getSharedPreferences(Constants.APP_SETTINGS_NAME, 0);
        String latitude = preferences.getString(Constants.APP_SETTINGS_LATITUDE, "51.51");
        String longitude = preferences.getString(Constants.APP_SETTINGS_LONGITUDE, "-0.13");
        String locale = LanguageUtil.getLanguageName(PreferenceUtil.getLanguage(this));
        String units = AppPreference.getTemperatureUnit(this);

        String requestResult = "";
        HttpURLConnection connection = null;
        try {
            URL url = Utils.getWeatherForecastUrl(Constants.WEATHER_ENDPOINT, latitude, longitude, units, locale);
            connection = (HttpURLConnection) url.openConnection();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                InputStream inputStream = connection.getInputStream();

                int bytesRead;
                byte[] buffer = new byte[1024];
                while ((bytesRead = inputStream.read(buffer)) > 0) {
                    byteArray.write(buffer, 0, bytesRead);
                }
                byteArray.close();
                requestResult = byteArray.toString();
                AppPreference.saveLastUpdateTimeMillis(this);
            }

        } catch (IOException e) {
            Log.e(TAG, "IOException: " + requestResult);

        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        parseWeather(requestResult);
    }

