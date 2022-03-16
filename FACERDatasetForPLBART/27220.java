    private void getWeatherForCity(OpenWeatherService service, OrmCity city) {
        String latLng = String.valueOf(city.getLat()) + " , " + String.valueOf(city.getLon());
        Call<ForecastWeather> responseCall =
                service.getWeather(BuildConfig.WEATHER_API_KEY, latLng, String.valueOf(FORECAST_COUNT_DAYS));
        try {
            ForecastWeather response = responseCall.execute().body();
            if (response.getError() == null) {
                List<OrmWeather> ormWeatherList = new ArrayList<>();
                ormWeatherList.add(getCurrentOrmWeather(city.get_id(),response));
                getHourlyOrmWeather(city.get_id(), response, ormWeatherList);
                localDataSource.saveForecast(ormWeatherList);
            } else {
                Log.e(LOG_TAG, response.getError().getMessage());
                Toast.makeText(getApplicationContext(), response.getError().getCode()+
                        ":"+response.getError().getMessage(),Toast.LENGTH_SHORT).show();
             }
            } catch (IOException e) {
                e.printStackTrace();
                updateSyncStatus(SYNC_ERROR);
            } catch (ParseException e) {
                 e.printStackTrace();
        }
    }

