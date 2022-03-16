        /**
         * * Reacts to the old JSON weather information retrieval.
         *
         * @param jsonString      weather data in JSON format
         * @param weatherInfoType a kind of weather information
         * @param queryTime       the time in millis the weather data were stored
         */
        void onOldJsonStringRetrieved(String jsonString, WeatherInfoType weatherInfoType,
                                      long queryTime);

