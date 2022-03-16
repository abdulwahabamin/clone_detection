        /**
         * Determines whether the weather records are outdated and should be renewed.
         *
         * @param lastUpdateTime when was this type of record last updated locally
         * @return true, if current records are too old; false otherwise
         */
        private boolean recordNeedsToBeUpdatedForWeatherInfo(long lastUpdateTime) {
            if (lastUpdateTime == CityTable.CITY_NEVER_QUERIED) {
                return true;
            } else {
                long currentTime = System.currentTimeMillis();
                return currentTime - lastUpdateTime > getWeatherDataCachePeriod();
            }
        }

