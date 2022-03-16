        @Override
        protected Pair<String, Long> doInBackground(URL... params) {
            SqlOperation sqlOperation = new SqlOperation(parentActivity, weatherInfoType);
            Pair<String, Long> storedWeatherInfo = sqlOperation.getJsonStringForWeatherInfo(cityId);
            long lastQueryTime = storedWeatherInfo.second;

            if (!(lastQueryTime == CityTable.CITY_NEVER_QUERIED ||
                    recordNeedsToBeUpdatedForWeatherInfo(lastQueryTime))) {
                // recent data already stored locally
                return Pair.create(storedWeatherInfo.first, CURRENT_TIME_SQL);
            } else if (!isCancelled()) {
                String jsonDataObtainedFromWebService = getJsonStringFromWebService(params[0]);
                if (jsonDataObtainedFromWebService == null) {
                    // data from web not available
                    if (lastQueryTime == CityTable.CITY_NEVER_QUERIED) {
                        // no data available at all - should display an error message
                        return Pair.create(null, null);
                    } else {
                        // there is an old record that may be offered to user
                        return Pair.create(storedWeatherInfo.first, lastQueryTime);
                    }
                } else {
                    // show record obtained from the web
                    return Pair.create(jsonDataObtainedFromWebService, CURRENT_TIME_WEB);
                }
            } else {
                return null;
            }
        }

