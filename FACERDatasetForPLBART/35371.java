    @Override
    public void updateDataInWeeks() {
        String showCity = getShowCity();
        final HWeather weather = mWeatherRepository.getLocalWeather(showCity);
        final List<WeekWeather> weekWeathers = new ArrayList<>();
        String[] weeks = new String[7];
        final List<Integer> lists = new ArrayList<>();
        if (weather == null) return;
        for (int i = 0; i < WeatherJsonConverter.getWeather(weather).getDaily_forecast().size(); i++) {
            WeekWeather weekWeather = new WeekWeather();
            String weatherCond = WeatherJsonConverter.getWeather(weather).getDaily_forecast().get(i).getCond().getTxt_d();
            weekWeather.setLowTemp(Integer.parseInt(WeatherJsonConverter.getWeather(weather).getDaily_forecast().get(i).getTmp().getMin()));
            lists.add(Integer.parseInt(WeatherJsonConverter.getWeather(weather).getDaily_forecast().get(i).getTmp().getMin()));
            weekWeather.setHighTemp(Integer.parseInt(WeatherJsonConverter.getWeather(weather).getDaily_forecast().get(i).getTmp().getMax()));
            weekWeather.setDate(WeatherJsonConverter.getWeather(weather).getDaily_forecast().get(i).getDate());
            if (weatherCond.contains("/")) {
                weekWeather.setCond(weatherCond.split("/")[1]);
            } else {
                weekWeather.setCond(weatherCond);
            }
            weekWeathers.add(weekWeather);
        }
        try {
            weeks = DateUtil.
                    getNextWeek(new SimpleDateFormat("yyyy-MM-dd").
                            parse(WeatherJsonConverter.getWeather(weather).getDaily_forecast().get(0).getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        final String[] finalWeeks = weeks;

        mView.updateWeeksView(weekWeathers, finalWeeks, lists);


    }

