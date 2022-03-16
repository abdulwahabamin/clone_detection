        /**
         * Obtains the time period (which can be specified by a user) for which the cached weather data
         * can be reused.
         *
         * @return a time in milliseconds
         */
        private long getWeatherDataCachePeriod() {
            String minutesString = PreferenceManager.getDefaultSharedPreferences(parentActivity)
                    .getString(SettingsActivity.PREF_DATA_CACHE_PERIOD, getResources().getString(
                            R.string.pref_data_cache_period_default));
            int minutes = Integer.parseInt(minutesString);
            return minutes * 60 * 1000;
        }

