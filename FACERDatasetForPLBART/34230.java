    private void getWeather() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences pref = getSharedPreferences(Constants.APP_SETTINGS_NAME, 0);
                String latitude = pref.getString(Constants.APP_SETTINGS_LATITUDE, "51.51");
                String longitude = pref.getString(Constants.APP_SETTINGS_LONGITUDE, "-0.13");
                String locale = LanguageUtil.getLanguageName(PreferenceUtil.getLanguage(GraphsActivity.this));
                String units = AppPreference.getTemperatureUnit(GraphsActivity.this);

                String requestResult = "";
                HttpURLConnection connection = null;
                try {
                    URL url = getWeatherForecastUrl(Constants.WEATHER_FORECAST_ENDPOINT, latitude, longitude, units, locale);
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
                        AppPreference.saveLastUpdateTimeMillis(GraphsActivity.this);
                    }
                } catch (IOException e) {
                    mHandler.sendEmptyMessage(Constants.TASK_RESULT_ERROR);
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
                parseWeatherForecast(requestResult);
            }
        });
        t.start();
    }

