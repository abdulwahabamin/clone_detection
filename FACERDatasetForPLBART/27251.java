    public static void sortWeatherHour(List<OrmWeather> forecast) {
        Collections.sort(forecast, new Comparator<OrmWeather>() {
            @Override
            public int compare(OrmWeather o1, OrmWeather o2) {
                return o1.getDt().compareTo(o2.getDt());
            }
        });
    }

