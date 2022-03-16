        /**
         * Reacts to the recent JSON weather information retrieval.
         *
         * @param jsonString        weather data in JSON format
         * @param weatherInfoType   a kind of weather information
         * @param shouldSaveLocally whether the retrieved data should be saved in the database
         */
        void onRecentJsonStringRetrieved(String jsonString, WeatherInfoType weatherInfoType,
                                         boolean shouldSaveLocally);

