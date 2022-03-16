    /**
     * Parses the message to be shown to user when there is no network access, but the old weather
     * data stored locally still can be displayed.
     *
     * @param queryTime the time when the old weather data were obtained
     * @return time in millis
     */
    @NonNull
    private String getAlertDialogMessage(long queryTime) {
        long weatherDataAge = System.currentTimeMillis() - queryTime;
        int hours = (int) (weatherDataAge / (3600 * 1000));
        int days = hours / 24;
        hours %= 24;
        if (days == 0 && hours == 0) {
            hours = 1;
        }

        Resources res = getResources();
        String daysPlural = res.getQuantityString(R.plurals.days, days);
        String hoursPlural = res.getQuantityString(R.plurals.hours, hours);

        if (days > 0 && hours > 0) {
            return String.format(res.getString(R.string.old_data_message_x_days_and_y_hours_ago),
                    days, daysPlural, hours, hoursPlural);
        } else {
            int number = days > 0 ? days : hours;
            String plural = days > 0 ? daysPlural : hoursPlural;
            return String.format(res.getString(R.string.old_data_message_x_days_or_hours_ago),
                    number, plural);
        }

    }

