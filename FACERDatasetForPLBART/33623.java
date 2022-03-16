    /**
     * Divides all the three-hourly forecasts into separate lists, to be displayed as view pager
     * pages. These lists correspond to days. Since there are eight three-hourly forecasts in a 24
     * hour day, the lists should have eight forecasts each. However, as the time of the first
     * forecast can be any time of the day, and we would like (for user convenience) to start each
     * list with the morning forecast (around 5-7 in the morning), the first day ("today") will
     * possibly have less or more than eight forecasts. Also, the last day will usually have less
     * than eight three-hourly forecasts.
     */
    private void splitThreeHourlyForecastsIntoDailyLists() {
        int firstForecastHour = getFirstThreeHourlyForecastHour();
        int morningStartHour = findMorningStartHour(firstForecastHour);
        int unallocatedThreeHourlyForecastCount = jsonStringsForChildFragments.size();

        jsonStringListsForChildListFragments = new ArrayList<>();
        int forecastHour = firstForecastHour;
        for (int i = 0; i < unallocatedThreeHourlyForecastCount; i++) {
            boolean shouldStartNewDailyList = shouldStartNewDailyList(morningStartHour,
                    forecastHour);
            if (shouldStartNewDailyList) {
                @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
                ArrayList<String> threeHourlyForecastsForOneDay = new ArrayList<>();
                jsonStringListsForChildListFragments.add(threeHourlyForecastsForOneDay);
            }

            getLatestDailyThreeHourlyForecastList().add(jsonStringsForChildFragments.get(i));

            forecastHour += 3;
            forecastHour %= 24;
        }
    }

