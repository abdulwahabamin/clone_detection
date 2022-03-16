    public static List<Forecast> filter(List<Forecast> list, int numberOfDays) {
        List<Forecast> result = new ArrayList<Forecast>();

        GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();

        int currentDay = cal.get(Calendar.DAY_OF_WEEK);

        for (Forecast forecast: list) {
            cal.setTime(forecast.getForecastTime());

            if (currentDay == cal.get(Calendar.DAY_OF_WEEK)) {
                continue;
            }

            if (cal.get(Calendar.HOUR_OF_DAY) == 15 && result.size() < numberOfDays) {
                result.add(forecast);
            }

            if (result.size() == numberOfDays) {
                break;
            }
        }

        //for  a 5 day forecast, there might be no forecast for 3pm on the last day, therefore take the latest forecast for that day
        if (result.size() < numberOfDays) {
            result.add(list.get(list.size()-1));
        }

        return result;
    };

