        /**
         * Checks if the obtained JSON contains any useful data. This is necessary due to
         * a strange way HTTP status codes are handled in the Open Weather Map API - see
         * https://claudiosparpaglione.wordpress.com/tag/openweathermap for more details.
         *
         * @param jsonString JSON data for the requested city and weather information type
         * @return true if there are meaningful data to display, false otherwise
         */
        private boolean isWeatherDataAvailable(String jsonString) {
            try {
                JSONObject obj = new JSONObject(jsonString);
                if (obj.has(OPEN_WEATHER_MAP_API_HTTP_CODE_KEY)) {
                    int httpStatusCode = obj.getInt(OPEN_WEATHER_MAP_API_HTTP_CODE_KEY);
                    if (JsonFetcher.HTTP_STATUS_CODE_OK != httpStatusCode) {
                        return false;
                    }
                }
            } catch (JSONException e) {
                return false;
            }
            return true;
        }

