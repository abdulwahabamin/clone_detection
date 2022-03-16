    public void updateForecastData(List<Forecast> forecasts) {
        forecastList = new ArrayList<Forecast>();
        courseDayList = new ArrayList<Forecast>();

        // TODO: filter them accordingly and calculate what should be displayed .. (like average all the 3h forecasts for the week list)
        Date now = new Date();
        long currentTime = currentWeatherDataList.getTimestamp();

        for(Forecast f : forecasts) {
            Date time = f.getForecastTime();

            // only add Forecasts that are in the future
            if(time.after(now)) {

                // course of day list should show entries until the same time the next day is reached
                // since we force our forecasts to be in the future and they are ordered.. we can assume
                // the next entry to be to the full 3h mark after this time ..
                // if we now add a total of 8 entries if should sum up to 24 hours
                if(courseDayList.size() < 8) {
                    courseDayList.add(f);
                }

                Calendar c = new GregorianCalendar();
                c.setTime(f.getForecastTime());
                if(c.get(Calendar.HOUR_OF_DAY) == 12) {
                    forecastList.add(f);
                }
            }
        }

        notifyDataSetChanged();
    }

