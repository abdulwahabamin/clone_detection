    /**
     * Finds the morning hour that the forecasts for each day should start. This will be 5, 6, or 7.
     *
     * @param firstForecastHour hour of the first three-hourly forecast, provided by OWM
     * @return an hour in range [5..7]
     */
    private int findMorningStartHour(int firstForecastHour) {
        int remainder = (firstForecastHour - EARLIEST_MORNING_HOUR) % 3;
        if (remainder < 0) {
            remainder += 3;
        }
        if (remainder == 0) {
            return EARLIEST_MORNING_HOUR;
        } else if (remainder == 1) {
            return EARLIEST_MORNING_HOUR + 1;
        } else if (remainder == 2) {
            return EARLIEST_MORNING_HOUR + 2;
        } else {
            throw new IllegalStateException("Unexpected remainder: " + remainder);
        }
    }

