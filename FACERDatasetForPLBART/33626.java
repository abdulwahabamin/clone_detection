    /**
     * Finds whether the new daily three hourly list should be created. This will be the case if:
     * (a) currently there are no daily lists at all, or
     * (b) the time of the three-hourly forecast under consideration is a morning hour, unless the
     * current daily list is the only daily list so far, and it only contains forecasts at hours
     * in range [0..4]. That is, if the very first three-hourly forecast time is between 0 and 4 am,
     * then the first daily list will contain all the three hourly forecast until the next day's
     * morning.
     *
     * @param morningStartHour hour at which the day starts (around 5-7 am, depending on the data
     *                         OWM provides
     * @param forecastHour     hour of the three-hourly forecast, provided by the OWM
     * @return true if a new daily list should be created and added to the
     * jsonStringListsForChildListFragments
     */
    private boolean shouldStartNewDailyList(int morningStartHour, int forecastHour) {
        if (jsonStringListsForChildListFragments.size() == 0) {
            return true;
        }
        if (forecastHour == morningStartHour) {
            int threeHourlyForecastCountInCurrentDailyList =
                    getLatestDailyThreeHourlyForecastList().size();
            return forecastHour - 3 * threeHourlyForecastCountInCurrentDailyList < 0;
        }
        return false;
    }

