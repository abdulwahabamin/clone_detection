    /**
     * Returns a label for the dates, only one per day preferably at noon.
     * @param weather weather entity
     * @param i number of weather in long term forecast
     * @return label (either short form of day in week or empty string)
     */
    private String getDateLabel(Weather weather, int i) {
        String output = dateFormat.format(weather.getDate());

        Calendar cal = Calendar.getInstance();
        cal.setTime(weather.getDate());
        int weatherHour = cal.get(Calendar.HOUR_OF_DAY);

        // label for first day if it starts after 13:00
        if (i == 0 && weatherHour > 13) {
            return output;
        }
        // label for the last day if it ends before 11:00
        else if (i == weatherList.size() - 1 && weatherHour < 11) {
            return output;
        }
        // label in the middle of the day at 11:00 / 12:00 / 13:00 for all other days
        else if (weatherHour >= 11 && weatherHour <= 13) {
            return output;
        }
        // normal case: no date label
        else {
            return "";
        }
    }

