    /**
     * Converts the response to JSON and updates the database so that the latest weather data are
     * displayed.
     *
     * @param response The response of the HTTP request.
     */
    @Override
    public void processSuccessScenario(String response) {
        IDataExtractor extractor = new OwmDataExtractor();
        try {
            JSONObject json = new JSONObject(response);
            JSONArray list = json.getJSONArray("list");
            for (int i = 0; i < list.length(); i++) {
                String currentItem = list.get(i).toString();
                CurrentWeatherData weatherData = extractor.extractCurrentWeatherData(currentItem);
                int cityId = extractor.extractCityID(currentItem);
                // Data were not well-formed, abort
                if (weatherData == null || cityId == Integer.MIN_VALUE) {
                    final String ERROR_MSG = context.getResources().getString(R.string.convert_to_json_error);
                    Toast.makeText(context, ERROR_MSG, Toast.LENGTH_LONG).show();
                    return;
                }
                // Could retrieve all data, so proceed
                else {
                    weatherData.setCity_id(cityId);

                    CurrentWeatherData current = dbHelper.getCurrentWeatherByCityId(cityId);
                    if(current != null && current.getCity_id() == cityId) {
                        dbHelper.updateCurrentWeather(weatherData);
                    } else {
                        dbHelper.addCurrentWeather(weatherData);
                    }

                    //update UI
                    ViewUpdater.updateCurrentWeatherData(weatherData);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // TODO: Error Handling
    }

